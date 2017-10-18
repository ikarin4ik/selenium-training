package ru.stqa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestGrid {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability("platform", Platform.WINDOWS);
        driver = new RemoteWebDriver( new URL("http://10.37.129.2:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @Test
    public void login() {


        driver.get("https://www.google.ru/");
        driver.findElement(By.name("q")).sendKeys("webdriver", Keys.ENTER);

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

