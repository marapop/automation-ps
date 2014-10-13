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

import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.steps.alfresco.AlfrescoNavigationSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;

@Story(Application.BasicFunctionality.NavigateToRepository.class)
@RunWith(ThucydidesRunner.class)
public class RepositoryNavigationTest {


	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.ALFRESCO_URL)
	public Pages pages;

	@Steps
	private AlfrescoLoginSteps loginStep;
	@Steps
	private AlfrescoDashboardSteps dashboardSteps;
	@Steps
	private AlfrescoNavigationSteps navigationSteps;

	private String userName = "admin";
	private String userPass = "admin";
	private String folderPath = "Data Dictionary > Space Templates > Software Engineering Project > Documentation > Samples";


	@Test
	public void navigateToRepositoryFile() {

		loginStep.loginToSite(userName, userPass);
		
//		appMenuSteps.clickOnRepositoryButton();

		navigationSteps.navigateToFolder(folderPath);
		
	}

}
