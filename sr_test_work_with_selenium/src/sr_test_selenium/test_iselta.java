package sr_test_selenium;


//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class test_iselta {

	public static void main(String[] args) throws Exception {
		
		FirefoxOptions cap = new FirefoxOptions();
		cap.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(cap);
		//WebDriver driver = new ChromeDriver(cap);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String baseUrl = "http://localhost/iselta/";
		driver.navigate().to(baseUrl);
		driver.findElement(By.xpath("//a[@href='?content=login']")).click();
		driver.findElement(By.xpath("//input[@class='rightShort']")).click();
		driver.findElement(By.xpath("//input[@class='rightShort']")).sendKeys("heide");
		driver.findElement(By.xpath("//input[@name='password']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("heide");
		driver.findElement(By.xpath("//input[@name='btn_login']")).click();
		
		driver.findElement(By.xpath("//a[@id='meinHotel']")).click();
		driver.findElement(By.xpath("//input[@name='btn_edit']")).click();
		driver.findElement(By.xpath("//input[@name='btn_gotoStep_5']")).click();
		
		Scanner in = new Scanner(new FileReader("C:\\Users\\Tezcan\\Desktop\\mt_RE_parsed.txt"));
		
		String line;
		while((line = in.next()) != null)
		{
			System.out.print(line);
			char[] chars = line.toCharArray();
			for(int i = 0; i < chars.length; i++) {
				Startmt(chars[i], driver, baseUrl);
				
			}
			
			System.out.println(" - "+"fin");
		}
		in.close();
		driver.close();
	}
	
	public static void Startmt(char x, WebDriver driver, String baseUrl) throws Exception {
		WebElement input = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		switch (x) {
	        case 'a':
	        	input = driver.findElement(By.xpath("//input[@name='frm_arr_product[AdditionalServices][OfferingDays][1]']"));
	        	js.executeScript("arguments[0].setAttribute('type', 'checkbox')",input);
	        	input.click();
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        	
	        case 'b':
	        	input = driver.findElement(By.xpath("//input[@name='frm_arr_product[AdditionalServices][NumberOfPackages]']"));
	        	input.sendKeys("5");
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        	
	        case 'c':
	        	input = driver.findElement(By.xpath("//input[@name='frm_arr_product[AdditionalServices][Price]']"));
	        	input.sendKeys("5");
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        	
	        case 'd':
	        	input = driver.findElement(By.xpath("//input[@name='frm_arr_product[AdditionalServices][Title]']"));
	        	input.sendKeys("Mehmet");
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        	
	        case 'e':
	        	input = driver.findElement(By.xpath("//option[@value='577']"));
	        	js.executeScript("arguments[0].setAttribute('type', '')",input);
	        	input.click();
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        
	        case 'f':
	        	input = driver.findElement(By.xpath("//input[@name='btn_addAdditionalService']"));
	        	input.click();
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        	
	        case 'g':
	        	input = driver.findElement(By.xpath("//input[@name='btn_editAdditionalService_88']"));
	        	input.click();
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        case 'h':
	        	input = driver.findElement(By.xpath("//input[@name='frm_arr_product[AdditionalServices][OfferingDays][2]']"));
	        	js.executeScript("arguments[0].setAttribute('type', 'checkbox')",input);
	        	input.click();
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        case 'i':
	        	input = driver.findElement(By.xpath("//input[@name='frm_arr_product[AdditionalServices][Price]']"));
	        	input.sendKeys("15");
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        case 'j':
	        	input = driver.findElement(By.xpath("//input[@name='frm_arr_product[AdditionalServices][Title]']"));
	        	input.sendKeys("Test1");
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        case 'k':
	        	input = driver.findElement(By.xpath("//input[@name='btn_saveAdditionalService']"));
	        	input.click();
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	        case 'l':
	        	input = driver.findElement(By.xpath("//input[@name='btn_cancelAdditionalService']"));
	        	input.click();
	        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        	break;
	      
	        	

}
		}}
