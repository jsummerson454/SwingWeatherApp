package group18.backend;

public class Hour {
    private int dayOfMonth;
    private String dayOfWeek;
    private boolean has_plan = false;
    private int hour;
    private double humidity;
    private double temperature;
    private double apparentTemperature;
    private WeatherIconType weatherIconType;
    private Plan plan;

    public boolean hasPlan() {return has_plan;}

    public String getDayOfWeek(){return dayOfWeek;}

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfMonth(){
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth){
        this.dayOfMonth = dayOfMonth;
    }

    public int getHour(){
        return hour;
    }

    public void setHour(int hour){
        this.hour = hour;
    }

    public double getHumidity(){
        return humidity;
    }

    public void setHumidity(double humidity){
        this.humidity = humidity;
    }

    public double getTemperature(){
        return temperature;
    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
    }

    public double getApparentTemperature(){
        return apparentTemperature;
    }

    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public WeatherIconType getWeatherIconType(){
        return weatherIconType;
    }

    public void setWeatherIconType(WeatherIconType weatherIconType){
        this.weatherIconType = weatherIconType;
    }

    public Plan getPlan(){
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
        this.has_plan = true;
    }

    public void hasNoPlan(boolean b) {
        this.has_plan = b;
    }
}
