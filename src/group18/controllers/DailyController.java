package group18.controllers;

import group18.Main;
import group18.screens.DailyView;

public class DailyController {
    private DailyView view;

    public DailyController(DailyView view) {
        this.view = view;
        view.addDailyButtonListener(a ->
        {
            Main.app.setViewSettings();
        });
    }
}
