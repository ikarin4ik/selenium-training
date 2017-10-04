package ru.stqa;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiteCartPageOfGoods {



    @Test
    public void testFirefox(){
        FirefoxDriver driver = new FirefoxDriver();
        campaignsAssert(driver);
        driver.quit();
    }

    @Test
    public void testChrome(){
        ChromeDriver driver = new ChromeDriver();
        campaignsAssert(driver);
        driver.quit();
    }
    @Test
    public void testSafari(){

        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setUseTechnologyPreview(true);
        SafariDriver driver = new SafariDriver(safariOptions);
        campaignsAssert(driver);
        driver.quit();
    }


    private void campaignsAssert(WebDriver driver) {
        driver.get("http://localhost/litecart/");

        WebElement product = driver.findElement(By.cssSelector("div.content div#box-campaigns div.content ul.listing-wrapper li.product"));
        WebElement nameProductText = product.findElement(By.cssSelector("a.link div.name"));
        String assertNameProductText = nameProductText.getText();

        WebElement normalPrice = product.findElement(By.cssSelector("a.link div s.regular-price"));
        String assertNormalPrice = normalPrice.getText();
        String assertColorNormalPrice = normalPrice.getCssValue("color");



        String assertFontSizeNormalPrice = normalPrice.getCssValue("font-size");
        String assertStrikeNormalPrice = normalPrice.getTagName();

        WebElement stockPrice = product.findElement(By.cssSelector("a.link div strong.campaign-price"));
        String assertStockPrice = stockPrice.getText();
        String assertColorStockPrice = stockPrice.getCssValue("color");
        String assertFontSizeStockPrice = stockPrice.getCssValue("font-size");
        String assertStrongStockPrice = stockPrice.getTagName();

        WebElement link = driver.findElement(By.cssSelector("div.content div#box-campaigns div.content ul.listing-wrapper li.product a.link"));
        link.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        By by = By.cssSelector("div.content div#box-product div h1.title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        WebElement nameProductPageText = driver.findElement(by);
        String assertProductPageText = nameProductPageText.getText();

        WebElement normalPricePageProduct = driver.findElement(By.cssSelector("div.content div.information div.price-wrapper s.regular-price"));
        String assertNormalPricePageProduct = normalPricePageProduct.getText();
        String aasertColorNormalPricePageProduct = normalPricePageProduct.getCssValue("color");
        String assertFontSizeNormalPricePageProduct = normalPricePageProduct.getCssValue("font-size");
        String assertStrikeNormalPricePageProduct = normalPricePageProduct.getTagName();


        WebElement stockPricePageProduct = driver.findElement(By.cssSelector("div.content div.information div.price-wrapper strong.campaign-price"));
        String assertStockPricePageProduct = stockPricePageProduct.getText();
        String assertColorStockPricePageProduct = stockPricePageProduct.getCssValue("color");
        String assertFontSizeStockPricePageProduct = stockPricePageProduct.getCssValue("font-size");
        String assertStrongStockPricePageProduct = stockPricePageProduct.getTagName();

        // на главной странице и на странице товара совпадает текст названия товара
        // на главной странице и на странице товара совпадают цены (обычная и акционная)

        Assert.assertEquals(assertNameProductText, assertProductPageText);
        Assert.assertEquals(assertNormalPrice, assertNormalPricePageProduct);
        Assert.assertEquals(assertStockPrice, assertStockPricePageProduct);
        Assert.assertEquals(assertStrikeNormalPrice, assertStrikeNormalPricePageProduct);
        Assert.assertEquals(assertColorStockPrice, assertColorStockPricePageProduct);

        // обычная цена серая на главной странице и странице продукта

        String[] rgb = extractRGB(assertColorNormalPrice);

        Assert.assertEquals(rgb[0].trim(), rgb[1].trim());
        Assert.assertEquals(rgb[1].trim(), rgb[2].trim());

        rgb = extractRGB(aasertColorNormalPricePageProduct);

        Assert.assertEquals(rgb[0].trim(), rgb[1].trim());
        Assert.assertEquals(rgb[1].trim(), rgb[2].trim());


        // акционная цена красная на главной странице и странице продукта

        rgb = extractRGB(assertColorStockPrice);

        Assert.assertEquals(rgb[1].trim(), "0");
        Assert.assertEquals(rgb[2].trim(), "0");
        Assert.assertNotEquals(rgb[0].trim(), "0");

        rgb = extractRGB(assertColorStockPricePageProduct);

        Assert.assertEquals(rgb[1].trim(), "0");
        Assert.assertEquals(rgb[2].trim(), "0");
        Assert.assertNotEquals(rgb[0].trim(), "0");

        // Assert.assertEquals(extractRGB(assertColorStockPrice), ("rgb(204, 0, 0)"));
        // Assert.assertEquals(extractRGB(assertColorStockPricePageProduct), ("rgb(204, 0, 0)"));

        // обычная цена на главной странице и странице продукта зачеркнутая
        // акционная цена главной странице и странице продукта жирная

        Assert.assertEquals(assertStrikeNormalPrice, "s");
        Assert.assertEquals(assertStrongStockPrice, "strong");

        Assert.assertEquals(assertStrikeNormalPricePageProduct, "s");
        Assert.assertEquals(assertStrongStockPricePageProduct, "strong");

        // акционная цена крупнее, чем обычная

        Assert.assertTrue(Double.parseDouble(assertFontSizeNormalPrice.replace("px","")) < Double.parseDouble(assertFontSizeStockPrice.replace("px","")));
        Assert.assertTrue(Double.parseDouble(assertFontSizeNormalPricePageProduct.replace("px","")) < Double.parseDouble(assertFontSizeStockPricePageProduct.replace("px","")));
    }

    private String[] extractRGB(String rgbString) {
        if(rgbString.startsWith("rgba")) {
            return rgbString.substring(5,rgbString.length() - 1).split(",");
        }
        return rgbString.substring(4,rgbString.length() - 1).split(",");
    }

}
