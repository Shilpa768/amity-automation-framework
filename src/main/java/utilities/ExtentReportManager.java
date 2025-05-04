package utilities; 
import com.aventstack.extentreports.ExtentReports; 
import com.aventstack.extentreports.reporter.ExtentSparkReporter; 
public class ExtentReportManager { 
    public static ExtentReports extent; 
    public static ExtentReports getInstance() { 
        if (extent == null) { 
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/AmityTestReport.html"); 
            extent = new ExtentReports(); 
            extent.attachReporter(htmlReporter); 
        } 
        return extent; 
    } 
} 
