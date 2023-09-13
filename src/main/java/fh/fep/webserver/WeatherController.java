package fh.fep.webserver;

import java.text.DecimalFormat;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;

public class WeatherController implements AbstractWeatherController{

    private int taskId;

    public WeatherController(int i)  {
        this.taskId = i;
    }

    public WeatherController()  {}

    final String apiKey = "752998c2f6fbb86c57bb497e360e3a0d"; //victors-Account
    final String weatherBaseURL = "https://api.openweathermap.org/data/2.5/weather?";

    final String weatherBaseURLgetLatLonUsingName = "http://api.openweathermap.org/geo/1.0/direct?q=";

    void printInfo() {
        if(taskId == 1) {
            System.out.println("Task-NR:" + taskId + " by Thread-ID: " + Thread.currentThread());
        }
    }

    public String buildURL(Location location) {
        printInfo();
        return "lat="+location.lat + "&lon="+location.lon + "&appid="+apiKey;
    }

    public String visualizeWeatherData(String data) {
        printInfo();
        return "### Wetter ### \n" + data;
    }

    public Location getLocationUsingCityName(String cityName) {
        printInfo();
        Location location = null;

        try {
            APIConnector apiConnectorWeather = new APIConnector(weatherBaseURLgetLatLonUsingName);

            // HTTP Request
            JSONObject weatherJSONObject = (JSONObject) apiConnectorWeather
                    .getJSONArray(cityName + "&appid=" + apiKey)
                    .get(0);

            String lat = weatherJSONObject.get("lat").toString();
            String lon =  weatherJSONObject.get("lon").toString();

            location = new Location(lat, lon);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return location;
    }

    /**
     * HTTP Request to remote server to query real time weather data.
     * @param url the URL
     * @return String containing relevant information
     */
    public String getWeatherData(String url) {
        printInfo();
        JSONObject todaysWeather = null;

        try {
            APIConnector apiConnectorWeather = new APIConnector(weatherBaseURL);

            // HTTP Request
            JSONObject weatherJSONObject = apiConnectorWeather.getJSONObject(url);
            todaysWeather = (JSONObject) weatherJSONObject.get("main");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(todaysWeather != null) {
            double temp = (Double) todaysWeather.get("temp") - 273.15;

            DecimalFormat df = new DecimalFormat("##.##");
            String formattedTemp = df.format(temp);

            return "Temperatur: " + formattedTemp + " Grad Celsius" +
                    "\nDruck: " + todaysWeather.get("pressure") +
                    "\nFeuchtigkeit: " + todaysWeather.get("humidity");
        } else {
            return "";
        }
    }
}
