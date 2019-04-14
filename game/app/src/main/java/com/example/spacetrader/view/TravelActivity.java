package com.example.spacetrader.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.PlanetInventory;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.RadicalEvent;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.Star;
import com.example.spacetrader.entity.StarType;
import com.example.spacetrader.model.AppComponent;
import com.example.spacetrader.model.AppModule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

public class TravelActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView travelListView;
    private ArrayList<Star> starsAvailable;
    private int currFuel;

    @SuppressWarnings("WeakerAccess")
    @Inject
    AppModule.SpaceTraderModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent component =((SpaceTrader) getApplication()).getAppComponent();
        //noinspection LawOfDemeter
        component.inject(this);

        setContentView(R.layout.activity_travel);

        toolbar = findViewById(R.id.toolbar);
        travelListView = findViewById(R.id.travelListView);

        Player player = model.player;
        if (player == null) {
            return;
        }

        Ship ship = player.getShip();
        if (ship == null) {
            return;
        }

        currFuel = ship.getCurrFuel();

        travelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Player player = model.player;
                Ship ship = player.getShip();

                Planet planet = player.getCurrPlanet();
                Star star = planet.getStar();
                int prevX = star.getXCord();
                int prevY = star.getYCord();
                Star nextStar = starsAvailable.get(position);

                Map<String, Planet> nextStarPlanetMap = nextStar.getPlanets();
                Collection<Planet> planetMapValues = nextStarPlanetMap.values();
                Iterator<Planet> iterator = planetMapValues.iterator();
                Planet nextPlanet = iterator.next();
                player.setCurrPlanet(nextPlanet);

                Random rand = new Random();
                int randomChance = rand.nextInt(100) + 1;

                Planet currentPlanet = player.getCurrPlanet();

                if (randomChance <= 10) {
                    RadicalEvent[] radicalEvents = RadicalEvent.values();
                    int eventSelector = rand.nextInt(7);
                    RadicalEvent event = radicalEvents[eventSelector];
                    currentPlanet.setRadicalEvent(event);
                }

                String message = "";

                RadicalEvent radicalEvent = currentPlanet.getRadicalEvent();
                currentPlanet.setRadicalEvent(radicalEvent);
                String planetName = currentPlanet.getName();

                switch (radicalEvent) {
                    case NONE:
                        message = planetName
                                + " welcomes you!";
                        break;
                    case BOREDOM:
                        message = planetName
                                + " is currently stricken by a fit of extreme boredom.";
                        break;
                    case COLD:
                        message = planetName
                                + " is currently stricken undergoing a deep freeze.";
                        break;
                    case WAR:
                        message = planetName
                                + " is currently rife with war.";
                        break;
                    case PLAGUE:
                        message = planetName
                                + " is currently stricken with a horrible plague.";
                        break;
                    case DROUGHT:
                        message = planetName
                                + " is currently going through a horrible drought.";
                        break;
                    case CROPFAIL:
                        message = planetName
                                + " is currently going through a horrible crop failure.";
                        break;
                    case LACKOFWORKERS:
                        message = planetName
                                + " is currently suffering from a lack of workers.";
                        break;
                }
                Toast toast = Toast.makeText(
                        TravelActivity.this, message,
                        Toast.LENGTH_SHORT
                );
                toast.show();

                PlanetInventory currentPlanetInventory = currentPlanet.getPlanetInventory();
                currentPlanetInventory.updatePrices();

                int newXCoordinate = nextStar.getXCord();
                int newYCoordinate = nextStar.getYCord();
                int change = (int) Math.pow((Math.pow(Math.abs(newYCoordinate - prevY),2)
                        + Math.pow(Math.abs(newXCoordinate - prevX),2)),.5);

                ship.setCurrFuel(currFuel - change);

                AppModule.save(getApplicationContext(), model);
                update();
            }
        });

        update();

    }

    private void update() {
        starsAvailable = new ArrayList<>();
        Player player = model.player;

        ArrayList<String> starDescriptions = new ArrayList<>();
        Planet currentPlanet = player.getCurrPlanet();
        Star currentStar = currentPlanet.getStar();
        int currXCoordinate = currentStar.getXCord();
        int currYCoordinate = currentStar.getYCord();

        Map<String, Star> starsMap = model.universe.getStars();
        for (Map.Entry<String, Star> entry: starsMap.entrySet()) {
            String name = entry.getKey();
            Star nextStar = entry.getValue();

            int nextXCoordinate = nextStar.getXCord();
            int nextYCoordinate = nextStar.getYCord();

            if ((Math.abs(nextXCoordinate - currXCoordinate) <= currFuel) &&
                    (Math.abs(nextYCoordinate - currYCoordinate) <= currFuel) &&
                    (Math.pow((Math.pow(Math.abs(nextYCoordinate - currYCoordinate), 2)
                            + Math.pow(Math.abs(nextXCoordinate - currXCoordinate), 2)), .5)
                            <= currFuel)) {
                starsAvailable.add(nextStar);
                StarType starType = nextStar.getStarType();
                String description = nextStar.getName() + "  |  " + starType.toFormattedString()
                        + " at " + nextXCoordinate + ", " + nextYCoordinate;

                starDescriptions.add(description);
            }
        }

        ListAdapter starsAvailableAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                starDescriptions
        );

        travelListView.setAdapter(starsAvailableAdapter);

        Planet planet = model.player.getCurrPlanet();
        Star star = planet.getStar();
        toolbar.setTitle("Current Location: " + planet.getName());

        toolbar.setSubtitle("Star: " + star.getName() + " at (" + star.getXCord() + ", "
                + star.getYCord() + ")");


    }
}
