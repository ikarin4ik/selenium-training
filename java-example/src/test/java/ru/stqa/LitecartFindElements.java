package ru.stqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LitecartFindElements {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void Login () {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.linkText("Appearence")).click();
        driver.findElement(By.id("doc-template")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Template')]"));
        driver.findElement(By.id("doc-logotype")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Logotype')]"));

        driver.findElement(By.linkText("Catalog")).click();
     // нужно ли искать заголовок h1? скорее всего нужно применить поиск по номеру в списке, т.к. заголовки у пункотв одинаковые
        driver.findElement(By.id("doc-catalog")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Catalog')]"));
        driver.findElement(By.id("doc-product_groups")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Product Groups')]"));
        driver.findElement(By.id("doc-option_groups")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Option Groups')]"));
        driver.findElement(By.id("doc-manufacturers")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Manufacturers')]"));
        driver.findElement(By.id("doc-suppliers")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Suppliers')]"));
        driver.findElement(By.id("doc-delivery_statuses")).click();
        driver.findElement(By.xpath("//h1[contains(text(),' Delivery Statuses')]"));
        driver.findElement(By.id("doc-sold_out_statuses")).click();
        driver.findElement(By.xpath("//h1[contains(text(),' Sold Out Statuses')]"));
        driver.findElement(By.id("doc-quantity_units")).click();
        driver.findElement(By.xpath("//h1[contains(text(),' Quantity Units')]"));
        driver.findElement(By.id("doc-csv")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'CSV Import/Export')]"));

        driver.findElement(By.linkText("Countries")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Countries')]"));

        driver.findElement(By.linkText("Currencies")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Currencies')]"));

        driver.findElement(By.linkText("Customers")).click();
        driver.findElement(By.id("doc-customers")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Customers')]"));
     //   driver.findElement(By.cssSelector("#doc-csv.name"));
        driver.findElement(By.xpath("//h1[contains(text(),' CSV Import/Export')]"));
        driver.findElement(By.id("doc-newsletter")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Newsletter')]"));

        driver.findElement(By.linkText("Geo Zones")).click();
        driver.findElement(By.xpath("//h1[contains(text(),' Geo Zones')]"));

        driver.findElement(By.linkText("Languages")).click();
        driver.findElement(By.id("doc-languages")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Languages')]"));
        driver.findElement(By.id("doc-storage_encoding")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Storage Encoding')]"));

        driver.findElement(By.linkText("Modules")).click();
        // нужно ли искать заголовок h1? скорее всего нужно применить поиск по номеру в списке, т.к. заголовки у пункотв одинаковые
        driver.findElement(By.id("doc-jobs")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Job Modules')]"));
        driver.findElement(By.id("doc-customer")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Customer Modules')]"));
        driver.findElement(By.id("doc-shipping")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Shipping Modules')]"));
        driver.findElement(By.id("doc-payment")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Payment Modules')]"));
        driver.findElement(By.id("doc-order_total")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Order Total Modules')]"));
        driver.findElement(By.id("doc-order_success")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Order Success Modules')]"));
        driver.findElement(By.id("doc-order_action")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Order Action Modules')]"));

        driver.findElement(By.linkText("Orders")).click();
        driver.findElement(By.id("doc-orders")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Orders')]"));
        driver.findElement(By.id("doc-order_statuses")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Order Statuses')]"));

        driver.findElement(By.linkText("Pages")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Pages')]"));

        driver.findElement(By.linkText("Reports")).click();
        // нужно ли искать заголовок h1? скорее всего нужно применить поиск по номеру в списке, т.к. заголовки у пункотв одинаковые
        driver.findElement(By.id("doc-monthly_sales")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Monthly Sales')]"));
        driver.findElement(By.id("doc-most_sold_products")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Most Sold Products')]"));
        driver.findElement(By.id("doc-most_shopping_customers")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Most Shopping Customers)]"));

        driver.findElement(By.linkText("Settings")).click();
        // нужно ли искать заголовок h1? скорее всего нужно применить поиск по номеру в списке, т.к. заголовки у пункотв одинаковые
        driver.findElement(By.id("doc-store_info")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Settings')]"));
        driver.findElement(By.id("doc-defaults")).click();
     //   driver.findElement(By.xpath("//h1[contains(text(),'Settings')]")); повторяется name=Settings
        driver.findElement(By.id("doc-general")).click();
     //   driver.findElement(By.xpath("//h1[contains(text(),'Settings')]")); повторяется name=Settings
        driver.findElement(By.id("doc-listings")).click();
        //   driver.findElement(By.xpath("//h1[contains(text(),'Settings')]")); повторяется name=Settings
        driver.findElement(By.id("doc-images")).click();
        //   driver.findElement(By.xpath("//h1[contains(text(),'Settings')]")); повторяется name=Settings
        driver.findElement(By.id("doc-checkout")).click();
        //   driver.findElement(By.xpath("//h1[contains(text(),'Settings')]")); повторяется name=Settings
        driver.findElement(By.id("doc-advanced")).click();
        //   driver.findElement(By.xpath("//h1[contains(text(),'Settings')]")); повторяется name=Settings
        driver.findElement(By.id("doc-security")).click();
        //   driver.findElement(By.xpath("//h1[contains(text(),'Settings')]")); повторяется name=Settings

        driver.findElement(By.linkText("Slides")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Slides')]"));

        driver.findElement(By.linkText("Tax")).click();
        driver.findElement(By.id("doc-tax_classes")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Tax Classes')]"));
        driver.findElement(By.id("doc-tax_rates")).click();
        driver.findElement(By.xpath("//h1[contains(text(),' Tax Rates')]"));

        driver.findElement(By.linkText("Translations")).click();
        driver.findElement(By.id("doc-search")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Search Translations')]"));
        driver.findElement(By.id("doc-scan")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Scan Files For Translations')]"));
       // driver.findElement(By.id("doc-csv")).click(); уже есть элемент с таким id
        driver.findElement(By.xpath("//h1[contains(text(),'CSV Import/Export')]"));

        driver.findElement(By.linkText("Users")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'Users')]"));

        driver.findElement(By.linkText("vQmods")).click();
        driver.findElement(By.id("doc-vqmods")).click();
        driver.findElement(By.xpath("//h1[contains(text(),'vQmods')]"));


    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
