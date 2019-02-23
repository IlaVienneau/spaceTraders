package com.example.spacetrader.view;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.example.spacetrader.R;
import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.viewModel.ConfigViewModel;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;



import java.util.Arrays;
import java.util.List;


public class ConfigActivity extends AppCompatActivity {
    private ConfigViewModel viewModel;
    private EditText nameEditText = null;

    private TextView pointCountTextView = null;
    private SeekBar pilotSeekBar = null;
    private SeekBar fighterSeekBar = null;
    private SeekBar traderSeekBar = null;
    private SeekBar engineerSeekBar = null;

    private Toolbar toolbar;

    private Spinner difficultySpinner = null;

    private Player player;

    private int totalPointsAvailable = 16;
    private int remainingPoints = 0;
    private int pilotSkill = 0;
    private int fighterSkill = 0;
    private int traderSkill = 0;
    private int engineerSkill = 0;

    private void updateSkill(int skill, int change) {
        int[] skills = new int[]{pilotSkill, fighterSkill, traderSkill, engineerSkill};

        skill = change;

        int currentPoints = 0;
        for (int i : skills) {
            currentPoints += i;
        }

        remainingPoints = totalPointsAvailable - currentPoints;

        int overflow = Math.min(0, totalPointsAvailable - currentPoints);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        setSupportActionBar(toolbar);

        nameEditText = findViewById(R.id.name);

        difficultySpinner = findViewById(R.id.difficultySpinner);
        ArrayAdapter difficultyAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Difficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);

        pointCountTextView = findViewById(R.id.pointCountTextView);
        pilotSeekBar = findViewById(R.id.pilotSeekBar);
        fighterSeekBar = findViewById(R.id.fighterSeekBar);
        traderSeekBar = findViewById(R.id.traderSeekBar);
        engineerSeekBar = findViewById(R.id.engineerSeekBar);



        pilotSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = new Player(nameEditText.getText(), Ship.GNAT, );
            }
        });
    }
}
