package ru.stqa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseURL;

    public Page(WebDriver driver, String baseURL) {
        this.driver = driver;
        this.baseURL = baseURL;
        wait = new WebDriverWait(driver, 10);
    }



}