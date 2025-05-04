package base; 
import org.openqa.selenium.WebDriver; 
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod; 
import utilities.DriverManager; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.util.Properties; 
public class BaseClass { 
    public static WebDriver driver; 
    public static Properties prop; 
    @BeforeMethod 
    public void setUp() throws IOException { 
        prop = new Properties(); 
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties"); 
        prop.load(fis); 
        driver = DriverManager.getDriver(); 
        driver.get(prop.getProperty("baseUrl")); 
    } 
    @AfterMethod 
    public void tearDown() { 
        if (driver != null) driver.quit(); 
    } 
} 
