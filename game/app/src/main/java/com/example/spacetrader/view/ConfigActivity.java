package com.example.spacetrader.view;

import android.content.Intent;
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


import java.lang.reflect.Array;
import java.util.ArrayList;
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
    private Difficulty difficulty = Difficulty.BEGINNER;


    private void updateSkill(int skill, int change, String type) {
        class skillNode {
            private int data;
            private String type;
            public skillNode(int d, String t) {
                data = d;
                type = t;
            }

        }
        ArrayList<skillNode> arr = new ArrayList<skillNode>();
        arr.add(new skillNode(pilotSkill,"pilot"));
        arr.add(new skillNode(fighterSkill,"fighter"));
        arr.add(new skillNode(traderSkill, "trader"));
        arr.add(new skillNode(engineerSkill,"engineer"));

        int currentPoints = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).type.equals(type)) {
                if (change + arr.get(i).data > 16) {
                    arr.get(i).data = 16;
                } else if (change + arr.get(i).data < 0) {
                    arr.get(i).data = 0;
                } else {
                    arr.get(i).data = arr.get(i).data + change;
                }
            }
            currentPoints += arr.get(i).data;
        }

        remainingPoints = totalPointsAvailable - currentPoints;

        double overflow = Math.min(0, remainingPoints);

        if (overflow < 0) {
            int delta = 0;
            int i = 0;
            while (delta > overflow) {
                if (arr.get(i).type.equals(type) || arr.get(i).data == 0) {
                    i = (i + 1) % arr.size();
                }
                arr.get(i).data -= 1;
                delta -= 1;
                remainingPoints--;
                i = (i + 1) % arr.size();
            }
        }

        pilotSkill = arr.get(0).data;
        fighterSkill = arr.get(1).data;
        traderSkill = arr.get(2).data;
        engineerSkill = arr.get(3).data;
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
                if (seekBar.equals(pilotSeekBar)) {
                    updateSkill(pilotSkill, progress, "pilot");
                } else if (seekBar.equals(fighterSeekBar)) {
                    updateSkill(fighterSkill, progress, "fighter");
                } else if (seekBar.equals(traderSeekBar)) {
                    updateSkill(traderSkill, progress, "trader");
                } else if (seekBar.equals(engineerSeekBar)) {
                    updateSkill(engineerSkill, progress, "engineer");
                }
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        fighterSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.equals(pilotSeekBar)) {
                    updateSkill(pilotSkill, progress, "pilot");
                } else if (seekBar.equals(fighterSeekBar)) {
                    updateSkill(fighterSkill, progress, "fighter");
                } else if (seekBar.equals(traderSeekBar)) {
                    updateSkill(traderSkill, progress, "trader");
                } else if (seekBar.equals(engineerSeekBar)) {
                    updateSkill(engineerSkill, progress, "engineer");
                }
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        traderSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.equals(pilotSeekBar)) {
                    updateSkill(pilotSkill, progress, "pilot");
                } else if (seekBar.equals(fighterSeekBar)) {
                    updateSkill(fighterSkill, progress, "fighter");
                } else if (seekBar.equals(traderSeekBar)) {
                    updateSkill(traderSkill, progress, "trader");
                } else if (seekBar.equals(engineerSeekBar)) {
                    updateSkill(engineerSkill, progress, "engineer");
                }
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        engineerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.equals(pilotSeekBar)) {
                    updateSkill(pilotSkill, progress, "pilot");
                } else if (seekBar.equals(fighterSeekBar)) {
                    updateSkill(fighterSkill, progress, "fighter");
                } else if (seekBar.equals(traderSeekBar)) {
                    updateSkill(traderSkill, progress, "trader");
                } else if (seekBar.equals(engineerSeekBar)) {
                    updateSkill(engineerSkill, progress, "engineer");
                }
                update();
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
                player = new Player(nameEditText.getText().toString(), Ship.GNAT, pilotSkill,
                        fighterSkill,traderSkill, engineerSkill, difficulty);
                System.out.println("player created");
            }
        });

        update();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void update() {
        pointCountTextView.setText(""+ remainingPoints + '/' + totalPointsAvailable);
        pilotSeekBar.setProgress(pilotSkill);
        fighterSeekBar.setProgress(fighterSkill);
        traderSeekBar.setProgress(traderSkill);
        engineerSeekBar.setProgress(engineerSkill);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }

}
