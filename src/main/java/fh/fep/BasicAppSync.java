package fh.fep;

public class BasicAppSync {

    public static void main(String[] args) {
        String weather = WeatherService.readWeatherFor("Münster");
        System.out.println(weather);
    }
}
