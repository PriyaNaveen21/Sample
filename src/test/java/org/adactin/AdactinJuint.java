package org.adactin;

import java.io.IOException;

import org.baseClass.BaseClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdactinJuint {
	static BaseClass b= new BaseClass();
	pojoClass p = new pojoClass();
	@BeforeClass
	public static void launchBrowser() {
		b.getBrowser();
		b.getUrl("http://adactinhotelapp.com/");
}
	@Test
	public void testCase() throws IOException {
		b.enterText(p.getUserName(), b.getDataFromWorkbook(1, 0));
		b.enterText(p.getPassword(), b.getDataFromWorkbook(1, 1));
		b.click(p.getLoginBtn());
	b.selectByVisibleText(p.getLocation(),"London");
	b.selectByVisibleText(p.getHotels(), "Hotel Creek");
	b.selectByVisibleText(p.getRoomType(), "Super Deluxe");
	b.selectByVisibleText(p.getInDate(),b.getDataFromWorkbook(1,6));
	b.selectByVisibleText(p.getOutDate(), b.getDataFromWorkbook(1, 7));
	b.click(p.getSearch());
}
}