package Pages.cc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void ClickON_signupButton()
	{
		
		System.out.println("Click on signup button : Successfull");
	}
	
	public void EnterData_SignupField() 
	{
		System.out.println("ENter data on Fileds : Successfully");
	}
	

}
