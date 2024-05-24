package com.trskullex.proje;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // mainactvityde basliomu kontrolü
        if (getIntent().getStringExtra("SELECTED_CITY") == null) {
            finish();
            return;
        }

        setContentView(R.layout.activity_city);

        // Şehir adını aldım
        String selectedCity = getIntent().getStringExtra("SELECTED_CITY");

        // Gezilecek yerleri gösterdim
        if (selectedCity != null) {
            showPlaces(selectedCity);
        } else {
            // tost mesajı
            Toast.makeText(this, "No city selected", Toast.LENGTH_SHORT).show();
            finish();
        }

        // Geri dön butonum
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Şehirdeki gezilecek yerleri gösteren metodum
    private void showPlaces(String selectedCity) {

        // Yerleri göstermek için bir düzen (layout) nesnem
        LinearLayout placesLayout = findViewById(R.id.placesLayout);

        //  null ise aktiviteyi kapat
        if (placesLayout == null) {
            finish();
            return;
        }

        // Seçilen şehre göre gezilecek yerleri aldım
        List<Place> places = getPlaces(selectedCity);

        // Her bir yer için bir düzen oluşturdum ve ekrana ekledim
        //iç içe geçmiş bir class olduğundan place değişkenim final olarak belirledim yoksa hata veriyor
        for (final Place place : places) {
            LinearLayout placeLayout = new LinearLayout(this);
            placeLayout.setOrientation(LinearLayout.VERTICAL);

            ImageView imageView = new ImageView(this);
            imageView.setImageResource(place.getImageResourceId());
            imageView.setAdjustViewBounds(true);

            // Resmin yükseklik ve genişlik ayarı kısmım
            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            imageParams.setMargins(0, 0, 0, 16);
            imageView.setLayoutParams(imageParams);

            // Resme tıklanınca yapılacak işlemleri belirlediğim kısım
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Seçilen yer hakkında detaylı bilgiler içeren PlaceDetailActivitye geçiş yapma kısmım
                    Intent intent = new Intent(CityActivity.this, PlaceDetailActivity.class);
                    intent.putExtra("SELECTED_PLACE", place);
                    startActivity(intent);
                }
            });

            // Resmi düzene ekleme kısmım
            placeLayout.addView(imageView);

            // Yer ismini gösterdiğim kısım
            TextView textView = new TextView(this);
            textView.setText(place.getName());
            textView.setTextColor(getResources().getColor(android.R.color.black));

            // TextView kutusunun parametrelerini ayarladığım kısım(yükseklik genişlik gibi)
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            textView.setLayoutParams(textParams);

            // TextViewi düzene eklediğim kısım
            placeLayout.addView(textView);

            // Yer düzenini ana düzene eklediğim yer
            placesLayout.addView(placeLayout);
        }
    }

    // Şehre göre gezilecek yerleri gösterdiğim yer
    private List<Place> getPlaces(String selectedCity) {
        List<Place> places = new ArrayList<>();

        if (selectedCity.equals("İstanbul")) {
            places.add(new Place(R.drawable.istanbul1, "Ayasofya",
                    "Hagia Sophia is a historical building built approximately 1500 years ago. Hagia Sophia Mosque is a historical cathedral and basilica built by the Byzantine emperor Justinian I between 532 and 537. This historical building, built with a basilica plan, became a Greek Orthodox cathedral in 1054."+
                            "\n"+
                            "For more information, you can check out these links:\n" +
                            "\n" +
                            "https://tr.wikipedia.org/wiki/Hagia Sophia\n" +
                            "https://ayasofyamuzesi.gov.tr/", "Sultanahmet, Istanbul", 41.0082, 28.9784));
            places.add(new Place(R.drawable.istanbul2, "Maiden Tower", "Maiden's Tower is a historical tower located on the Bosphorus. According to historical records, the tower, which is 24 meters high, was first built in B.C. It was built in 24. The tower, which has been used for many different purposes, serves as a lighthouse, watchtower, quarantine station and today a restaurant.\n" +
                    "\n" +
                    "The history and legends of the Maiden's Tower are quite interesting. There are many legends and stories about the tower. If you would like to get more information about the history and legends of the Maiden's Tower, you can check out the links below:\n" +
                    "\n" +
                    "https://tr.wikipedia.org/wiki/K%C4%B1z_Kulesi\n" , "Sarayburnu, Istanbul", 41.0214, 29.0049));
            places.add(new Place(R.drawable.istanbul3, "Topkapı Palace", "Topkapı Palace is a palace complex used in the 15th and 16th centuries of the Ottoman Empire, located in the Fatih district of Istanbul. The palace was used by Ottoman sultans between 1465 and 1856. Topkapi Palace was opened to the public as a museum in 1924 and today houses many historical artifacts and collections.\n" +
                    "Topkapı Palace is the largest palace of the period and consists of many different structures. Inside the palace, there are important sections such as Harem, Enderun, Hasbahçe, Kubbealtı and Divan-ı Hümayun. There are also many historical artifacts, weapon collections, jewelry and other important artifacts from the Ottoman period inside the palace.\n" +
                    "For more information you can visit these links:\n" +
                    "https://tr.wikipedia.org/wiki/Topkap%C4%B1_Saray%C4%B1", "Beyazıt, Istanbul", 41.0115, 28.9814));
            places.add(new Place(R.drawable.istanbul4,   "Bosphorus tour", "Bosphorus tours are usually organized as half-day or full-day and give tourists the opportunity to visit important points such as the Bosphorus Bridge, Topkapı Palace, Dolmabahçe Palace, Maiden's Tower. In addition, historical and cultural information is given during the tours, usually accompanied by local guides.\n" +
                    "If you would like to get more information about the Bosphorus tour and take a look at the tour programs, you can review the links below:\n" +
                    "https://www.touristanbul.com/tr/boaz-turu", "Bosphorus, Istanbul", 41.1621, 29.0496));
        }
        else if (selectedCity.equals("Ankara")) {
            places.add(new Place(R.drawable.ankara1, "Anıtkabir", "Anıtkabir is a monument and museum complex located in Ankara, the capital of Turkey, where the mausoleum of Mustafa Kemal Atatürk, the founder of the Republic of Turkey, is located. Anıtkabir is an important symbol of Turkish national identity and is visited by millions of visitors every year.\n" +
                    "\n" +
                    "To get more information about Anıtkabir and plan a visit, you can visit the links below:\n" +
                    "\n" +
                    "Anıtkabir Official Website: https://www.anitkabir.tsk.tr/\n" +
                    "\n" +
                    "Anıtkabir Museum and Mausoleum - Republic of Turkey Ministry of Culture and Tourism: https://muze.gov.tr/muzeler/anitkabir-muzesi-ve-anit-mezari\n" +
                    "\n" +
                    "Anıtkabir - Wikipedia: https://tr.wikipedia.org/wiki/An%C4%B1tkabir", "Ankara", 39.9220 ,32.8358));
            places.add(new Place(R.drawable.ankara2, "Sakarya Battle Historical National Park", "Sakarya Battle Historical National Park is a national park located in the Sakarya province of Turkey. This park is located in the region where the Battle of Sakarya, an important turning point of the Turkish War of Independence, took place. The park offers visitors a historical atmosphere and keeps the memory of the Battle of Sakarya alive."
                    +"\n"+
                    "https://tr.wikipedia.org/wiki/Sakarya_Meydan_Muharebesi\n" +
                    "https://www.turizm.net/turkey/info/history/sakarya.html", "Ankara", 40.7892, 30.4120));
            places.add(new Place(R.drawable.ankara3, "Atatürk Forest Farm", "Atatürk Forest Farm is an agricultural research and application farm located in Çankaya district of Ankara and established in 1925. This is one of the largest agricultural research and application centers in Turkey. Many activities such as agricultural research, agricultural education, animal husbandry and plant cultivation are carried out on the farm. There are also recreational areas on the farm such as picnic areas, children's playgrounds and hiking trails.\n" +
                    "\n" +
                    "For more information, you can check out these links:\n" +
                    "\n" +
                    "https://tr.wikipedia.org/wiki/Atat%C3%BCrk_Orman_%C3%87iftli%C4%9Fi", "Ankara",  39.9371, 32.8537));
            places.add(new Place(R.drawable.ankara4, "Etnografya Müzesi", "Ethnographic museums are museums where objects, traditions, clothing, handicrafts and other ethnographic items belonging to human culture are exhibited. These museums are often visited to understand the lifestyles and history of different cultures. Ethnographic museums usually contain artifacts collected and classified by anthropologists and ethnologists.\n" +
                    "\n" +
                    "Ethnographic museums offer visitors the opportunity to understand the lifestyles, traditions and history of different cultures. These museums generally exhibit ethnographic works as well as the results of ethnological research.."
                    +"\n"+
                    "Ankara Ethnography Museum: https://tr.wikipedia.org/wiki/Ankara_Etnografya_M%C3%BCzesi\n" +
                    "\n" +
                    "You can visit the official website of the Ministry of Culture and Tourism to get information about other ethnography museums in Turkey.", "Ankara", 39.9438, 32.8562));
        }
        else if (selectedCity.equals("İzmir")) {
            places.add(new Place(R.drawable.izmir1, "Konak Meydanı", "Izmir Konak Square is a historical square located in the center of Izmir and one of the most important squares of the city. The square was built during the Ottoman period in the 17th century and hosts many historical buildings. The historical clock tower located in Konak Square is one of the symbolic buildings of Izmir and was built in 1901.\n" +
                    "\n" +
                    "The square also hosts various historical buildings, restaurants, cafes and shopping opportunities. Additionally, Konak Square is one of the most popular tourist spots in Izmir and offers a historical and cultural experience for visitors.\n"
                    +"https://tr.wikipedia.org/wiki/Konak_Meydan%C4%B1", "İzmir", 38.4192, 27.1287));
            places.add(new Place(R.drawable.izmir2, "Alaçatı", "Alaçatı, located in the Çeşme district of İzmir, is one of the most popular holiday resorts in Turkey. Alaçatı is known for its historical stone houses, windsurfing opportunities, famous beaches and delicious restaurants. It also attracts attention with its cute cafes, boutique hotels and lively nightlife.\n" +
                    "\n" +
                    "Alaçatı's famous winds offer an ideal environment for windsurfing and sailing sports. In addition, the stone houses, narrow streets and courtyards decorated with flowers in Alaçatı create the unique atmosphere of the town.\n" +
                    "\n" +
                    "Places to visit in Alaçatı include historical stone houses, Alaçatı Market, wind mills and beaches. In addition, many famous events and festivals held in Alaçatı attract the attention of visitors.\n" +
                    "\n" +
                    "To get more information about Alaçatı, you can visit the links below:\n" +
                    "\n" +
                    "Alaçatı Municipality Official Website: https://tr.wikipedia.org/wiki/Ala%C3%A7at%C4%B1\n" +
                    "Alaçatı Travel Guide: https://www.rehbername.com/kesfet/alacatinin-tarihcesi", "İzmir", 38.4192, 27.1287));
            places.add(new Place(R.drawable.izmir3, "Ephesus Antik Kenti", "The Ancient City of Ephesus is located in the Izmir province of Turkey and dates back to B.C. It is an important ancient city dating back to the 10th century. Ephesus is known as an important port city and trade center in ancient times. Today, it hosts many historical ruins that visitors can see, including important buildings such as the Library of Celsus, the Grand Theatre, the Temple of Artemis and the House of Virgin Mary.\n" +
                    "\n" +
                    "If you would like to get more information about the Ancient City of Ephesus and plan a visit, you can review the links below:\n" +
                    "\n" +
                    "https://www.kulturportali.gov.tr/turkiye/izmir/gezecekyer/efes-antik-kenti\n" +
                    "\n" +
                    "https://www.ktb.gov.tr/EN-113736/efes-antik-kenti.html", "Selçuk, İzmir", 37.9394, 27.3412));
            places.add(new Place(R.drawable.izmir4, "Pergamon Acropolis Ancient City", "Pergamon Acropolis is an ancient city located in a city known as Pergamon in ancient times. Today, Bergama is a district of Izmir province of Turkey. The acropolis is a region usually located at the highest point in ancient cities and where important structures such as temples, palaces and theaters are located.\n" +
                    "\n" +
                    "The Acropolis of Pergamon played an important role as a major center of culture, art and science during the Hellenistic period. Among the structures in the acropolis, there are many important structures such as the Temple of Athena, the Temple of Traian, a library, a theater and a palace.\n" +
                    "\n" +
                    "If you would like to learn more about this ancient city and take a look at its images, you can use the links below:\n" +
                    "\n" +
                    "https://www.kulturportali.gov.tr/turkiye/izmir/gezecekyer/bergama-akropolu\n" +
                    "https://tr.wikipedia.org/wiki/Pergamon", "Bergama, Izmir", 39.1208, 27.1807));
        }

        return places;
    }
}
