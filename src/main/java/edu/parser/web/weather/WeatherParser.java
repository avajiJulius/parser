package edu.parser.web.weather;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class WeatherParser {

    private PageBuilder builder;

    public WeatherParser(PageBuilder builder) {
        this.builder = builder;
    }

    public List<String> getWeather() throws IOException {
        Document doc = this.builder.getWeatherPage();
        List<String> result = new ArrayList<>();
        //YESTERDAY
        Element yesterday = doc.select("div.term.term_orient_h.fact__yesterday").first();
        String yesterdayLabel = yesterday.getElementsByClass("term__label").text();
        String yesterdayTemperature = yesterday.getElementsByClass("temp__value").text();
        String tempUnit = doc.selectFirst("span.temp__unit").text();
        //TODAY
        Element today = doc.select("div.temp.fact__temp.fact__temp_size_s").first();
        String todayLabel = today.child(0).text();
        String todayTemp = today.child(1).text();
        //FEELS
        Element todayFeel = doc.select("div.link__feelings.fact__feelings").first();
        String todayFeels = todayFeel.child(1).text();
        String todayAttr = todayFeel.child(0).text();

        //Strings
        result.add(yesterdayLabel + " " + yesterdayTemperature + tempUnit);
        result.add(todayLabel + " " + todayTemp + tempUnit + " " + todayAttr);
        result.add(todayFeels);

        return result;
    }
}
