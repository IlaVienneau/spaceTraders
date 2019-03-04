package com.example.spacetrader.view;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.example.spacetrader.R;
import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.Universe;
import com.example.spacetrader.viewModel.ConfigViewModel;
import android.widget.SeekBar;


import java.util.ArrayList;

public class ConfigActivity extends AppCompatActivity {
    private ConfigViewModel viewModel;
    private EditText nameEditText = null;

    private TextView pointCountTextView = null;
    private SeekBar pilotSeekBar = null;
    private SeekBar fighterSeekBar = null;
    private SeekBar traderSeekBar = null;
    private SeekBar engineerSeekBar = null;

    private Toolbar toolbar;

    private Spinner universeSizeSpinner = null;
    private Spinner difficultySpinner = null;

    private Player player;


    private final int totalPointsAvailable = 16;

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
                if (change >= 0) {
                    arr.get(i).data = Math.min(change, 16);
                } else {
                    arr.get(i).data = Math.max(change, 0);
                }
            }
            currentPoints += arr.get(i).data;
        }

        while (currentPoints > 16) {
            for (int i = 0; i < arr.size(); i++) {
                if (!arr.get(i).type.equals(type) && arr.get(i).data > 0) {
                    arr.get(i).data--;
                    currentPoints--;
                }
            }
        }

        remainingPoints = totalPointsAvailable - currentPoints;


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

        // TODO: hardcoded sizes
        String[] sizes = {"Small Universe", "Medium Universe", "Large Universe"};
        universeSizeSpinner = findViewById(R.id.universeSizeSpinner);
        ArrayAdapter universeSizeAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sizes);
        universeSizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        universeSizeSpinner.setAdapter(universeSizeAdapter);


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
                System.out.println(player.toString());

                String universeSize = universeSizeSpinner.getSelectedItem().toString();
                Universe universe;
                switch(universeSize) {
                    case "Small Universe":
                        universe = new Universe(50);
                        break;
                    case "Medium Universe":
                        universe = new Universe(75);
                        break;
                    case "Large Universe":
                        universe = new Universe(100);
                        break;
                    default:
                        universe = new Universe(75);
                        break;
                }

                Intent intent = new Intent(ConfigActivity.this, UniverseMapActivity.class);
                startActivity(intent);
                System.out.println("Universe Created");
                System.out.println(universe.toString());

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
