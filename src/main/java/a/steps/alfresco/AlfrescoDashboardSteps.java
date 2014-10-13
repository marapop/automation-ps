package a.steps.alfresco;

import java.awt.AWTException;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import org.junit.Assert;

import a.tools.alfresco.Constants;
import a.pages.alfresco.AlfrescoDashboardPage;

public class AlfrescoDashboardSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    public AlfrescoDashboardSteps(Pages pages) {
        super(pages);
    }

    private AlfrescoDashboardPage alfrescoDashboardPage;

    @Step
    public void verifyUserButtonProperties(String userName, String lastName) {
        alfrescoDashboardPage.verifyLoggedInUserDisplayedName(userName,
                lastName);
    }

    @Step
    public void verifyMyNewSite(String siteName) {
        Assert.assertTrue("The site named '" + siteName
                + "' was not found on dashboard!",
                alfrescoDashboardPage.isSiteOnDashboard(siteName));
    }

    @Step
    public void verifyAfterDeleteTheSite(String siteName) {
        Assert.assertFalse("The site named '" + siteName
                + "' should not be listed on dashboard!",
                alfrescoDashboardPage.isSiteOnDashboard(siteName));
    }
    
    @Step
    public void clickSiteFinder() {
    	alfrescoDashboardPage.clickSiteFinder();
    }
    
    @Step
    public void searchTheSiteCreatedByOther(String siteName) {
    	alfrescoDashboardPage.searchTheSiteCreatedByOther(siteName);
    }
    
    @Step
    public boolean isSiteOnDashboard(String siteName) {
    	 return alfrescoDashboardPage.isSiteOnDashboard(siteName);
    }
    
    @Step("Select site from dashboard")
	public void selectSiteOnDashboard(String siteName) {
		alfrescoDashboardPage.selectSiteFromDashboard(siteName);
	}
    
	@Step
	public void openSiteModal(String siteName) {
		String siteUrl = System.getProperty(Constants.URL_PROPERTY);
		if(siteUrl.contains("null")){
			siteUrl = Constants.ALFRESCO_URL;
		}
		getDriver().get(siteUrl + Constants.SITE_PREFIX + siteName.toLowerCase() + Constants.SITE_SUFIX);
		waitABit(Constants.WAIT_TIME_SHORT);
	}
	
	 @Step
	    public void openTheSiteFound(String siteName) {
	    	alfrescoDashboardPage.openTheSiteFound(siteName);
	    }


    @Step
    public void selectSiteFromDashboard(String siteName) {
        alfrescoDashboardPage.selectSiteFromDashboard(siteName);
    }

    @Step
    public void verifyMyNewTask(String taskName) {
        Assert.assertTrue("The task named '" + taskName
                + "' was not found on dashboard",
                alfrescoDashboardPage.isTaskOnDashboard(taskName));
    }

    @Step
    public void checkTaskStatus(String taskName, String taskStatus) {
        Assert.assertTrue("The task named '" + taskName
                + "' was not found on dashboard and the '" + taskStatus
                + "' is not correct",
                alfrescoDashboardPage.checkTaskStatus(taskName, taskStatus));
    }

    @Step
    public void checkTaskWarningNotification(String taskname) {
        alfrescoDashboardPage.checkTaskWarningNotification(taskname);
    }

    @Step
    public void selectTaskFromDashboard(String... taskIdentifiers) {
        alfrescoDashboardPage.selectTaskFromDashboard(taskIdentifiers);
    }

    @Step
    public void verifyThatTheTaskIsNotInTheDashlet(String... taskIdentifiers) {
        alfrescoDashboardPage.verifyThatTheTaskIsNotInTheDashlet(taskIdentifiers);
    }

    @Step
    public boolean checkIfUserIsLoggedIn() {
        return alfrescoDashboardPage.checkIfUserIsLoggedIn();
    }

    @Step
    public void logout() {
        alfrescoDashboardPage.logout();
    }
    
    @Step
    public void clickOnAcceptInvitation(){
    	alfrescoDashboardPage.clickOnAcceptInvitation();
    }
    
    @Step
    public void acceptRoleInvitation(){
    	alfrescoDashboardPage.acceptRoleInvitation();
    }

    @Step
    public boolean logoutIfLoggedIn() throws AWTException {
        return alfrescoDashboardPage.logoutIfLoggedIn();
    }

    @Step
    public void clickOnStartWorkflowItem() {
        alfrescoDashboardPage.clickOnStartWorkflowItem();
    }

    @Step
    public void closeNewestOpenedTabIfExists() {
        alfrescoDashboardPage.closeNewestOpenedTabIfExists();
    }

    @Step
    public void clickOnDashboardHeaderButton(String... buttonTitles) {
        alfrescoDashboardPage.clickOnDashboardHeaderButton(buttonTitles);
    }

    @Step
    public void clickOnRepositoryItem() {
        alfrescoDashboardPage.clickOnRepositoryItem();
    }

    @Step
    public void insertSiteNameForSearch(String name) {
        alfrescoDashboardPage.insertSiteNameForSearch(name);
    }

    @Step
    public void selectSiteFromResults(String name) {
        alfrescoDashboardPage.selectSiteFromResults(name);
    }

    @Step
    public void clickOnJoinSiteFromResults(String username, String siteName) {
        alfrescoDashboardPage.clickOnJoinSiteFromResults(username, siteName);
    }

    @Step
    public void clickOnLeaveSiteFromResults(String username, String siteName) {
        alfrescoDashboardPage.clickOnLeaveSiteFromResults(username, siteName);
    }

    @Step
    public void selectSectionFromConsole(String term) {
        alfrescoDashboardPage.selectSectionFromConsole(term);
    }

    @Step
    public void clickOnAddCategoryIcon() {
        alfrescoDashboardPage.clickOnAddCategoryIcon();
    }

    @Step
    public void clickOnSearchIcon() {
        alfrescoDashboardPage.clickOnSearchIcon();
    }

    @Step
    public void clickOnAdvancedSearchLink() {
        alfrescoDashboardPage.clickOnAdvancedSearchLink();
    }

    @Step
    public void clickOnActivitiWorkflowConsoleLink() {
        alfrescoDashboardPage.clickOnActivitiWorkflowConsoleLink();
    }

    @Step
    public void deleteCategory(String catName) {
        alfrescoDashboardPage.deleteCategory(catName);
    }

    @Step
    public void checkDocumentStatusInMyDocumentsList(String docName,
            String actionName, String siteName) {
        alfrescoDashboardPage.checkDocumentStatusInMyDocumentsList(docName,
                actionName, siteName);
    }

    @Step
    public void checkThatMenuOptionDoesntExists(String... menuOption) {
        alfrescoDashboardPage.checkThatMenuOptionDoesntExists(menuOption);
    }
}
