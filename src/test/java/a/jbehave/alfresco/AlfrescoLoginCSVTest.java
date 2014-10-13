package a.jbehave.alfresco;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import a.steps.alfresco.AlfrescoLoginSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;

@Story(Application.BasicFunctionality.LoginIntoShare.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH + "credentials.csv", separator=Constants.CSV_SEPARATOR)
public class AlfrescoLoginCSVTest {

	
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.ALFRESCO_URL)
	public Pages pages;

	@Steps
	private AlfrescoLoginSteps loginStep;


	private String username;
	private String password;


	@Qualifier
    public String getQualifier() {
        return username;
    }
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	@Test
	public void loginToAlfrescoSite() {

		loginStep.loginToSite(username, password);
	}

}
