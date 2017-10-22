package ru.stqa;


import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class ProxyTest {
    private WebDriver chromeDriver;
    private WebDriverWait waitChrome;
    public BrowserMobProxy proxy;



    @Before
    public void start () {
        proxy = new BrowserMobProxyServer();
        proxy.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        chromeDriver = new ChromeDriver(capabilities);
    }

    @Test
    public void getBrowserLogs() {
        proxy.newHar();
        chromeDriver.navigate().to("http://selenium2.ru");
        Har har = proxy.endHar();
        har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" + l.getRequest().getUrl()));
    }

    @Test
    public void  testProxy () {
        chromeDriver.get("https://www.google.ru/");
        chromeDriver.findElement(By.name("q")).sendKeys("webdriver", Keys.ENTER);
        waitChrome.until(titleIs("webdriver - Поиск в Google"));
    }

    @After
    public void stop() {
        chromeDriver.quit();
        chromeDriver = null;
    }


}
