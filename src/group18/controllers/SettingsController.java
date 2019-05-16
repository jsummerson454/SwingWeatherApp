package group18.controllers;

import group18.screens.SettingsView;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsController
{
    SettingsView settingView;

    int hotSliderPos = 0;
    int coldSliderPos = 0;

    public void changeUnitsToFahrenheit() {

    }

    public void changeUnitsToCelsius() {

    }

    public void turnNotificationsOn() {

    }

    public void turnNotificationsOff() {


    }

    public void selectColdDegreeThreshold(int degrees) {

    }

    public void selectHotDegreeThreshold(int degrees) {

    }

    //public void setLocation(Location location){}

    void backToPreviousScreen() {

    }


    public SettingsController (SettingsView settingsView) {
        this.settingView = settingsView;

        settingsView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        settingsView.selectLocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        settingsView.coldSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                coldSliderPos = settingsView.coldSlider.getValue();
            }
        });

        settingsView.hotSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                hotSliderPos = settingsView.coldSlider.getValue();
            }
        });
    }

}
