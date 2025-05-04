package pages; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory; 
public class HomePage { 
    public HomePage() { 
        PageFactory.initElements(base.BaseClass.driver, this); 
    } 
    @FindBy(xpath = "//h1[contains(text(), 'Transform Your Career')]") 
    public WebElement heroText; 
    public String getHeroText() { 
        return heroText.getText(); 
    } 
} 
