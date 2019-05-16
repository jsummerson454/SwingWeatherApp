package group18;

import group18.controllers.DailyController;
import group18.controllers.HomeController;
import group18.controllers.HourlyController;
import group18.screens.DailyView;
import group18.screens.HomeView;
import group18.screens.HourlyView;

import javax.swing.*;

public class Application {
    private HomeView home;
    private DailyView daily;
    private HourlyView hourly;

    private JFrame window;

    public void setViewHome() {
        daily.main.setVisible(false);
        hourly.main.setVisible(false);
        home.main.setVisible(true);
    }

    public void setViewDaily() {
        daily.main.setVisible(true);
        hourly.main.setVisible(false);
        home.main.setVisible(false);
    }

    public void setViewHourly() {
        daily.main.setVisible(false);
        hourly.main.setVisible(true);
        home.main.setVisible(false);
    }


    public Application() {
        //initialise models

        //initialize screens (with required models as parameters)
        home = new HomeView();
        home.main.setVisible(true);
        home.main.setSize(360, 640);

        daily = new DailyView();
        daily.main.setVisible(false);
        daily.main.setSize(360, 640);

        hourly = new HourlyView();
        hourly.main.setVisible(false);
        hourly.main.setSize(360, 640);

        //initialise controllers (with screens and required models as parameters)
        HomeController homeController = new HomeController(home);
        DailyController dailyController = new DailyController(daily);
        HourlyController hourlyController = new HourlyController(hourly);

        //add screens to window
        window = new JFrame();
        window.add(home.main);
        window.add(daily.main);
        window.add(hourly.main);

        window.setTitle("Weather App");
        window.setSize(360, 640);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }


}
