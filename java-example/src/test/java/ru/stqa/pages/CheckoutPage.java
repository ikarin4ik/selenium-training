package ru.stqa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CheckoutPage extends Page {

    public static final String ROW_SELECTOR = "table.dataTable.rounded-corners tbody tr:not(.header):not(.footer)";

    public CheckoutPage(WebDriver driver, String baseURL) {
        super(driver, baseURL);
    }

    public void open() {
        driver.get(baseURL + "/checkout");
    }

    public void stopProductCarusel() {
        String firstProduct = "#box-checkout-cart ul li:nth-child(1) a.inact";
        wait.until(presenceOfElementLocated(By.cssSelector(firstProduct)));
        driver.findElement(By.cssSelector(firstProduct)).click();
    }

    public int getProductsCount() {
        List<WebElement> rows = driver.findElements(By.cssSelector(ROW_SELECTOR));
        return rows.size() > 3 ? rows.size() - 3 : rows.size();
    }


    public void removeFirstAvailableProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("remove_cart_item")));
        int productsCount = getProductsCount();
        int expectedCount = productsCount > 1 ? (productsCount + 3) - 1 :  0;
        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(ROW_SELECTOR), expectedCount));
    }
}