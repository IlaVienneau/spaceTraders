package com.example.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.RadicalEvent;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.Star;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.StarType;
import com.example.spacetrader.model.AppModule;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

public class TravelActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView travelListView;
    private ArrayList<Star> starsAvailable;
    private Player player;
    private int currFuel;
    private Planet currPlanet;

    @Inject
    AppModule.SpaceTraderModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SpaceTrader) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_travel);

        player = model.player;
        Ship ship = player.getShip();
        currFuel = ship.getCurrFuel();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        travelListView = (ListView) findViewById(R.id.travelListView);

        travelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Player player = model.player;
                Ship ship = player.getShip();
                Planet currentPlanet = player.getCurrplanet();
                Star currentStar = currentPlanet.getStar();
                int prevX = currentStar.getxCord();
                int prevY = currentStar.getyCord();
                Star nextStar = starsAvailable.get(position);

                Planet nextPlanet = nextStar.getPlanets().values().iterator().next();
                player.setCurrplanet(nextPlanet);

                Random rand = new Random();
                int randomChance = rand.nextInt(100) + 1;

                if (randomChance <= 90) {
                    RadicalEvent[] radicalEvents = RadicalEvent.values();
                    int eventSelector = rand.nextInt(6) + 1;
                    RadicalEvent event = radicalEvents[eventSelector];
                    player.getCurrplanet().setRadicalEvent(event);
                }

                String message = "";

                switch (player.getCurrplanet().getRadicalEvent()) {
                    case NONE:
                        message = player.getCurrplanet().getName()
                                + " welcomes you!";
                        break;
                    case BOREDOM:
                        message = player.getCurrplanet().getName()
                                + " is currently stricken by a fit of extreme boredom.";
                        break;
                    case COLD:
                        message = player.getCurrplanet().getName()
                                + " is currently stricken undergoing a deep freeze.";
                        break;
                    case WAR:
                        message = player.getCurrplanet().getName()
                                + " is currently rife with war.";
                        break;
                    case PLAGUE:
                        message = player.getCurrplanet().getName()
                                + " is currently stricken with a horrible plague.";
                        break;
                    case DROUGHT:
                        message = player.getCurrplanet().getName()
                                + " is currently going through a horrible drought.";
                        break;
                    case CROPFAIL:
                        message = player.getCurrplanet().getName()
                                + " is currently going through a horrible crop failure.";
                        break;
                    case LACKOFWORKERS:
                        message = player.getCurrplanet().getName()
                                + " is currently suffering from a lack of workers.";
                        break;
                }
                Toast toast = Toast.makeText(
                        TravelActivity.this, message,
                        Toast.LENGTH_SHORT
                );
                toast.show();

                player.getCurrplanet().getPlanetInventory().updatePrices();

                int newXCoord = nextStar.getxCord();
                int newYCoord = nextStar.getyCord();
                int change = (int) Math.pow((Math.pow(Math.abs(newYCoord - prevY),2)
                        + Math.pow(Math.abs(newXCoord - prevX),2)),.5);
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
        Planet currentPlanet = player.getCurrplanet();
        Star currentStar = currentPlanet.getStar();
        int currXCoord = currentStar.getxCord();
        int currYCoord = currentStar.getyCord();

        for (Map.Entry<String, Star> entry: model.universe.getStars().entrySet()) {
            String name = entry.getKey();
            Star nextStar = entry.getValue();
            int nextXCoord = nextStar.getxCord();
            int nextYCoord = nextStar.getyCord();

            if ((Math.abs(nextXCoord - currXCoord) <= currFuel) && (Math.abs(nextYCoord
                    - currYCoord) <= currFuel) && (Math.pow((Math.pow(Math.abs(nextYCoord
                    - currYCoord), 2) + Math.pow(Math.abs(nextXCoord
                    - currXCoord), 2)), .5) <= currFuel)) {
                starsAvailable.add(nextStar);
                StarType starType = nextStar.getStarType();
                String description = nextStar.getName() + "  |  " + starType.toFormattedString()
                        + " at " + nextXCoord + ", " + nextYCoord;
                starDescriptions.add(description);
            }
        }

        ListAdapter starsAvailableAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                starDescriptions
        );

        travelListView.setAdapter(starsAvailableAdapter);

        Planet planet = model.player.getCurrplanet();
        Star star = planet.getStar();
        toolbar.setTitle("Current Location: " + planet.getName());
        toolbar.setSubtitle("Star: " + star.getName() + " at (" + star.getxCord()
                + ", " + star.getyCord() + ")");

    }
}
