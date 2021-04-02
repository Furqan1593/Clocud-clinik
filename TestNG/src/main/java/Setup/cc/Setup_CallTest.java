package Setup.cc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.cc.Login;
import Pages.cc.doctor_login;

public class Setup_CallTest {
	

	public class setup  extends Base {

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
	}
}
