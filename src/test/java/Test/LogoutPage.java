package Test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogoutPage
{
	RemoteWebDriver driver;
  // element locator
	 @FindBy(xpath="//a[starts-with(@aria-label,'Google Account')]/img")
	 public WebElement profilepic;
	 @FindBy(linkText="Sign out")
	 public WebElement signout;
	 @FindBy(xpath="//div[text()='Sign out']/..")
	 public WebElement sn;
	 @FindBy(xpath="//span[text()='Choose an account']")
	 public WebElement relogin;
	 
	 // constructor method
	 public LogoutPage(RemoteWebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 // opeartional and observation methods
	 public void Clickprofilepic() throws Exception
	 {
		 profilepic.click();
		 Thread.sleep(5000);
	 }
	 public void clicksignout() throws Exception 
	 {
			try 
			{
				signout.click();
			
			}
			catch(Exception ex)
			{
		 WebElement e=driver.findElement(By.xpath("(//iframe[@role='presentation'])[2]"));
				driver.switchTo().frame(e);
				sn.click();
				Thread.sleep(5000);
			}
		}
	 public boolean isLoginReDispalyed()
	 {
		 if(relogin.isDisplayed())
		 {
			 return(true);
		 }
		 else
		 {
			 return(false);
		 }
	 }
	 
	
}

