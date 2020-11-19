package org.baseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	// 1.Configure browser & maximize
	public static void getBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\selenium\\Sample\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// 2.Get url
	public static void getUrl(String data) {
		driver.get(data);
	}

	// 3.Sendkeys
	public void enterText(WebElement element, String data) {
		element.sendKeys(data);
	}

	// 4. Click
	public void click(WebElement element) {
		element.click();
	}

	// 5.To get current url
	public void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	// 6.To get title page
	public static void titltPage() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// 7.To get text from browser
	public void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	// 8.To get the user send text
	public void getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
	}

	// 9.To perform 'Mouse over'
	public static void mouseOver(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	// 10.To perform Right click
	public static void rightClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	// 11.To perform Double Click
	public static void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	// 12.To perform Drag & drop
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	// 13.To perform keyboard action- Down
	public static void down() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	// 14.To perform keyboard action- Up
	public static void up() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	// 15.To perform keyboard action- Enter
	public static void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// 16.To perform keyboard action- Cut
	public static void cut() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}

	// 17.To perform keyboard action- Copy
	public static void copy() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	// 18.To perform keyboard action-Paste
	public static void paste() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	// 19.To perform keyboard action- Save
	public static void save() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_S);
	}

	// 20.To perform keyboard action- Screenshot
	public static void keyBoardScreenshot() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_WINDOWS);
		r.keyPress(KeyEvent.VK_PRINTSCREEN);
		r.keyRelease(KeyEvent.VK_WINDOWS);
		r.keyRelease(KeyEvent.VK_PRINTSCREEN);
	}

	// 21.To perform keyboard action- Escape
	public static void escape() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}

	// 22.Take Screenshot method
	public static void takeScreenshot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(screenshot);

		File f = new File(path);
		FileUtils.copyFile(screenshot, f);
	}

	// 23.Get attributes using java script
	public static void getAttributeJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object o = js.executeScript(" return arguments[0].getAttribute('value')", element);
		System.out.println(o);
	}

	// 24.Click the button using java script
	public static void clickJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	// 25.Scroll down using java script
	public static void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", element);
	}

	// 26.Scroll up using java script
	public static void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// 27.Alert-accept
	public static void accept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	// 28.Alert- dismiss
	public static void dismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	// 29.Alert- send keys
	public static void sendAndAccept(String text) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
		a.accept();
	}

	// 30.Alert- send keys
	public static void sendAndDismiss(String text) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
		a.dismiss();
	}

	// 31.To find a Frame count
	public static void frameCount(List<WebElement> elements) {
		int frameCount = elements.size();
		System.out.println(frameCount);
	}

	// 32.How to switch to frame by using index value
	public void switchToFrame(int i) {
		driver.switchTo().frame(i);
	}

	// 33.How to switch to frame by using string name
	public void switchToFrame(String s) {
		driver.switchTo().frame(s);
	}

	// 34.How to switch to frame by using web element
	public void switchToFraame(WebElement element) {
		driver.switchTo().frame(element);
	}

	// 35.How to switch to parent frame
	public void parentFrame() {
		driver.switchTo().parentFrame();
	}

	// 36.How to default page
	public void defaultFrame() {
		driver.switchTo().defaultContent();
	}

	// 37.Drop down-Print get options
	public static void getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
			System.out.println(text);
		}
	}

	// 38.Drop down- Select by visible text
	public void selectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	// 39.DropDown - Select by Index
	public static void selectByIndex(WebElement element, int i) {
		Select s = new Select(element);
		s.selectByIndex(i);
	}

	// 40.DropDown- Select by value
	public static void selectByValue(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByValue(text);
	}

	// 41.DropDown-DeSelect all
	public static void deselectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	// 42. DropDown- Is multi selected?
	public static void multiSelected(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	// 43.DropDown- Get all selected options
	public static void allSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++) {
			String text = allSelectedOptions.get(i).getText();
			System.out.println(text);
		}
	}

	// 44.How to get the parent window
	public void parentWindow() {
		String parent = driver.getWindowHandle();
		System.out.println(parent);
	}

	// 45.How to get the child windows
	public void childWindow() {
		Set<String> child = driver.getWindowHandles();
		System.out.println(child);
	}

	// 46.How to go to parent window
	public void jumpToParentWindow(String parent) {
		driver.switchTo().window(parent);
	}

	// 47.Implicit wait
	public void implicitWait(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}

	// 48.Webdriver wait- visiblityofElementLocated
	public void webDriverWait(int i, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	// 49.Fluent wait
	@SuppressWarnings({ "deprecation", "unused" })
	public void fluentWait(int i, int j) {
		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(i, TimeUnit.SECONDS)
				.pollingEvery(j, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	}

	// 50.Quit or Close the driver
	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	//51.Get data from WorkBook
	public String getDataFromWorkbook(int row, int cell) throws IOException {

		File f = new File("E:\\selenium\\Sample\\Excel\\Maven Data.xlsx");

		FileInputStream fInput = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fInput);

		Sheet s = w.getSheet("Adactin_Hotel");

		Row r = s.getRow(row);

		Cell c = r.getCell(cell);

		int cellType = c.getCellType();

		String value=null;
		if (cellType == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			java.util.Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/YYYY");
			value = sd.format(dateCellValue);
		} else {
			double ncv = c.getNumericCellValue();
			long l = (long) ncv;
			value = String.valueOf(l);
		}
		return value;
	}
	
	//52.Set Cell value
	public String setCellValue(int row, int cell, String orderId) throws IOException {
		String value = null;
		File f = new File("E:\\selenium\\Sample\\Excel\\Maven Data.xlsx");

		FileInputStream fInput = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fInput);

		Sheet s = w.getSheet("Adactin_Hotel");

		Row r = s.getRow(row);

		Cell c = r.getCell(cell);

		c.setCellValue(orderId);

		FileOutputStream fOut = new FileOutputStream(f);
		w.write(fOut);

		return value;
	}
}

