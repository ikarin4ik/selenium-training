package ru.stqa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    private final String PRODUCT_SELECTOR = "div.content div#box-most-popular div.content ul li:nth-child(1) a.link";


    public HomePage(WebDriver driver, String baseURL) {
        super(driver, baseURL);
    }

    public void open() {
        driver.get(baseURL + "/");
    }


    public int getProductsInBasketCount() {
        String numberOfGoods = driver.findElement(By.cssSelector("span.quantity")).getText();
        return Integer.parseInt(numberOfGoods);
    }

    public void clickOnFirstProductOnPage() {
        driver.findElement(By.cssSelector(PRODUCT_SELECTOR)).click();
    }
}