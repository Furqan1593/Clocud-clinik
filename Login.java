package Pages.cc;

import java.util.Iterator;
import java.util.Set;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	WebDriver ldriver;

	public Login(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	/*public void Verify_All_the_field_Appear(String user, String Pwd, String exp)
	{
		System.out.println("All the field are prisent on login page : SuccessFull");

	}*/

	//@Test(dataProvider="loginData")
	public void ENterData_onLoginField(String user, String pwd, String exp) throws InterruptedException 
	{
		System.out.println(user + ": "+ pwd + ": "+ exp);
		System.out.println("ENter data on Login field :  SuccessFUll");
		ldriver.findElement(By.id("_58_login")).sendKeys(user);
		ldriver.findElement(By.id("_58_password")).sendKeys(pwd);
		ldriver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
	}
	
	public void Click_On_CallNow()throws InterruptedException 
		{
		
		Actions act=new Actions(ldriver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		//ldriver.findElement(By.xpath("ui-chkbox-icon ui-icon ui-icon-blank ui-c']")).click(); // ui-chkbox-icon ui-icon ui-icon-blank ui-c
		ldriver.findElement(By.id("_calldoctor_WAR_CloudClinikPatientportlet_:mainForm:j_idt49")).sendKeys("Body Pain High Fever");
		Thread.sleep(2000);
		ldriver.findElement(By.xpath("//span[contains(text(),'CALL NOW')]")).click();
		String Cl__doctor_Title="Call a Doctor (instant)";
		String C1S_doctor_Title=ldriver.getTitle();
		System.out.println("Page Title cal noe::::::   " + C1S_doctor_Title);
		Thread.sleep(15000);
		if(Cl__doctor_Title.equals(C1S_doctor_Title))
		{
			String parentWindow = ldriver.getWindowHandle();
			Set<String> handler = ldriver.getWindowHandles();
			Iterator<String> it =handler.iterator();
			String parent=it.next();
			System.out.println("patinet window Title  " + ldriver.getTitle());
			System.out.println("Parent window ID" + parent);
			//WebDriverWait wait = new WebDriverWait(ldriver,50);
			//wait.until(ExpectedConditions.titleContains("Sehat Express"));
			String child= it.next();
			ldriver.switchTo().window(child);
			Thread.sleep(2000);
			System.out.println("Chlid window Title  " + ldriver.getTitle());
			System.out.println("Child window ID" + child);
			act.sendKeys(Keys.ENTER).perform();
			ldriver.findElement(By.xpath("//a[text()='Click here to join  Call']")).click();
			Thread.sleep(8000);
			ldriver.switchTo().window(parent);
			WebDriverWait wait = new WebDriverWait(ldriver,70);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"_MyPresciptions_WAR_CloudClinikPatientportlet_:consultationRatingForm:consultationRating\"]/div[5]"))).click();
			Thread.sleep(2000);
			ldriver.findElement(By.id("_MyPresciptions_WAR_CloudClinikPatientportlet_:consultationRatingForm:ratingComments")).sendKeys(" Very Good service");
			Thread.sleep(2000);
			ldriver.findElement(By.id("_MyPresciptions_WAR_CloudClinikPatientportlet_:consultationRatingForm:j_idt69")).click();
		}
		else
		{
			System.out.println("user redirected on sehat khani");
			ldriver.close();
			//ldriver.quit();
		}



	}

		 
			// TODO Auto-generated method stub
			
			
}

/*@DataProvider(name="loginData")
		String[][] getData()
		{
			String loginData[][]= {
					{"huda.1","11223355","valid"},
					{"huda.1P","11223355","validP"}
			};
			Assert.fail("login not fount");
			return loginData;*/
/*@DataProvider()
	public  String[][] getData()
	{
		String loginData[][]= {
				{"huda.1","11223355","valid"}
		};
		return loginData;
	}*/







