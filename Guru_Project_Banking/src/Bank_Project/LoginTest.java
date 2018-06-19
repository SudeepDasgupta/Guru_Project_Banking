package Bank_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver dr;
	
  @BeforeTest
  public void LaunchBrowser() {
	  
	  dr = new FirefoxDriver();
	  System.out.println("launching firefox browser");
		  
  }
  
  @Test(priority=0)
  public void LoginPage() {
  dr.get("http://www.demo.guru99.com/V4/");
  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  dr.manage().window().maximize();
  }
  
  @Test(priority=1)
  public void Login(){
	 
	 // WebElement uid = dr.findElement(By.xpath("//input[@type='text']"));
	  WebElement uid;
	  WebDriverWait wait1 = new WebDriverWait(dr, 100);
	  uid=wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
	  uid.sendKeys("mngr138278");
	
  
	//  WebElement pwd = dr.findElement(By.xpath("//input[@type='password']"));
	//  pwd.sendKeys("yzYzUpE");
	  
	  WebElement pwd;
	  WebDriverWait wait2 = new WebDriverWait(dr, 100);
	  pwd=wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
	  pwd.sendKeys("yzYzUpE");
	  
	  
	  WebElement loginbtn = dr.findElement(By.xpath("//input[1][@type='submit']"));
	  loginbtn.click();
	  
  }
  
  @Test(priority=2)
  public void verifyHomepageTitle() {
      String expectedTitle = "Guru99 Bank Manager HomePage";
      String actualTitle = dr.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      
  }
  
  @AfterTest
  public void closebrowser(){
		 dr.quit();
	  
  }
  
  
}
