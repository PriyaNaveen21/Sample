package org.projectClass;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.baseClass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Sample extends BaseClass {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		 
		getBrowser();
		
		getUrl("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell inspiron" + Keys.ENTER);

	List l = new LinkedList<String>();
	List<WebElement> products = driver
			.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	System.out.println(products.size());
	for (WebElement x : products) {
		String a = x.getText();
		System.out.println(a);
		String data = a.substring(0, 18);
		String last = data.toUpperCase();
		l.add(last);
	}
	Set s = new LinkedHashSet<String>();
	s.addAll(l);
	System.out.println(s);
}
}
