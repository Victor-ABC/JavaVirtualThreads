package fh.fep.thread;

import fh.fep.webserver.AbstractWeatherController;
import fh.fep.webserver.Location;
import fh.fep.webserver.MockWeatherController;
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
        AbstractWeatherController weatherController = new MockWeatherController(taskId);

        Location location = weatherController.getLocationUsingCityName(city); //100  ms
        String url = weatherController.buildURL(location);                       //10 ns
        String weatherData = weatherController.getWeatherData(url);             //100 ms
        return "Request Nr. " + taskId + " " + weatherController.visualizeWeatherData(
                weatherData);         //10ns
    }
}