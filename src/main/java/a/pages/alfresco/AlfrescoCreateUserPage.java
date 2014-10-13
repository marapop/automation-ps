package a.pages.alfresco;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoCreateUserPage extends AbstractPage {

	public AlfrescoCreateUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[id*='default-create-main']")
	private WebElement newUserPageContainer;

	@FindBy(css = "[id*='default-create-firstname']")
	private WebElement firstNameField;

	@FindBy(css = "[id*='default-create-lastname']")
	private WebElement lastNameField;

	@FindBy(css = "[id*='default-create-email']")
	private WebElement userEmailField;

	@FindBy(css = "[id*='default-create-username']")
	private WebElement userNameField;

	@FindBy(css = "[id*='default-create-password']")
	private WebElement userPasswordField;

	@FindBy(css = "[id*='default-create-verifypassword']")
	private WebElement vPasswordField;

	@FindBy(css = "[id*='default-createuser-ok-button-button']")
	private WebElement pageCreateNewUserButton;

	@FindBy(className = "grouppicker-row")
	private WebElement searchGroupContainer;

	@FindBy(css = "input[id*='groupfinder-search-text']")
	private WebElement searchGroupField;

	@FindBy(css = "button[id*='group-search-button-button']")
	private WebElement searchGroupButton;

	@FindBy(css = "div[id*='create-groupfinder-results']")
	private WebElement searchResultsContainer;

	public void inputUserFirstName(String firstName) {
		element(newUserPageContainer).waitUntilVisible();
		element(firstNameField).waitUntilVisible();
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
	}

	public void inputUserLastName(String lastName) {
		element(newUserPageContainer).waitUntilVisible();
		element(lastNameField).waitUntilVisible();
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
	}

	public void inputUserEmail(String userEmail) {
		element(userEmailField).waitUntilVisible();
		userEmailField.clear();
		userEmailField.sendKeys(userEmail);
	}

	public void inputUserClientName(String clientName) {
		element(userNameField).waitUntilVisible();
		userNameField.clear();
		userNameField.sendKeys(clientName);
	}

	public void inputUserPassword(String clientPass) {

		element(userPasswordField).waitUntilVisible();
		userPasswordField.clear();
		userPasswordField.sendKeys(clientPass);

		element(vPasswordField).waitUntilVisible();
		vPasswordField.clear();
		vPasswordField.sendKeys(clientPass);
	}

	public void clickOnAddGroupButton() {
		element(searchGroupContainer).waitUntilVisible();
		element(searchResultsContainer).waitUntilVisible();
		waitABit(Constants.WAIT_TIME_LONG);
		WebElement cancelCheckOutGroupButton = searchResultsContainer
				.findElement(By
						.cssSelector("td[headers*='actions'] div span span button"));
		element(cancelCheckOutGroupButton).waitUntilVisible();
		cancelCheckOutGroupButton.click();
	}

	public void findGroupToUser(String cancelGroup) {
		element(searchGroupContainer).waitUntilVisible();
		element(searchGroupField).waitUntilVisible();
		searchGroupField.clear();
		searchGroupField.sendKeys(cancelGroup);
	}

	public void clickOnSearchGroupButton() {
		element(searchGroupContainer).waitUntilVisible();
		element(searchGroupButton).click();
	}

	public void clickOnCreateUser() {
		element(pageCreateNewUserButton).waitUntilEnabled();
		pageCreateNewUserButton.click();
		waitFor(ExpectedConditions.invisibilityOfElementLocated(By
				.id("message")));
	}

}
