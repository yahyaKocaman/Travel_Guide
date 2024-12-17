# Travel Guide Application
![Team_Logo](https://github.com/yahyaKocaman/Travel_Guide/blob/master/logo.jpg)
## About
A comprehensive Android travel guide application that helps users explore cities in Turkey, discover landmarks, and plan their trips effectively.

## Features

### 🌟 Key Features
- Interactive city selection interface
- Real-time weather information for selected cities
- Detailed information about tourist attractions
- Google Maps integration for navigation
- Street View support for immersive location preview
- Camping locations map
- Dark/Light theme support

### 🏛️ Supported Cities
- Istanbul
- Ankara
- Izmir
- Bursa
- Antalya

### 📍 For Each City
- Historical landmarks
- Cultural sites
- Natural attractions
- Tourist spots
- Location coordinates
- Detailed descriptions
- Navigation support

## Technical Details

### 🛠️ Built With
- Java
- Android SDK
- Google Maps API
- OpenWeather API
- WebView
- Glide for image loading
- Volley for network requests
- SharedPreferences for theme persistence

### 📱 Key Components
- `MainActivity`: Main application interface
- `CityActivity`: City-specific information display
- `PlaceDetailActivity`: Detailed view of locations
- `CampingActivity`: Camping locations interface
- `MenuActivity`: Application navigation menu

### 🔧 Dependencies
dependencies {
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    implementation 'com.android.volley:volley:1.2.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.22'
}


### Setup
# Prerequisites
Android Studio
JDK 8 or higher
Android SDK
Google Maps API key
OpenWeather API key
## Installation
Clone the repository:
git clone https://github.com/yahyaKocaman/Travel_Guide

Open project in Android Studio

Configure API keys in local.properties:

MAPS_API_KEY=your_google_maps_api_key
WEATHER_API_KEY=your_openweather_api_key


### Build and run the application
# Usage
Launch the application
Select a city from the available options
Browse through various attractions
Use navigation features to explore locations
View weather information
Access Street View for immersive location preview
# Contributing
Fork the repository
Create your feature branch (git checkout -b feature/AmazingFeature)
Commit your changes (git commit -m 'Add some AmazingFeature')
Push to the branch (git push origin feature/AmazingFeature)
Open a Pull Request
### License
This project is licensed under the MIT License - see the LICENSE file for details

### Acknowledgments
Google Maps Platform
OpenWeather API
Android Development Team
Contributors and testers
