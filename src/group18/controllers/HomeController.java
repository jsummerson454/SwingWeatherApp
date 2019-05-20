package group18.controllers;

import group18.Main;
import group18.models.HomeModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController {

    private HomeModel homeModel;

    public HomeController(HomeModel homeModel) {
        this.homeModel = homeModel;

        homeModel.homeView.hourly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.app.setViewHourly();
            }
        });

        homeModel.homeView.weekly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.app.setViewDaily();
            }
        });

    }
}
