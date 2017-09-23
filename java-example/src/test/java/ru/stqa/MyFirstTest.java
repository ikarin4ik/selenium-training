package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

    private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private WebDriver safariDriver;
    private WebDriverWait waitChrome;
    private WebDriverWait waitFirefox;
    private WebDriverWait waitSafari;


    @Before
    public void start () {
        chromeDriver = new ChromeDriver();
        firefoxDriver = new FirefoxDriver();
        safariDriver = new SafariDriver();
        waitChrome = new WebDriverWait (chromeDriver, 10);
        waitFirefox = new WebDriverWait (firefoxDriver, 10);
        waitSafari = new WebDriverWait (safariDriver, 10);
    }

   @Test
   public void  myFirstTest () {
        chromeDriver.get("https://www.google.ru/");
        chromeDriver.findElement(By.name("q")).sendKeys("webdriver", Keys.ENTER);
        waitChrome.until(titleIs("webdriver - Поиск в Google"));
    }

    @Test
    public void  mySecondTest () {
        firefoxDriver.get("https://www.google.ru/");
        firefoxDriver.findElement(By.name("q")).sendKeys("webdriver", Keys.ENTER);
        waitFirefox.until(titleIs("webdriver - Поиск в Google"));
    }

    @Test
    public void  myThirdTest () {
        safariDriver.get("https://www.google.ru/");
        safariDriver.findElement(By.name("q")).sendKeys("webdriver", Keys.ENTER);
        waitSafari.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop() {
        chromeDriver.quit();
        chromeDriver = null;
        firefoxDriver.quit();
        firefoxDriver = null;
        safariDriver.quit();
        safariDriver = null;
    }
}


