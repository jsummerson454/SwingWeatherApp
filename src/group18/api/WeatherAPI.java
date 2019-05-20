package group18.api;

import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import group18.backend.Day;
import group18.backend.WeatherIconType;

import java.util.*;

public class WeatherAPI
{
    private static final String apiKey = "5b37526269b0f826ad21cf54d2a25762";
    private static Map<String, WeatherIconType> weatherTypeIconMap = new HashMap<>();
    private static Map<Integer,String> dayOfWeekMap = new HashMap<>();
    static {
        weatherTypeIconMap.put("clear-day", WeatherIconType.Clear);
        weatherTypeIconMap.put("clear-night", WeatherIconType.Clear);
        weatherTypeIconMap.put("rain", WeatherIconType.Rain);
        weatherTypeIconMap.put("snow", WeatherIconType.Snow);
        weatherTypeIconMap.put("sleet", WeatherIconType.Sleet);
        weatherTypeIconMap.put("wind", WeatherIconType.Wind);
        weatherTypeIconMap.put("fog", WeatherIconType.Fog);
        weatherTypeIconMap.put("partly-cloudy-day", WeatherIconType.Partly_Cloudy);
        weatherTypeIconMap.put("partly-cloudy-night", WeatherIconType.Partly_Cloudy);
        weatherTypeIconMap.put("cloudy", WeatherIconType.Cloudy);

        dayOfWeekMap.put(Calendar.MONDAY,"Mon");
        dayOfWeekMap.put(Calendar.TUESDAY,"Tue");
        dayOfWeekMap.put(Calendar.WEDNESDAY,"Wed");
        dayOfWeekMap.put(Calendar.THURSDAY,"Thu");
        dayOfWeekMap.put(Calendar.FRIDAY,"Fri");
        dayOfWeekMap.put(Calendar.SATURDAY,"Sat");
        dayOfWeekMap.put(Calendar.SUNDAY,"Sun");

    }

    public static List<Day> getDailyForecast()
    {
        List<Day> dailyForecast = new ArrayList<>();

        ForecastIO fio = new ForecastIO(apiKey);
        fio.setUnits(ForecastIO.UNITS_SI);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast("52.2053", "0.1218");


        Calendar calendar =  GregorianCalendar.getInstance();

//        Calendar calendar = new GregorianCalendar();
//        calendar.add(Calendar.DATE, 1);

        FIODaily daily = new FIODaily(fio);
        //In case there is no daily data available
        if(daily.days()>0)
        {
            //Print daily data
            for (int i = 0; i < daily.days(); i++)
            {
                Day day = new Day();
                dailyForecast.add(day);
                FIODataPoint point = daily.getDay(i);

                day.setDayOfMonth(calendar.get(Calendar.DAY_OF_MONTH));
                day.setDayOfWeek(dayOfWeekMap.get(calendar.get(Calendar.DAY_OF_WEEK)));
                day.setMaxTemperature((int) Double.parseDouble(point.getByKey("temperatureHigh")));
                day.setMaxTemperature((int) Double.parseDouble(point.getByKey("temperatureLow")));
                day.setSummary(point.getByKey("summary"));
                day.setWeatherIconType(parseIcon(point.getByKey("icon")));

                calendar.add(Calendar.DATE, 1);
            }
        }


        return dailyForecast;
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

}
