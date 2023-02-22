package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity {
    private TextView cityWeather, temperatureWeather, weatherConditionWeather,
            humidityWeather, maxTemperatureWeather, minTemperatureWeather, pressureWeather, windWeather;

    private Button search;
    private EditText editText;

    private ImageView imageViewWeather;

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
                    String cityName = editText.getText().toString();
                    getWeatherData(cityName);
                    editText.setText("");
            }
        });
    }

    public void getWeatherData(String name){

        WeatherAPI weatherAPI = RetrofitWeather.getClient().create(WeatherAPI.class);
        Call<OpenWeatherMap> call = weatherAPI.getWeatherWithCity(name);
        call.enqueue(new Callback<OpenWeatherMap>() {
            @Override
            public void onResponse(Call<OpenWeatherMap> call, Response<OpenWeatherMap> response) {

                if(response.isSuccessful()){
                    cityWeather.setText(response.body().getName() + " , " + response.body().getSys().getCountry());
                    temperatureWeather.setText(response.body().getMain().getTemp()+"°C");
                    weatherConditionWeather.setText(response.body().getWeather().get(0).getDescription());
                    humidityWeather.setText(" : " + response.body().getMain().getHumidity()+"%");
                    maxTemperatureWeather.setText(" : " + response.body().getMain().getTempMax()+"");
                    minTemperatureWeather.setText(" : " + response.body().getMain().getTempMin()+"");
                    pressureWeather.setText(" : " + response.body().getMain().getPressure());
                    windWeather.setText(" : " + response.body().getWind().getSpeed());

                    String iconCode = response.body().getWeather().get(0).getIcon();
                    Picasso.get().load("https://openweathermap.org/img/wn/"+iconCode+"@2x.png")
                            .placeholder(R.drawable.ic_launcher_background)
                            .into(imageViewWeather);
                }else{
                    Toast.makeText(WeatherActivity.this, "City not found, please try again.", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<OpenWeatherMap> call, Throwable t) {

            }
        });
    }
}