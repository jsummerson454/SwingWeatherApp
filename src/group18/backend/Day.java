package group18.backend;

import java.util.ArrayList;
import java.util.List;

public class Day
{
    private WeatherIconType weatherIconType;
    private String summary;
    private double maxTemperature;
    private double minTemperature;
    private int dayOfMonth;
    private String dayOfWeek;
    private List<Hour> hourList = new ArrayList();

    public List<Hour> getHourList()
    {
        return hourList;
    }

    public void setHourList(List<Hour> hourList)
    {
        this.hourList = hourList;
    }



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

    public double getMaxTemperature()
    {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature)
    {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature()
    {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature)
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
