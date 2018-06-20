package com.qait.automation.TatocAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TatocFunctionsForAutomation {
	WebDriver driver;

	public void tatocPage1() {
		 driver = new ChromeDriver();
		 driver.get("http://10.0.1.86/tatoc/");
		driver.findElement(By.linkText("Basic Course")).click();
	}
	public void tatocPage2() {
		driver.findElement(By.className("greenbox")).click();
	}
	public void tatocPage3() {
		String Box1Color="",Box2Color="";
        Box1Color=driver.switchTo().frame("main").findElement(By.id("answer")).getAttribute("class");
        do {
        	Box2Color=driver.switchTo().frame("child").findElement(By.id("answer")).getAttribute("class");;
        	driver.switchTo().parentFrame();
        	if(Box1Color.equals(Box2Color)) {
        		driver.findElement(By.linkText("Proceed")).click();
        	}
        	else {
        		driver.findElement(By.linkText("Repaint Box 2")).click();
        	}
        }while(!Box1Color.equals(Box2Color));
        
	}
	public void tatocPage4() {
		new Actions(driver).dragAndDrop(driver.findElement(By.id("dragbox")),driver.findElement(By.id("dropbox"))).perform();
        driver.findElement(By.linkText("Proceed")).click();
	}
	public void tatocPage5() {
		driver.findElement(By.linkText("Launch Popup Window")).click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
      	  driver.switchTo().window(winHandle);
        }
        WebElement we=driver.findElement(By.id("name"));
        we.sendKeys("Anoop Kumar");
        driver.findElement(By.id("submit")).click();
        driver.switchTo().window(winHandleBefore);
        driver.findElement(By.linkText("Proceed")).click();
	}
	public void tatocPage6() {
		driver.findElement(By.linkText("Generate Token")).click();
        String c=driver.findElement(By.id("token")).getText();
        String[] str=c.split(" ");
        Cookie ck=new Cookie("Token", str[str.length-1]);
        driver.manage().addCookie(ck);
       driver.findElement(By.linkText("Proceed")).click();
	}
	
	
	
}
