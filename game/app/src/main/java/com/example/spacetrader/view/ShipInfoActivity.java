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
import com.example.spacetrader.entity.ShipType;
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
                Ship ship = player.getShip();
                int wallet = player.getWallet();
                if (wallet > 5 && (ship.getCurrFuel() < ship.getFuel())) {
                    ship.setCurrFuel(ship.getCurrFuel() + 1);
                    player.setWallet(wallet - 5);
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
