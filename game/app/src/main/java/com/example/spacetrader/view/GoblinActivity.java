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
import com.example.spacetrader.model.AppModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


public class GoblinActivity extends AppCompatActivity {

    @Inject
    AppModule.SpaceTraderModel model;

    private Player player;
    private Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SpaceTrader) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_goblin);

        Intent intent = getIntent();

        player = model.player;
        planet = player.getCurrPlanet();

        Toolbar toolbar = (Toolbar) findViewById(R.id.goblinToolbar);
        TextView fineTextView = (TextView) findViewById(R.id.tookTextView);

        toolbar.setTitle("Space Goblin Encounter");

        Button payGobButton = findViewById(R.id.payGobButton);
        final GoblinEncounter gob = new GoblinEncounter();
        player.resetGobProb();

        payGobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gob.surrender(player);
                Toast toast = Toast.makeText(
                        GoblinActivity.this, "The gobs took your money. Your wallet is now " + player.getWallet(),
                        Toast.LENGTH_SHORT
                );
                toast.show();

                finish();
            }
        });

        Button fightButton = findViewById(R.id.fightGobButton);
        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean success = gob.fight(player);

                if (success) {
                    Toast toast = Toast.makeText(
                            GoblinActivity.this, "You won!",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(
                            GoblinActivity.this, "They caught you! You lost... a lot of money... lucky you're alive.",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }

                finish();

            }
        });

    }
}