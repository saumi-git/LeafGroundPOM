package TestCases;

import Pages.RadioAndCheckboxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC005_RadioAndCheckboxTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/radio.xhtml;jsessionid=node01ncws9vym9jq419oa5t7pzc8r95061020.node0");
    }

    @Test
    public void RadioBtnTest(){
        RadioAndCheckboxPage radioAndCheckboxPage=new RadioAndCheckboxPage(driver);
        radioAndCheckboxPage.findDefaultSelectedRadioBtn();
        radioAndCheckboxPage.selectTheAge();
    }

}
