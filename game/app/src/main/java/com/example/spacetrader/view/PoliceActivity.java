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
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.PoliceEncounter;
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
        player = model.player;

        Button payFineButton = findViewById(R.id.payButton);
        final PoliceEncounter police = new PoliceEncounter();

        payFineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                police.pay(player);
                Toast toast = Toast.makeText(
                        PoliceActivity.this, "You paid the fine. Your wallet is now " + player.getWallet(),
                        Toast.LENGTH_SHORT
                );
                toast.show();
            }
        });

        Button fleeButton = findViewById(R.id.fleeButton);
        fleeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean success = police.flee(player);

                if (success) {
                    Toast toast = Toast.makeText(
                            PoliceActivity.this, "You got away!",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(
                            PoliceActivity.this, "They caught you! You lose half of your credits",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }

            }
        });

    }
}