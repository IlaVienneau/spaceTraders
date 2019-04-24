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
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.PlanetInventory;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.TradeGood;
import com.example.spacetrader.model.AppModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


public class PoliceActivity extends AppCompatActivity {

    @Inject
    AppModule.SpaceTraderModel model;

    private Player player;
    private Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SpaceTrader) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_police);

        Intent intent = getIntent();

        this.player = model.player;
        this.planet = player.getCurrPlanet();

        Toolbar toolbar = (Toolbar) findViewById(R.id.policeToolbar);
        TextView fineTextView = (TextView) findViewById(R.id.fineTextView);

        fineTextView.setText("Fine: ");

        toolbar.setTitle("Police Encounter");

        Button payFineButton = findViewById(R.id.payButton);
        payFineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((player.getWallet() > 5) &&
                        (player.getShip().getCurrFuel() < player.getShip().getFuel())) {
                    player.getShip().setCurrFuel(player.getShip().getCurrFuel() + 1);
                    player.setWallet(player.getWallet() - 5);
                } else {
                    String message = "Not enough money to buy fuel or fuel tank full.";
                    Toast toast = Toast.makeText(
                            PoliceActivity.this, message,
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }
            }
        });

        Button fleeButton = findViewById(R.id.fleeButton);
        fleeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((player.getWallet() > 5) &&
                        (player.getShip().getCurrFuel() < player.getShip().getFuel())) {
                    player.getShip().setCurrFuel(player.getShip().getCurrFuel() + 1);
                    player.setWallet(player.getWallet() - 5);
                } else {
                    String message = "Not enough money to buy fuel or fuel tank full.";
                    Toast toast = Toast.makeText(
                            PoliceActivity.this, message,
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }
            }
        });


}