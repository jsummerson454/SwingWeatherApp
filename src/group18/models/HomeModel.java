package group18.models;

import group18.backend.Day;
import group18.screens.HomeView;

import javax.swing.*;

public class HomeModel {
    public HomeView homeView;


    public HomeModel (SettingsModel settingModel, HomeView homeView) {
        this.homeView = homeView;
        // Add Day today as a parameter

        /*
        // Setting up the average temperature
        double averageTemp = 0.5*(today.getMaxTemperature()+today.getMinTemperature());
        // Using function in settings model to convert to string
        String tempStr = settingModel.getInUnits(averageTemp);
        homeView.actualTemperature.setText(tempStr);
        // Our API does not provide this so we are just setting it to the current
        // temperature for now
        homeView.feelsLike.setText("Feels like " + tempStr);
        */


    }
}
