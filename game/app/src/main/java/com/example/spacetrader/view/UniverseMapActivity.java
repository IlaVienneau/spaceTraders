package com.example.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Universe;

public class UniverseMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe_map);

        Intent intent = getIntent();
        final Universe universe = (Universe)intent.getSerializableExtra("Universe");
        final Player player = (Player)intent.getSerializableExtra("Player");
        System.out.println("Current planet in UniverseAct:  "+ player.getCurrplanet());

        Button tradeButton = findViewById(R.id.tradeButton);
        tradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UniverseMapActivity.this, MarketActivity.class);
                intent.putExtra("Player", player);
                startActivity(intent);
            }
        });
    }
}