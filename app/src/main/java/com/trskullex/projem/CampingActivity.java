package com.trskullex.projem;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CampingActivity extends AppCompatActivity {

    private WebView mapWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camping);

        mapWebView = findViewById(R.id.mapWebView);
        Button backButton = findViewById(R.id.backButton);

        // WebView ayarları
        mapWebView.getSettings().setJavaScriptEnabled(true);
        mapWebView.setWebViewClient(new WebViewClient());

        // Google Maps haritasını yükleme
        String mapUrl = "https://www.google.com/maps/d/embed?mid=1nmRlfAZn5-RSes6WEpo4fH-fypjCmNvJ&ehbc=2E312F";
        mapWebView.loadUrl(mapUrl);

        backButton.setOnClickListener(v -> finish());
    }
}