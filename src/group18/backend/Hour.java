package group18.backend;

public class Hour
{
    private int dayOfMonth;
    private int hour;
    private double humidity;
    private int temperature;
    private int apparentTemperature;
    private WeatherIconType weatherIconType;
    private Plan plan;


    public int getDayOfMonth()
    {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth)
    {
        this.dayOfMonth = dayOfMonth;
    }

    public int getHour()
    {
        return hour;
    }

    public void setHour(int hour)
    {
        this.hour = hour;
    }

    public double getHumidity()
    {
        return humidity;
    }

    public void setHumidity(double humidity)
    {
        this.humidity = humidity;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }

    public int getApparentTemperature()
    {
        return apparentTemperature;
    }

    public void setApparentTemperature(int apparentTemperature)
    {
        this.apparentTemperature = apparentTemperature;
    }

    public WeatherIconType getWeatherIconType()
    {
        return weatherIconType;
    }

    public void setWeatherIconType(WeatherIconType weatherIconType)
    {
        this.weatherIconType = weatherIconType;
    }

    public Plan getPlan()
    {
        return plan;
    }

    public void setPlan(Plan plan)
    {
        this.plan = plan;
    }
}
