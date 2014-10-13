package a.jbehave;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.browserlaunchers.Sleeper;

import a.tools.alfresco.Constants;
import a.steps.EndUserSteps;
import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoDocumentLibrarySteps;
import a.steps.alfresco.AlfrescoInvitePeopleSteps;
import a.steps.alfresco.AlfrescoLoginSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;
    
    @Steps
    AlfrescoLoginSteps alfrescoLoginSteps;
    
    @Steps
    AlfrescoDashboardSteps alfrescoDashboardSteps;
    
    @Steps
    AlfrescoInvitePeopleSteps alfrescoInvitePeopleSteps;
    
    @Steps
    AlfrescoDocumentLibrarySteps alfrescoDocumentLibrarySteps;

    @Given("the user is on the Wikionary home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        endUser.is_the_home_page();
    }
    
    @Given("I log in with user [$userName] and password [$password] and I open [$siteName] site")
	@When("I log in with user [$userName] and password [$password] and I open [$siteName] site")
	public void loginAndNavigatetoDocumentLibrary(String userName, String password, String siteName) {
		alfrescoLoginSteps.openLoginPage(Constants.ALFRESCO_URL);
		alfrescoLoginSteps.login(userName,password);
		if (alfrescoDashboardSteps.isSiteOnDashboard(siteName)) {
			alfrescoDashboardSteps
			.selectSiteOnDashboard(siteName);
		} else {
			alfrescoDashboardSteps.clickSiteFinder();
			alfrescoDashboardSteps
			.searchTheSiteCreatedByOther(siteName);
			alfrescoDashboardSteps.openTheSiteFound(siteName);
		}
	}

    @When("the user wants to click on 'Invite people'")
    @Then("the user wants to click on 'Invite people'")
    public void clickOnInvitePeople() {
		alfrescoDocumentLibrarySteps.clickOnInvitePeople();
	}

    @Then("they should see the Add External Users section")
    public void  checkIfAddExternalUsersScetionExsits() {
        alfrescoInvitePeopleSteps.checkIfAddExternalUsersScetionExsits();
    }
    
    
	@Given("I wait [$seconds] seconds")
	@When("I wait [$seconds] seconds")
	@Then("I wait [$seconds] seconds")
	public void waitInSeconds(int seconds) {
		Sleeper.sleepTight(seconds * 1000);
	}

}
