package fh.fep;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;

public class PrimaryController {

    private final String apiKey = "752998c2f6fbb86c57bb497e360e3a0d"; //victors-Account

    private final String weatherBaseURL = "https://api.openweathermap.org/data/2.5/weather?";

    void visualizeWeatherData(String data) {
        System.out.println(data);
    }

    String getWeatherData(String lat, String lon) throws MalformedURLException {
        JSONObject todaysWeather = GetTodaysWeatherInformation(lat, lon);
        System.out.println(todaysWeather);
        return "Min temperature: " + todaysWeather.get("min_temp") +
               "\nCurrent temperature: " + todaysWeather.get("the_temp") +
               "\nMax temperature: " + todaysWeather.get("max_temp");
    }

    public JSONObject GetTodaysWeatherInformation(String lat, String lon) throws MalformedURLException {
        APIConnector apiConnectorWeather = new APIConnector(weatherBaseURL);

        String query = "lat="+lat + "&lon="+lon + "&appid="+apiKey;

        JSONObject weatherJSONObject = apiConnectorWeather.getJSONObject(query);

        //todo: richtiges feld des json objekts für temperatur
        JSONArray weatherArray = (JSONArray) weatherJSONObject.get("consolidated_weather");

        return  (JSONObject) weatherArray.get(0);
    }

}
