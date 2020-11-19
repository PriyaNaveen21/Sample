package org.adactin;
	
import org.baseClass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class pojoClass extends BaseClass {
public pojoClass() {
PageFactory.initElements(driver, this);
}
	@FindBy(id="username")
	private WebElement userName;

	@FindBy(id="password")
	private WebElement password;

	@FindBy(xpath="//input[@id='login']")
	private WebElement loginBtn;

	@FindBys({@FindBy(name="location"),@FindBy(id="location")})
	private WebElement location;

	@FindBy(id="hotels")
	private WebElement hotels;

	@FindBy(id="room_type")
	private WebElement roomType;

	@FindBy(id="datepick_in")
	private WebElement inDate;

	@FindBy(id="datepick_out")
	private WebElement outDate;

	@FindBy(id="Submit")
	private WebElement search;

	@FindBy(id="radiobutton_0")
	private WebElement radioBtn;

	@FindBy(id="continue")
	private WebElement continueBtn;

	@FindBy(id= "first_name")
	private WebElement firstName;

	@FindBy(id="last_name")
	private WebElement lastName;

	@FindBy(id="address")
	private WebElement address;

	@FindBy(id="cc_num")
	private WebElement cardNum;

	@FindBy(id="cc_type")
	private WebElement cardType;

	@FindBy(id="cc_exp_month")
	private WebElement expiryMonth;

	@FindBy(id="cc_exp_year")
	private WebElement expiryYear;

	@FindBy(id="cc_cvv")
	private WebElement cvv;

	@FindBy(id="book_now")
	private WebElement bookNow;

	@FindBy(id="order_no")
	private WebElement orderNo;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getInDate() {
		return inDate;
	}

	public WebElement getOutDate() {
		return outDate;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getRadioBtn() {
		return radioBtn;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardNum() {
		return cardNum;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpiryMonth() {
		return expiryMonth;
	}

	public WebElement getExpiryYear() {
		return expiryYear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public WebElement getOrderNo() {
		return orderNo;
	}
	}


