package com.example.spacetrader.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.model.AppComponent;
import com.example.spacetrader.model.AppModule;

import javax.inject.Inject;

public class ShipInfoActivity extends AppCompatActivity {

    private Player player;
    private TextView fuelTextView;
    private TextView capTextView;
    private TextView currCapTextView;
    private TextView currFuelTextView;
    private TextView walletTextView;

    @SuppressWarnings("WeakerAccess")
    @Inject
    AppModule.SpaceTraderModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent component =((SpaceTrader) getApplication()).getAppComponent();
        component.inject(this);

        setContentView(R.layout.activity_ship);

        Toolbar toolbar = findViewById(R.id.shipToolBar);
        player = model.player;

        toolbar.setTitle("Ship Information");
        toolbar.setSubtitle("" + player.getShipType() + "");

        currCapTextView = findViewById(R.id.shipCurrCapTextView);
        currFuelTextView = findViewById(R.id.shipCurrFuelTextView);
        fuelTextView = findViewById(R.id.shipFuelTextView);
        capTextView = findViewById(R.id.shipCapTextView);
        walletTextView = findViewById(R.id.wallet);


        Button fuelButton = findViewById(R.id.buyFuelButton);
        fuelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update to check that we need fuel when we change curr fuel
                if ((player.getWallet() >= 5) &&
                        (player.getShip().getCurrFuel() < player.getShip().getFuel())) {
                    player.getShip().setCurrFuel(player.getShip().getCurrFuel() + 1);
                    player.setWallet(player.getWallet() - 5);
                } else {
                    String message = "Not enough money to buy fuel or fuel tank full.";
                    Toast toast = Toast.makeText(
                            ShipInfoActivity.this, message,
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }
                update();
            }
        });

        Button weaponButton = findViewById(R.id.upgradeWeaponsButton);
        weaponButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update to check that player can purchase upgrades to weapons
                if ((player.getWallet() >= 500) &&
                        (player.getShip().getCurrShieldSlots() <
                                player.getShip().getMaxWeaponSlots())) {
                    player.getShip().setCurrWeaponSlots(player.getShip().getCurrWeaponSlots() + 1);
                    player.setWallet(player.getWallet() - 500);
                } else {
                    String message = "Not enough money to upgrade weapon arsenal" +
                            " or weapon arsenal at max upgrades.";
                    Toast toast = Toast.makeText(
                            ShipInfoActivity.this, message,
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }
                update();
            }
        });

        Button shieldButton = findViewById(R.id.upgradeShieldsButton);
        shieldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //update to check that player can purchase upgrades to shields
                if ((player.getWallet() >= 750) &&
                        (player.getShip().getCurrShieldSlots() <
                                player.getShip().getMaxShieldSlots())) {
                    player.getShip().setCurrShieldSlots(player.getShip().getMaxShieldSlots() + 1);
                    player.setWallet(player.getWallet() - 750);
                } else {
                    String message = "Not enough money to upgrade shield array" +
                            " or shield array at max upgrades.";
                    Toast toast = Toast.makeText(
                            ShipInfoActivity.this, message,
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }
                update();
            }
        });

        Button insuranceButton = findViewById(R.id.buyInsuranceButton);
        insuranceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //update to check that player can buy insurance
                if (player.getShip().getInsured()) {
                    String message = "This ship is already insured";
                    Toast toast = Toast.makeText(
                            ShipInfoActivity.this, message,
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }else if ((player.getWallet() >= 2000) &&
                        (!player.getShip().getInsured())) {
                    player.getShip().setInsured(true);
                    player.setWallet(player.getWallet() - 2000);
                } else {
                    String message = "Not enough money to buy insurance.";
                    Toast toast = Toast.makeText(
                            ShipInfoActivity.this, message,
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }
                update();
            }
        });

        Button escapePodButton = findViewById(R.id.buyEscapePodButton);
        escapePodButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //update to check that we need fuel when we change curr fuel
                if (player.getShip().getEscapePod()) {
                    String message = "This ship already has an escape pod installed";
                    Toast toast = Toast.makeText(
                            ShipInfoActivity.this, message,
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }else if ((player.getWallet() >= 250) &&
                        (!player.getShip().getEscapePod())) {
                    player.getShip().setEscapePod(true);
                    player.setWallet(player.getWallet() - 250);
                } else {
                    String message = "Not enough money to buy escape pod.";
                    Toast toast = Toast.makeText(
                            ShipInfoActivity.this, message,
                            Toast.LENGTH_SHORT
                    );
                    toast.show();
                }
                update();
            }
        });
        update();


    }

    private void update() {
        Ship ship = player.getShip();
        int currCargoLoad = player.getShipCurrentCapacity();
        int maxCargoCapacity = ship.getMaxCapacity();
        int maxFuelCapacity = ship.getFuel();
        int currFuel = ship.getCurrFuel();

        currCapTextView.setText("Cargo Space Available: "
                + (maxCargoCapacity - currCargoLoad) + "");
        currFuelTextView.setText("Fuel available" + currFuel + "");
        fuelTextView.setText("Fuel Capacity: " + maxFuelCapacity + "");
        capTextView.setText("Max Cargo Capacity: " + maxCargoCapacity + "");
        walletTextView.setText("Wallet:  " + player.getWallet());
    }
}
