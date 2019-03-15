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
import com.example.spacetrader.viewModel.ConfigViewModel;
import android.widget.SeekBar;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import com.example.spacetrader.entity.TradeGood;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Optional;


public class MarketActivity extends AppCompatActivity {
    @Override
    // idk below
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        Intent intent = getIntent();
        Universe universe = (Universe)intent.getSerializableExtra("Universe");
        final Player player = (Player)intent.getSerializableExtra("Player");
        System.out.println("Current planet in MarketAct:  "+ player.getCurrplanet());

       // Planet home = universe.getPlanet("Paradise", 1);
        Planet home = player.getCurrplanet();
        System.out.println(home.getInventory());
        PlanetInventory inventory = (PlanetInventory) home.getInventory();

        final String[] tradeGoods = new String[inventory.getInventory().size()];
        final TradeGood[] planetGoods = new TradeGood[inventory.getInventory().size()];
        int i = 0;
        for (TradeGood trade : inventory.getInventory().values()) {
            tradeGoods[i] = trade.getName() + "  Price:  $" +
                    inventory.updatePrice(trade.getName(), player.getCurrplanet().getTechLevel());
            planetGoods[i] = trade;
            i++;
        }

        final ArrayList<TradeGood> cargoGoods = new ArrayList<>();
        //final TradeGood[] cargoGoods = new TradeGood[player.getShipInventory().getInventory().size()];


        for (TradeGood good : player.getShipInventory().getInventory().values()) {
            cargoGoods.add(good);
        }

        // temporary if-else for cargo inventory status
//        if (player.getShipInventory().getInventory() != null) {
           // final TradeGood[] cargoGoods = new TradeGood[player.getShipInventory().getInventory().size()];

          //  int j = 0;
           // for (TradeGood good : player.getShipInventory().getInventory().values()) {
           //     cargoGoods[j] = good;
          //      j++;
          //  }

            final ListAdapter cargoGoodsAdapter = new ArrayAdapter<TradeGood>(this, android.R.layout.simple_list_item_1, cargoGoods);
            ListView cargoGoodsListView = findViewById(R.id.cargoGoodsListView);
            cargoGoodsListView.setAdapter(cargoGoodsAdapter);

        if (player.getShipInventory().getInventory() != null) {
            cargoGoodsListView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //buy trade good at position
                            //player.buy, get player here too
                            player.getShipInventory().sell(cargoGoods.get(position), 1, player.getCurrplanet());
                            cargoGoods.clear();
                            for (TradeGood good : player.getShipInventory().getInventory().values()) {
                                System.out.println("Current good:  " + good);
                                cargoGoods.add(good);
                            }
                            ((ArrayAdapter) cargoGoodsAdapter).notifyDataSetChanged();
                        }
                    }
            );
        } else {
           cargoGoodsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //buy trade good at position
                            //player.buy, get player here too
                            Toast.makeText(MarketActivity.this, "Your cargo is empty", Toast.LENGTH_SHORT).show();;
                        }
                    }
            );
        }

//        } else {
//            String[] emptyCargo = {"No items in cargo"};
//
//            ListAdapter cargoGoodsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emptyCargo);
//            ListView cargoGoodsListView = findViewById(R.id.cargoGoodsListView);
//            cargoGoodsListView.setAdapter(cargoGoodsAdapter);
//
//            cargoGoodsListView.setOnItemClickListener(
//                    new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            //buy trade good at position
//                            //player.buy, get player here too
//                            Toast.makeText(MarketActivity.this, "Your cargo is empty", Toast.LENGTH_SHORT).show();;
//                        }
//                    }
//            );
//        }



        // need to make a for loop to put hash map keys and values in an array called tradeGoods
        // or make a HashMap adapter

        //figure out how to do two lists

        //converts an array into a list UI
        //android.R.layout is how i want the list to look



        ListAdapter tradeGoodsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tradeGoods);
        ListView tradeGoodsListView = findViewById(R.id.tradeGoodsListView);
        tradeGoodsListView.setAdapter(tradeGoodsAdapter);

//        Moved this up to if-else block for now 
//
//        ListAdapter cargoGoodsAdapter = new ArrayAdapter<TradeGood>(this, android.R.layout.simple_list_item_1, cargoGoods);
//        ListView cargoGoodsListView = findViewById(R.id.cargoGoodsListView);
//        cargoGoodsListView.setAdapter(cargoGoodsAdapter);



        tradeGoodsListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //buy trade good at position
                        //player.buy, get player here too

                        player.getShipInventory().buy(planetGoods[position], 1, player.getCurrplanet());
                        System.out.println(player.getShipInventory().getInventory());
                        cargoGoods.clear();
                        for (TradeGood good : player.getShipInventory().getInventory().values()) {
                            System.out.println("Current good:  " + good);
                            cargoGoods.add(good);
                        }
                        ((ArrayAdapter) cargoGoodsAdapter).notifyDataSetChanged();


                    }
                }
        );

//        cargoGoodsListView.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        //buy trade good at position
//                        //player.buy, get player here too
//                        player.getShipInventory().sell(cargoGoods[position], 1);
//                    }
//                }
//        );
    }
}

//get planet inventory
//loop thru the hashmap of that inventory to get each tradeGood
