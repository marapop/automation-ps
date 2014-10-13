package a.steps.alfresco;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import a.pages.alfresco.AlfrescoDetailsViewPage;
import a.tools.alfresco.WebDriverConfig;

public class AlfrescoDetailsViewSteps {

	WebDriver driver = WebDriverConfig.getCurrentDriver();
	AlfrescoDetailsViewPage detailsViewPage = PageFactory.initElements(driver, AlfrescoDetailsViewPage.class);
	

	public void verifyCommentsArePresent(List<String> table) {
		detailsViewPage.verifyCommentsArePresent(table);
	}

	public void verifyCommentsAreNotPresent(List<String> table) {
		detailsViewPage.verifyCommentsAreNotPresent(table);
	}
}
