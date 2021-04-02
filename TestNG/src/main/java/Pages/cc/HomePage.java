package Pages.cc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage {
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void CheckAll_the_Element() {
		
		SoftAssert softassert=new SoftAssert();
		String Expected_Result="Google.com";
		String Actual_Result="Yahoo.com";
		if (Actual_Result.equals(Expected_Result)) {
			System.out.println("TestCase Pass");
		}
		else {
				System.out.println("TestCase Fail");
		}
		
		System.out.println("This message should be shown on there");
		//softassert.assertEquals(Actual_Result, Expected_Result, "My name  uashdjk vhafildshli fdasilhiusf hdaih iihuhsfdai hiasfhd hisdufh ");
		System.out.println("The alll element are visiable");
		//Assert.fail("Assert is print on there");
		System.out.println("ending point");
		
		softassert.assertAll();
	}

}
	