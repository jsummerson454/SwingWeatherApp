package group18.backend;

import java.util.ArrayList;
import java.util.List;

public class Day
{
    private WeatherIconType weatherIconType;
    private String summary;
    private int maxTemperature;
    private int minTemperature;
    private int dayOfMonth;
    private String dayOfWeek;
    private List<Plan> planList = new ArrayList();

    public WeatherIconType getWeatherIconType()
    {
        return weatherIconType;
    }

    public void setWeatherIconType(WeatherIconType weatherIconType)
    {
        this.weatherIconType = weatherIconType;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public int getMaxTemperature()
    {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature)
    {
        this.maxTemperature = maxTemperature;
    }

    public int getMinTemperature()
    {
        return minTemperature;
    }

    public void setMinTemperature(int minTemperature)
    {
        this.minTemperature = minTemperature;
    }

    public int getDayOfMonth()
    {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth)
    {
        this.dayOfMonth = dayOfMonth;
    }

    public String getDayOfWeek()
    {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek)
    {
        this.dayOfWeek = dayOfWeek;
    }


}
