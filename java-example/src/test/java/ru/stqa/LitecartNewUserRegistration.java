package ru.stqa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LitecartNewUserRegistration {

    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void newCustomer() {
        driver.get("http://localhost/litecart/");
//        driver.findElement();

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
