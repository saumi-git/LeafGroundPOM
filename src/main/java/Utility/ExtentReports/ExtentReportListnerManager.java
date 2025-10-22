package Utility.ExtentReports;

import Base.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListnerManager extends BaseClass implements ITestListener {
    @Override
    public void onTestStart(ITestResult result){
        String testName=result.getTestClass().getName()+"-"+result.getMethod().getMethodName();
        ExtentReportUtility.createTest(testName);
        ExtentReportUtility.test.info("Started Test Execution : "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ExtentReportUtility.test.assignCategory(result.getMethod().getGroups()); //To display groups in the report
        ExtentReportUtility.test.pass("Test case passed : "+result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result){
        ExtentReportUtility.test.assignCategory(result.getMethod().getGroups());
        ExtentReportUtility.test.fail(result.getName()+" - Test case failed.");
        ExtentReportUtility.test.fail(result.getThrowable());
        ExtentReportUtility.captureScreenshotAsBas64_reportOnly_failCase(getDriver(),result.getName()+"_failed_Point_Screenshot");

    }

    @Override
    public void onTestSkipped(ITestResult result){
        ExtentReportUtility.test.assignCategory(result.getMethod().getGroups());
        ExtentReportUtility.test.skip(result.getName()+" - Test case skipped.");
        ExtentReportUtility.captureScreenshotAsBase64_reportOnly_skipCase(getDriver(),result.getName()+"_skipped_Point_Screenshot");
    }
}
