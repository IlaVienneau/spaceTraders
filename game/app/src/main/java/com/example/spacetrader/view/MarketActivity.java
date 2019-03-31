package com.example.spacetrader.view;

import android.annotation.TargetApi;
import android.media.Image;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.PlanetInventory;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.PoliticalSystem;
import com.example.spacetrader.entity.Resource;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.ShipInventory;
import com.example.spacetrader.entity.TechLevel;
import com.example.spacetrader.entity.TradeGood;
import com.example.spacetrader.entity.Universe;
import com.example.spacetrader.model.AppModule;
import com.example.spacetrader.viewModel.ConfigViewModel;
import android.widget.SeekBar;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import com.example.spacetrader.entity.TradeGood;

import org.w3c.dom.Text;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;


public class MarketActivity extends AppCompatActivity {

    @Inject
    AppModule.SpaceTraderModel model;

    private Player player;
    private Planet planet;

    private Toolbar toolbar;
    private TextView walletTextView;
    private ListView planetGoodsListView;
    private ListView cargoGoodsListView;

    // View Models
    private ArrayList<TradeGood> planetGoods;
    private ArrayList<TradeGood> cargoGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SpaceTrader) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_market);

        Intent intent = getIntent();

        this.player = model.player;
        this.planet = player.getCurrplanet();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        walletTextView = (TextView) findViewById(R.id.walletTextView);
        planetGoodsListView = findViewById(R.id.tradeGoodsListView);
        cargoGoodsListView = findViewById(R.id.cargoGoodsListView);

        toolbar.setTitle(planet.getName() + " MarketPlace");

        cargoGoodsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Selling
                TradeGood good = cargoGoods.get(position);
                PlanetInventory.TradeStock stock = planet.getInventory().get(good);

                if (stock == null) {
                    Toast.makeText(
                            MarketActivity.this, "This planet cannot buy " + good.getName() + "s",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                int owned = player.getShipInventory().get(good);
                if (owned == 0) {
                    Toast.makeText(
                            MarketActivity.this, "You got none!",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }


                stock.quantity += 1;

                player.getShipInventory().put(good, owned - 1);
                player.setWallet(player.getWallet() + stock.price);

                update();
            }
        });

        planetGoodsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Buying

                // TODO: ship capacity
//                if (player.getShipCurrentCapacity() < player.getShipType().getMaxCapacity()) {
//                    Toast.makeText(
//                            MarketActivity.this, "Ship is out of room!",
//                            Toast.LENGTH_SHORT
//                    ).show();
//
//                    return;
//                }

                TradeGood good = planetGoods.get(position);
                PlanetInventory.TradeStock stock = planet.getInventory().get(good);

                if (stock.quantity == 0) {
                    Toast.makeText(
                            MarketActivity.this, "None available!",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                } else if (player.getWallet() < stock.price) {
                    Toast.makeText(
                            MarketActivity.this, "Not enough credits!",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                stock.quantity -= 1;

                Integer owned = player.getShipInventory().get(good);
                if (owned == null) {
                    owned = 0;
                }

                player.getShipInventory().put(good, owned + 1);
                player.setWallet(player.getWallet() - stock.price);

                update();
            }
        });


        update();
    }

    private void update() {
        walletTextView.setText("Wallet: " + player.getWallet() + "₴");

        planetGoods = new ArrayList<>();
        ArrayList<String> planetGoodDescriptions = new ArrayList<>();
        for (Map.Entry<TradeGood, PlanetInventory.TradeStock> entry : planet.getInventory().entrySet()) {
            TradeGood good = entry.getKey();
            PlanetInventory.TradeStock stock = entry.getValue();

            String description = good.getName()
                    + " [" + stock.quantity + "] "
                    + " @ " + stock.price + "₴";

            planetGoods.add(good);
            planetGoodDescriptions.add(description);
        }

        ListAdapter planetGoodsAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                planetGoodDescriptions
        );

        planetGoodsListView.setAdapter(planetGoodsAdapter);

        cargoGoods = new ArrayList<>();
        ArrayList<String> cargoGoodDescriptions = new ArrayList<>();
        for (Map.Entry<TradeGood, Integer> entry : player.getShipInventory().entrySet()) {
            TradeGood good = entry.getKey();
            Integer stock = entry.getValue();

            String description = good.getName()
                    + " [" + stock + "] ";

            cargoGoods.add(good);
            cargoGoodDescriptions.add(description);
        }

        ListAdapter cargoGoodsAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                cargoGoodDescriptions
        );

        cargoGoodsListView.setAdapter(cargoGoodsAdapter);
    }
}
