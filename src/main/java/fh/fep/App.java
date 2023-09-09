package fh.fep;

import java.net.MalformedURLException;
import java.net.http.HttpRequest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException {
        //Längen und Breitengrade von London
        String lat = "51.509865";
        String lon = "-0.118092";


        String weather = WeatherService.readWeatherFor(lat, lon);
        System.out.println(weather);
    }
}
