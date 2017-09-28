package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LitecartMenuTest {
    private WebDriver driver;
    private WebDriverWait wait;



    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void clickOnMenu () {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> elements = driver.findElements(By.cssSelector("#app-"));
        for (int i = 0; i < elements.size(); i++) {
            List<WebElement> elementsOnPage = driver.findElements(By.cssSelector("#app-"));
            elementsOnPage.get(i).click();
            driver.findElement(By.cssSelector("td#content h1"));

            List<WebElement> subElements = driver.findElements(By.cssSelector("#app-.selected ul a"));
            for (int j = 0; j < subElements.size(); j++) {
                List<WebElement> subElementsOnPage = driver.findElements(By.cssSelector("#app-.selected ul a"));
                subElementsOnPage.get(j).click();
                driver.findElement(By.cssSelector("td#content h1"));
            }
        }



    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
