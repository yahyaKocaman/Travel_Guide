package com.trskullex.proje;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlaceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_detail);

        // Seçilen yer nesnesini aldım
        Place selectedPlace = (Place) getIntent().getSerializableExtra("SELECTED_PLACE");

        // Yer detaylarını gösterdim
        if (selectedPlace != null) {
            displayPlaceDetails(selectedPlace);
        }

        // Geri Dön Butonum
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Street View Button
        Button streetViewButton = findViewById(R.id.streetViewButton);
        streetViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStreetView(selectedPlace.getLatitude(), selectedPlace.getLongitude(), selectedPlace.getLocation());
            }
        });
    }

    private void displayPlaceDetails(Place place) {
        // Resmi ayarladım
        ImageView imageView = findViewById(R.id.detailImageView);
        imageView.setImageResource(place.getImageResourceId());

        // İsmi ayarladım
        TextView nameTextView = findViewById(R.id.detailNameTextView);
        nameTextView.setText(place.getName());

        // Tıklanabilir linklerle açıklama ayarladım
        TextView descriptionTextView = findViewById(R.id.detailDescriptionTextView);
        descriptionTextView.setText(place.getDescription());
        Linkify.addLinks(descriptionTextView, Linkify.WEB_URLS); // Linkleri tıklanabilir hale getirdim
        descriptionTextView.setMovementMethod(LinkMovementMethod.getInstance());

        // Konumu ayarladım
        TextView locationTextView = findViewById(R.id.detailLocationTextView);
        locationTextView.setText(place.getLocation());

        // 3D Navigasyon Butonum
        Button navigateButton = findViewById(R.id.navigateButton);
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = place.getLatitude();
                double longitude = place.getLongitude();

                // Google Maps uygulamasını başlatmak için bir URI oluşturdum
                Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + Uri.encode(place.getLocation()));

                // Bir harita uygulamasını açmak için bir Intent oluşturdum
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps"); // Sadece Google Maps uygulamasını kullan

                // Eğer cihazda Google Maps yüklü ise başlattım
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    // Eğer Google Maps yüklü değilse, kullanıcıya bir mesaj gösterdim
                    Toast.makeText(PlaceDetailActivity.this, "Google Maps app not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openStreetView(double latitude, double longitude, String location) {
        // StreetView enlem boylam urlsi
        Uri streetViewUri = Uri.parse("google.streetview:cbll=" + latitude + "," + longitude);

        // Street viewi başlatma
        Intent streetViewIntent = new Intent(Intent.ACTION_VIEW, streetViewUri);

        // streetview paketini uygulama
        streetViewIntent.setPackage("com.google.android.apps.maps");

        //kullanıcının cihazında streetview varmı yok mu kontrolü
        if (streetViewIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(streetViewIntent);
        } else {
            //streetview yoksa hata mesajım
            Toast.makeText(this, "Street View app not installed", Toast.LENGTH_SHORT).show();
        }
    }
}
