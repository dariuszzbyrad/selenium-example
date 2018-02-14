package com.dzbyrad.seleniumexample;

import com.dzbyrad.seleniumexample.Model.City;
import com.dzbyrad.seleniumexample.Scraper.Scraper;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scraper scraper = new Scraper();

        List<City> cities = scraper.getListOfCities();
        cities.forEach(s -> System.out.println(s));

        scraper.destroy();

    }
}
