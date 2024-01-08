package com.kotki.frontend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    WebDriver webDriver;

    @BeforeEach
    public void setUp(){
        webDriver = new ChromeDriver();
    }

    @Test
    public void seeIfClicks(){
        SeleniumTestPage page = new SeleniumTestPage(webDriver);
        page.open();
        page.clickEditCatLink();
        page.clickDeleteCatLink();
        page.clickAddCat();
    }

}
