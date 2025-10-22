package TestCases;

import Base.BaseClass;
import Pages.DropdownPage;
import Utility.ExtentReports.ExtentReportUtility;
import Utility.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC003_DropdownTest extends BaseClass {

    @Test
    public void dropdownTest(){
        ExtentReportUtility.createTest("TC003 Dropdown Test");
        PropertyFileReader config=PropertyFileReader.getInstance();
        driver.get(config.getProperty("dropDownUrl"));
        DropdownPage dropdownPage=new DropdownPage(driver);
        dropdownPage.selectAutomationTool();
        dropdownPage.getNumberOfOptions();
        dropdownPage.selectCountry();

        ExtentReportUtility.captureScreenshotAsBase64_reportOnly_stepInfo(getDriver(),"Verify Dropdown");

    }
}
