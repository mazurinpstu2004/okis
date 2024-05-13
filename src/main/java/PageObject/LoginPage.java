package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    private static final String LOGINPAGE = "https://login.live.com/";
    private static final String LOGINLABEL = "//input[@name='loginfmt']";
    private static final String NEXTBUTTON = "//button[@type='submit']";
    private static final String PASSLABEL = "//input[@name='passwd']";
    private static final String SIGNBUTTON = "//button[@type='submit']";
    private static final String ANSWERBUTTON = "//button[@id='acceptButton']";
    public static String login(WebDriver Driver, String Login, String Password) throws Exception {
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.get(LOGINPAGE);
        try {
            WebDriverWait wait= new WebDriverWait(Driver, Duration.ofSeconds(10));
            WebElement loginLabel = Driver.findElement(By.xpath(LOGINLABEL));
            wait.until(d -> loginLabel.isDisplayed());
            loginLabel.sendKeys(Login);
            WebElement nextButton = Driver.findElement(By.xpath(NEXTBUTTON));
            wait.until(ExpectedConditions.elementToBeClickable(nextButton));
            nextButton.click();
        } catch (Exception e) {
            throw new WrongLoginException("Неверный логин");
        }

        try {
            WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
            WebElement passLabel = Driver.findElement(By.xpath(PASSLABEL));
            wait.until(d -> passLabel.isDisplayed());
            passLabel.sendKeys(Password);
            WebElement signButton = Driver.findElement(By.xpath(SIGNBUTTON));
            wait.until(ExpectedConditions.elementToBeClickable(signButton));
            signButton.click();

            WebElement answerButton = Driver.findElement(By.xpath(ANSWERBUTTON));
            wait.until(ExpectedConditions.elementToBeClickable(answerButton));
            answerButton.click();
        } catch (Exception e) {
            throw new WrongPasswordException("Неверный пароль");
        }
        return Login;
    }
    public static class WrongLoginException extends Exception {
        public WrongLoginException(String msg) {
            super(msg);
        }
    }
    public static class WrongPasswordException extends Exception {
        public WrongPasswordException(String msg) {
            super(msg);
        }
    }
}
