package ru.stqa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortCountriesTest {

    public static final String COUNTRIES_URL = "?app=countries&doc=countries";
    private static final String BASE_URL = "http://localhost/litecart/admin";

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    public void login() {
        driver.get(BASE_URL);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

    }


    public void logout () {
        driver.findElement(By.cssSelector("td#sidebar div.header a[title='Logout'] ")).click();
    }

    @Test()
    public void verifyCountries () {
        login();
        driver.get(BASE_URL + COUNTRIES_URL);
        ArrayList <String> list = new ArrayList<String>();
        List<WebElement> elements = driver.findElements(
                By.cssSelector("td#content form[name=countries_form] table.dataTable tbody tr.row :nth-child(5)"));

        for (WebElement element : elements) {
            list.add(element.getText());

        }

        ArrayList<String> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(i), sortedList.get(i));
        }
        logout();
    }

    @Test()
    public void verifyCountriesZones () {
        login();
        driver.get(BASE_URL + COUNTRIES_URL);
        List<WebElement> elements = driver.findElements(By.cssSelector("td#content form[name=countries_form] table.dataTable tbody tr.row"));
        for (int i = 0; i < elements.size(); i++) {
            WebElement zoneCount = elements.get(i).findElement(By.cssSelector(":nth-child(6)"));
            if(!zoneCount.getText().trim().equals("0")) {
                WebElement link = elements.get(i).findElement(By.cssSelector(":nth-child(5) a"));
                link.click();

                List<WebElement> zoneElements = driver.findElements(By.cssSelector("td#content form table#table-zones tbody tr:not(.header) :nth-child(3)"));
                ArrayList<String> zones = new ArrayList<>();

                for (int j = 0; j < zoneElements.size() - 1; j++) {
                    zones.add(zoneElements.get(j).getText());
                }

                ArrayList<String> zonesSorted = new ArrayList<>(zones);
                Collections.sort(zonesSorted);

                for (int k = 0; k < zones.size(); k++) {
                     Assert.assertEquals(zones.get(k), zonesSorted.get(k));
                }

                driver.get(BASE_URL + COUNTRIES_URL);
                elements = driver.findElements(By.cssSelector("td#content form[name=countries_form] table.dataTable tbody tr.row"));
            }

        }
        logout();
    }





    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}