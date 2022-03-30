package Test;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
  // Define Element locators
	@FindBy(how=How.NAME,using="identifier") public WebElement userName;
	@FindBy(xpath="//span[text()='Next']/parent::button") public WebElement homeNext;
	 
	// construtor method
	public HomePage(RemoteWebDriver driver)
	{
		// connect driver to above defined locators
		PageFactory.initElements(driver, this);
	}
	// opeational and observation methods
	public void filluserName(String x)
	{
        // locate and opearte element
		userName.sendKeys(x);
	}
	public void ClickHomeNext() throws Exception 
	{
		homeNext.click();
		Thread.sleep(5000);
	}
		
}