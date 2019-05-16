package group18;

import com.github.prominence.openweathermap.api.*;
import com.github.prominence.openweathermap.api.constants.Accuracy;
import com.github.prominence.openweathermap.api.constants.Language;
import com.github.prominence.openweathermap.api.constants.Unit;
import com.github.prominence.openweathermap.api.exception.DataNotFoundException;
import com.github.prominence.openweathermap.api.exception.InvalidAuthTokenException;
import com.github.prominence.openweathermap.api.model.response.Weather;

public class LibTest {
    public static void main(String[] args) throws InvalidAuthTokenException, DataNotFoundException {
        OpenWeatherMapManager openWeatherManager = new OpenWeatherMapManager("6e0fbbbcffc34c17ff1c13e5872571aa");
        WeatherRequester weatherRequester = openWeatherManager.getWeatherRequester();
        Weather weatherResponse = weatherRequester
                .setLanguage(Language.ENGLISH)
                .setUnitSystem(Unit.METRIC_SYSTEM)
                .setAccuracy(Accuracy.ACCURATE)
                .getByCityName("Minsk");

        System.out.println(weatherResponse.toString());
    }
}
