package Pages.cc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BookAppoinment {
	WebDriver ldriver;
	public BookAppoinment(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void Click_on_AddAppoinment() {
		
		System.out.println("CLick on AddAppoinment sucessfully");  
	}
	

}
