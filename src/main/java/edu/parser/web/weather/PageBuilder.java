package edu.parser.web.weather;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class PageBuilder {
    private String city;

    PageBuilder(String city) {
        this.city = city;
    }
    public Document getWeatherPage() throws IOException {
//        String url = "https://www.accuweather.com/en/world-weather";
//        Document page = Jsoup.parse(new URL(url), 3000);
        Document page = Jsoup.connect("https://yandex.ru/pogoda/" + this.city)
                .userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)").get();
        return page;
    }
}
