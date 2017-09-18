package pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Facebook {
	WebDriver driver;
	@BeforeTest
	public void OpenBrowser(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
		
	}	
	@Test(dataProvider="FacebookData")
	public void FacebookSignUp(String FN, String LN, String EM, String AEM,String PW, 
			String MN,String DY, String YR, String GN  ) throws InterruptedException{
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("firstname")).sendKeys(FN);
		
		driver.findElement(By.name("lastname")).sendKeys(LN);
		
		driver.findElement(By.name("reg_email__")).sendKeys(EM);
	
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(AEM);
		
		driver.findElement(By.name("reg_passwd__")).sendKeys(PW);
		
		
		Select monthSelect=new Select(driver.findElement(By.name("birthday_month")));
		monthSelect.selectByVisibleText(MN);
		
		Select daySelect=new Select(driver.findElement(By.id("day")));
		daySelect.selectByVisibleText(DY);
		
		Select yearSelect=new Select(driver.findElement(By.id("year")));
		yearSelect.selectByVisibleText(YR);
		if(GN.equalsIgnoreCase("Female")){
			driver.findElement(By.xpath(".//*[@id='u_0_6']")).click();
		}
		else if(GN.equalsIgnoreCase("Male")){
			driver.findElement(By.xpath(".//*[@id='u_0_7']")).click();
			
		}
		Thread.sleep(3000);
	}
		
	
	@AfterTest
	public void CloseBrowser(){
		System.out.println("Facebook SignUp Successful");
		System.out.println("Facebook SignUp Successful");
		driver.close();
		
	}
	@DataProvider(name="FacebookData")
	public Object[][] getData(){
		return new Object[][]{
			{"Shalina", "Akhtar", "shalina@yahoo.com","shalina@yahoo.com","face1234" ,"May", "15","1980","Femal"},
			{"Sonia", "Sultana", "sonia@yahoo.com","sonia@yahoo.com","face1234" ,"Mar", "20","1989","Femal"},
			{"Ozair", "Uddin", "uddin@yahoo.com","uddin@yahoo.com","ggar12" ,"Jun", "22","1987","Male"},
			{"Shalina", "Akhtar", "shalina@yahoo.com","shalina@yahoo.com","face1234" ,"May", "15","1980","Femal"},
			{"Sonia", "Sultana", "sonia@yahoo.com","sonia@yahoo.com","face1234" ,"Mar", "20","1989","Femal"},
			{"Ozair", "Uddin", "uddin@yahoo.com","uddin@yahoo.com","ggar12" ,"Jun", "22","1987","Male"}
		};
	}
}
