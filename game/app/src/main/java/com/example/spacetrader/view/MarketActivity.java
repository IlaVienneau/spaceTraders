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
    private Player player;
    private Planet planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        Intent intent = getIntent();

        this.player = (Player)intent.getSerializableExtra("Player");
        this.planet = player.getCurrplanet();
    }
}
