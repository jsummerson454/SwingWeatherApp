package group18.models;

import group18.screens.SettingsView;

public class SettingsModel {

    private SettingsView settingsView;

    private boolean celsius = true;
    private boolean notifications;

    // These variables are stored in celsius
    private double coldThreshold = -2.0;
    private double hotThreshold = 32.0;

    private double coldStart = -10;
    private double hotStart = 24;

    private String getInUnits (double val) {
        // Returns a string of the temperature
        // in the correct units
        if (celsius) {
            return String.format("%.2f℃", val);
        }
        return String.format("%.2f℉", val*1.8 + 32.0);
    }


    public double getColdThreshold() {
        return coldThreshold;
    }

    private void updateAboveBelowLabels () {
        // Updates labels in the view
        settingsView.belowLabel.setText("Below  " + getInUnits(coldThreshold));
        settingsView.aboveLabel.setText("Above  " + getInUnits(hotThreshold));
    }

    public void setColdThreshold(double sliderPos) {
        this.coldThreshold = sliderPos + coldStart;
        settingsView.belowLabel.setText("Below  " + getInUnits(coldThreshold));
    }

    public double getHotThreshold() {
        return hotThreshold;
    }

    public void setHotThreshold(double sliderPos) {
        this.hotThreshold = sliderPos + hotStart;
        settingsView.aboveLabel.setText("Above  " + getInUnits(hotThreshold));
    }

    public boolean isCelsius() {
        return celsius;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public SettingsView getView() {
        return settingsView;
    }

    public void setCelsius() {
        celsius = true;
        updateAboveBelowLabels();
    }

    public void setFahrenheit () {
        celsius = false;
        updateAboveBelowLabels();
    }

    public void notificationsOn () {
        notifications = true;
    }

    public void notificationsOff () {
        notifications = false;
    }

    public SettingsModel(SettingsView settingsView) {
        this.settingsView = settingsView;
        updateAboveBelowLabels();
        settingsView.coldSlider.setValue((int)(coldThreshold-coldStart));
        settingsView.hotSlider.setValue((int)(hotThreshold-hotStart));
    }


}
