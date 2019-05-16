package group18.api;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.ForecastIO;

public class APITest
{
    public static void main(String[] args)
    {
        String api_key = "5b37526269b0f826ad21cf54d2a25762";

        ForecastIO fio = new ForecastIO(api_key);
        fio.setUnits(ForecastIO.UNITS_SI);
        fio.setLang(ForecastIO.LANG_ENGLISH);
        fio.getForecast("38.7252993", "-9.1500364");

        FIOCurrently currently = new FIOCurrently(fio);
        //Print currently data
        System.out.println("\nCurrently\n");
        String [] f  = currently.get().getFieldsArray();
        for(int i = 0; i<f.length;i++)
            System.out.println(f[i]+": "+currently.get().getByKey(f[i]));
    }
}
