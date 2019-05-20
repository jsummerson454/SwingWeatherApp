package group18;

import group18.backend.Screen;
import group18.backend.WeatherIconType;
import group18.controllers.*;
import group18.models.HomeModel;
import group18.models.SettingsModel;
import group18.screens.*;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class Application {
    private HomeView home;
    private DailyView daily;
    private HourlyView hourly;
    private SettingsView settings;
    public static String location;
    private HomeController homeController;
    private DailyController dailyController;
    private HourlyController hourlyController;

    // Keeps a stack of screens traversed through
    private LinkedList<Screen> previousScreen = new LinkedList<>();

    private SettingsModel settingsModel;

    private JFrame window;

    public void updateTemperatureLabels()
    {
        if(null != homeController)
        {
            homeController.updateTemperatureLabels();
        }

        if(null != dailyController)
        {
            dailyController.updateTemperatureLabels();
        }

        if(null != hourlyController)
        {
            hourlyController.updateTemperatureLabels();
        }
    }

    public static ImageIcon getWeatherIcon(WeatherIconType w) {
        // Gets the corresponding weather icon based on type entered
        String s = "resources/";
        switch (w) {
            case Cloudy:
                s += "cloudy.png";
                break;
            case Fog:
                s += "fog.png";
                break;
            case Partly_Cloudy:
                s += "partly-cloudy-day.png";
                break;
            case Snow:
                s += "snow.png";
                break;
            case Rain:
                s += "rain.png";
                break;
            case Wind:
                s += "wind.png";
                break;
            case Sleet:
                s += "sleet.png";
                break;
            default:
                s += "clear-day.png";
                break;
        }
        return new ImageIcon(s);
    }

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

    public void addAScreen(Screen s) {
        // Adds to the screen traversal stack
        previousScreen.add(s);
    }

    public void backAScreen() {
        // Navigates back to the last screen
        Screen s = previousScreen.removeLast();
        switch (s) {
            case home:
                setViewHome();
                break;
            case daily:
                setViewDaily();
                break;
            case hourly:
                setViewHourly();
                break;
            case settings:
                setViewSettings();
                break;
        }
    }

    public SettingsModel getSettingsModel() {
        return settingsModel;
    }

    public void init() {
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

        HomeModel homeModel = new HomeModel(settingsModel,home);

        daily = new DailyView();
        daily.main.setVisible(false);
        daily.main.setSize(360, 640);

        hourly = new HourlyView();
        hourly.main.setVisible(false);
        hourly.main.setSize(360, 640);






        //initialise controllers (with screens and required models as parameters)
        SettingsController settingsController = new SettingsController(settingsModel);
        homeController = new HomeController(settingsModel,homeModel);
        dailyController = new DailyController(settingsModel,daily);
        hourlyController = new HourlyController(settingsModel,hourly);


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
