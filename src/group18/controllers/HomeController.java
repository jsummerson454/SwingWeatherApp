package group18.controllers;

import group18.Main;
import group18.backend.Screen;
import group18.models.HomeModel;
import group18.screens.HomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController {

    private HomeModel homeModel;

    public HomeController(HomeModel homeModel) {
        this.homeModel = homeModel;
        HomeView homeView = homeModel.homeView;

        homeView.settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.app.previousScreen.add(Screen.home);
                Main.app.setViewSettings();
            }
        });

        homeView.hourly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.app.previousScreen.add(Screen.home);
                Main.app.setViewHourly();
            }
        });

        homeView.weekly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.app.previousScreen.add(Screen.home);
                Main.app.setViewDaily();
            }
        });

    }
}
