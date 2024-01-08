package com.kotki.frontend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumTestPage {
    public static final String URL = "http://localhost:8080/viewAll";

    WebDriver webDriver;

    public SeleniumTestPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(id="editcat")
    WebElement editCatLink;

    @FindBy(id="deletecat")
    WebElement deleteCatLink;

    @FindBy(id="addcat")
    WebElement addCatLink;

    public void open(){
        webDriver.get(URL);
        PageFactory.initElements(webDriver, this);
    }

    public void clickEditCatLink(){
        editCatLink.click();
    }

    public void clickDeleteCatLink() {
        deleteCatLink.click();
    }

    public void clickAddCat(){
        addCatLink.click();
    }
}
