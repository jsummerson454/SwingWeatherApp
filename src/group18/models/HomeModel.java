package group18.models;

import group18.Application;
import group18.Main;
import group18.api.WeatherAPI;
import group18.backend.Day;
import group18.screens.HomeView;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class HomeModel {
    public HomeView homeView;
    private SettingsModel settingsModel;

    public double getAverageTemperature() {
        return averageTemperature;
    }

    private double averageTemperature;


    public HomeModel (SettingsModel settingsModel, HomeView homeView) {
        this.homeView = homeView;
        this.settingsModel = settingsModel;

        Calendar thisInstant = Calendar.getInstance();

        Day today = WeatherAPI.getForecastForADay(thisInstant.get(Calendar.DAY_OF_MONTH));

        // Setting up the average temperature
        averageTemperature = 0.5*(today.getMaxTemperature()+today.getMinTemperature());
        homeView.imageIcon.setIcon(Application.getWeatherIcon(today.getWeatherIconType()));
        refreshLabels();
    }

    public void refreshLabels () {
        // Using function in to convert to string
        String tempStr = settingsModel.getInUnits(averageTemperature);
        homeView.actualTemperature.setText(tempStr);
        // Our API does not provide this so we are just setting it to the current
        // temperature for now
        homeView.feelsLike.setText("Feels like " + tempStr);
    }
}
