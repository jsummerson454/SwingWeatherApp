package group18.models;

import group18.api.WeatherAPI;
import group18.backend.Day;

import java.util.List;

public class DailyModel
{
    public List<Day> getDayList()
    {
        return dayList;
    }

    private List<Day> dayList;



    public void loadDailyForecast()
    {
        dayList = WeatherAPI.getDailyForecast();
    }

}