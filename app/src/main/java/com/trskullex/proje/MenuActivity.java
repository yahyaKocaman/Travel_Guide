package com.trskullex.proje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton travelButton = findViewById(R.id.travelButton);
        ImageButton campingButton = findViewById(R.id.campingButton);

        travelButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
        });

        campingButton.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, CampingActivity.class);
            startActivity(intent);
        });
    }
}