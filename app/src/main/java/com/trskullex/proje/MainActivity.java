package com.trskullex.proje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    private Spinner citySpinner;
    private Button showPlacesButton;

    private String selectedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Temayı yüklemek için
        loadTheme();

        setContentView(R.layout.activity_main);

        citySpinner = findViewById(R.id.citySpinner);
        showPlacesButton = findViewById(R.id.showPlacesButton);

        // Spinner için adaptör oluşturdum ve kaynak belirttiğim kısım
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);


        // Spinner'da bir öğe seçildiğinde tetiklenecek olayları belirledim
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCity = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Show places to visit butonuna tıklanınca tetiklenecek olayları belirlediğim kısımım
        showPlacesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedCity != null) {
                    // Logcat e seçilen şehiri yazdırdığım kısım
                    Log.d("MainActivity", "Button Clicked. Selected City: " + selectedCity);

                    // CityActivitye geçiş yapmak için Intent oluşturdum
                    Intent intent = new Intent(MainActivity.this, CityActivity.class);
                    intent.putExtra("SELECTED_CITY", selectedCity);
                    startActivity(intent); // CityActivity' e geçiş kısmı
                }
            }
        });
    }

    // Temayı yükleme metodu
    private void loadTheme() {
        SharedPreferences preferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        boolean isDarkMode = preferences.getBoolean("dark_mode", false);

        if (isDarkMode) {
            // Koyu tema
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            // Açık tema
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}

