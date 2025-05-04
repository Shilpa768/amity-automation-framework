package testcases; 
import base.BaseClass; 
import org.testng.Assert; 
import org.testng.annotations.Listeners; 
import org.testng.annotations.Test; 
import pages.HomePage; 
@Listeners(utilities.TestListener.class) 
public class HomePageTest extends BaseClass { 
    @Test 
    public void verifyHeroText() { 
        HomePage homePage = new HomePage(); 
        String actualText = homePage.getHeroText(); 
        Assert.assertTrue(actualText.contains("Transform Your Career"), "Hero text mismatch"); 
    } 
} 
