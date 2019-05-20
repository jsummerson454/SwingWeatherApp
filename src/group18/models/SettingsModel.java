package group18.models;

import group18.screens.SettingsView;

import java.io.*;

public class SettingsModel implements Serializable
{
    public static String settingsFilePath = "data"+ System.getProperty("file.separator") + "settings";
    private transient SettingsView settingsView;

    // Enabled to true by default
    private boolean celsius = true;
    private boolean notifications = true;

    // These variables are stored in celsius
    private double coldThreshold = -2.0;
    private double hotThreshold = 32.0;

    // Some parameters for the sliders
    // The users should not be able to change this
    private double coldStart = -10;
    private double hotStart = 24;

    public String getInUnits (double val) {
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
        // Sets the cold threshold and configures the explanation text
        coldThreshold = sliderPos + coldStart;
        settingsView.belowLabel.setText("Below  " + getInUnits(coldThreshold));
    }

    public double getHotThreshold() {
        return hotThreshold;
    }

    public void setHotThreshold(double sliderPos) {
        // Sets the hot threshold and configures the explanation test
        hotThreshold = sliderPos + hotStart;
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
        // Sets celsius and updates labels to celsius
        celsius = true;
        updateAboveBelowLabels();
    }

    public void setFahrenheit () {
        // Sets Fahrenheit and updates labels to that unit
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
        // Puts the slider in the correct position and updates labels
        this.settingsView = settingsView;
        updateAboveBelowLabels();
        settingsView.coldSlider.setValue((int)(coldThreshold-coldStart));
        settingsView.hotSlider.setValue((int)(hotThreshold-hotStart));
    }

    // initializing the view on start
    public void initView()
    {
        updateAboveBelowLabels();
    }

    public void saveSettings() throws IOException
    {
        File file = new File(SettingsModel.settingsFilePath);
        if(!file.exists())
        {
            file.createNewFile();
        }
        ObjectOutputStream outputStream =
                new ObjectOutputStream(new FileOutputStream(file));

        outputStream.writeObject(this);
    }

    public static SettingsModel initSettingsModel(SettingsView settingsView) throws IOException, ClassNotFoundException
    {
        ObjectInputStream inputStream =
                new ObjectInputStream(new FileInputStream(SettingsModel.settingsFilePath));

        SettingsModel settingsModel = (SettingsModel) inputStream.readObject();
        settingsModel.settingsView = settingsView;
        settingsModel.initView();

        return settingsModel;
    }


}
