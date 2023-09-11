package fh.fep.webserver;

public interface AbstractWeatherController {

    /**
     * Build a URL for fetching weather data based on location.
     *
     * @param location the location for which to build the URL.
     * @return a URL string for fetching weather data.
     */
    String buildURL(Location location);

    /**
     * Visualize weather data in a human-readable format.
     *
     * @param data the raw weather data to visualize.
     * @return a formatted weather information string.
     */
    String visualizeWeatherData(String data);

    /**
     * Get the location using a city name.
     *
     * @param cityName the name of the city.
     * @return a Location object representing the city's coordinates.
     */
    Location getLocationUsingCityName(String cityName);

    /**
     * Get weather data from a remote server based on a URL.
     *
     * @param url the URL for fetching weather data.
     * @return a string containing relevant weather information.
     */
    String getWeatherData(String url);
}
