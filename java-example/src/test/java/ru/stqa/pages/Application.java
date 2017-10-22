package ru.stqa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {
    private static final String BASE_URL = "http://localhost/litecart";
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;

    public Application () {
        driver = new ChromeDriver();
        homePage = new HomePage(driver, BASE_URL);
        productPage = new ProductPage(driver, BASE_URL);
        checkoutPage = new CheckoutPage(driver, BASE_URL);
    }

    public void quit () {
        driver.quit();
        driver = null;
    }

    public void addProductsToBasket(int productsCount) {
        for (int i = 0; i < productsCount; i++) {
            homePage.open();
            int count = homePage.getProductsInBasketCount();
            homePage.clickOnFirstProductOnPage();
            productPage.waitForPageLoaded();
            productPage.addProductToCart();
            productPage.waitForProductCountInBasketBecame(++count);
        }
    }

    public void removeAllProductsFromBasket() {
        checkoutPage.open();
        System.out.println("checkoutPage.getProductsCount  = " + checkoutPage.getProductsCount());
        checkoutPage.stopProductCarusel();
        while (checkoutPage.getProductsCount() > 0) {
            checkoutPage.removeFirstAvailableProduct();
        }
    }
}
