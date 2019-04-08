package com.example.spacetrader.view;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.ShipType;
import com.example.spacetrader.entity.Universe;
import com.example.spacetrader.model.AppModule;
import com.example.spacetrader.viewModel.ConfigViewModel;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ConfigActivity extends AppCompatActivity {
    @Inject
    AppModule.SpaceTraderModel model;

    private ConfigViewModel viewModel;
    private EditText nameEditText;
    private EditText passwordEditText;

    private TextView pointCountTextView;
    private SeekBar pilotSeekBar;
    private SeekBar fighterSeekBar;
    private SeekBar traderSeekBar;
    private SeekBar engineerSeekBar;

    private Toolbar toolbar;

    private Spinner universeSizeSpinner;

    private final int totalPointsAvailable = 16;

    private int remainingPoints;
    private int pilotSkill;
    private int fighterSkill;
    private int traderSkill;
    private int engineerSkill;
    private Difficulty difficulty = Difficulty.BEGINNER;

    private static int smallUniverseSize = 50;
    private static int mediumUniverseSize = 75;
    private static int largeUniverseSize = 100;

    private void updateSkill(int skill, int change, String type) {
        class skillNode {
            private int data;
            private String type;
            skillNode(int d, String t) {
                data = d;
                type = t;
            }

        }
        List<skillNode> arr = new ArrayList<>();
        arr.add(new skillNode(pilotSkill,"pilot"));
        arr.add(new skillNode(fighterSkill,"fighter"));
        arr.add(new skillNode(traderSkill, "trader"));
        arr.add(new skillNode(engineerSkill,"engineer"));

        int currentPoints = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).type.equals(type)) {
                if (change >= 0) {
                    arr.get(i).data = Math.min(change, totalPointsAvailable);
                } else {
                    arr.get(i).data = Math.max(change, 0);
                }
            }
            currentPoints += arr.get(i).data;
        }

        while (currentPoints > totalPointsAvailable) {
            for (int i = 0; i < arr.size(); i++) {
                if (!arr.get(i).type.equals(type) && (arr.get(i).data > 0)) {
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
        ((SpaceTrader) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_config);
        setSupportActionBar(toolbar);

        nameEditText = (EditText) findViewById(R.id.name);
        passwordEditText = (EditText) findViewById(R.id.password);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Player Information");

        Spinner difficultySpinner = findViewById(R.id.difficultySpinner);
        ArrayAdapter difficultyAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Difficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);

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
                String name = nameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                Player player = new Player(
                        name,
                        password,
                        ShipType.GNAT,
                        pilotSkill,
                        fighterSkill,
                        traderSkill,
                        engineerSkill,
                        difficulty
                );
//                System.out.println("player created");
//                System.out.println(player.toString());

                String universeSize = universeSizeSpinner.getSelectedItem().toString();
                Universe universe;

                switch(universeSize) {
                    case "Small Universe":
                        universe = new Universe(smallUniverseSize);
                        break;
                    case "Medium Universe":
                        universe = new Universe(mediumUniverseSize);
                        break;
                    case "Large Universe":
                        universe = new Universe(largeUniverseSize);
                        break;
                    default:
                        universe = new Universe(mediumUniverseSize);
                        break;
                }

                player.setCurrPlanet(universe.getPlanet("Paradise", 1));

                model.player = player;
                model.universe = universe;
                AppModule.save(getApplicationContext(), model);

//                System.out.print("Set player to:  " + universe.getPlanet("Paradise", 1).toString());
                Intent intent = new Intent(ConfigActivity.this, UniverseMapActivity.class);
                startActivity(intent);
//                System.out.println("Universe Created");
//                System.out.println(universe.toString());
            }
        });

        update();
    }

    private void update() {
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
