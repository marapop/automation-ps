package a.jbehave;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.AfterScenario;
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
	public void loginAndNavigatetoDocumentLibrary(String userName,
			String password, String siteName) {
		alfrescoLoginSteps.openLoginPage(Constants.ALFRESCO_URL);
		alfrescoLoginSteps.login(userName, password);
		if (alfrescoDashboardSteps.isSiteOnDashboard(siteName)) {
			alfrescoDashboardSteps.selectSiteOnDashboard(siteName);
		} else {
			alfrescoDashboardSteps.clickSiteFinder();
			alfrescoDashboardSteps.searchTheSiteCreatedByOther(siteName);
			alfrescoDashboardSteps.openTheSiteFound(siteName);
		}
	}

	@Given("I log in with user [$userName] and password [$password]")
	@When("I log in with user [$userName] and password [$password]")
	public void login(String userName, String password) {
		alfrescoLoginSteps.openLoginPage(Constants.ALFRESCO_URL);
		alfrescoLoginSteps.login(userName, password);
	}

	@When("the user wants to click on 'Invite people'")
	@Then("the user wants to click on 'Invite people'")
	public void clickOnInvitePeople() throws Exception {
		alfrescoDashboardSteps.invitePeopleButton();
	}

	@When("I click on 'Create a site' in the User Dashboard screen")
	public void clickCreateSiteFromUserDashboard() {
		alfrescoDashboardSteps.clickCreateSiteFromUserDashboard();
	}

	@When("I click on the 'Create a site' action in the the 'Sites' menu from Alfresco header")
	public void clickCreateSiteFromSitesMenu() {
		alfrescoDashboardSteps.clickCreateSiteFromSitesMenu();
	}

	@When("I cannot see the 'Create a site' button in the the 'Sites' menu from Alfresco header")
	@Then("I cannot see the 'Create a site' button in the the 'Sites' menu from Alfresco header")
	public void checkCreateSite() throws Exception {
		alfrescoDashboardSteps.checkCreateSite();
	}

	@Given("[$searchedUserName] is not part of Administrator and Ixxus Staff")
	@When("[$searchedUserName] is not part of Administrator and Ixxus Staff")
	@Then("[$searchedUserName] is not part of Administrator and Ixxus Staff")
	public void deleteGroup(String searchedUserName) {
		alfrescoDashboardSteps.deleteGroup(searchedUserName);
	}

	@Then("the pop-up 'Create Site' should appear")
	public void verifyIfTheCreateSitePopUpAppear() {
		alfrescoDashboardSteps.verifyIfTheCreateSitePopUpAppear();
	}

	@Then("I should be able to create a public site named [$siteName1]")
	public void createSite(String siteName1) {
		alfrescoDashboardSteps.createSite(siteName1);
	}

	@Given("[$searchedUserName] is part of [$groupName]")
	@When("[$searchedUserName] is part of [$groupName]")
	@Then("[$searchedUserName] is part of [$groupName]")
	public void addGroup(String groupName, String searchedUserName) {
		alfrescoDashboardSteps.addGroup(groupName, searchedUserName);
	}

	@Then("the site named [$siteName] is present in MySites")
	public void verifyMyNewSite(String siteName){
		alfrescoDashboardSteps.verifyMyNewSite(siteName);
	}
	
	@Given("I log out")
	public void clickOnLogOut() {
		alfrescoDashboardSteps.clickOnLogOut();
	}

	@AfterScenario
	public void afterEachScenario() {
		alfrescoLoginSteps.closeBrowser();
	}

	@Then("they should see the Add External Users section")
	public void checkIfAddExternalUsersScetionExsits() {
		alfrescoInvitePeopleSteps.checkIfAddExternalUsersScetionExsits();
	}

	@Then("the user cannot see the 'Invite people' button")
	public void checkInvitePeople() throws Exception {
		alfrescoDashboardSteps.checkInvitePeople();
	}

	@Given("I wait [$seconds] seconds")
	@When("I wait [$seconds] seconds")
	@Then("I wait [$seconds] seconds")
	public void waitInSeconds(int seconds) {
		Sleeper.sleepTight(seconds * 1000);
	}

}
