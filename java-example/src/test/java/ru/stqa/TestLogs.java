package ru.stqa;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Level;

public class TestLogs {
    private static final String BASE_URL_COUNTRIES = "http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1";
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.DRIVER, Level.INFO);
        DesiredCapabilities capabilities =DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
        driver = new ChromeDriver(capabilities);

        wait = new WebDriverWait(driver, 10);
    }

    private void login() {
        driver.get(BASE_URL_COUNTRIES);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void verifyLogs () {
        login();
        List <WebElement> elements = driver.findElements(By.cssSelector("#content form table.dataTable tbody tr.row td:nth-child(3)>a"));
        for (int i = 0; i < elements.size(); i++) {
            List <WebElement> elementList = driver.findElements(By.cssSelector("#content form table.dataTable tbody tr.row td:nth-child(3)>a"));
            if (!elementList.get(i).getText().equals("Subcategory")) {
                elementList.get(i).click();
            }
            List<LogEntry> logEntries = driver.manage().logs().get("browser").getAll();
            Assert.assertEquals(0, logEntries.size());
            driver.get(BASE_URL_COUNTRIES);
        }


    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
