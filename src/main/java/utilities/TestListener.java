package utilities; 
import com.aventstack.extentreports.ExtentTest; 
import com.aventstack.extentreports.MediaEntityBuilder; 
import org.testng.ITestContext; 
import org.testng.ITestListener; 
import org.testng.ITestResult; 
public class TestListener implements ITestListener { 
    private static ExtentTest test; 
    @Override 
    public void onTestStart(ITestResult result) { 
        test = utilities.ExtentReportManager.getInstance().createTest(result.getMethod().getMethodName()); 
    } 
    @Override 
    public void onTestSuccess(ITestResult result) { 
        test.pass("Test Passed"); 
        captureScreenshot(result); 
    } 
    @Override 
    public void onTestFailure(ITestResult result) { 
        test.fail("Test Failed"); 
        captureScreenshot(result); 
    } 
    private void captureScreenshot(ITestResult result) { 
        try { 
            String screenshotPath = utilities.ScreenshotUtil.takeScreenshot(base.BaseClass.driver, result.getName()); 
            test.info("Screenshot attached", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); 
        } catch (Exception e) { 
            System.out.println("Exception while taking screenshot: " + e.getMessage()); 
        } 
    } 
    @Override 
    public void onFinish(ITestContext context) { 
        utilities.ExtentReportManager.getInstance().flush(); 
    } 
} 
