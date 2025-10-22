package TestCases;

import Base.BaseClass;
import Pages.AlertPage;
import Utility.ExtentReports.ExtentReportUtility;
import Utility.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001_AlertTest extends BaseClass{

    @Test
    public void alertTest() throws InterruptedException {
        ExtentReportUtility.createTest("TC001 Alert Test");
        PropertyFileReader config=PropertyFileReader.getInstance();
        driver.get(config.getProperty("alertUrl"));
        AlertPage alertPage=new AlertPage(getDriver());
        alertPage.acceptSimpleAlert();
        alertPage.confirmAlert();
        alertPage.promptDialogAlert();

        ExtentReportUtility.captureScreenshotAsBase64_reportOnly_stepInfo(getDriver(),"Verify Alert Test");

    }
}
