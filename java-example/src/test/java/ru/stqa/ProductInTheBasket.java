package ru.stqa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ProductInTheBasket {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test

    public void addProductToBasket() {

        driver.get("http://localhost/litecart/");

        for (int i = 0; i < 3; i++) {
            // найти корзину и посмотреть, сколько там товаров уже есть
            String numberOfGoods = driver.findElement(By.cssSelector("span.quantity")).getText();
            Integer n = Integer.parseInt(numberOfGoods);
            // открыть первый товар из списка
            String productSelector = "div.content div#box-most-popular div.content ul li:nth-child(1) a.link";
            driver.findElement(By.cssSelector(productSelector)).click();
            // подождать пока перейдем на страницу товара и добавить товар в корзину
            WebElement addToCartButton = wait.until(visibilityOfElementLocated(By.cssSelector("td.quantity button")));
            List<WebElement> sizeElements = driver.findElements(By.cssSelector("select[name='options[Size]']"));
            if (sizeElements.size() > 0) {
                sizeElements.get(0).sendKeys("Small");
            }
            addToCartButton.click();
            n++;
            // подождать, пока счётчик товаров в корзине обновится
            wait.until(textToBePresentInElementLocated(By.cssSelector("span.quantity"), n.toString()));
            // вернуться на главную страницу
            driver.findElement(By.cssSelector("div#site-menu-wrapper nav#site-menu.twelve-eighty ul li.general-0 a")).click();
        }

        // открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
        driver.findElement(By.cssSelector("div#cart-wrapper div#cart a.link")).click();

        String firstProduct = "#box-checkout-cart ul li:nth-child(1) a.inact";

        wait.until(presenceOfElementLocated(By.cssSelector(firstProduct)));
        driver.findElement(By.cssSelector(firstProduct)).click();

        String rowsSelector = "table.dataTable.rounded-corners tbody tr:not(.header):not(.footer)";
        // поочередно удалить все товары из корзины, после каждого удаления подождать, пока обновится таблица
        List<WebElement> rows = driver.findElements(By.cssSelector(rowsSelector));
        while (rows.size() > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("remove_cart_item")));
            WebElement buttonRemove = driver.findElement(By.name("remove_cart_item"));
            buttonRemove.click();
            // подождать, пока строки таблицы не обновятся (уменьшатся на ед)
            if (rows.size() == 4) {
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(rowsSelector), 0));
            } else {
                wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(rowsSelector), rows.size() - 1));
            }
            rows = driver.findElements(By.cssSelector(rowsSelector));
        }
        // строки таблицы
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
