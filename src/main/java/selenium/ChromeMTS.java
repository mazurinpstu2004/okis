package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ChromeMTS {
    public static void main(String[] args) {
        WebDriver Driver = new ChromeDriver();
        Driver.manage().window().maximize();
        Driver.get("https://perm.mts.ru/");
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String title = Driver.getTitle();
        System.out.println(title);

        List<WebElement> content;
        content = Driver.findElements(By.xpath("//mts-main-menu-navigation/nav/ul/li/span/span"));
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i).getText());
        }

        WebElement xElem;
        xElem = Driver.findElement(By.xpath("//mts-navigation-widget/section/div/div/div/a[1]"));
        xElem.click();

        WebElement cssElem;
        cssElem = Driver.findElement(By.cssSelector("a[href=\"/personal/dom\"]"));
        cssElem.click();

        Driver.quit();
    }
}
