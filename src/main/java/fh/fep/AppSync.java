package fh.fep;

import java.net.MalformedURLException;

public class AppSync {

    public static void main(String[] args) {
        String weather = WeatherService.readWeatherFor("Paris");
        System.out.println(weather);
    }
}
