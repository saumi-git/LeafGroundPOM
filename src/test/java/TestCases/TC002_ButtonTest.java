package TestCases;

import Base.BaseClass;
import Pages.ButtonPage;
import Utility.ExtentReports.ExtentReportUtility;
import Utility.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002_ButtonTest extends BaseClass {

    @Test
    public void buttonTest(){
        ExtentReportUtility.createTest("TC002 Button Test");
        PropertyFileReader config=PropertyFileReader.getInstance();
        driver.get(config.getProperty("buttonUrl"));
        ButtonPage buttonPage=new ButtonPage(driver);
        buttonPage.clickAndConfirmBtnClick();
        buttonPage.verifyTitle();
        buttonPage.getPositionOfBtn();
        buttonPage.getColorOfBtn();
        buttonPage.getSizeOfBtn();

        ExtentReportUtility.captureScreenshotAsBase64_reportOnly_stepInfo(getDriver(),"Verify Button");
    }
}
