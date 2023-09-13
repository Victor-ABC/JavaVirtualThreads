package fh.fep.webserver;


public class MockWeatherController implements AbstractWeatherController{
    final String apiKey = "12345678"; // victors-Account
    int taskId;

    public MockWeatherController(int taskId) {
        this.taskId = taskId;
    }

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

        // Mock HTTP Request
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String lat = "50.91123";
        String lon = "-1.23";

        return new Location(lat, lon);
    }

    /**
     * HTTP Request to remote server to query real time weather data.
     * @param url the URL
     * @return String containing relevant information
     */
    public String getWeatherData(String url) {
        printInfo();

        // Mock HTTP Request
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return """
                Temperatur: 18 Grad Celsius
                Druck: 1030
                Feuchtigkeit: 30""";
    }
}

