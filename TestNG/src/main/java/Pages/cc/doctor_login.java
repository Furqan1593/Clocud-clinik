package Pages.cc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class doctor_login {
	WebDriver ldriver;

	public doctor_login(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void login_Doctor() throws Exception
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "start-maximized","use-fake-ui-for-media-stream"));
		options.addArguments("use-fake-device-for-media-stream");
		options.addArguments("use-fake-ui-for-media-stream");
		options.addArguments("--incognito");
		ldriver = new ChromeDriver(options);
		ldriver.manage().window().maximize();
		ldriver.get("https://sehatexpress.nhsrc.gov.pk/web/cloudclinik/cc-login");
		ldriver.findElement(By.id("_58_login")).sendKeys("doctor.1");
		ldriver.findElement(By.id("_58_password")).sendKeys("infogistic1");
		ldriver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
	}
	
	
	public void Attend_Call() throws Exception{
		WebDriverWait wait = new WebDriverWait(ldriver,99);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"_videochatwidget_WAR_CloudClinikportlet_:videochatform:buddiesList:0:acceptcallbtn\"]"))).click();	
	}
	
	
	public void prescription() throws Exception {
		String Cl__doctor_Title="ePrescription";
		String C1S_doctor_Title=ldriver.getTitle();
		System.out.println("Page Title cal noe::::::   " + C1S_doctor_Title);
		Thread.sleep(5000);
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
			System.out.println("Chlid window Title  " + ldriver.getTitle());
			System.out.println("Child window ID" + child);
			Thread.sleep(10000);
			//ldriver.close();
			//ldriver.findElement(By.xpath("//a[text()='Click here to join  Call']")).click();
			Thread.sleep(4000);
			ldriver.switchTo().window(parent);
			Thread.sleep(4000);
			//ldriver.switchTo().window(parent);
			ldriver.findElement(By.xpath("//*[@id=\"_appointmentWidget_WAR_CloudClinikportlet_:form:appointments:0:theLink\"]")).click();
			Thread.sleep(3000);
			//ldriver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:complaints_input")).sendKeys("fever");
			Actions act=new Actions(ldriver);
			act.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
			Thread.sleep(1000);
			act.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
			ldriver.findElement(By.id("_Eprescription_WAR_CloudClinikportlet_:presc_form:btn_presc_save_only")).click();
			Thread.sleep(1000);
			act.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(ldriver,99);
			//ldriver.findElement(By.id("_videochatwidget_WAR_CloudClinikportlet_:videochatform:buddiesList:0:visitCompleteBtn")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"_videochatwidget_WAR_CloudClinikportlet_:videochatform:buddiesList:0:visitCompleteBtn\"]"))).click();
			Thread.sleep(1000);
		}
	}
}

































