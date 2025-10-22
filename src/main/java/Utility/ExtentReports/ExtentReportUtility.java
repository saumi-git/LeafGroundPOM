package Utility.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentReportUtility {
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void startReporter(){
        sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//test_output//extentReports/ExtentReport.html");
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Automate LeafGround-Extent Report");
        sparkReporter.config().setTheme(Theme.STANDARD);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("ProjectName","LeafGround");
        extent.setSystemInfo("Browser","Chrome");
        extent.setSystemInfo("Operating System",System.getProperty("os.name"));
        extent.setSystemInfo("Java Version",System.getProperty("java.version"));
        extent.setSystemInfo("Tester",System.getProperty("user.name"));
    }

    public static void createTest(String testName){
        test=extent.createTest(testName);
    }

    public static void endReport(){
        extent.flush();
    }

    public static void captureScreenshotAsBase64_reportOnly_stepInfo(WebDriver driver, String message){
        String base64=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        test.info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

    }
    public static void captureScreenshotAsBas64_reportOnly_failCase(WebDriver driver,String message){
        String base64=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        test.skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
    }

    public static void captureScreenshotAsBase64_reportOnly_skipCase(WebDriver driver,String message){
        String base64=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        test.info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());

    }
}
