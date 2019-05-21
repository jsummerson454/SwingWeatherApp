package group18.api;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import group18.Main;
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
        // Makes a call retrieving the weather data
        fio = new ForecastIO(apiKey);
        fio.setUnits(ForecastIO.UNITS_SI);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast("52.2053", "0.1218");

        // Maps the string to a weather icon enum
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

        // Map from a calender day int to a string used to represent the day
        dayOfWeekMap.put(Calendar.MONDAY,"Mon");
        dayOfWeekMap.put(Calendar.TUESDAY,"Tue");
        dayOfWeekMap.put(Calendar.WEDNESDAY,"Wed");
        dayOfWeekMap.put(Calendar.THURSDAY,"Thu");
        dayOfWeekMap.put(Calendar.FRIDAY,"Fri");
        dayOfWeekMap.put(Calendar.SATURDAY,"Sat");
        dayOfWeekMap.put(Calendar.SUNDAY,"Sun");

    }

    // If we already have them we do not make a call again
    private static List<Day> dailyForecast = null;
    private static List<Hour> hourlyForecast = null;

    public static List<Day> getDailyForecast()
    {
        if( null == dailyForecast)
        {
            // Prevents wasteful calls
            dailyForecast = getDailyForecastAPICall();
            if(null != hourlyForecast)
            {
                mapHoursToDays();
            }
        }

        return new ArrayList(dailyForecast);
    }

    public static void setLocation(String loc) {
        //due to API limitations we cannot geocode user's location input into long, lat coordinates. We have set it
        //so we can switch between 2 locations in our prototype
        String locLower = loc.toLowerCase();
        if (locLower.equals(Main.app.location.toLowerCase())) {
            return;
        }

        switch (locLower) {
            case "cambridge":
                fio.getForecast("52.2053", "0.1218");
                break;
            case "scunthorpe":
                fio.getForecast("53.589106", "-0.655427");
                break;
            case "nairobi":
                fio.getForecast("-1.301829", "36.823359");
                break;
            default:
                System.out.println("Don't have location information for that location, setting to Cambridge by default");
                loc = "Cambridge";
                fio.getForecast("52.2053", "0.1218");
                break;
        }
        Main.app.location = loc.substring(0,1).toUpperCase() + loc.substring(1).toLowerCase();

        hourlyForecast = getHourlyForecastAPICall();
        dailyForecast = getDailyForecastAPICall();

        Main.app.refreshAll();

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
        // Getting the forecast for the day of the month entered
        // this is used to get the current day in the home screen
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
        // Gets the hourly forecast for a particular day
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

            if(null != dailyForecast)
            {
                mapHoursToDays();
            }
        }

        return new ArrayList(hourlyForecast);
    }

    private static List<Hour> getHourlyForecastAPICall()
    {
        // This call returns our hourly forecast returning the list of hours
        List<Hour> hourlyForecast = new ArrayList<>();
        FIOHourly hourly = new FIOHourly(fio);

        //In case there is no daily data available
        if(hourly.hours()>0)
        {
            // Print daily data
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
        // Getting a string representing the icon and parsing it to an icon type
        WeatherIconType weatherIconType = weatherTypeIconMap.get(api_text);

        if( null == weatherIconType)
        {
            weatherIconType = WeatherIconType.NONE;
        }

        return weatherIconType;
    }

    private static int parseDayFromTime(String time)
    {
        // Takes a time string and returns an int representing the day
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
        // Takes our time string and returns an int representing the hour
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
        // Returns a calendar object from a time string
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
        calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(day) - 1);

        return calendar;
    }
}
