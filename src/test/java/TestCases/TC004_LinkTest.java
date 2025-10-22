package TestCases;

import Base.BaseClass;
import Pages.LinkPage;
import Utility.ExtentReports.ExtentReportUtility;
import Utility.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC004_LinkTest extends BaseClass {

    @Test
    public void linkTest(){
        ExtentReportUtility.createTest("TC004 Link Test");
        PropertyFileReader config=PropertyFileReader.getInstance();
        driver.get(config.getProperty("linkUrl"));
        LinkPage linkPage=new LinkPage(driver);
        linkPage.clickHomeLink();
        linkPage.findWhereTheLinkGoes();
        linkPage.findLinkIsBroken();
        linkPage.findDuplicateLink();
        linkPage.countPageLinks();
        linkPage.countLayoutElements();

        ExtentReportUtility.captureScreenshotAsBase64_reportOnly_stepInfo(getDriver(),"Verify Link Test");
    }
}
