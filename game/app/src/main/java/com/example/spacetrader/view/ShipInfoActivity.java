package com.example.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.ShipType;
import com.example.spacetrader.entity.Star;
import com.example.spacetrader.model.AppModule;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.example.spacetrader.model.AppModule;
import javax.inject.Inject;

public class ShipInfoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Player player;
    private Ship ship;
    private ShipType shipType;
    private TextView fuelTextView;
    private TextView capTextView;
    private TextView currCapTextView;
    private TextView currFuelTextView;

    @Inject
    AppModule.SpaceTraderModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SpaceTrader) getApplication()).getAppComponent().inject(this);   //what

        setContentView(R.layout.activity_ship);

        toolbar = (Toolbar) findViewById(R.id.shipToolBar);
        player = model.player;
        ship = player.getShip();
        shipType = player.getShipType();

        toolbar.setTitle("Ship Information");
        toolbar.setSubtitle("" + player.getShipType() + "");

        currCapTextView = (TextView) findViewById(R.id.shipCurrCapTextView);
        currFuelTextView = (TextView) findViewById(R.id.shipCurrFuelTextView);
        fuelTextView = (TextView) findViewById(R.id.shipFuelTextView);
        capTextView = (TextView) findViewById(R.id.shipCapTextView);

        update();
    }

    private void update() {
        int currCargoLoad = player.getShipCurrentCapacity();
        int maxCargoCapacity = player.getShip().getMaxCapacity();
        int maxFuelCapacity = player.getShip().getFuel();
        int currFuel = player.getShip().getCurrFuel();

        currCapTextView.setText("Cargo Space Available: " + (maxCargoCapacity - currCargoLoad) + "");
        currFuelTextView.setText("Fuel available" + currFuel + "");
        fuelTextView.setText("Fuel Capacity: " + maxFuelCapacity + "");
        capTextView.setText("Max Cargo Capacity: " + maxCargoCapacity + "");
    }
}
