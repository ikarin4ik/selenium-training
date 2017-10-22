package ru.stqa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProductPage extends Page {

    public static final String ADD_TO_CART_BUTTON = "td.quantity button";

    public ProductPage(WebDriver driver, String baseURL) {
        super(driver, baseURL);
    }


    public WebElement waitForPageLoaded() {
        return wait.until(visibilityOfElementLocated(By.cssSelector(ADD_TO_CART_BUTTON)));
    }

    public void addProductToCart() {
        List<WebElement> sizeElements = driver.findElements(By.cssSelector("select[name='options[Size]']"));
        if (sizeElements.size() > 0) {
            sizeElements.get(0).sendKeys("Small");
        }
        driver.findElement(By.cssSelector(ADD_TO_CART_BUTTON)).click();
    }

    public void waitForProductCountInBasketBecame(Integer count) {
        wait.until(textToBePresentInElementLocated(By.cssSelector("span.quantity"), count.toString()));
    }
}