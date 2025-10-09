package TestCases;

import Pages.ButtonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002_ButtonTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest(){
        ButtonPage buttonPage=new ButtonPage(driver);
        buttonPage.clickAndConfirmBtnClick();
        buttonPage.verifyTitle();
        buttonPage.getPositionOfBtn();
        buttonPage.getColorOfBtn();
        buttonPage.getSizeOfBtn();
    }
}
