package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class EdgeExample {
    public static void main(String[] args) {
        WebDriver Driver = new EdgeDriver();
        Driver.get("https://testng.org/");

        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String title = Driver.getTitle();
        System.out.println(title);

        List<WebElement> TableOfContents;
        TableOfContents = Driver.findElements(By.xpath("//li/a"));
        for (int i = 0; i < TableOfContents.size(); i++) {
            System.out.println(TableOfContents.get(i).getAttribute("text"));
        }
        WebElement xElem1, xElem2, xElem3;
        xElem1 = Driver.findElement(By.xpath("//div/ul/li[3]"));
        xElem1.click();

        xElem2 = Driver.findElement(By.xpath("//ul/li[3]/ul/li[6]"));
        xElem2.click();

        xElem3 = Driver.findElement((By.xpath("//ul/li[3]/ul/li[6]/ul/li[2]")));
        xElem3.click();

//        WebElement cssElem1, cssElem2;
//        cssElem1 = Driver.findElement(By.cssSelector("a[href=\"#_download\"]"));
//        cssElem1.click();
//
//        cssElem2 = Driver.findElement(By.cssSelector("a[href=\"#_snapshots\"]"));
//        cssElem2.click();


//        Driver.quit();
    }
}
