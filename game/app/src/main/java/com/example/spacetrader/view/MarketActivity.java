package com.example.spacetrader.view;

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
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.Universe;
import com.example.spacetrader.viewModel.ConfigViewModel;
import android.widget.SeekBar;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;



public class MarketActivity extends AppCompatActivity {
    @Override
    // idk below
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        // need to make a for loop to put hash map keys and values in an array called tradeGoods
        // or make a HashMap adapter

        //figure out how to do two lists

        //converts an array into a list UI
        //android.R.layout is how i want the list to look
        ListAdapter tradeGoodsAdapter = new ArrayAdapter<TradeGood>(this, android.R.layout.simple_list_item_1, tradeGoods);
        ListView tradeGoodsListView = findViewById(R.id.tradeGoodsListView);
        tradeGoodsListView.setAdapter(tradeGoodsAdapter);

        tradeGoodsListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //do stuff to edit inventory
                    }
                }
        );
    }
}