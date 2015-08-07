package com.endava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by cmarineata on 8/6/2015.
 */
public class PageObjTest {

    WebDriver driver;
    ShopPage page;

    @Before
    public void before() {
        driver = new FirefoxDriver();
        page = PageFactory.initElements(driver, ShopPage.class);
    }

    @After
    public void after() {
        driver.close();
    }

    @Test
    public void test() {
        page.connectToPage("galaxy s5");
        page.countShops();
        page.minimPrice();
        page.maxPrice();
        page.checkPrice();
    }
}
