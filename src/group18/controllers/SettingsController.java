package group18.controllers;

import group18.screens.SettingsView;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsController
{
    private SettingsView settingView;

    private boolean celcius = true;

    private int hotSliderPos = 0;
    private int coldSliderPos = 0;

    private int coldStart = -10;
    private int hotStart = 24;

    private Dimension fixedSize = new Dimension(100,100);

    private String getUnit () {
        if (celcius) {
            return "℃";
        }
        return "℉";
    }


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
        settingsView.belowLabel.setPreferredSize(fixedSize);
        settingsView.aboveLabel.setPreferredSize(fixedSize);


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
                int coldValue = coldSliderPos + coldStart;
                settingsView.belowLabel.setText("Below  " + coldValue + getUnit());
            }
        });

        settingsView.hotSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                hotSliderPos = settingsView.hotSlider.getValue();
                int hotValue = hotSliderPos + hotStart;
                if (hotValue / 10 == 0) {
                    settingsView.aboveLabel.setText("Above  " + hotValue + getUnit());
                }
                else {
                    settingsView.aboveLabel.setText("Above " + hotValue + getUnit());
                }
            }
        });
    }

}
