package org.projectClass;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day1Task_PC extends BaseClass{
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		 
		getBrowser();
		
		getUrl("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell Vostro",Keys.ENTER);
		
		List li = new LinkedList<String>();
	    List<WebElement> laptops = driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));

	    System.out.println("Size :"+laptops.size());
	    for (WebElement Products : laptops) {
	    	String s= Products.getText();
	    	System.out.println(s);
	    	String data = s.substring(0, 15);
	    	String last = data.toUpperCase();
	    	li.add(last);
		} System.out.println("*********************");

	    Set si = new LinkedHashSet<String>();
	    si.addAll(li);
	    System.out.println(si);
	}
	
}
