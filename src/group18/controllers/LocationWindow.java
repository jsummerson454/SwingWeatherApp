package group18.controllers;

import group18.misc.Location;
import group18.misc.LocationSelector;
import group18.models.SettingsModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LocationWindow {

    public LocationWindow(SettingsModel settingsModel) {
        // Creating our pop-up box which enables the user to select a location
        JFrame window = new JFrame();

        LocationSelector loc = new LocationSelector();

        window.setTitle("Select a location");
        window.setSize(300, 150);
        window.add(loc.main);

        // Setting the back button to remove the frame
        loc.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });

        // After enter is selected the country and city entered is processed
        loc.enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Location l = new Location(loc.countryField.getText(), loc.cityField.getText());
            }
        });



        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
