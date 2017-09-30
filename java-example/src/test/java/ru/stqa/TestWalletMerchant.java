package ru.stqa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWalletMerchant {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriver firefoxDriver;
    private WebDriverWait waitFirefox;

    @Before
    public void start () {
        firefoxDriver = new FirefoxDriver();
        waitFirefox = new WebDriverWait(firefoxDriver, 10);
    }

    @Test
    public void click () {
        firefoxDriver.get("https://www.walletone.com/merchant/client/");
        firefoxDriver.findElement(By.name("Login")).sendKeys("89225330323");
        firefoxDriver.findElement(By.name("Password")).sendKeys("KFS777");


    }

    @After
    public void stop () {
        firefoxDriver.quit();
        firefoxDriver = null;
    }
}
