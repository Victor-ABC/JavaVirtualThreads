package fh.fep.webserver;


import java.text.DecimalFormat;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;

public class MockWeatherController implements AbstractWeatherController{


    static final String apiKey = "752998c2f6fbb86c57bb497e360e3a0d"; //victors-Account
    static final String weatherBaseURL = "https://api.openweathermap.org/data/2.5/weather?";

    static final String weatherBaseURLgetLatLonUsingName = "http://api.openweathermap.org/geo/1.0/direct?q=";

    public String buildURL(Location location) {
        return "lat="+location.lat + "&lon="+location.lon + "&appid="+apiKey;
    }

    public String visualizeWeatherData(String data) {
        return "### Wetter ### \n" + data;
    }

    public Location getLocationUsingCityName(String cityName) {
            String lat = "50.91123";
            String lon =  "-1.23";
        return new Location(lat, lon);
    }

    /**
     * HTTP Request to remote server to query real time weather data.
     * @param url the URL
     * @return String containing relevant information
     */
    public String getWeatherData(String url) {
            return "Temperatur: " + "18" + " Grad Celsius" +
                    "\nDruck: " + "1030" +
                    "\nFeuchtigkeit: " + "30";
    }
}

