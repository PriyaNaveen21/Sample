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
	b.implicitWait(3);
	b.click(p.getRadioBtn());
	b.click(p.getContinueBtn());

	b.implicitWait(3);
	b.enterText(p.getFirstName(), b.getDataFromWorkbook(2, 10));
	b.enterText(p.getLastName(), b.getDataFromWorkbook(2, 11));
	b.enterText(p.getAddress(), b.getDataFromWorkbook(2, 13));
	b.enterText(p.getCardNum(), b.getDataFromWorkbook(2, 14));
	b.enterText(p.getCardType(), b.getDataFromWorkbook(2, 15));
	b.enterText(p.getExpiryMonth(), b.getDataFromWorkbook(2, 16));
	b.enterText(p.getExpiryYear(), b.getDataFromWorkbook(2, 17));
	b.enterText(p.getCvv(), b.getDataFromWorkbook(2, 18));
	b.click(p.getBookNow());

	b.implicitWait(10);
	String s = p.getOrderNo().getAttribute("value");
	b.setCellValue(1, 12, s);
}

}