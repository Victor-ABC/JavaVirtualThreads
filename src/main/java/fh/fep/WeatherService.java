package fh.fep;

import fh.fep.webserver.Location;
import fh.fep.webserver.WeatherController;
import java.util.concurrent.CompletableFuture;

public class WeatherService {

    public static String readWeatherFor(String city) {
        Location location = WeatherController.getLocationUsingCityName(city); //100  ms
        String url = WeatherController.buildURL(location);                       //10 ns
        String weatherData = WeatherController.getWeatherData(url);             //100 ms
        return WeatherController.visualizeWeatherData(weatherData);         //10ns
    }

    public static CompletableFuture<String> readWeatherAsyncFor(String city) {
        return CompletableFuture.supplyAsync(() -> WeatherController.getLocationUsingCityName(city))
                .thenApply(WeatherController::buildURL)
                .thenApply(WeatherController::getWeatherData)
                .thenApply(WeatherController::visualizeWeatherData);
    }

}
