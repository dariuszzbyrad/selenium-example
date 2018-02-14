package com.dzbyrad.seleniumexample.Scraper;

import static org.apache.commons.lang3.Validate.notNull;

import com.dzbyrad.seleniumexample.Model.City;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Scraper {
    private static final String CHROME_DRIVER_PATH = "webdriver/chromedriver.exe";

    private WebDriver driver;
    private WikipediaScraper wikiScraper;

    public Scraper() {
        init();
    }

    private void init() {
        driver = prepareWebDriver();
        wikiScraper = new WikipediaScraper(driver);
    }

    private WebDriver prepareWebDriver() {
        System.setProperty(
                "webdriver.chrome.driver",
                CHROME_DRIVER_PATH);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void destroy() {
        driver.close();
    }

    public List<City> getListOfCities() {
        return wikiScraper.getListOfCities();
    }
}
