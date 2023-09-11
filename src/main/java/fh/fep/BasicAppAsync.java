package fh.fep;


import java.util.concurrent.CompletableFuture;


public class BasicAppAsync {

    public static void main(String[] args) {
        String city = "Münster"; // Replace with the desired city
        CompletableFuture<String> weatherDataFuture = WeatherService.readWeatherAsyncFor(city);
        weatherDataFuture.thenAccept(System.out::println);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}