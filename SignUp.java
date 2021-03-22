package Pages.cc;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.input.Input;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.grpc.Context.Key;

public class SignUp {
	WebDriver ldriver;
	
	public SignUp(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="Email")
	@CacheLookup
	WebElement Email;
	@FindBy(name="Password")
	@CacheLookup
	WebElement Password;
	
	public void ClickON_signupButton() throws InterruptedException
	{
		//ldriver.get("https://sehatexpress.nhsrc.gov.pk/web/cloudclinik/cc-login");
		ldriver.findElement(By.xpath("//span[text()='No Account Yet? Register Here']")).click();
		Thread.sleep(2000);
		System.out.println("Click on signup button : Successfull");
	}
	
	public void EnterData_SignupField() throws InterruptedException
	{
	{
		String id="fqurqan.12";
		String pwd1="infogistic1";
		ldriver.findElement(By.xpath("//input[@name='_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:firstname']")).sendKeys("Furqan");
		ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:lastname")).sendKeys("Akhtar");
		ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:loginId")).sendKeys(id);
		ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:password")).sendKeys(pwd1);
		ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:confirm_pass")).sendKeys("infogistic1");
		ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:dob_input")).click();
		Thread.sleep(2000);
		ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:dob_input")).sendKeys("3/3/1995");
		Actions act=new Actions(ldriver);
		act.sendKeys(Keys.ENTER,Keys.TAB).perform();
		ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:mobileno")).sendKeys("03032717966");
		//Actions act=new Actions(ldriver);
		act.sendKeys(Keys.TAB,Keys.TAB,Keys.SPACE).perform();
		ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:dfszafg")).click();
		ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:accountActivaton:MR")).sendKeys(id);
		String i;
		Scanner scan=new Scanner(System.in);
		i=scan.nextLine();
		System.out.println("USer input :   i" + i);
		ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:accountActivaton:activationCode")).sendKeys(i);
		System.out.println("USer input :   i" + i);
		System.out.println("ENter data on Fileds : Successfully");
		Thread.sleep(2000);
		ldriver.findElement(By.xpath("//span[text()='Submit']")).click(); // register complete done
		Thread.sleep(5000);
		ldriver.findElement(By.xpath("//a[text()='Click here to login. ']")).click();
		ldriver.findElement(By.id("_58_login")).sendKeys(id);
		ldriver.findElement(By.id("_58_password")).sendKeys(pwd1);
		ldriver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Login lo=new Login(ldriver);
		lo.Click_On_CallNow();
		
		
		System.out.println("Register and Login Automation test case pass :      ");
	}
	}
}