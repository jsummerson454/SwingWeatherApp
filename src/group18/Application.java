package group18;

import group18.controllers.*;
import group18.models.HomeModel;
import group18.models.SettingsModel;
import group18.screens.*;

import javax.swing.*;

public class Application {
    private HomeView home;
    private DailyView daily;
    private HourlyView hourly;
    private SettingsView settings;
    public static String location;

    private SettingsModel settingsModel;

    private JFrame window;

    public void setViewHome() {
        daily.main.setVisible(false);
        hourly.main.setVisible(false);
        home.main.setVisible(true);
        settings.main.setVisible(false);
    }

    public void setViewDaily() {
        daily.main.setVisible(true);
        hourly.main.setVisible(false);
        home.main.setVisible(false);
        settings.main.setVisible(false);
    }

    public void setViewHourly() {
        daily.main.setVisible(false);
        hourly.main.setVisible(true);
        home.main.setVisible(false);
        settings.main.setVisible(false);
    }

    public void setViewSettings() {
        daily.main.setVisible(false);
        hourly.main.setVisible(false);
        home.main.setVisible(false);
        settings.main.setVisible(true);
    }

    public SettingsModel getSettingsModel()
    {
        return settingsModel;
    }

    public Application() {
        //initialise models

        //initialize screens (with required models as parameters)
        settings = new SettingsView();
        // settingsModel = new SettingsModel(settings);
        try
        {
            settingsModel = SettingsModel.initSettingsModel(settings);
        } catch (Exception e)
        {
            e.printStackTrace();
            settingsModel = new SettingsModel(settings);
        }
        settings.main.setVisible(false);
        settings.main.setSize(360, 640);

        home = new HomeView();
        home.main.setVisible(true);
        home.main.setSize(360, 640);

        HomeModel homeModel = new HomeModel(settingsModel, home);

        daily = new DailyView();
        daily.main.setVisible(false);
        daily.main.setSize(360, 640);

        hourly = new HourlyView();
        hourly.main.setVisible(false);
        hourly.main.setSize(360, 640);






        //initialise controllers (with screens and required models as parameters)
        SettingsController settingsController = new SettingsController(settingsModel);
        HomeController homeController = new HomeController(homeModel);
        DailyController dailyController = new DailyController(daily);
        HourlyController hourlyController = new HourlyController(hourly);


        //add screens to window

        window = new JFrame();
        window.add(settings.main);
        window.add(home.main);
        window.add(daily.main);
        window.add(hourly.main);


        window.setTitle("Weather App");
        window.setSize(360, 640);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }


}
