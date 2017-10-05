package ru.stqa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LitecartNewUserRegistration {
    private final String FIRST_NAME = "Maxim";
    private final String LAST_NAME = "Ivanov";
    private final String ADRESS = "3321 Hinkle Lake Road";
    private final String POSTCODE = "12345";
    private final String CITY = "Quincy";
    private final String COUNTRY = "United States";
    private final String EMAIL = System.nanoTime() + "@gmail.com";
    private final String PHONE = "6174836907";
    private final String PASSWORD = "123qwe";



    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }
    private void logout() {
        driver.findElement(By.cssSelector("div.left aside#navigation div.content div#box-account div ul li:nth-child(4) a")).click();
    }

    @Test
    public void newCustomer() throws InterruptedException {
        driver.get("http://localhost/litecart/");
        driver.findElement(By.cssSelector("#navigation div.content div#box-account-login div.content form table tbody tr td a")).click();

        driver.findElement(By.name("firstname")).sendKeys(FIRST_NAME);
        driver.findElement(By.name("lastname")).sendKeys(LAST_NAME);
        driver.findElement(By.name("address1")).sendKeys(ADRESS);
        driver.findElement(By.name("postcode")).sendKeys(POSTCODE);
        driver.findElement(By.name("city")).sendKeys(CITY);
        driver.findElement(By.cssSelector("div.content form table tbody tr td span.select2-container")).click();
        driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys(COUNTRY + Keys.ENTER);
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("phone")).sendKeys(PHONE);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("confirmed_password")).sendKeys(PASSWORD);
        driver.findElement(By.name("create_account")).click();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//      logout

        logout();

//      login

        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("login")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//      logout
        logout();


    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
