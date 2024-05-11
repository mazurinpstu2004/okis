package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static PageObject.HomePage.searchInPage;

public class SearchPage {
    private static final String SEARCHLABEL = "//input[@type='search']";
    private static final String SEARCHBUTTON = "//button[@id='search']";
    private static final String SEARCHPAGE = "https://www.microsoft.com/ru-ru/search/explore?q=";
    private static final String SHOPBUTTON = "//a[@class='nav-link']";
    public static void search(WebDriver Driver, String textSearch) throws Exception {
        if (textSearch.isEmpty()) {
            throw new NotFoundndInfoException("По данному запросу ничего не найдено");
        }
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.get(SEARCHPAGE);
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));

        WebElement searchLabel = Driver.findElement(By.xpath(SEARCHLABEL));
        wait.until(d -> searchLabel.isDisplayed());
        searchLabel.sendKeys(textSearch);

        WebElement buttonSearch = Driver.findElement(By.xpath(SEARCHBUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
        buttonSearch.click();
    }
    public static void shopSearch(WebDriver Driver, String textSearch) {
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.get(SEARCHPAGE);
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));

        WebElement searchLabel = Driver.findElement(By.xpath(SEARCHLABEL));
        wait.until(d -> searchLabel.isDisplayed());
        searchLabel.sendKeys(textSearch);

        WebElement searchButton = Driver.findElement(By.xpath(SEARCHBUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        WebElement shopButton = Driver.findElement(By.xpath(SHOPBUTTON));
        wait.until(ExpectedConditions.elementToBeClickable(shopButton));
        shopButton.click();

    }
    public static class NotFoundndInfoException extends Exception {
        public NotFoundndInfoException(String msg) {
            super(msg);
        }
    }
}
