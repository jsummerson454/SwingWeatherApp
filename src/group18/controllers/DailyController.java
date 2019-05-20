package group18.controllers;

import group18.Main;
import group18.api.WeatherAPI;
import group18.models.DailyModel;
import group18.screens.DailyView;

public class DailyController {
    private DailyView view;
    private DailyModel model;

    public DailyController(DailyView view) {
        this.view = view;
        initModel();
        view.addDailyButtonListener(a ->
        {
            Main.app.setViewSettings();
        });
        view.addDailyForecast(model.getDayList());

    }


    private void initModel()
    {
        model = new DailyModel();
        model.loadDailyForecast();
    }

}
