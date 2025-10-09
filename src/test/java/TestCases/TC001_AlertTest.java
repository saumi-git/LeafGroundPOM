package TestCases;

import Pages.AlertPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001_AlertTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/alert.xhtml");
    }

    @Test
    public void alertTest() throws InterruptedException {
        AlertPage alertPage=new AlertPage(driver);
        alertPage.acceptSimpleAlert();
        alertPage.confirmAlert();
        alertPage.promptDialogAlert();

    }
}
