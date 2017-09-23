package ru.stqa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestFirefoxNightly {
    private WebDriver firefoxDriver;
    private WebDriverWait waitFirefox;

    @Before
    public void start() {
        FirefoxOptions options = new FirefoxOptions().setLegacy(false);
        options.setBinary(new FirefoxBinary(new File("/Users/karinakastanova/Downloads/FirefoxNightly.app/Contents/MacOS/firefox")));
        firefoxDriver = new FirefoxDriver(options);
        waitFirefox = new WebDriverWait (firefoxDriver, 10);
    }

    @Test
    public void  myFirstTest () {
        firefoxDriver.get("https://www.google.ru/");
        firefoxDriver.findElement(By.name("q")).sendKeys("webdriver", Keys.ENTER);
        waitFirefox.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop() {
        firefoxDriver.quit();
        firefoxDriver = null;
    }
}
