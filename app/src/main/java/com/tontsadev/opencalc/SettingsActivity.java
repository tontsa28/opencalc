package com.tontsadev.opencalc;

// Import AppCompatActivity
import androidx.appcompat.app.AppCompatActivity;

// Import other classes
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

// SettingsActivity class
public class SettingsActivity extends AppCompatActivity {

    // Initialize the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set activity_settings as the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Add toolbar to activity
        Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrowback_white);

    }

    // Initialize toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Add menu items to the toolbar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_settings, menu);
        return true;

    }
}