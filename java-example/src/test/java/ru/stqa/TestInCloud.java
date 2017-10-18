package ru.stqa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestInCloud {
    private WebDriver driver;
    public static final String USERNAME = "karinagarmash1";
    public static final String AUTOMATE_KEY = "y4ZqbpzJ1avis46aRB7q";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MAC");
        caps.setCapability("browser", "opera");
//        caps.setCapability("browser_version", "7.0");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("build", "First build");

        driver = new RemoteWebDriver(new URL(URL), caps);

    }

    @Test
    public void login() {

        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
