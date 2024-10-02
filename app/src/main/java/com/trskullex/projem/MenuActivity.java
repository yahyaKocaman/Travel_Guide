package com.trskullex.projem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.bumptech.glide.Glide;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadTheme(); 
        setContentView(R.layout.activity_menu);

        ImageButton travelButton = findViewById(R.id.travelButton);
        ImageButton campingButton = findViewById(R.id.campingButton);

        
        Glide.with(this)
                .asGif()
                .load(R.drawable.travel_animated) 
                .into(travelButton);

        Glide.with(this)
                .asGif()
                .load(R.drawable.camping_animated) 
                .into(campingButton);

        travelButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
        });

        campingButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, CampingActivity.class);
            startActivity(intent);
        });
    }

    private void loadTheme() {
        SharedPreferences preferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        boolean isDarkMode = preferences.getBoolean("dark_mode", false);
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
