package a.steps.alfresco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import a.pages.alfresco.AlfrescoEditPropertiesPage;
import a.tools.alfresco.WebDriverConfig;


public class AlfrescoEditPropertiesSteps {

	WebDriver driver = WebDriverConfig.getCurrentDriver();
	AlfrescoEditPropertiesPage editPropertiesPage = PageFactory.initElements(driver, AlfrescoEditPropertiesPage.class);

	public void verifyFieldIsPresent(String fieldName) {
		editPropertiesPage.verifyElementWithTitleIsDisplayed(fieldName);
	}

}
