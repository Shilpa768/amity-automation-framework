package utilities; 
import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot; 
import org.openqa.selenium.WebDriver; 
import java.io.File; 
import java.io.IOException; 
import java.text.SimpleDateFormat; 
import java.util.Date; 
public class ScreenshotUtil { 
    public static String takeScreenshot(WebDriver driver, String testName) { 
        try { 
            TakesScreenshot ts = (TakesScreenshot) driver; 
            File source = ts.getScreenshotAs(OutputType.FILE); 
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()); 
            String fileName = testName + "_" + timestamp + ".png"; 
            String path = "screenshots/" + fileName; 
            FileUtils.copyFile(source, new File(path)); 
            return path; 
        } catch (IOException e) { 
            e.printStackTrace(); 
            return null; 
        } 
    } 
} 
