package utilities; 
import io.github.bonigarcia.wdm.WebDriverManager; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeOptions; 
import org.openqa.selenium.firefox.FirefoxOptions; 
import org.openqa.selenium.edge.EdgeOptions; 
import static base.BaseClass.prop; 
public class DriverManager { 
    public static WebDriver getDriver() { 
        String browser = prop.getProperty("browser", "chrome"); 
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless", "false")); 
        switch (browser.toLowerCase()) { 
            case "chrome": 
                WebDriverManager.chromedriver().setup(); 
                ChromeOptions chromeOptions = new ChromeOptions(); 
                if (headless) chromeOptions.addArguments("--headless=new", "--window-size=1920,1080"); 
                return new ChromeDriver(chromeOptions); 
            case "firefox": 
                WebDriverManager.firefoxdriver().setup(); 
                FirefoxOptions firefoxOptions = new FirefoxOptions(); 
                if (headless) firefoxOptions.setHeadless(true); 
                return new FirefoxDriver(firefoxOptions); 
            case "edge": 
                WebDriverManager.edgedriver().setup(); 
                EdgeOptions edgeOptions = new EdgeOptions(); 
                if (headless) edgeOptions.addArguments("--headless=new"); 
                return new EdgeDriver(edgeOptions); 
            default: 
                throw new IllegalArgumentException("Unsupported browser: " + browser); 
        } 
    } 
} 
