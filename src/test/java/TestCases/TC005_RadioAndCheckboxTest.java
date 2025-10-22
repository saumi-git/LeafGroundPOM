package TestCases;

import Base.BaseClass;
import Pages.RadioAndCheckboxPage;
import Utility.ExtentReports.ExtentReportUtility;
import Utility.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC005_RadioAndCheckboxTest extends BaseClass {

    @Test
    public void RadioBtnTest(){
        ExtentReportUtility.createTest("TC005 Radio button Test");
        PropertyFileReader config=PropertyFileReader.getInstance();
        driver.get(config.getProperty("radioBtnUrl"));
        RadioAndCheckboxPage radioAndCheckboxPage=new RadioAndCheckboxPage(driver);
        radioAndCheckboxPage.findDefaultSelectedRadioBtn();
        radioAndCheckboxPage.selectTheAge();

        ExtentReportUtility.captureScreenshotAsBase64_reportOnly_stepInfo(getDriver(),"Verify Radio btn ");
    }

}
