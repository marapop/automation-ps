package a.jbehave.alfresco;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import a.steps.alfresco.AlfrescoListActionsSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.steps.alfresco.AlfrescoNavigationSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;

@Story(Application.BasicFunctionality.NavigateToDocumentView.class)
@RunWith(ThucydidesRunner.class)
public class OpenDocumentViewTest {


	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.ALFRESCO_URL)
	public Pages pages;

	@Steps
	private AlfrescoLoginSteps loginStep;
	@Steps
	private AlfrescoNavigationSteps navigationSteps;
	@Steps
	private AlfrescoListActionsSteps listActionsSteps;
	

	private String userName = "admin";
	private String userPass = "admin";
	private String fileName = "activities-email_nl.ftl";
	private String folderPath = "Data Dictionary > Email Templates > activities";
		
	@Test
	public void navigateAndOpenDocumentView() {

		loginStep.loginToSite(userName, userPass);
		
//		appMenuSteps.clickOnRepositoryButton();

		navigationSteps.navigateToFolder(folderPath);
		listActionsSteps.openFile(fileName);

	}
}
