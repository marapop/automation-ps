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

import a.steps.alfresco.AlfrescoLoginSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;

@Story(Application.BasicFunctionality.LoginIntoShare.class)
@RunWith(ThucydidesRunner.class)
public class AlfrescoLoginTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	//@ManagedPages(defaultUrl = Constants.ALFRESCO_URL)
	@ManagedPages(defaultUrl = Constants.ALFRESCO_URL_Cengage)
	public Pages pages;

	@Steps
	private AlfrescoLoginSteps loginStep;


	private String userName = "admin";
	private String userPass = "admin";
	

	@Test
	public void loginToAlfrescoSite() {

		loginStep.loginToSite(userName, userPass);
	}

}
