package fh.fep.thread;

import fh.fep.webserver.AbstractWeatherController;
import fh.fep.webserver.Location;
import fh.fep.webserver.MockWeatherController;
import fh.fep.webserver.WeatherController;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    public int taskId;
    public String city;

    public Task(int taskId, String city) {
        this.taskId = taskId;
        this.city = city;
    }

    @Override
    public String call() {
        AbstractWeatherController weatherController = new WeatherController(taskId);

        Location location = weatherController.getLocationUsingCityName(city);
        String url = weatherController.buildURL(location);
        String weatherData = weatherController.getWeatherData(url);
        return "Request Nr. " + taskId + " " + weatherController.visualizeWeatherData(weatherData);
    }
}