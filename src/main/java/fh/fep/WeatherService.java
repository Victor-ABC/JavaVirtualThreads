package fh.fep;

import fh.fep.webserver.AbstractWeatherController;
import fh.fep.webserver.Location;
import fh.fep.webserver.MockWeatherController;
import fh.fep.webserver.WeatherController;
import java.util.concurrent.CompletableFuture;

public class WeatherService {

    public static String readWeatherFor(String city) {
        AbstractWeatherController weatherController = new WeatherController();

        Location location = weatherController.getLocationUsingCityName(city); //100  ms
        String url = weatherController.buildURL(location);                       //10 ns
        String weatherData = weatherController.getWeatherData(url);             //100 ms
        return weatherController.visualizeWeatherData(weatherData);         //10ns
    }

    public static CompletableFuture<String> readWeatherAsyncFor(String city) {
        AbstractWeatherController weatherController = new WeatherController();

        return CompletableFuture.supplyAsync(() -> weatherController.getLocationUsingCityName(city))
                .thenApply(weatherController::buildURL)
                .thenApply(weatherController::getWeatherData)
                .thenApply(weatherController::visualizeWeatherData);
    }

}
