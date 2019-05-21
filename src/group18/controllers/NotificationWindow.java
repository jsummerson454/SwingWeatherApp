package group18.controllers;

import group18.misc.Location;
import group18.misc.LocationSelector;
import group18.models.SettingsModel;
import group18.screens.Notification;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationWindow {

    public NotificationWindow(SettingsModel settingsModel, double currentTemp) {
        // Creating our pop-up box which enables the user to select a location
        JFrame window = new JFrame();

        Notification not = new Notification();

        window.setTitle("Notification");
        window.setSize(300, 150);
        window.add(not.main);

        if (!(settingsModel.isNotifications())) {
            not.tempLabel.setText("Notifications turned off");
            not.suggestionLabel.setText("So they will not be received");
        }
        else {
            if (currentTemp < settingsModel.getColdThreshold()) {
                not.tempLabel.setText("It's cold!");
                not.suggestionLabel.setText("Make sure your children have coats");

            }
            else if (currentTemp > settingsModel.getHotThreshold()) {
                not.tempLabel.setText("It's hot!");
                not.suggestionLabel.setText("Make sure your children have shorts");
            }
            else {
                not.tempLabel.setText("No notification");
                not.suggestionLabel.setText("Acceptable temperature");
            }
        }



        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }
}
