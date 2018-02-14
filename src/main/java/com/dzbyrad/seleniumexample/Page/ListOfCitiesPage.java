package com.dzbyrad.seleniumexample.Page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class ListOfCitiesPage {

    @FindBy(how = How.XPATH, using = "//div[contains(@style,'-moz-column-count:3; -webkit-column-count:3; column-count:3;')]/ul/li/a")
    private List<WebElement> citiesElements;

    public List<String> getListOfCities() {
        List<String> cities = new ArrayList<>();

        citiesElements
                .stream()
                .forEach(e -> cities.add(e.getAttribute("href")));

        return cities;
    }
}
