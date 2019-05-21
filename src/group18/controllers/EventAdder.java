package group18.controllers;

import group18.backend.Hour;
import group18.backend.Plan;
import group18.misc.EventSelector;
import group18.misc.Location;
import group18.misc.LocationSelector;
import group18.models.SettingsModel;
import group18.screens.HourlyPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventAdder {

    public EventAdder(Hour thisHour, HourlyPanels hourPanel) {
        // Creating our pop-up box which enables the user to select a location
        JFrame window = new JFrame();

        EventSelector loc = new EventSelector();

        window.setTitle("Add an event");
        window.setSize(300, 150);
        window.add(loc.main);

        // Setting the back button to remove the frame
        loc.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        });

        // Delete button
        // Setting the back button to remove the frame
        loc.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisHour.hasNoPlan(false);
                hourPanel.eventButton.setForeground(Color.black);
                hourPanel.eventButton.setText("+Event");
                window.dispose();
            }
        });

        // After enter is selected the country and city entered is processed
        loc.enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String event_name = loc.countryField.getText();
                Plan new_plan = new Plan(event_name);
                thisHour.setPlan(new_plan);
                window.dispose();
                hourPanel.eventButton.setForeground(Color.red);
                hourPanel.eventButton.setText(event_name);
            }
        });



        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }
}
