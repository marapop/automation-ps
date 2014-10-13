package a.pages.alfresco;

import java.util.List;

import org.junit.Assert;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlfrescoEditPropertiesPage extends PageObject {

	public AlfrescoEditPropertiesPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Verifies if a field is present
	 */
	public void verifyFieldIsPresent(String fieldName) {
		List<WebElement> fieldsList = getDriver().findElements(
				By.cssSelector("div[id $= 'default-form-fields'] > div.set > div"));
		for (WebElement elem : fieldsList) {
			if (elem.getText().contains(fieldName)) {
				WebElement fieldInput = elem.findElement(By.cssSelector("textarea"));
				Assert.assertTrue(fieldInput.isDisplayed());
				break;
			}
		}
	}

	public void verifyElementWithTitleIsDisplayed(String fieldName) {
		getDriver().findElement(By.cssSelector("[title='" + fieldName + "']")).isDisplayed();
	}

}
