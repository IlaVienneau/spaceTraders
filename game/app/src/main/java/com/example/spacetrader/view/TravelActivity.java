package com.example.spacetrader.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.Star;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.StarType;
import com.example.spacetrader.model.AppModule;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

public class TravelActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView travelListView;
    private ArrayList<Star> starsAvailable;
    private Player player;
    private int currFuel;

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

                int newXCoord = nextStar.getxCord();
                int newYCoord = nextStar.getyCord();
                int change = (int) Math.pow((Math.pow(Math.abs(newYCoord - prevY),2) + Math.pow(Math.abs(newXCoord - prevX),2)),.5);
                ship.setCurrFuel(currFuel - change);

                AppModule.save(getApplicationContext(), model);
                update();
                System.out.println(model.player.getShip().getCurrFuel());
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

            if ((Math.abs(nextXCoord - currXCoord) <= currFuel) && (Math.abs(nextYCoord - currYCoord) <= currFuel) && (Math.pow((Math.pow(Math.abs(nextYCoord - currYCoord), 2) + Math.pow(Math.abs(nextXCoord - currXCoord), 2)), .5) <= currFuel)) {
                starsAvailable.add(nextStar);
                StarType starType = nextStar.getStarType();
                String description = nextStar.getName() + "  |  " + starType.toFormattedString() + " at " + nextXCoord + ", " + nextYCoord;
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
        toolbar.setSubtitle("Star: " + star.getName() + " at (" + star.getxCord() + ", " + star.getyCord() + ")");

    }
}
