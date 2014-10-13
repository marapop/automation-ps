package a.pages.alfresco;

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.junit.Assert;

public class AlfrescoDetailsViewPage extends PageObject {

	public AlfrescoDetailsViewPage(WebDriver driver) {
		super(driver);
	}


	/**
	 * Verifies if a list of comments are present in the Details View
	 */
	public void verifyCommentsArePresent(List<String> comments) {
		List<WebElement> itemsList = getDriver().findElements(
				By.cssSelector("div[id*= 'default-comments-list'] > table > tbody.yui-dt-data"));
		for (String s : comments) {
			boolean b = false;
			for (WebElement elem : itemsList) {
				if (elem.getText().contains(s)) {
					b = true;
					break;
				}
			}
			Assert.assertTrue(b);
		}
	}

	/**
	 * Verifies if a list of comments are NOT present in the Details View
	 */
	public void verifyCommentsAreNotPresent(List<String> comments) {
		List<WebElement> itemsList = getDriver().findElements(
				By.cssSelector("div[id*= 'default-comments-list'] > table > tbody.yui-dt-data"));
		for (String s : comments) {
			boolean b = false;
			for (WebElement elem : itemsList) {
				if (elem.getText().contains(s)) {
					b = true;
					break;
				}
			}
			Assert.assertFalse(b);
		}
	}


}
