package com.qa.DropDown;


import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {
	
	
	public static WebDriver driver;
	@Test
	public void initilize() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Arize\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			driver.get("https://www.salesforce.com/au/");
			driver.manage().window().maximize();
			WebElement button = driver.findElement(By.xpath("(//a[contains(text(),'Start free trial')])[1]"));
			button.click();
			
			Set<String>windowHandeles =driver.getWindowHandles();
			//System.out.println(windowHandeles);
			Iterator<String>iterator =windowHandeles.iterator();
			String parentwindow = iterator.next();
			
			String childwindow = iterator.next();
			
			driver.switchTo().window(childwindow);
			
			System.out.println(driver.getTitle());
			
		 WebElement jobTitle = driver.findElement(By.xpath("//select[@name='UserTitle']"));
		 
		 Select select = new Select(jobTitle);
		 
		List<WebElement>list =  select.getOptions();
		 
		for(int i=0;i<list.size();i++) {
			
			System.out.println(list.get(i).getText());
		}
		
		
			
			

}
}
