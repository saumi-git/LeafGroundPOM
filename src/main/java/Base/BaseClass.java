package Base;

import Utility.ExtentReports.ExtentReportUtility;
import Utility.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseClass {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuit(){
        ExtentReportUtility.startReporter();
    }

    @BeforeMethod
    public void setUpBrowser() {
        PropertyFileReader config = PropertyFileReader.getInstance();
        String browser = config.getProperty("browser");
     //   String baseUrl = config.getProperty("baseUrl");
        long implicitWait = Long.parseLong(config.getProperty("implicitWait"));

        // Initialize WebDriver based on browser type
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        // Navigate to URL from config
      //  driver.get(baseUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void endReport(){
        ExtentReportUtility.endReport();
    }
}
