package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class WeatherActivity extends AppCompatActivity {
    private TextView cityWeather, temperatureWeather, weatherConditionWeather,
            humidityWeather, maxTemperatureWeather, minTemperatureWeather, pressureWeather, windWeather;

    private Button search;
    private EditText editText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        cityWeather = findViewById(R.id.textViewCity_weather);
        temperatureWeather = findViewById(R.id.textViewTemp_weather);
        weatherConditionWeather = findViewById(R.id.textViewWeatherCondition_weather);
        humidityWeather = findViewById(R.id.textViewHumidity_weather);
        maxTemperatureWeather = findViewById(R.id.textViewMaxTemp_weather);
        minTemperatureWeather = findViewById(R.id.textViewMinTemp_weather);
        pressureWeather = findViewById(R.id.textViewPressure_weather);
        windWeather = findViewById(R.id.textViewWind_weather);
        search = findViewById(R.id.search_weather);
        editText = findViewById(R.id.editTextCityName_weather);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}