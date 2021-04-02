package Setup.cc;
import org.testng.Assert;
// https://www.youtube.com/watch?v=Pd3pnQHaqeg&list=PLIMhDiITmNrL6oGR_--u6Qyq2q1qtWOJE&index=8 
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.cc.BookAppoinment;
import Pages.cc.HomePage;
import Pages.cc.Login;
import Pages.cc.SignUp;
import Pages.cc.doctor_login;
import Setup.cc.Base;

public class SetuP {
	public class setup extends Base {

		@Test(dataProvider="loginData")
		public void login_test(String user, String pwd, String exp)throws Exception
		{
			Login lo=new Login(driver);
			doctor_login dl=new doctor_login(driver);
			dl.login_Doctor();
			lo.ENterData_onLoginField(user, pwd, exp);
			lo.Click_On_CallNow();
			dl.Attend_Call();
			lo.CLick_On_Join_Call();
			dl.prescription();
			lo.Submit_Rating();
		}
			@DataProvider(name="loginData")
			String[][] getData()
			{
				String loginData[][]= {
						{"furqan.1","infogistic1","valid"},
						//{"huda.1P","11223355","validP"}

				};
				return loginData;
			
			
		}
		
			
		
		/*@Test(priority=2)
		public void Signup() throws Exception
		{
			
			doctor_login dl=new doctor_login(driver);
			dl.login_Doctor();
			Login lo=new Login(driver);
			
			//SignUp sign=new SignUp(driver);
			//sign.ClickON_signupButton();
			//sign.EnterData_SignupField(); 
		}
		

		@Test(priority=3)
		public void Home_Page() throws InterruptedException
		{
			HomePage HP=new HomePage(driver);
			HP.CheckAll_the_Element();
		}
		
		@Test(priority=4)
		public void AddAppinment_page()
		{
			BookAppoinment BP=new BookAppoinment(driver);
			BP.Click_on_AddAppoinment();
		}*/
		
		
		
	}
	

}







