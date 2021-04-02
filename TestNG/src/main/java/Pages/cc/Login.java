package Pages.cc;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import javax.sound.midi.Soundbank;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Utality_NIH;
import io.github.bonigarcia.wdm.WebDriverManager;

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

	/*public void DataDriven() throws Exception
	{
		File file= new File("C:\\Users\\furqanm\\eclipse-workspace\\cloud-clinic-simple\\excle\\login.xls.xlsx");//
		FileInputStream fis= new FileInputStream(file); // Start datadriven 
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheet("Login");
		//String Value=sheet.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(Value);
		int rowcount=sheet.getPhysicalNumberOfRows();

		for (int i = 0; i < rowcount ; i++) {
			XSSFRow row=sheet.getRow(i);

			int cellcount=row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellcount ; j++) {
			XSSFCell cell=row.getCell(j);

			String CellValue=getCellValue(cell);
			System.out.print(" || "+CellValue);
			}
			System.out.println();

		}
	}
	public static String getCellValue(XSSFCell cell) {   // Change All the value into String Value 

		switch(cell.getCellType()) {
		case NUMERIC: 
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case STRING:
			return cell.getStringCellValue();
		case BLANK:
			return String.valueOf(cell.getNumericCellValue());

		default: 
			return cell.getStringCellValue();

		}                          // End Data Driven
	}*/
	public void ENterData_onLoginField(String user, String pwd, String exp) throws InterruptedException 
	{
		System.out.println(user + ": "+ pwd + ": "+ exp);
		System.out.println("ENter data on Login field :  SuccessFUll");
		ChromeOptions options = new ChromeOptions();
		options.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "start-maximized","use-fake-ui-for-media-stream"));
		options.addArguments("--disable-notifications");
		options.addArguments("use-fake-device-for-media-stream");
		options.addArguments("use-fake-ui-for-media-stream");
		WebDriverManager.chromedriver().setup();
		ldriver= new ChromeDriver(options);
		ldriver.manage().window().maximize();
		ldriver.get("https://sehatexpress.nhsrc.gov.pk/web/cloudclinik/cc-login");
		ldriver.findElement(By.id("_58_login")).sendKeys(user);
		ldriver.findElement(By.id("_58_password")).sendKeys(pwd);
		ldriver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
	}

	public void Click_On_CallNow()throws InterruptedException 
	{

		Actions act=new Actions(ldriver);
		//act.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(2000);
		//ldriver.findElement(By.xpath("ui-chkbox-icon ui-icon ui-icon-blank ui-c']")).click(); // ui-chkbox-icon ui-icon ui-icon-blank ui-c
		ldriver.findElement(By.id("_calldoctor_WAR_CloudClinikPatientportlet_:mainForm:j_idt49")).sendKeys("Body Pain High Fever");
		Thread.sleep(2000);
		ldriver.findElement(By.xpath("//span[contains(text(),'CALL NOW')]")).click();
		Thread.sleep(2000);
	}
	public void CLick_On_Join_Call()throws Exception {

		String Cl__doctor_Title="Call a Doctor (instant)";
		String C1S_doctor_Title=ldriver.getTitle();
		System.out.println("Page Title cal noe::::::   " + C1S_doctor_Title);
		Thread.sleep(8000);
		if(Cl__doctor_Title.equals(C1S_doctor_Title))
		{
			String parentWindow = ldriver.getWindowHandle();
			Set<String> handler = ldriver.getWindowHandles();
			Iterator<String> it =handler.iterator();
			String parent=it.next();
			//System.out.println("patinet window Title  " + ldriver.getTitle());
			System.out.println("Parent window ID" + parent);
			//WebDriverWait wait = new WebDriverWait(ldriver,50);
			//wait.until(ExpectedConditions.titleContains("Sehat Express"));
			String child= it.next();
			ldriver.switchTo().window(child);
			Thread.sleep(2000);
			//System.out.println("Chlid window Title  " + ldriver.getTitle());
			System.out.println("Child window ID" + child);
			//ldriver.close();
			Thread.sleep(2000);
			Actions act=new Actions(ldriver);
			//act.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			ldriver.findElement(By.xpath("//a[text()='Click here to join  Call']")).click();
			Thread.sleep(14000);
			ldriver.switchTo().window(parent);
		}

		else
		{
			System.out.println("user redirected on sehat khani");
			//ldriver.close();
			//ldriver.quit();
		}

	}
	public void Submit_Rating()throws Exception
	{
		WebDriverWait wait = new WebDriverWait(ldriver,70);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"_MyPresciptions_WAR_CloudClinikPatientportlet_:consultationRatingForm:consultationRating\"]/div[5]"))).click();
		Thread.sleep(2000);
		ldriver.findElement(By.id("_MyPresciptions_WAR_CloudClinikPatientportlet_:consultationRatingForm:ratingComments")).sendKeys(" Very Good service");
		Thread.sleep(2000);
		ldriver.findElement(By.id("_MyPresciptions_WAR_CloudClinikPatientportlet_:consultationRatingForm:j_idt69")).click();
	}
}			
