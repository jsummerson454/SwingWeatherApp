package group18.models;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import group18.screens.HomeView;

public class HomeModel {
    public HomeView homeView;


    public HomeModel (HomeView homeView, FIOCurrently currently) {
        this.homeView = homeView;

        currently.get().

    }
}
