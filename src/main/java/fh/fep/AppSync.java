package fh.fep;

public class AppSync {

    public static void main(String[] args) {
        String weather = WeatherService.readWeatherFor("Münster");
        System.out.println(weather);
    }
}
