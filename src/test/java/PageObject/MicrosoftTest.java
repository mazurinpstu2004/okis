package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static PageObject.HomePage.*;
import static PageObject.LoginPage.login;
import static PageObject.SearchPage.*;

public class MicrosoftTest {
    protected static WebDriver Driver;
    private static final String HOMEPAGE = "https://www.microsoft.com";
    private static final String LOGIN = "testpochta52@mail.ru";
    private static final String PASSWORD = "FIRt(bai4tO6";

    @DataProvider(name = "LoginPasswords")
    public Object[][] wrongData() {
        String Login1 = "testpochta52/!mail.ru";
        String Password1 = "FIRt(bai4tO6";
        String Login2 = "testpochta52@mail.ru";
        String Password2 = "FIRt(bzi4tO6";
        return new Object[][] {
                {Login1, Password1}, {Login2, Password2}
        };
    }
    @DataProvider(name = "textSearch")
    public Object[][] searchData() {
        String textSearch1 = "Microsoft";
        String textSearch2 = "Visual Studio";
        String textSearch3 = "VS Code";
        return new Object[][] {
                {textSearch1}, {textSearch2}, {textSearch3}
        };
    }
    @DataProvider(name = "shopSearch")
    public Object[][] shopData() {
        String shopSearch1 = "FIFA";
        String expectedResult1 = "https://www.microsoft.com/ru-ru/search/shop?q=FIFA";
        String shopSearch2 = "Office";
        String expectedResult2 = "https://www.microsoft.com/ru-ru/search/shop?q=Office";
        return new Object[][] {
                {shopSearch1, expectedResult1}, {shopSearch2, expectedResult2}
        };
    }
    @BeforeClass(alwaysRun = true)
    public static void openBrowser() {
        Driver = new ChromeDriver();
        Driver.manage().window().maximize();
        Driver.get(HOMEPAGE);
    }
    @AfterClass(alwaysRun = true)
    public static void closeBrowser() {
        if (Driver != null) {
            Driver.quit();
        }
    }
    @Test(groups = "positive")
    public static void testSignInPage() throws Exception {
        String expectedResult = "Вход в учетную запись Майкрософт";
        String actualResult;
        signInPage(Driver);
        actualResult = Driver.getTitle();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = {"positive"})
    public static void testLogin() throws Exception {
        String expectedResult = LOGIN;
        String actualResult;
        actualResult = login(Driver, LOGIN, PASSWORD);
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = ("negative"), dataProvider = "LoginPasswords", expectedExceptions = {LoginPage.WrongLoginException.class, LoginPage.WrongPasswordException.class})
    public static void negTestLogin(String Login, String Password) throws Exception {
        login(Driver, Login, Password);
    }
    @Test(groups = "positive")
    public static void testSearchInPage() {
        String expectedResult = "https://www.microsoft.com/ru-ru/search/explore?q=Windows";
        String actualResult;
        searchInPage(Driver);
        actualResult = Driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = "positive", dataProvider = "textSearch")
    public static void testSearch(String textSearch) throws Exception {
        String expectedResult = "Ознакомиться Microsoft.com";
        String actualResult;
        search(Driver, textSearch);
        actualResult = Driver.getTitle();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = "negative", expectedExceptions = {SearchPage.NotFoundndInfoException.class})
    public static void negTestSearch() throws Exception {
        search(Driver, "");
    }
    @Test(groups = "positive", dataProvider = "shopSearch")
    public static void testShopSearch(String shopSearch, String expectedResult) {
        String actualResult;
        shopSearch(Driver, shopSearch);
        actualResult = Driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
    @Test(groups = "positive")
    public static void testSiteMap() {
        String expectedResult = "Карта сайта Microsoft";
        String actualResult;
        siteMap(Driver);
        actualResult = Driver.getTitle();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
