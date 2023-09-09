package fh.fep;

import fh.fep.webserver.Location;
import fh.fep.webserver.WeatherController;
import java.util.concurrent.CompletableFuture;

public class WeatherService {

    public static String readWeatherFor(String city) {
        Location location = WeatherController.getLocationUsingCityName(city);
        String url = WeatherController.buildURL(location);
        String weatherData = WeatherController.getWeatherData(url);
        return WeatherController.visualizeWeatherData(weatherData);
    }

    public static CompletableFuture<String> readWeatherAsyncFor(String city) {
        return CompletableFuture.supplyAsync(() -> WeatherController.getLocationUsingCityName(city))
                .thenApply(WeatherController::buildURL)
                .thenApply(WeatherController::getWeatherData)
                .thenApply(WeatherController::visualizeWeatherData);
    }

}
