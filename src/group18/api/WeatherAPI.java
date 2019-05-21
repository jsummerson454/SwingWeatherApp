package group18.api;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import group18.backend.Day;
import group18.backend.Hour;
import group18.backend.WeatherIconType;

import java.util.*;

public class WeatherAPI
{
    private static final String apiKey = "5b37526269b0f826ad21cf54d2a25762";
    private static Map<String, WeatherIconType> weatherTypeIconMap = new HashMap<>();
    private static ForecastIO fio;
    private static Map<Integer,String> dayOfWeekMap = new HashMap<>();
    static {
        fio = new ForecastIO(apiKey);
        fio.setUnits(ForecastIO.UNITS_SI);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast("52.2053", "0.1218");

        weatherTypeIconMap.put("\"clear-day\"", WeatherIconType.Clear);
        weatherTypeIconMap.put("\"clear-night\"", WeatherIconType.Clear);
        weatherTypeIconMap.put("\"rain\"", WeatherIconType.Rain);
        weatherTypeIconMap.put("\"snow\"", WeatherIconType.Snow);
        weatherTypeIconMap.put("\"sleet\"", WeatherIconType.Sleet);
        weatherTypeIconMap.put("\"wind\"", WeatherIconType.Wind);
        weatherTypeIconMap.put("\"fog\"", WeatherIconType.Fog);
        weatherTypeIconMap.put("\"partly-cloudy-day\"", WeatherIconType.Partly_Cloudy);
        weatherTypeIconMap.put("\"partly-cloudy-night\"", WeatherIconType.Partly_Cloudy);
        weatherTypeIconMap.put("\"cloudy\"", WeatherIconType.Cloudy);

        dayOfWeekMap.put(Calendar.MONDAY,"Mon");
        dayOfWeekMap.put(Calendar.TUESDAY,"Tue");
        dayOfWeekMap.put(Calendar.WEDNESDAY,"Wed");
        dayOfWeekMap.put(Calendar.THURSDAY,"Thu");
        dayOfWeekMap.put(Calendar.FRIDAY,"Fri");
        dayOfWeekMap.put(Calendar.SATURDAY,"Sat");
        dayOfWeekMap.put(Calendar.SUNDAY,"Sun");

    }

    private static List<Day> dailyForecast = null;
    private static List<Hour> hourlyForecast = null;

    //  want to make only one api call per opening of the app
    public static List<Day> getDailyForecast()
    {
        if( null == dailyForecast)
        {
            dailyForecast = getDailyForecastAPICall();
        }

        return new ArrayList(dailyForecast);
    }

    private static List<Day> getDailyForecastAPICall()
    {
        List<Day> dailyForecast = new ArrayList<>();

        FIODaily daily = new FIODaily(fio);
        //In case there is no daily data available
        if (daily.days() > 0)
        {
            //Print daily data
            for (int i = 0; i < daily.days(); i++)
            {
                Day day = new Day();
                dailyForecast.add(day);

                FIODataPoint point = daily.getDay(i);
                Calendar calendar = getCalenderFromTime(point.getByKey("time"));

                day.setDayOfMonth(calendar.get(Calendar.DAY_OF_MONTH));
                day.setDayOfWeek(dayOfWeekMap.get(calendar.get(Calendar.DAY_OF_WEEK)));
                day.setMaxTemperature(Double.parseDouble(point.getByKey("temperatureHigh")));
                day.setMinTemperature(Double.parseDouble(point.getByKey("temperatureLow")));
                day.setSummary(point.getByKey("summary"));
                day.setWeatherIconType(parseIcon(point.getByKey("icon")));

                calendar.add(Calendar.DATE, 1);
            }
        }


        return dailyForecast;
    }

    public static Day getForecastForADay(int dayOfMonth)
    {
        List<Day> days = getDailyForecast();

        for(Day day: days)
        {
            if(day.getDayOfMonth() == dayOfMonth)
            {
                return day;
            }
        }
        return null;
    }

    public static List<Hour> getHourlyForecastForDayOfMonth(int dayOfMonth)
    {
        List<Hour> hours = getAllHoursForecast();

        List<Hour> res = new ArrayList<>();

        for(Hour hour: hours)
        {
            if(hour.getDayOfMonth() == dayOfMonth)
            {
                res.add(hour);
            }
        }

        return res;
    }

    public static List<Hour> getAllHoursForecast()
    {
        if( null == hourlyForecast)
        {
            hourlyForecast = getHourlyForecastAPICall();
        }

        return new ArrayList(hourlyForecast);
    }

    private static List<Hour> getHourlyForecastAPICall()
    {
        List<Hour> hourlyForecast = new ArrayList<>();
        FIOHourly hourly = new FIOHourly(fio);

        //In case there is no daily data available
        if(hourly.hours()>0)
        {
            //Print daily data
            for (int i = 0; i < hourly.hours(); i++)
            {
                Hour hour = new Hour();
                hourlyForecast.add(hour);
                FIODataPoint point = hourly.getHour(i);

                String time = point.getByKey("time");
                Calendar calendar = getCalenderFromTime(point.getByKey("time"));

                hour.setDayOfMonth(parseDayFromTime(time));
                hour.setDayOfWeek(dayOfWeekMap.get(calendar.get(Calendar.DAY_OF_WEEK)));
                hour.setHour(parseHourFromTime(time));
                hour.setApparentTemperature(Double.parseDouble(point.getByKey("apparentTemperature")));
                hour.setHumidity(Double.parseDouble(point.getByKey("humidity")));
                hour.setWeatherIconType(parseIcon(point.getByKey("icon")));
                hour.setTemperature(Double.parseDouble(point.getByKey("temperature")));
            }
        }

        return hourlyForecast;
    }


    private static WeatherIconType parseIcon(String api_text)
    {
        WeatherIconType weatherIconType = weatherTypeIconMap.get(api_text);

        if( null == weatherIconType)
        {
            weatherIconType = WeatherIconType.NONE;
        }

        return weatherIconType;
    }

    private static int parseDayFromTime(String time)
    {
        String[] parts = time.trim().split("-");

        String day  = parts[0];

        if(day.charAt(0) == '0')
        {
            day = day.substring(1);
        }

        return Integer.parseInt(day);
    }

    private static int parseHourFromTime(String time)
    {
        String[] parts = time.trim().split(" ")[1].split(":");

        String hour  = parts[0];

        if(hour.charAt(0) == '0')
        {
            hour = hour.substring(1);
        }

        return Integer.parseInt(hour);
    }

    private static Calendar getCalenderFromTime(String time)
    {
        Calendar calendar = new GregorianCalendar();

        String[] parts = time.trim().split(" ")[0].split("-");

        String day  = parts[0];
        if(day.charAt(0) == '0')
        {
            day = day.substring(1);
        }

        String month  = parts[1];
        if(month.charAt(0) == '0')
        {
            month = month.substring(1);
        }

        String year  = parts[2];
        if(year.charAt(0) == '0')
        {
            year = year.substring(1);
        }

        calendar.set(Calendar.YEAR,Integer.parseInt(year));
        calendar.set(Calendar.MONTH,Integer.parseInt(month) - 1);
        calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(day));

        return calendar;
    }
}
