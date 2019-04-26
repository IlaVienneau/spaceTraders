package com.example.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.GoblinEncounter;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.PoliceEncounter;
import com.example.spacetrader.entity.ShipType;
import com.example.spacetrader.model.AppModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


public class ShipyardActivity extends AppCompatActivity {

    @Inject
    AppModule.SpaceTraderModel model;

    private Player player;
    private Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SpaceTrader) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_shipyard);

        Intent intent = getIntent();

        player = model.player;
        planet = player.getCurrPlanet();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView upgradeMessageTextView = (TextView) findViewById(R.id.messageTextView);

        toolbar.setTitle("Shipyard: Upgrade Your Ship!");


        Button hornetShipButton = findViewById(R.id.ship3Button);
        hornetShipButton.setText("Upgrade to Hornet: 750");
        hornetShipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int wallet = player.getWallet();

                if (player.getWallet() > 750) {
                    player.setWallet(wallet - 750);
                    player.setShipType(ShipType.HORNET);
                    player.setShip(ShipType.HORNET);
                } else {
                    Toast toast = Toast.makeText(
                            ShipyardActivity.this, "Not enough credits!",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }


                Intent intent = new Intent(ShipyardActivity.this, ShipInfoActivity.class);
                startActivity(intent);
                finish();

            }
        });

        Button waspShipButton = findViewById(R.id.ship4Button);
        waspShipButton.setText("Upgrade to Wasp: 1000");
        waspShipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int wallet = player.getWallet();

                if (player.getWallet() > 1000) {
                    player.setWallet(wallet - 1000);
                    player.setShipType(ShipType.WASP);
                    player.setShip(ShipType.WASP);
                } else {
                    Toast toast = Toast.makeText(
                            ShipyardActivity.this, "Not enough credits!",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }

                Intent intent = new Intent(ShipyardActivity.this, ShipInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button fireflyShipButton = findViewById(R.id.ship2Button);
        fireflyShipButton.setText("Upgrade to firefly: 400");
        fireflyShipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int wallet = player.getWallet();

                if (player.getWallet() > 400) {
                    player.setWallet(wallet - 400);
                    player.setShipType(ShipType.FIREFLY);
                    player.setShip(ShipType.FIREFLY);
                } else {
                    Toast toast = Toast.makeText(
                            ShipyardActivity.this, "Not enough credits!",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }

                Intent intent = new Intent(ShipyardActivity.this, ShipInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button beetleShipButton = findViewById(R.id.ship1Button);
        beetleShipButton.setText("Upgrade to beetle: 500");
        beetleShipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wallet = player.getWallet();

                if (player.getWallet() > 500) {
                    player.setWallet(wallet - 500);
                    player.setShipType(ShipType.BEETLE);
                    player.setShip(ShipType.BEETLE);
                } else {
                    Toast toast = Toast.makeText(
                            ShipyardActivity.this, "Not enough credits!",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }


                Intent intent = new Intent(ShipyardActivity.this, ShipInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}