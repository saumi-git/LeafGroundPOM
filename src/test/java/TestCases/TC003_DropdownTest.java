package TestCases;

import Pages.DropdownPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC003_DropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/select.xhtml");
    }

    @Test
    public void dropdownTest(){
        DropdownPage dropdownPage=new DropdownPage(driver);
        dropdownPage.selectAutomationTool();
        dropdownPage.getNumberOfOptions();
        dropdownPage.selectCountry();

    }
}
