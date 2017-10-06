package ru.stqa;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddNewProduct {
    private static final String BASE_URL = "http://localhost/litecart/admin";
    private final String PRODUCT_NAME = "Nintendo Switch";
    private final String PRODUCT_CODE = "B01MUAGZ49";
    private final String QUANTITY = "10";
    private final String DATE_FROM = "10.11.2017";
    private final String DATE_TO = "10.02.2018";
    private final String KEYWORDS = "Game console";
    private final String SHORT = "major video game console developed by Nintendo";
    private final String DESCRIPTION = "Known in development by its codename NX, it was unveiled in October 2016 and was released worldwide on March 3, 2017";
    private final String HEAD_TITLE = "Game product";
    private final String META_DESCRIPTION = "Nintendo";
    private final String PRICE = "300";
    private final String PRICE_EUR = "256";

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void addNewProduct() {
        login();
        driver.findElement(By.cssSelector("#sidebar #box-apps-menu-wrapper ul#box-apps-menu li:nth-child(2) a")).click();
        driver.findElement(By.cssSelector("td#content div a.button:nth-child(2)")).click();

        fillTabGeneral();

        uploadImage();

        dateValidFrom();

        dateValidTo();

        driver.findElement(By.cssSelector("td#content form div.tabs ul.index li:nth-child(2) a")).click();

        // ожидание
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        fillTabInformation();

        driver.findElement(By.cssSelector("td#content form div.tabs ul.index li:nth-child(4) a")).click();

        // ожидание
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        fillTabPrice();

        // cохранение

        driver.findElement(By.name("save")).click();

        // проверка

        List<WebElement> productElements = driver.findElements(
                By.xpath("//*[@id='content']/form/table/tbody/tr/td/a[contains(text(),'" + PRODUCT_NAME + "')]"));

        Assert.assertTrue(productElements.size() > 0);


    }

    private void login() {
        driver.get(BASE_URL);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    private void quantity() {
        driver.findElement(By.cssSelector("input[name='quantity']")).click();
        driver.findElement(By.cssSelector("input[name='quantity']")).clear();
        driver.findElement(By.cssSelector("input[name='quantity']")).sendKeys(QUANTITY);

    }

    private void dateValidFrom() {
        driver.findElement(By.cssSelector("[name='date_valid_from']")).click();
        driver.findElement(By.cssSelector("[name='date_valid_from']")).sendKeys(DATE_FROM);
    }

    private void dateValidTo() {
        driver.findElement(By.cssSelector("[name='date_valid_to']")).click();
        driver.findElement(By.cssSelector("[name='date_valid_to']")).sendKeys(DATE_TO);
    }

    private void fillTabPrice() {
        driver.findElement(By.cssSelector("input[name='purchase_price']")).click();
        driver.findElement(By.cssSelector("input[name='purchase_price']")).clear();
        driver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys(PRICE);
        driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']")).sendKeys("USD");
        driver.findElement(By.name("prices[USD]")).sendKeys(PRICE);
        driver.findElement(By.name("prices[EUR]")).sendKeys(PRICE_EUR);
    }

    private void fillTabInformation() {
        driver.findElement(By.cssSelector("select[name='manufacturer_id']")).sendKeys("ACME Corp.");
        driver.findElement(By.name("keywords")).sendKeys(KEYWORDS);
        driver.findElement(By.name("short_description[en]")).sendKeys(SHORT);
        driver.findElement(
                By.cssSelector("table tbody tr td span.input-wrapper div div.trumbowyg-editor")).sendKeys(DESCRIPTION);
        driver.findElement(By.name("head_title[en]")).sendKeys(HEAD_TITLE);
        driver.findElement(By.name("meta_description[en]")).sendKeys(META_DESCRIPTION);
    }

    private void uploadImage() {
        File upload = new File("src/main/resources/product.jpg");
        String filepath = upload.getAbsolutePath();
        driver.findElement(By.cssSelector("input[name='new_images[]']")).sendKeys(filepath);
    }

    private void fillTabGeneral() {
        driver.findElement(By.cssSelector("input[name='status'][value='1']")).click();
        driver.findElement(By.name("name[en]")).sendKeys(PRODUCT_NAME);
        driver.findElement(By.name("code")).sendKeys(PRODUCT_CODE);
        driver.findElement(By.cssSelector("input[name='categories[]'][value='1']")).click();
        driver.findElement(By.cssSelector("select[name='default_category_id'] option[value='1']")).click();
        driver.findElement(By.cssSelector("input[name='product_groups[]'][value='1-3']")).click();
        quantity();
        driver.findElement(By.cssSelector("select[name='sold_out_status_id'] option[value='2']")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
