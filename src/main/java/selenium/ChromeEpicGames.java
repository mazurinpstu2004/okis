package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ChromeEpicGames {
    public static void main(String[] args) {
        WebDriver Driver = new ChromeDriver();
        Driver.manage().window().maximize();

        Driver.get("https://store.epicgames.com/ru/");
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String title = Driver.getTitle();
        System.out.println(title);

        List<WebElement> content;
        content = Driver.findElements(By.xpath("//li/div/a/div/div/span"));
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i).getText());
        }

        WebElement xElem;
        xElem = Driver.findElement(By.xpath("//li[2]"));
        xElem.click();

//        WebElement cssElem;
//        cssElem = Driver.findElement(By.cssSelector("a[href=\"/ru/news\"]"));
//        cssElem.click();

//        Driver.quit();
    }
}
