package a.pages.alfresco;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;

public class AlfrescoLoginPage extends AbstractPage {

	public AlfrescoLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "username")
	private WebElement userInput;

	@FindBy(name = "password")
	private WebElement passwordInput;

	@FindBy(css = "button[id*='submit-button']")
	private WebElement loginButton;

	@FindBy(css = "div.error")
	private WebElement errorMessageText;

	public void enterUsername(String userName) {
		element(userInput).waitUntilVisible();
		userInput.clear();
		userInput.sendKeys(userName);
	}

	public void enterPassword(String password) {
		element(passwordInput).waitUntilVisible();
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void openLoginPage(String url) {
		try {
			getDriver().get(url);
		} catch (Exception e) {
			System.out.println("\n===============Exception in get()\n");
		}

		getDriver().manage().window().maximize();
		waitABit(2000);
	}

	public void closeBrowser() {
		getDriver().quit();
	}

	public int getEnteredPasswordLength() {
		element(passwordInput).waitUntilVisible();
		return element(passwordInput).getTextValue().length();
	}

	public String getPasswordFieldType() {
		element(passwordInput).waitUntilVisible();
		return passwordInput.getAttribute("type");
	}

	public void clickLoginButton() {
		element(loginButton).waitUntilVisible();
		element(loginButton).click();
	}

	public void verifyThatUsernameFieldIsEmpty() {
		Assert.assertTrue("The username field is not empty ",
				element(userInput).getText().isEmpty());
	}

	public void verifyThatPasswordFieldIsEmpty() {
		Assert.assertTrue("The username field is not empty ",
				element(passwordInput).getText().isEmpty());
	}

	public void verifyThatTheErrorMessageBoxIsDisplayed() {
		Assert.assertTrue("Error message not displayed",
				errorMessageText.isDisplayed());
	}

	public void verifyThatCorrectErrorMessageIsDisplayed(String expectedMessage) {
		Assert.assertEquals(expectedMessage, errorMessageText.getText());
	}
}
