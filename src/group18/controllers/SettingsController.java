package group18.controllers;

import group18.models.SettingsModel;
import group18.screens.SettingsView;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsController
{
    private SettingsModel settingsModel;
    private SettingsView settingsView;


    private int hotSliderPos = 0;
    private int coldSliderPos = 0;

    private double coldStart = -10;
    private double hotStart = 24;




    void backToPreviousScreen() {

    }


    public SettingsController (SettingsModel settingsModel) {
        this.settingsModel = settingsModel;
        settingsView = settingsModel.getView();

        settingsView.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        settingsView.selectLocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocationWindow locationWindow = new LocationWindow(settingsModel);
            }
        });


        settingsView.celciusRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsModel.setCelsius();
            }
        });

        settingsView.fahrenheitRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsModel.setFahrenheit();
            }
        });

        settingsView.onRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsModel.notificationsOn();
            }
        });

        settingsView.offRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsModel.notificationsOff();
            }
        });

        settingsView.coldSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                coldSliderPos = settingsView.coldSlider.getValue();
                double coldValue = coldSliderPos + coldStart;
                settingsModel.setColdThreshold(coldValue);
            }
        });

        settingsView.hotSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                hotSliderPos = settingsView.hotSlider.getValue();
                double hotValue = hotSliderPos + hotStart;
                settingsModel.setHotThreshold(hotValue);
            }
        });
    }

}
