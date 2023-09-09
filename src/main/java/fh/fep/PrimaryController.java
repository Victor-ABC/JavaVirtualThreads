package fh.fep;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;

public class PrimaryController {


    static final String apiKey = "752998c2f6fbb86c57bb497e360e3a0d"; //victors-Account
    static final String weatherBaseURL = "https://api.openweathermap.org/data/2.5/weather?";

    static String buildURL(String lat, String lon) {
        return "lat="+lat + "&lon="+lon + "&appid="+apiKey;
    }

    static String visualizeWeatherData(String data) {
        return "Weather: " + data;
    }

    static String getWeatherData(String url) {

        JSONObject todaysWeather = null;
        try {
            todaysWeather = GetTodaysWeatherInformation(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(todaysWeather != null) {
            return "Min temperature: " + todaysWeather.get("min_temp") +
                    "\nCurrent temperature: " + todaysWeather.get("the_temp") +
                    "\nMax temperature: " + todaysWeather.get("max_temp");
        } else {
            return "";
        }
    }

    static public JSONObject GetTodaysWeatherInformation(String url) throws MalformedURLException {
        APIConnector apiConnectorWeather = new APIConnector(weatherBaseURL);


        JSONObject weatherJSONObject = apiConnectorWeather.getJSONObject(url);

        //todo: richtiges feld des json objekts für temperatur
        JSONArray weatherArray = (JSONArray) weatherJSONObject.get("consolidated_weather");

        return  (JSONObject) weatherArray.get(0);
    }

}
