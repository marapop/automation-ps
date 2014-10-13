package a.jbehave.alfresco;



import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import a.steps.alfresco.AlfrescoCreateUserSteps;
import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;

@Story(Application.BasicFunctionality.CreateUser.class)
@RunWith(ThucydidesRunner.class)
public class CreateNewUserTest {
	
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.ALFRESCO_URL)
    public Pages pages;
    
    @Steps
    private AlfrescoLoginSteps loginStep;
    @Steps
    private AlfrescoDashboardSteps dashboardSteps;
    @Steps
    private AlfrescoCreateUserSteps createUserSteps;

    private String userName = "admin";
    private String userPass = "admin";
    
    private String firstName= "John" + RandomStringUtils.randomAlphabetic(3);
    private String lastName="Doe" + RandomStringUtils.randomAlphabetic(3);
    private String userEmail="johnd" + RandomStringUtils.randomAlphabetic(3) + "@gmail.com"; 
    private String clientName="john_dd" + RandomStringUtils.randomAlphabetic(3);
    private String clientPass= "johndoe" + RandomStringUtils.randomAlphabetic(3);
	

    @Test
    public void createNewUser(){
    	
    	loginStep.loginToSite(userName, userPass);
    	
//    	appMenuSteps.createNewUser();
//    	appMenuSteps.clickOnCreateNewUserButton();
//    	
    	createUserSteps.fillNewUserDetails(firstName, lastName, userEmail, clientName, clientPass);
    }

}
