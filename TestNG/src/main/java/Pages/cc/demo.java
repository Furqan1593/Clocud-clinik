package Pages.cc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class demo {
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys("0287");
		driver.findElement(By.id("searchBtn")).click();
		driver.findElement(By.id("ohrmList_chkSelectRecord_67")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btnDelete")).click();
		Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		String name=driver.findElement(By.id("dialogDeleteBtn")).getAttribute("value");
		//getAttribute(name);
		System.out.println(name);
		WebElement name1=driver.findElement(By.id("dialogDeleteBtn"));
		name1.sendKeys(Keys.ENTER);
		
		
		
		
		
	}

}
