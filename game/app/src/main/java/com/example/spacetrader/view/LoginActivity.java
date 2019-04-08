package com.example.spacetrader.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.spacetrader.R;
import com.example.spacetrader.SpaceTrader;
import com.example.spacetrader.model.AppModule;

import javax.inject.Inject;


public class LoginActivity extends AppCompatActivity {
    @Inject
    private
    AppModule.SpaceTraderModel model;

    private EditText nameEditText;
    private EditText passwordEditText;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((SpaceTrader) getApplication()).getAppComponent().inject(this);

        setContentView(R.layout.activity_login);
        setSupportActionBar(toolbar);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Space Trader");
        toolbar.setSubtitle("Load previous game");


        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (AppModule.load(name, password, getApplicationContext(), model)) {
                    Intent intent = new Intent(LoginActivity.this, UniverseMapActivity.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(LoginActivity.this, "No save file, or incorrect username/password", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
