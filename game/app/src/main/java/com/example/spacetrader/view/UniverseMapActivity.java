package com.example.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.PlanetInventory;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Star;
import com.example.spacetrader.entity.TradeGood;
import com.example.spacetrader.entity.Universe;
import com.example.spacetrader.model.AppModule;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

public class UniverseMapActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView travelListView;

    @Inject
    AppModule.SpaceTraderModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SpaceTrader) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_universe_map);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        travelListView = (ListView) findViewById(R.id.travelListView);

        Button tradeButton = findViewById(R.id.tradeButton);
        tradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UniverseMapActivity.this, MarketActivity.class);
                startActivity(intent);
            }
        });

        Button travelButton = findViewById(R.id.travelButton);
        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UniverseMapActivity.this, TravelActivity.class);
                startActivity(intent);
            }
        });
        update();
    }

    @Override
    protected void onResume() {
        super.onResume();
        update();
    }

    private void update() {
        Planet planet = model.player.getCurrplanet();
        Star star = planet.getStar();
        toolbar.setTitle("Current Location: " + planet.getName());
        toolbar.setSubtitle("Star: " + star.getName() + " at (" + star.getxCord() + ", " + star.getyCord() + ")");

    }
}