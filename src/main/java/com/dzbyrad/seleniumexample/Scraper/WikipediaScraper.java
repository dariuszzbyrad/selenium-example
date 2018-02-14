package com.dzbyrad.seleniumexample.Scraper;

import com.dzbyrad.seleniumexample.Model.City;
import com.dzbyrad.seleniumexample.Page.CityPage;
import com.dzbyrad.seleniumexample.Page.ListOfCitiesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class WikipediaScraper {

    private static final String CITIES_IN_POLAND_URL = "https://pl.wikipedia.org/wiki/Miasta_w_Polsce";

    private WebDriver driver;
    private ListOfCitiesPage listOfCitiesPage;
    private CityPage cityPage;

    public WikipediaScraper(WebDriver driver) {
        this.driver = driver;
        init();
    }

    public void init() {
        listOfCitiesPage = PageFactory.initElements(driver, ListOfCitiesPage.class);
        cityPage = PageFactory.initElements(driver, CityPage.class);
    }

    public List<City> getListOfCities() {
        driver.get(CITIES_IN_POLAND_URL);

        List<String> urls = listOfCitiesPage.getListOfCities();

        return urls
                .stream()
//                .filter(u -> u.contains("("))
                .map(u -> getCityDetails(u))
                .collect(Collectors.toList());
    }

    private City getCityDetails(String url) {
        driver.get(url);

        return cityPage.getDetails();
    }
}
