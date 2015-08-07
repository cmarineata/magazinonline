package com.endava;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import javax.xml.bind.SchemaOutputResolver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static javax.lang.model.element.Element.*;

/**
 * Created by cmarineata on 8/6/2015.
 */
public class ShopTest {

    static WebDriver driver;

    @BeforeClass
    public static void before(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void after(){
        driver.close();
    }

    @Before
    public void goTo(){
        driver.get("http://www.shopmania.ro");
    }

    @Test
    public void testShop() {

        WebElement searchField = driver.findElement(By.xpath("//input[@id='autocomplete_prod']"));
        searchField.sendKeys("galaxy s5");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn text-lg bg-style1 block']"));
        searchButton.submit();

//        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement meniuButton = driver.findElement(By.xpath("//div//ul//li[4]//a[@title='Telefoane mobile']"));
        meniuButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement pricecheck = driver.findElement(By.xpath("//ul/li[1]/div[3]/p[1]/a"));  ////a//span[@class='price']
        pricecheck.click();


//        List<WebElement> optionCount = driver.findElements(By.xpath("//span[@itemprop='offerCount']")); //ul/li  //div/p
//        System.out.println("The number of avaliable shops is: " + optionCount.size());
//
//
//        WebElement name = driver.findElement(By.xpath("//div/a[@title='Globalmobile.ro']"));
//        WebElement minPrice = driver.findElement(By.xpath("//div/a[@class='price-offer']"));
//        System.out.println("The shops name is: " + name.getText() + "and the min price is: "+ minPrice.getText());
//
//        WebElement minPrice = driver.findElement(By.xpath("//div/ul/li/div[2]/div/p/a/span[@class='price']"));
//        minPrice.click();
//        System.out.println(minPrice.getText());


    }

}

