package a.pages.alfresco;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.Constants;

public class AlfrescoCopyMoveLinkToPage extends PageObject {

	public AlfrescoCopyMoveLinkToPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div#ygtv7")
	private WebElement linkToRightLibraryContainer;

	@FindBy(css = "button[id $= 'copyMoveTo-ok-button']")
	private WebElement linkButton;

	@FindBy(css = "button[id $= 'default-copyMoveTo-ok-button']")
	private WebElement linkButton2;
	
	@FindBy(css = "[id $= 'default-copyMoveTo-ok-button']")
	private WebElement linkButtonID;

	@FindBy(css = "[id $= 'default-copyMoveTo-cancel-button']")
	private WebElement copyCancelButton;

	
	
	
	public void clickOnLinkButton() {
		waitABit(Constants.WAIT_TIME);
		linkButton.click();
		waitABit(5000);
	}
	
	public void selectNode(String nodeName) {
		waitABit(Constants.WAIT_TIME);
		List<WebElement> itemsList = getDriver().findElements(
				By.cssSelector("div[id $= 'default-copyMoveTo-treeview'] div > table > tbody > tr span"));
		for (WebElement elem : itemsList) {
			if (elem.getText().contains(nodeName)) {
				elem.click();
				break;
			}
		}
	}

	public void linkToItemFromMoreMenu(String itemName) {
		waitABit(Constants.WAIT_TIME);
		List<WebElement> treeItems = getDriver().findElements(By.cssSelector("div#ygtv7 span"));
		for (WebElement itemNow : treeItems) {
			if (itemNow.getText().contains(itemName)) {
				itemNow.click();
				waitABit(Constants.WAIT_TIME);
				break;
			}
		}
		element(linkButton2).waitUntilVisible();
		linkButton2.click();
		waitForRenderedElementsToBePresent(By.cssSelector("div#message"));
		waitForRenderedElementsToDisappear(By.cssSelector("div#message"));
	}

	/**
	 * Clicks on the "Copy to" Cancel button
	 */
	public void clickOnCopyToCancelButton() {
		waitABit(Constants.WAIT_TIME);
		element(copyCancelButton).waitUntilVisible();
		copyCancelButton.click();
		waitABit(Constants.WAIT_TIME);
	}

	/**
	 * Checks if an item is restricted
	 */
	public void verifyItemIsRestricted(String itemName) {
		waitABit(2000);
		List<WebElement> itemsList = getDriver().findElements(
				By.cssSelector("div[id $= 'default-copyMoveTo-treeview'] div > table > tbody > tr"));
		for (WebElement elem : itemsList) {
			if (elem.findElement(By.cssSelector("span")).getText().contains(itemName)) {
				String classs = elem.findElement(By.cssSelector("td:nth-child(2)")).getAttribute("class");
				Assert.assertTrue("element is not restricted", classs.contains("restricted-copy-dialog-node"));
				break;
			}
		}
	}

	/**
	 * Checks if an item is NOT restricted
	 */
	public void verifyItemIsNotRestricted(String itemName) {
		waitABit(2000);
		List<WebElement> itemsList = getDriver().findElements(
				By.cssSelector("div[id $= 'default-copyMoveTo-treeview'] div > table > tbody > tr"));
		for (WebElement elem : itemsList) {
			if (elem.findElement(By.cssSelector("span")).getText().contains(itemName)) {
				String classs = elem.findElement(By.cssSelector("td:nth-child(2)")).getAttribute("class");
				Assert.assertFalse("element is not restricted", classs.contains("restricted-copy-dialog-node"));
				break;
			}
		}
	}

	/**
	 * Verifies that the Copy/Move/Link button is not visible
	 */
	public void verifyCopyButtonIsDisabled() {
		Assert.assertFalse(element(linkButton).isEnabled());
	}
	
	/**
	 * Verifies that the Copy/Move/Link button is visible
	 */
	public void verifyCopyButtonIsEnabled() {
		Assert.assertTrue(element(linkButton).isEnabled());
	}

}
