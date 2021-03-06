package com.example.spacetrader.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.PlanetInventory;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.TradeGood;
import com.example.spacetrader.model.AppComponent;
import com.example.spacetrader.model.AppModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


public class MarketActivity extends AppCompatActivity {

    @SuppressWarnings("WeakerAccess")
    @Inject
    AppModule.SpaceTraderModel model;

    private Player player;
    private Planet planet;

    private TextView walletTextView;
    private ListView planetGoodsListView;
    private ListView cargoGoodsListView;

    // View Models
    private ArrayList<TradeGood> planetGoods;
    private ArrayList<TradeGood> cargoGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppComponent component =((SpaceTrader) getApplication()).getAppComponent();
        //noinspection LawOfDemeter
        component.inject(this);

        setContentView(R.layout.activity_market);

        this.player = model.player;
        this.planet = player.getCurrPlanet();

        Toolbar toolbar = findViewById(R.id.toolbar);
        walletTextView = findViewById(R.id.walletTextView);
        planetGoodsListView = findViewById(R.id.tradeGoodsListView);
        cargoGoodsListView = findViewById(R.id.cargoGoodsListView);

        toolbar.setTitle(planet.getName() + " MarketPlace");

        cargoGoodsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Selling
                TradeGood good = cargoGoods.get(position);
                HashMap<TradeGood, PlanetInventory.TradeStock> planetInventory = planet
                        .getInventory();
                PlanetInventory.TradeStock stock = planetInventory.get(good);

                if (stock == null) {
                    Toast toast = Toast.makeText(
                            MarketActivity.this, "This planet cannot buy " + good.getName(),
                            Toast.LENGTH_SHORT
                    );
                    toast.show();

                    return;
                }

                HashMap<TradeGood, Integer> shipInventory = player.getShipInventory();
                int owned = shipInventory.get(good);
                if (owned == 0) {
                    Toast toast = Toast.makeText(
                            MarketActivity.this, "You don't have any!",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();

                    return;
                }


                stock.quantity += 1;

                shipInventory.put(good, owned - 1);
                player.setWallet(player.getWallet() + stock.price);
                AppModule.save(getApplicationContext(), model);
                update();
            }
        });

        planetGoodsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Buying

//                if (player.getShipCurrentCapacity() <= player.getShip().getCapacity()) {
//                    Toast.makeText(
//                            MarketActivity.this, "Ship is out of room!",
//                            Toast.LENGTH_SHORT
//                    ).show();
//
//                    return;
//                }

                TradeGood good = planetGoods.get(position);
                HashMap<TradeGood, PlanetInventory.TradeStock> planetInventory = planet
                        .getInventory();
                PlanetInventory.TradeStock stock = planetInventory.get(good);

                if ((stock == null) || (stock.quantity == 0)) {
                    Toast toast = Toast.makeText(
                            MarketActivity.this, "None available!",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();

                    return;
                } else if (player.getWallet() < stock.price) {
                    Toast toast = Toast.makeText(
                            MarketActivity.this, "Not enough credits!",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();

                    return;
                } else if (player.getShipCurrentCapacity() == player.getShip().getMaxCapacity()) {
                    Toast toast = Toast.makeText(
                            MarketActivity.this, "Your ship's cargo is full!",
                            Toast.LENGTH_SHORT
                    );
                    toast.show();

                    return;
                }

                stock.quantity -= 1;

                HashMap<TradeGood, Integer> shipInventory = player.getShipInventory();
                Integer owned = shipInventory.get(good);
                if (owned == null) {
                    owned = 0;
                }

                shipInventory.put(good, owned + 1);
                player.setWallet(player.getWallet() - stock.price);
                AppModule.save(getApplicationContext(), model);
                update();
            }
        });


        update();
    }

    private void update() {
        walletTextView.setText("Wallet: " + player.getWallet() + "₴");

        planetGoods = new ArrayList<>();
        ArrayList<String> planetGoodDescriptions = new ArrayList<>();
        Map<TradeGood, PlanetInventory.TradeStock> planetInventory = planet.getInventory();

        for (Map.Entry<TradeGood, PlanetInventory.TradeStock> entry : planetInventory.entrySet()) {
            TradeGood good = entry.getKey();
            PlanetInventory.TradeStock stock = entry.getValue();

            String description = good.getName()
                    + " [" + stock.quantity + "] "
                    + " @ " + stock.price + "₴";

            planetGoods.add(good);
            planetGoodDescriptions.add(description);
        }

        ListAdapter planetGoodsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                planetGoodDescriptions
        );

        planetGoodsListView.setAdapter(planetGoodsAdapter);
        Map<TradeGood, Integer> shipInventory = player.getShipInventory();

        cargoGoods = new ArrayList<>();
        ArrayList<String> cargoGoodDescriptions = new ArrayList<>();
        for (Map.Entry<TradeGood, Integer> entry : shipInventory.entrySet()) {
            TradeGood good = entry.getKey();
            Integer stock = entry.getValue();

            String description = good.getName()
                    + " [" + stock + "] ";

            cargoGoods.add(good);
            cargoGoodDescriptions.add(description);
        }

        ListAdapter cargoGoodsAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                cargoGoodDescriptions
        );

        cargoGoodsListView.setAdapter(cargoGoodsAdapter);
    }
}
