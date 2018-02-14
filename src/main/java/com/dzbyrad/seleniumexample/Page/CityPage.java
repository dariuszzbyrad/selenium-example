package com.dzbyrad.seleniumexample.Page;

import com.dzbyrad.seleniumexample.Model.City;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CityPage {

    @FindBy(how = How.XPATH, using = "//td[contains(@style,'font-size:120%; vertical-align:middle;')]/span")
    private WebElement name;

    @FindBy(how = How.XPATH, using = "//a[@title='Podział administracyjny Polski']/parent::td/following-sibling::td/a")
    private WebElement voivodeship;

    @FindBy(how = How.XPATH, using = "//a[@title='Powiat']/parent::td/following-sibling::td/a")
    private WebElement county;

    @FindBy(how = How.XPATH, using = "//a[@title='Gmina (Polska)']/parent::td/following-sibling::td/a")
    private WebElement community;

    public City getDetails() {
        return City.builder()
                .name(getEmptyValueIfNoSuchElement(name))
                .voivodeship(getEmptyValueIfNoSuchElement(voivodeship))
                .county(getEmptyValueIfNoSuchElement(county))
                .community(getEmptyValueIfNoSuchElement(community))
                .build();
    }

    private String getEmptyValueIfNoSuchElement(WebElement element) {
        try {
            return element.getText();
        } catch (NoSuchElementException ex) {
            return StringUtils.EMPTY;
        }

    }
}
