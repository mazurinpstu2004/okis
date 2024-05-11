package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class HomePage {
    private static final String SIGNBUTTON = "//div[contains(text(), 'Войти')]";
    private static final String SEARCHBUTTON = "//button[@id='search']";
    private static final String SEARCHLABEL = "//input[@id='cli_shellHeaderSearchInput']";
    private static final String PRODUCTSBUTTON = "//button[@class='c-button-logo all-ms-nav']";
    private static final String SITEMAPBUTTON = "a[href='https://www.microsoft.com/ru-ru/sitemap.aspx']";

    public static void signInPage(WebDriver Driver) throws Exception {
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement signButton = Driver.findElement(By.xpath(SIGNBUTTON));
        signButton.click();
    }

    public static void searchInPage(WebDriver Driver) {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        WebElement searchButton = Driver.findElement(By.xpath(SEARCHBUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
        WebElement searchLabel = Driver.findElement(By.xpath(SEARCHLABEL));
        wait.until(d -> searchLabel.isDisplayed());
        searchLabel.sendKeys("Windows");
        searchButton.click();
    }
    public static void siteMap(WebDriver Driver) {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        WebElement productsButton = Driver.findElement(By.xpath(PRODUCTSBUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(productsButton));
        productsButton.click();

        WebElement sitemapButton = Driver.findElement(By.cssSelector(SITEMAPBUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(sitemapButton));
        sitemapButton.click();
    }
}