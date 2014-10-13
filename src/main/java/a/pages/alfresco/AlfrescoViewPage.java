package a.pages.alfresco;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.Constants;

public class AlfrescoViewPage extends PageObject {

	public AlfrescoViewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "login")
	private WebElement loginButton;

	@FindBy(id = "loginForm:user-name")
	private WebElement userInput;

	@FindBy(id = "loginForm:user-password")
	private WebElement passwordInput;

	@FindBy(id = "loginForm:submit")
	private WebElement submitButton;

	@FindBy(id = "dashboard:dash-body:dashlet-1-view:browse-link")
	private WebElement browseLinkOld;

	@FindBy(xpath = "//a[contains(.,'Browse items in your home space')]")
	private WebElement browseLink;

	@FindBy(css = "div.headbarTitle a:first-child")
	private WebElement myAlfrescoLink;

	@FindBy(css = "#browse > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(6)")
	private WebElement browseCenterTableOne;

	@FindBy(css = "#browse > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(7)")
	private WebElement browseCenterTableTwo;

	public void openOldAlfresco() {
		getDriver().get(Constants.EXPLORER_URL);
		if (element(loginButton).isVisible()) {
			performLogin();
			submitLoginDetails();
			waitABit(Constants.WAIT_TIME);
		}
		openNavigationShelf();
	}

	public void navigateToRootMyAlfrescoDashboard() {
		waitABit(Constants.WAIT_TIME);
		element(myAlfrescoLink).waitUntilVisible();
		myAlfrescoLink.click();
	}

	public void modalNavigation(String navigationPath) {
		navigateToRootMyAlfrescoDashboard();
		openBrowsing();

		String[] navigationItems = navigationPath.split(Constants.PATH_SEPARATOR);

		if (navigationItems.length > 0) {
			for (String pathNow : navigationItems) {
				waitABit(Constants.WAIT_TIME);
				navigateToItem(pathNow);
			}
		} else {
			System.out.println("ERROR: Path parameter is incorect.");
		}
	}

	public void performLogin() {
		element(loginButton).waitUntilVisible();
		loginButton.click();
	}

	public void submitLoginDetails() {
		element(userInput).waitUntilVisible();
		userInput.sendKeys(Constants.ALFRESCO_USER_LOGIN);
		element(passwordInput).waitUntilVisible();
		passwordInput.sendKeys(Constants.ALFRESCO_PASS_LOGIN);
		element(submitButton).waitUntilVisible();
		submitButton.click();
	}

	public void openNavigationShelf() {
		evaluateJavascript("document.forms['dashboard']['dashboard:modelist'].value='dashboard:sidebarPluginList:shelf';document.forms['dashboard'].submit();return false;");
	}

	public void openBrowsing() {
		element(browseLink).waitUntilVisible();
		browseLink.click();
	}

	public void navigateToItem(String itemName) {
		element(browseCenterTableOne).waitUntilVisible();
		List<WebElement> listItems = browseCenterTableOne.findElements(By.cssSelector(" table.recordSet tr > td:nth-child(2) a[id*='col']"));

		if (!listItems.isEmpty()) {
			for (WebElement elementNow : listItems) {

				if (elementNow.getText().contentEquals(itemName)) {
					elementNow.click();
					break;
				}

			}
		} else {
			navigateToSiteItem(itemName);
		}
	}

	public void navigateToSiteItem(String itemName) {
		element(browseCenterTableTwo).waitUntilVisible();
		List<WebElement> listItems = browseCenterTableTwo.findElements(By.cssSelector(" table.recordSet tr > td:nth-child(2) a[id*='col']"));

		for (WebElement elementNow : listItems) {
			if (elementNow.getText().contentEquals(itemName)) {
				elementNow.click();
				break;
			}

		}
	}

	public void clickOnItemCopy(String itemName) {
		element(browseCenterTableOne).waitUntilVisible();
		List<WebElement> listItems = browseCenterTableOne.findElements(By.cssSelector("tr.recordSetRow > td > table"));
		boolean foundItem = false;
		for (WebElement elementNow : listItems) {
			if (elementNow.getText().contains(itemName)) {
				elementNow.findElement(By.cssSelector("a > img[alt='Copy']")).click();
				waitABit(Constants.WAIT_TIME);
				break;
			}
		}

		if (!foundItem) {
			clickOnItemCopyInSecondContainer(itemName);
		}
	}

	public void clickOnItemCopyInSecondContainer(String itemName) {
		element(browseCenterTableTwo).waitUntilVisible();
		List<WebElement> listItems = browseCenterTableTwo.findElements(By.cssSelector("td > table"));
		firstFor: for (WebElement elementNow : listItems) {

			if (elementNow.getText().contains(itemName)) {
				elementNow.findElement(By.cssSelector("a[title='More Actions']")).click();
				List<WebElement> buttonLIst = elementNow.findElements(By.tagName("a"));
				for (WebElement buttonNow : buttonLIst) {
					if (buttonNow.getText().contains("Copy")) {
						buttonNow.click();
						waitABit(Constants.WAIT_TIME);
						break firstFor;
					}
				}
			}
		}
	}

	/**
	 * Clicks on the paste item button
	 */
	public void clickOnLinkItem(String itemName) {
		List<WebElement> clipboardItemsList = getDriver()
				.findElements(
						By.cssSelector("div#shelf > table > tbody > tr:first-child > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr > td > table > tbody > tr"));

		for (WebElement elem : clipboardItemsList) {
			if (elem.getText().contains(itemName)) {
				elem.findElement(By.cssSelector("img[title='Paste As Link']")).click();
				waitABit(Constants.WAIT_TIME);
				break;
			}
		}
	}
}
