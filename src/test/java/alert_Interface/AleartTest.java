package alert_Interface;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AleartTest {
	
	WebDriver driver;
	Alert alert;
	
	@Before
	public void steup () throws InterruptedException {
	
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 driver.get("https://www.google.co.in");
		 driver.navigate().to("https://nxtgenaiacademy.com/alertandpopup/");
		 Thread.sleep(2000);
	}
	@Ignore
	@Test
	public void test1() throws InterruptedException {
		WebElement alert1=driver.findElement(By.xpath("//button[text()='Alert Box']"));
		System.out.println(alert1.getText());
		alert1.click();
		Thread.sleep(2000);
	    alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		Thread.sleep(2000);
		}
	@Ignore
	@Test
	public void test2() throws InterruptedException {
		WebElement alert2=driver.findElement(By.xpath("//button[text()='Confirm Alert Box']"));
		
		System.out.println(alert2.getText());alert2.click();
		Thread.sleep(000);
		 alert=driver.switchTo().alert();
		
		System.out.println(driver.switchTo().alert().getText());
		//alert.accept();
		alert.dismiss();
		WebElement click_ok=driver.findElement(By.xpath("//p[@id='demo' and text()='You clicked on OK!' or text()='You clicked on Cancel!']"));
        //WebElement click_cancel=driver.findElement(By.xpath("//p[@id='demo' and text()='You clicked on Cancel!']"));		
		if(click_ok.getText().equals("You clicked on OK!")) {
			System.out.println("You clicked on OK!");
			}
		if (click_ok.getText().equals("You clicked on Cancel!")) {
			System.out.println("You clicked on Cancel!");
			}
		}
	@Test
	public void test3() throws InterruptedException {
		WebElement alert3=driver.findElement(By.xpath("//button[text()='Prompt Alert Box']"));
		alert3.click();
		alert=driver.switchTo().alert();
		alert.sendKeys("yes");
		
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(2000);
		WebElement alertmsg=driver.findElement(By.xpath("//p[@id='demoone' and text()='Sad to hear it ! ' or text()='Thanks for Liking Automation']"));
		//System.out.println(alertmsg.getText());
		if(alertmsg.getText().equals("Sad to hear it ! ")) {
			System.out.println(alertmsg.getText()+"NO");
			}
		if (alertmsg.getText().equals("Thanks for Liking Automation")) {
			System.out.println(alertmsg.getText()+"yes");
			}
	}
	
	@After
		
		public void close() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}