package a.pages.alfresco;

import java.util.List;

import org.junit.Assert;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.Constants;

public class AlfrescoRepositoryPage extends PageObject {

	public AlfrescoRepositoryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div#HEADER_REPOSITORY a")
	private WebElement repositoryButton;

	public void openRepository() {
		element(repositoryButton).waitUntilVisible();
		repositoryButton.click();
		waitABit(Constants.WAIT_TIME);

	}

	public void selectItem(String collectionName) {
		List<WebElement> collectionsList = getDriver()
				.findElements(
						By.cssSelector("div[id $= 'default-documents'] > table > tbody.yui-dt-data > tr h3.filename a"));
		for (WebElement elem : collectionsList) {
			if (elem.getText().contentEquals(collectionName)) {
				elem.click();
				break;
			}
		}
		waitABit(Constants.WAIT_TIME);
	}

	public void verifyCustomIconInRepoMainView(String nodeName, String iconType) {
		List<WebElement> collectionsList = getDriver().findElements(
				By.cssSelector("div[id $= 'default-documents'] > table > tbody.yui-dt-data > tr"));
		boolean b = false;
		for (WebElement elem : collectionsList) {
			if (elem.getText().contains(nodeName)) {
				WebElement imageElement = elem.findElement(By.cssSelector("img[id*='workspace']"));
				if (iconType.contains("Books")) {
					Assert.assertTrue(imageElement.getAttribute("src").contains(Constants.BOOK_CUSTOM_ICON_LARGE));
					b = true;
				}
				if (iconType.contains("Contents")) {
					Assert.assertTrue(imageElement.getAttribute("src").contains(Constants.CONTENTS_CUSTOM_ICON_LARGE));
					b = true;
				}
				break;
			}
		}
		Assert.assertTrue("node was not found", b);
	}
}
