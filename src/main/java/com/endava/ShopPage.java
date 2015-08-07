package com.endava;

import com.thoughtworks.selenium.webdriven.JavascriptLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by cmarineata on 8/6/2015.
 */
public class ShopPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='autocomplete_prod']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='btn text-lg bg-style1 block']")
    private WebElement searchButton;

    @FindBy(xpath = "//div//ul//li[4]//a[@title='Telefoane mobile']")
    private WebElement menuButton;

    @FindBy(xpath = "//ul/li[1]/div[3]/p[1]/a")
    private WebElement priceCheck;

    @FindBy(xpath = "//ul/li[@itemprop='offers']")
    private List<WebElement> noShops = new ArrayList<WebElement>();

    @FindBy(xpath = "//select/option[@value='price']")
    private WebElement filterButton;

    @FindBy(xpath = "//p/a[@class='text-xl text-dark price']")
    private  WebElement minPrice;

    @FindBy(xpath = "//ul[1]/li/div[2]/div[2]/p[1]/span/a/i")
    private WebElement extendButton;

    @FindBy(xpath ="//ul[1]/li/div[2]/div[2]/p[1]/a[@class='inline-block']")//xpath = "//div[5]/div/div[2]/div/a/h2[@class='font-alternate']")
    private WebElement shopName;

    @FindBy(xpath = "//ul[55]/li[2]/div[2]/div[3]/p[1]/a[@class='text-xl text-dark price']")
    private WebElement maxPrice;

    @FindBy(xpath ="//ul[55]/li[2]/div[2]/div[2]/p[1]/a[@class='inline-block']")//xpath = "//div[5]/div/div[2]/div/a/h2[@class='font-alternate']")
    private WebElement shopMaxName;


    public ShopPage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.shopmania.ro");
    }

    public void connectToPage(String produs){
        searchField.sendKeys(produs);
        searchButton.click();
        menuButton.click();
        priceCheck.click();
        filterButton.click();
        //      extendButton.click();
        //      extendMaxButton.click();
    }

    public void countShops(){
        System.out.println("Numarul de magazine disponibile este: " + noShops.size());
    }

    public void minimPrice(){
        System.out.println("Pretul minim este: "+ minPrice.getText());
        System.out.println("Numele magazinului cu pretul minim este: " + shopName.getAttribute("title"));
    }

    public void maxPrice(){
        System.out.println("Pretul maxim este: "+ maxPrice.getText());
        System.out.println("Numele magazinului cu pretul maxim este: " + shopMaxName.getAttribute("title"));
    }


    public void checkPrice(){
        String expectedPrice = maxPrice.getText();
        assertTrue(expectedPrice.contains("2.108,63 RON"));

        System.out.println("Rezultat Assert: "+ expectedPrice);
    }


}
