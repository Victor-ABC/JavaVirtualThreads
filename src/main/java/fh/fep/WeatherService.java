package fh.fep;

import java.net.MalformedURLException;
import java.util.concurrent.CompletableFuture;

public class WeatherService {

    public static String readWeatherFor(String lat, String lon) throws MalformedURLException {
        String url = PrimaryController.buildURL(lat, lon);
        String weatherData = PrimaryController.getWeatherData(url);
        return PrimaryController.visualizeWeatherData(weatherData);
    }

    public static CompletableFuture<String> readWeatherAsyncFor(String lat, String lon) {
        return CompletableFuture.supplyAsync(() -> PrimaryController.buildURL(lat, lon))
                .thenApply(PrimaryController::getWeatherData)
                .thenApply(PrimaryController::visualizeWeatherData);
    }

}
