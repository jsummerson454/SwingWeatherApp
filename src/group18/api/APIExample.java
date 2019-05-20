package group18.api;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;

public class APIExample
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


        System.out.println("Daily");

        FIODaily daily = new FIODaily(fio);
        //In case there is no daily data available
        if(daily.days()<0)
            System.out.println("No daily data.");
        else
            System.out.println("\nDaily:\n");
        //Print daily data
        for(int i = 0; i<daily.days(); i++){
            String [] h = daily.getDay(i).getFieldsArray();
            System.out.println("Day #"+(i+1));
            for(int j=0; j<h.length; j++)
                System.out.println(h[j]+": "+daily.getDay(i).getByKey(h[j]));
            System.out.println("\n");
        }


        System.out.println("Hourly");


        FIOHourly h = new FIOHourly(fio);
        System.out.println(h.hours());

//        FIOHourly hourly = new FIOHourly(fio);
//        //In case there is no hourly data available
//        if(hourly.hours()<0)
//            System.out.println("No hourly data.");
//        else
//            System.out.println("\nHourly:\n");
//        //Print hourly data
//        for(int i = 0; i<hourly.hours(); i++){
//            String [] h = hourly.getHour(i).getFieldsArray();
//            System.out.println("Hour #"+(i+1));
//            for(int j=0; j<h.length; j++)
//                System.out.println(h[j]+": "+hourly.getHour(i).getByKey(h[j]));
//            System.out.println("\n");
//        }
    }
}
