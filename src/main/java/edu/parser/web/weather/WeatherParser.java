package edu.parser.web.weather;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherParser {
    public static void main(String[] args) throws IOException {
        Document doc = getPage();
//        Element search = doc.select("input[class=SearchInput--InputField--232zz Search--inputClass--eGdhQ]")
//                .first().attr("value", "Moscow");
        String tempUnit = doc.selectFirst("span.temp__unit").text();
            String tempValueYesterday = doc.select("span.temp__value").get(1).text();
            String tempValueToday = doc.select("span.temp__value").get(2).text();
            String tempValueFeel = doc.select("span.temp__value").get(3).text();
            System.out.println("Yesterday in same time " + tempValueYesterday + tempUnit);
            System.out.println("Today " + tempValueToday + tempUnit);
            System.out.println("Feels like " + tempValueFeel + tempUnit);

    }

    public static Document getPage() throws IOException {
//        String url = "https://www.accuweather.com/en/world-weather";
//        Document page = Jsoup.parse(new URL(url), 3000);
        Document doc = Jsoup.connect("https://yandex.ru/pogoda/saint-petersburg")
                .userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)").get();
        return doc;
    }
}
