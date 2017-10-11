package ru.stqa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class NewWindow {
    private static final String BASE_URL_COUNTRIES = "http://localhost/litecart/admin/?app=countries&doc=countries";
    private WebDriver driver;
    private WebDriverWait wait;

    private ExpectedCondition<String> waitForNewWindow(Set<String> oldWindows) {
        return driver -> {
            Set<String> windows = driver.getWindowHandles();
            windows.removeAll(oldWindows);
            if (windows.size() > 0)
                return windows.iterator().next();
            else
                return null;
        };
    }


    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    private void login() {
        driver.get(BASE_URL_COUNTRIES);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

    }


    @Test
    public void addNewCountry() {
        login();
        driver.findElement(By.cssSelector("a.button")).click();
        wait.until(visibilityOfElementLocated(By.cssSelector("h1")));
        // найти ссылку, которая открывает новое окно
        List<WebElement> elements = driver.findElements(By.cssSelector("td#content form table tbody tr td a[target='_blank']"));
        for (WebElement element : elements) {
            String originalWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            element.click();
            String newWindow = wait.until(waitForNewWindow(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(originalWindow);
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}

