package Test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Gmail2stepdef 
{
  // declare objects as global to use in all stepdefinition methods
	public RemoteWebDriver driver;
	public HomePage obj1;
	public LoginPage obj2;
	public ComposePage obj3;
	public LogoutPage obj4;
	
	@Given("open {string} browser")
	public void method1(String bn) 
	{
		  if(bn.equalsIgnoreCase("chrome"))
	 	  {
	 		 WebDriverManager.chromedriver().setup();//create parent class object using child class constructor
	 		 driver=new ChromeDriver();
	 	  }
	 	  else if(bn.equalsIgnoreCase("firefox"))
	 	  {
	 		  WebDriverManager.firefoxdriver().setup();
	 		  driver=new FirefoxDriver();
	 	  }
	 	  else if(bn.equalsIgnoreCase("opera"))
	 	  {
	 		  WebDriverManager.operadriver().setup();
	 		  driver=new OperaDriver();
	 	  }
	 	  else
	 	  {
	 		  WebDriverManager.edgedriver().setup();
	 		  driver=new EdgeDriver();
	 	  }
		  // define objects
		  obj1= new HomePage(driver);
		  obj2=new LoginPage(driver);
		  obj3= new ComposePage(driver);
		  obj4=new LogoutPage(driver);
		  
	}

	@Given("launch site using {string}")
	public void method2(String url) throws Exception 
	{
	    driver.get(url);
	    Thread.sleep(5000);
	}

	@When("do login using {string} and {string} credentials")
	public void method3(String un, String pwd) throws Exception 
	{
	    obj1.filluserName(un);
	    obj1.ClickHomeNext();
	    obj2.fillpassword(pwd);
	    obj2.ClickLoginNext();
	    
	}

	@Then("compose is displayed")
	public void method4() 
	{
		if(obj3.isComposeDisplayed())
		{
			System.out.println("compose is dispalyed");	
		}
		else
		{
			System.out.println("compose is not dispalyed");
		}
	}

    @When("click on compose and fill fields and send mail and check reponse")
	public void method5(DataTable dt) throws Exception 
	{
    	//take data from datatable
       List<Map<String,String>> l= dt.asMaps();
       for(int i=0;i<l.size();i++)
       {
    	   // clock on compose'
    	   obj3.ClickCompose();
    	   // fill fields
    	   obj3.fillTo(l.get(i).get("to"));
    	   obj3.fillsubject(l.get(i).get("subject"));
    	   obj3.fillBody(l.get(i).get("body"));
    	   obj3.fileFilepath(l.get(i).get("attachment"));
    	   
    	   // send mail
    	   obj3.clicksend();
    	   System.out.println(obj3.getOutputMsg());	   
       }
	}
    
	@When("do logout")
	public void method6() throws Exception
	{
	   obj4.Clickprofilepic();
	   Thread.sleep(5000);
	   obj4.clicksignout();
	   
	}

	@Then("login page should be redisplayed")
	public void method7()
	{
	    if(obj4.isLoginReDispalyed())
	    {
	    	System.out.println("successful logout");
	    }
	    else
	    {
	    	System.out.println("unsuccessful logout");
	    	System.exit(0);
	    }
	}

	@When("close site")
	public void method8() 
	{
	   driver.close();
	}
}
