package Setup.cc;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public String URL= "https://sehatexpress.nhsrc.gov.pk/web/cloudclinik/cc-login";
	public String use1r= "huda.1";
	public String pwd2= "11223355";
	public String exp3= "Valid";
	@BeforeClass
	public void setup()
	{
		System.out.println("furqan");
		System.out.println("before class");
		//options.addArguments("start-maximized");
				//options.addArguments("--disable-notifications");
				//options.addArguments("use-fake-device-for-media-stream");
			     //options.addArguments("use-fake-ui-for-media-stream");
		ChromeOptions options = new ChromeOptions();
		options.addArguments(Arrays.asList("disable-infobars", "ignore-certificate-errors", "start-maximized","use-fake-ui-for-media-stream"));
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//driver.get("https://sehatexpress.nhsrc.gov.pk/web/cloudclinik/cc-login");
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterClass
	public void teardown() {
		//driver.quit();
		
	}

}
