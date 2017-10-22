package ru.stqa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.stqa.pages.Application;

public class ProductInTheBasketWithPageObject {

    private Application app;

    @Before
    public void start() {
        app = new Application();
    }

    @Test
    public void addProductToBasket() {
        app.addProductsToBasket(3);
        app.removeAllProductsFromBasket();
    }

    @After
    public void stop() {
        app.quit();
    }

}
