package Bank_Project;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScript_02 {
	
	WebDriver Driver;
	
	@BeforeTest
	  public void LaunchBrowser() {
		  
		  Driver = new FirefoxDriver();
		  System.out.println("launching firefox browser");
			  
	  }
		
	@Test(priority=0)
	  public void LoginPage() {
	  Driver.get(Utils.Base_URL);
	  Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  Driver.manage().window().maximize();
	  }
	
	
	 @Test(priority=1)
	  public void Login(){
		 
		 WebElement uid = Driver.findElement(By.xpath("//input[@type='text']"));
		 uid.sendKeys(Utils.UID);
		
	  
		  WebElement pwd = Driver.findElement(By.xpath("//input[@type='password']"));
		 pwd.sendKeys(Utils.PWD);
			  
		  
		  WebElement loginbtn = Driver.findElement(By.xpath("//input[1][@type='submit']"));
		  loginbtn.click();
		  
	  }
	  
	  @Test(priority=2)
	  public void verifyHomepageTitle() {
	 
	      String actualTitle = Driver.getTitle();

	      
	      if(actualTitle.contains(Utils.EXPECT_TITLE)){
	
				    System.out.println("Test case: Passed");
		} 
		else {
				    System.out.println("Test case : Failed");
		}
	      }
	      
	  
	
	 @AfterTest
	  public void closebrowser(){
			 Driver.quit();
		  
	  }

}
