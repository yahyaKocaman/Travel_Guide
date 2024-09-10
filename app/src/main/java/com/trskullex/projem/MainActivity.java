package com.trskullex.projem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton cityButton;
    private Button showPlacesButton;
    private Button backToMenuButton;
    private String selectedCity;
    private ImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadTheme();
        setContentView(R.layout.activity_main);

        cityButton = findViewById(R.id.cityButton);
        showPlacesButton = findViewById(R.id.showPlacesButton);
        backToMenuButton = findViewById(R.id.backToMenuButton);
        gifImageView = findViewById(R.id.gifImageView);

        ImageView imageView = findViewById(R.id.imageView);

        Glide.with(this)
                .asGif()
                .load(R.drawable.sa)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);

        // Load the new GIF below the cityButton
        Glide.with(this)
                .asGif()
                .load(R.drawable.road) // Replace with your actual GIF resource
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(gifImageView);

        cityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCityBottomSheet();
            }
        });

        showPlacesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedCity != null) {
                    Log.d("MainActivity", "Button Clicked. Selected City: " + selectedCity);
                    Intent intent = new Intent(MainActivity.this, CityActivity.class);
                    intent.putExtra("SELECTED_CITY", selectedCity);
                    startActivity(intent);
                }
            }
        });

        backToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void showCityBottomSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View bottomSheetView = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_cities, null);

        LinearLayout citiesContainer = bottomSheetView.findViewById(R.id.citiesContainer);
        String[] cities = getResources().getStringArray(R.array.cities);

        for (final String city : cities) {
            TextView cityTextView = new TextView(this);
            cityTextView.setText(city);
            cityTextView.setPadding(0, 20, 0, 20);
            cityTextView.setTextSize(18);
            cityTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedCity = city;
                    cityButton.setText(selectedCity);
                    bottomSheetDialog.dismiss();
                }
            });
            citiesContainer.addView(cityTextView);
        }

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
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