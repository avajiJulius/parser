package edu.parser.web.weather;

import java.io.IOException;
import java.util.List;

public class ParserApp {
    public static void main(String[] args) throws IOException {
        PageBuilder builder = new PageBuilder("London");
        WeatherParser weather = new WeatherParser(builder);
        List<String> tempList = weather.getWeather();
        tempList.forEach(System.out::println);
    }
}
