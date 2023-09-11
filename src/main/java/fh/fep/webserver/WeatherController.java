package fh.fep.webserver;


import java.text.DecimalFormat;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;

public class WeatherController implements AbstractWeatherController{


    final String apiKey = "752998c2f6fbb86c57bb497e360e3a0d"; //victors-Account
    final String weatherBaseURL = "https://api.openweathermap.org/data/2.5/weather?";

    final String weatherBaseURLgetLatLonUsingName = "http://api.openweathermap.org/geo/1.0/direct?q=";

    public String buildURL(Location location) {
        return "lat="+location.lat + "&lon="+location.lon + "&appid="+apiKey;
    }

    public String visualizeWeatherData(String data) {
        return "### Wetter ### \n" + data;
    }

    public Location getLocationUsingCityName(String cityName) {
        Location location = null;
        try {
            APIConnector apiConnectorWeather = new APIConnector(weatherBaseURLgetLatLonUsingName);
            JSONObject weatherJSONObject = (JSONObject) apiConnectorWeather.getJSONArray(cityName + "&appid=" + apiKey)
                    .get(0); //HTTP Request
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

        JSONObject todaysWeather = null;
        try {
            APIConnector apiConnectorWeather = new APIConnector(weatherBaseURL);
            JSONObject weatherJSONObject = apiConnectorWeather.getJSONObject(url); //HTTP Request
            todaysWeather = (JSONObject) weatherJSONObject.get("main");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } //- 273.15
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
