package Pages.cc;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.input.Input;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Utality_NIH;
import VOs.UserVo;
import bsh.Console;
//import Utility.Utality_NIH;
import io.grpc.Context.Key;

public class SignUp {
	WebDriver ldriver;
	XSSFSheet sheet;

	private List<UserVo> userList;

	public SignUp(WebDriver rdriver) {
		userList = new ArrayList<UserVo>();
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "Email")
	@CacheLookup
	WebElement Email;
	@FindBy(name = "Password")
	@CacheLookup
	WebElement Password;

	public void ClickON_signupButton() throws InterruptedException {
		// ldriver.get("https://sehatexpress.nhsrc.gov.pk/web/cloudclinik/cc-login");
		System.out.println("sa");
		ldriver.findElement(By.xpath("//span[text()='No Account Yet? Register Here']")).click();
		Thread.sleep(2000);
		System.out.println("Click on signup button : Successfull");
	}

	public void EnterData_SignupField() throws Exception {
		{
			// Utality_NIH uh=new
			// Utality_NIH("C:\\\\Users\\\\furqanm\\\\eclipse-workspace\\\\TestNG\\\\Excle\\\\login.xls.xlsx",
			// "NIH Testing");
			/*
			 * uh.DataDriven(); String name2=uh.getcelldata(1, 1	`	`
			 */

			Utality_NIH nih = new Utality_NIH();
			sheet = nih.DataDriven();
			UserVo uservo = new UserVo();
			for (int col = 1; col < 6; col++) {
				uservo = new UserVo();
				for (int row = 14; row < 21; row++) {
					System.out.println("====>>> " + sheet.getRow(row).getCell(col).getStringCellValue());
					if (row == 14)
						uservo.setFirstName(sheet.getRow(row).getCell(col).getStringCellValue());
					if (row == 15)
						uservo.setLastName(sheet.getRow(row).getCell(col).getStringCellValue());
					if (row == 16)
						uservo.setLoginId(sheet.getRow(row).getCell(col).getStringCellValue());
					if (row == 17)
						uservo.setPassword(sheet.getRow(row).getCell(col).getStringCellValue());
					if (row == 19)
						uservo.setDob(sheet.getRow(row).getCell(col).getStringCellValue());
					if (row == 20)
						uservo.setMobileNo(sheet.getRow(row).getCell(col).getStringCellValue());
				}
				userList.add(uservo);
			
			}
			for (UserVo user : userList) {
				ldriver.get("https://sehatexpress.nhsrc.gov.pk/web/cloudclinik/cc-login");
				Thread.sleep(2000);
				ldriver.findElement(By.xpath("//span[text()='No Account Yet? Register Here']")).click();
				System.out.println("==>> " + user.getLoginId());
				ldriver.findElement(By
						.xpath("//input[@name='_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:firstname']"))
				.sendKeys(user.getFirstName());
				ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:lastname"))
				.sendKeys(user.getLastName());
				ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:loginId"))
				.sendKeys(user.getLoginId());
				ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:password"))
				.sendKeys(user.getPassword());
				ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:confirm_pass"))
				.sendKeys(user.getPassword());
				ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:dob_input"))
				.click();
				Thread.sleep(2000);
				ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:dob_input"))
				.sendKeys(user.getDob());
				Actions act=new Actions(ldriver);
				act.sendKeys(Keys.ENTER,Keys.TAB).perform(); 
				ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:mobileno")).sendKeys(user.getMobileNo());
				//Actions act=new Actions(ldriver);
				act.sendKeys(Keys.TAB,Keys.TAB,Keys.SPACE).perform();
				ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:dfszafg")).click();
				ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:accountActivaton:MR")).sendKeys(user.getLoginId());
				String i; 
				Scanner scan=new Scanner(System.in); i=scan.nextLine();
				System.out.println("USer input :   i" + i);
				ldriver.findElement(By.id("_PatientSignUp_WAR_CloudClinikPatientportlet_:accountActivaton:activationCode")).sendKeys(i);
				System.out.println("USer input :   i" + i);
				System.out.println("ENter data on Fileds : Successfully");
				Thread.sleep(2000);
				ldriver.findElement(By.xpath("//span[text()='Submit']")).click(); // register
				Thread.sleep(5000);
				ldriver.findElement(By.xpath("//a[text()='Click here to login. ']")).click();
				ldriver.findElement(By.id("_58_login")).sendKeys(user.getLoginId());
				ldriver.findElement(By.id("_58_password")).sendKeys(user.getPassword());
				ldriver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
				//Login lo=new Login(ldriver); lo.Click_On_CallNow();
				ldriver.findElement(By.xpath("//*[@id=\"navbar-example\"]/div[1]/ul/li[6]/div/p")).click();
				Thread.sleep(1000);
				ldriver.findElement(By.xpath("//a[text()='Logout']")).click();
				Thread.sleep(2000);
				


			}
			/// String id="fqurqan.12";
			// String pwd1="infogistic1";

			/*
			 * ldriver.findElement(By.xpath(
			 * "//input[@name='_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:firstname']"
			 * )).sendKeys(); ldriver.findElement(By.id(
			 * "_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:lastname")).
			 * sendKeys(); ldriver.findElement(By.id(
			 * "_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:loginId")).
			 * sendKeys(); ldriver.findElement(By.id(
			 * "_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:password")).
			 * sendKeys(); ldriver.findElement(By.id(
			 * "_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:confirm_pass")).
			 * sendKeys(); ldriver.findElement(By.id(
			 * "_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:dob_input")).
			 * click(); Thread.sleep(2000); ldriver.findElement(By.id(
			 * "_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:dob_input")).
			 * sendKeys(); Actions act=new Actions(ldriver);
			 * act.sendKeys(Keys.ENTER,Keys.TAB).perform(); ldriver.findElement(By.id(
			 * "_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:mobileno")).
			 * sendKeys(); //Actions act=new Actions(ldriver);
			 * act.sendKeys(Keys.TAB,Keys.TAB,Keys.SPACE).perform();
			 * ldriver.findElement(By.id(
			 * "_PatientSignUp_WAR_CloudClinikPatientportlet_:patient_form:dfszafg")).click(
			 * ); ldriver.findElement(By.id(
			 * "_PatientSignUp_WAR_CloudClinikPatientportlet_:accountActivaton:MR")).
			 * sendKeys(); String i; Scanner scan=new Scanner(System.in); i=scan.nextLine();
			 * System.out.println("USer input :   i" + i); ldriver.findElement(By.id(
			 * "_PatientSignUp_WAR_CloudClinikPatientportlet_:accountActivaton:activationCode"
			 * )).sendKeys(i); System.out.println("USer input :   i" + i);
			 * System.out.println("ENter data on Fileds : Successfully");
			 * Thread.sleep(2000);
			 * ldriver.findElement(By.xpath("//span[text()='Submit']")).click(); // register
			 * complete done Thread.sleep(5000);
			 * ldriver.findElement(By.xpath("//a[text()='Click here to login. ']")).click();
			 * ldriver.findElement(By.id("_58_login")).sendKeys(LoginID);
			 * ldriver.findElement(By.id("_58_password")).sendKeys(Password3);
			 * ldriver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			 * Login lo=new Login(ldriver); lo.Click_On_CallNow();
			 */

			System.out.println("Register and Login Automation test case pass :      ");
		}
	}
}