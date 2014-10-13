package a.steps.alfresco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import a.pages.alfresco.AlfrescoViewPage;
import a.tools.alfresco.WebDriverConfig;


public class AlfrescoViewPSteps {
	
	WebDriver driver = WebDriverConfig.getCurrentDriver();
	AlfrescoViewPage alfrescoViewPage = PageFactory.initElements(driver, AlfrescoViewPage.class);
	
	public void navigateModal(String navigationPath) {
		alfrescoViewPage.modalNavigation(navigationPath);
	}

	
	public void copyItem(String copyItem) {
		alfrescoViewPage.clickOnItemCopy(copyItem);
	}

	
	public void linkItem(String linkItem) {
		alfrescoViewPage.clickOnLinkItem(linkItem);
	}

	public void navigateToOldAlfresco() {
		alfrescoViewPage.openOldAlfresco();
	}

}
