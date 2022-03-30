package Test;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposePage 
{
   // element locator
	@FindBy(xpath="//div[text()='Compose']") public WebElement Compose;
	@FindBy(name="to") public WebElement to;
	@FindBy(name="subjectbox") public WebElement Subject;
	@FindBy(xpath="//div[@aria-label='Message Body']") public WebElement body;
	@FindBy(name="Filedata") public WebElement attachFile;
	@FindBy(xpath="//div[text()='Send']") public WebElement send;
	@FindBy(xpath="//div[@role='alert']/descendant::span[2]") public WebElement outputmsg ;
	
	// constructor method
	
	public ComposePage(RemoteWebDriver driver)
	{
		// connect driver to above defined locators
		PageFactory.initElements(driver, this);
	}
	// opeational and observation methods
	 public boolean  isComposeDisplayed()
	 {
		if(Compose.isDisplayed())
		{
			return(true);
			
		}
		else
		{
			return(false);
		}
		 
	 }
	 public void ClickCompose() throws Exception
	 {
		 Compose.click();
		 Thread.sleep(5000);
	 }
	 public void fillTo(String x)
	 {
		 to.sendKeys(x);
	 }
	 public void fillsubject(String x)
	 {
		 Subject.sendKeys(x);
	 }
	 public void fillBody(String x)
	 {
	 body.sendKeys(x);
	 }
	 public void fileFilepath(String x)
	 {
		 attachFile.sendKeys(x);
	 }
	 public void clicksend() throws Exception
	 {
		 send.click();
		 Thread.sleep(5000);
	 }
	 public String getOutputMsg()
	 {
		 String x= outputmsg.getText();
		 return(x);
	 }

		
	}

			 


	 
	

