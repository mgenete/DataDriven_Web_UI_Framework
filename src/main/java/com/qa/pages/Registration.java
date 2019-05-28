package com.qa.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class Registration {
	
	
	public WebDriver driver;
	static Logger log = Logger.getLogger(Registration.class.getName());
	
	@FindBy(xpath = "//select[@id='payment_plan_id']")
	WebElement editionType;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@name='surname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='email_confirm']")
	WebElement confirmEmail;

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passWord;

	@FindBy(xpath = "//input[@name='passwordconfirm']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@name='agreeTerms']")
	WebElement termsAndCond;

	@FindBy(xpath = "//button[@id='submitButton']")
	WebElement submitBtn;
	
	@FindBy (tagName = "small")
	List<WebElement> errorMessage;
	
	public Registration(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public void newRegistration(String edition, String firstname, String lastname, String Email, String confEmail, String username, String password, String confPassword) {
		new Select(editionType).selectByVisibleText(edition);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		email.sendKeys(Email);
		confirmEmail.sendKeys(confEmail);
		userName.sendKeys(username);
		passWord.sendKeys(password);
		confirmPassword.sendKeys(confPassword);
		termsAndCond.click();
		//submitBtn.click();
		
	}
	
	public WebElement getEditionType() {
		return editionType;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getConfirmEmail() {
		return confirmEmail;
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public String getRegistrationErrorMessage() {
		for(WebElement element : errorMessage) {
			if(element.isDisplayed())
				return element.getText();
		}
		return null;
	}

}
