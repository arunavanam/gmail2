package Test;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
  // Define Element locator
	@FindBy(name="password") public WebElement password;
	@FindBy(xpath="//span[text()='Next']/parent::button") public WebElement loginNext;
	
   // constructor method
	
		public LoginPage(RemoteWebDriver driver)
		{
			// connect driver to above defined locators
			PageFactory.initElements(driver, this);
		}
		// opeational and observation methods
		
		public void fillpassword(String x)
		{
			// loacte element and operate
			password.sendKeys(x);
		}
		public void ClickLoginNext() throws Exception
		{
			loginNext.click();
			Thread.sleep(5000);
		}
}
