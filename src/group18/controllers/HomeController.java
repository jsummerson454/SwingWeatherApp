package group18.controllers;

import group18.Main;
import group18.screens.HomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController {
    private HomeView view;

    private class DailyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //would change the model here if needed

            //now resets the view using some view.repopulateData method or something, defined in the view itself

            //in this case however it only changes the current screen so:
            Main.app.setViewDaily();
        }
    }

    public HomeController(HomeView view) {
        this.view = view;

        view.addDailyButtonListener(new DailyButtonListener());

    }
}
