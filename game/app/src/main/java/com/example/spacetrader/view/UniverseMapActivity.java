package com.example.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Star;
import com.example.spacetrader.model.AppComponent;
import com.example.spacetrader.model.AppModule;

import javax.inject.Inject;

public class UniverseMapActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @SuppressWarnings("WeakerAccess")
    @Inject
    AppModule.SpaceTraderModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent component =((SpaceTrader) getApplication()).getAppComponent();
        //noinspection LawOfDemeter
        component.inject(this);

        setContentView(R.layout.activity_universe_map);

        toolbar = findViewById(R.id.toolbar);

        Button tradeButton = findViewById(R.id.tradeButton);
        tradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UniverseMapActivity.this, MarketActivity.class);
                startActivity(intent);
            }
        });

        Button shipInfoButton = findViewById(R.id.shipInfoButton);
        shipInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UniverseMapActivity.this, ShipInfoActivity.class);
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
    }

    @Override
    protected void onResume() {
        super.onResume();

        Planet planet = model.player.getCurrPlanet();
        update(planet);
    }

    private void update(Planet planet) {
        Star star = planet.getStar();

        toolbar.setTitle("Current Location: " + planet.getName());
        toolbar.setSubtitle("Star: " + star.getName() + " at (" + star.getXCord() + ", " + star.getYCord() + ")");

    }
}