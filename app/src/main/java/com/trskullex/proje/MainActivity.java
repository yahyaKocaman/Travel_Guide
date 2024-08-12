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

    // Spinner ve Button değişkenlerini tanımladığım yer
    private Spinner citySpinner;
    private Button showPlacesButton;

    // Seçilen şehiri saklamak için bir oluşturduğum değişkenim
    private String selectedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Temayı yüklemek için metod
        loadTheme();

        setContentView(R.layout.activity_main);

        // Spinner ve Buttonla ilgili layout IDleri kullanarak başlattım
        citySpinner = findViewById(R.id.citySpinner);
        showPlacesButton = findViewById(R.id.showPlacesButton);

        // ArrayAdapter kullanarak string array ve varsayılan spinner layout'u ile bir adaptör oluşturdum
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.cities, android.R.layout.simple_spinner_item);

        // Seçenekler listesi göründüğünde kullanılacak düşen görünümü belirttim
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Adaptörü spinnere uyguladım
        citySpinner.setAdapter(adapter);

        // Spinner için bir OnItemSelectedListener kurdum
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Bir öğe seçildiğinde, seçilen şehiri değişkende sakladım
                selectedCity = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Spinner'da hiçbir şey seçilmediğinde bu metod çağrılacak
            }
        });

        // "Yerleri Göster" butonu için bir OnClickListener kurdum
        showPlacesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedCity != null) {
                    // Seçilen şehiri Logcat'e kaydet
                    Log.d("MainActivity", "Button Clicked. Selected City: " + selectedCity);

                    // CityActivity'e geçiş yapmak için bir Intent oluştur
                    Intent intent = new Intent(MainActivity.this, CityActivity.class);

                    // Seçilen şehiri intent'e ekleyerek gönderdim
                    intent.putExtra("SELECTED_CITY", selectedCity);

                    // CityActivity'yi başlatma metodum
                    startActivity(intent);
                }
            }
        });
    }

    // Temayı SharedPreferences'ten yüklemek için metodum
    private void loadTheme() {
        SharedPreferences preferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        // Kaydedilen tema tercihini al (koyu mod veya açık mod)
        boolean isDarkMode = preferences.getBoolean("dark_mode", false);

        // Kaydedilen tercihe göre uygulamanın temasını ayarla
        if (isDarkMode) {
            // Koyu tema
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            // Açık tema
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
