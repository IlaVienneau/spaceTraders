package com.example.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Star;
import com.example.spacetrader.entity.Player;
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
        currFuel = player.getShip().getCurrFuel();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        travelListView = (ListView) findViewById(R.id.travelListView);

        travelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planet currentPlanet = model.player.getCurrplanet();
                int prevX = currentPlanet.getStar().getxCord();
                int prevY = currentPlanet.getStar().getyCord();
                Star star = starsAvailable.get(position);
                model.player.setCurrplanet(star.getPlanets().values().iterator().next());
                update();
                int currXCoord = currentPlanet.getStar().getxCord();
                int currYCoord = currentPlanet.getStar().getyCord();
                int change = (int) Math.pow((Math.pow(Math.abs(currYCoord - prevY),2) + Math.pow(Math.abs(currXCoord - prevX),2)),.5);
                model.player.getShip().setCurrFuel(currFuel - change);
                update();
                System.out.println(model.player.getShip().getCurrFuel());
            }
        });

        update();

    }

    private void update() {
        starsAvailable = new ArrayList<>();

        ArrayList<String> starDescriptions = new ArrayList<>();
        Planet currentPlanet = model.player.getCurrplanet();
        int currXCoord = currentPlanet.getStar().getxCord();
        int currYCoord = currentPlanet.getStar().getyCord();

        for (Map.Entry<String, Star> entry: model.universe.getStars().entrySet()) {
            String name = entry.getKey();
            Star nextStar = entry.getValue();
            int nextXCoord = nextStar.getxCord();
            int nextYCoord = nextStar.getyCord();

            if (Math.abs(nextXCoord - currXCoord) <= currFuel && Math.abs(nextYCoord - currYCoord) <= currFuel && Math.pow((Math.pow(Math.abs(nextYCoord - currYCoord),2) + Math.pow(Math.abs(nextXCoord - currXCoord),2)),.5) <= currFuel) {
                starsAvailable.add(nextStar);
                String description = nextStar.getName() + "  |  " + nextStar.getStarType().toFormattedString() + " at " + nextXCoord + ", " + nextYCoord;
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
        toolbar.setSubtitle("Star: " + star.getName() + " at (" + star.getxCord() + ", " + star.getxCord() + ")");

    }
}
