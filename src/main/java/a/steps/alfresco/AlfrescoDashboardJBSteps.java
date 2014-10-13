package a.steps.alfresco;

import java.awt.AWTException;
import java.util.Date;

import a.tools.alfresco.AbstractJBSteps;
import a.tools.alfresco.Constants;
import a.tools.alfresco.DateUtils;

public class AlfrescoDashboardJBSteps extends AbstractJBSteps {
	
    public void loginToAlfrescoWithAdminCredentials() {
        alfrescoLoginSteps.openLoginPage(Constants.SHARE_URL);
        alfrescoLoginSteps.enterUsername(Constants.ALFRESCO_ADMIN_USERNAME);
        alfrescoLoginSteps.enterPassword(Constants.ALFRESCO_ADMIN_PASSWORD);
        alfrescoLoginSteps.clickLoginButton();
    }

    public void loginWithUsernameAndPassword(String username, String password) {
        alfrescoLoginSteps.openLoginPage(Constants.SHARE_URL);
        alfrescoLoginSteps.enterUsername(username);
        alfrescoLoginSteps.enterPassword(password);
        alfrescoLoginSteps.clickLoginButton();
    }

    public void openAlfrescoLoginPage() {
        alfrescoLoginSteps.openLoginPage(Constants.SHARE_URL);
    }

    public void enterUsernameInTheUsernameField(String username) {
        alfrescoLoginSteps.enterUsername(username);
    }

    public void enterPasswordInThePasswordField(String password) {
        alfrescoLoginSteps.enterPassword(password);
    }

    public void clickLoginButton() {
        alfrescoLoginSteps.clickLoginButton();
    }

    public void verifyHeaderUserName(String firstName) {
        alfrescoDashboardSteps.verifyUserButtonProperties(firstName, "");
    }
    
    public void verifyHeaderUserNames(String firstName, String lastName) {
        alfrescoDashboardSteps.verifyUserButtonProperties(firstName, lastName);
    }
    
    public void logOutFromAlfresco() {
        alfrescoDashboardSteps.logout();
        alfrescoLoginSteps.verifyLoginPageIsOpen();
    }

    public void logOutFromAlfrescoIfLoggedIn() throws AWTException {
        if (alfrescoDashboardSteps.logoutIfLoggedIn())
            alfrescoLoginSteps.verifyLoginPageIsOpen();
    }

    public void logOutFromAlfrescoIfLoogedIn() {
        if (alfrescoDashboardSteps.checkIfUserIsLoggedIn()) {
            alfrescoDashboardSteps.logout();
            alfrescoLoginSteps.verifyLoginPageIsOpen();
        }
    }

    public void verifyThatTheLoginPageIsDisplayedTheUsernameAndThePasswordFieldsAreBlank() {
        alfrescoLoginSteps.verifyThatUsernameFieldIsEmpty();
        alfrescoLoginSteps.verifyThatPasswordFieldIsEmpty();
    }

    public void verifySystemErrorMessage(String error_message) {
        alfrescoLoginSteps.verifyThatTheErrorMessageIsDisplayed();
        alfrescoLoginSteps
                .verifyThatTheCorrectErrorMessageIsDisplayed(error_message);
    }

    public void thenIVerifyTheTaskNameOnDashboard(String taskName) {
        alfrescoDashboardSteps.verifyMyNewTask(taskName);
    }

    public void checkTaskNameAndStatus(String taskName, String taskStatus) {
        alfrescoDashboardSteps.checkTaskStatus(taskName, taskStatus);
    }

    public void checkTaskNameAndWarningNotification(String taskName) {
        alfrescoDashboardSteps.checkTaskWarningNotification(taskName);
    }

    public void checkThatTheTaskIsNotInTheDashlet(String taskIdentifiers) {
        alfrescoDashboardSteps.verifyThatTheTaskIsNotInTheDashlet(getVarargs(
                taskIdentifiers, ", "));
    }

    public void navigateToMyDashboard() {
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Home");
    }

    public void selectTaskFromDashboard(String taskIdentifiers) {
        alfrescoDashboardSteps
                .selectTaskFromDashboard(getVarargs(taskIdentifiers));
    }

   public void clickOnDashboardHeaderButton(String buttonTitles) {
        alfrescoDashboardSteps
                .clickOnDashboardHeaderButton(getVarargs(buttonTitles));
    }

    public void closeNewestOpenedTabIfExists() {
        alfrescoDashboardSteps.closeNewestOpenedTabIfExists();
    }

    public void navigateToDocumentFromRepository(String documentName) {
        alfrescoDashboardSteps.clickOnRepositoryItem();
        alfrescoDocumentLibrarySteps
                .selectDocumentFromDocumentLibrary(getVarargs(documentName));
       
    }

    public void navigateToDocumentLibrary(String title) {
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Home");
        alfrescoDashboardSteps.selectSiteFromDashboard(title);
        alfrescoSiteSteps.selectSiteNavigationItem(Constants.DOCUMENT_LIBRARY);
    }

    public void navigateToSiteDasboard(String site) {
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Home");
        alfrescoDashboardSteps.selectSiteFromDashboard(site);
    }

    public void navigateToDocumentLibrary() {
        alfrescoSiteSteps.selectSiteNavigationItem(Constants.DOCUMENT_LIBRARY);
    }

    public void searchAndSelectSite(String name) {
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Sites",
                "Site Finder");
        alfrescoDashboardSteps.insertSiteNameForSearch(name);
        alfrescoDashboardSteps.selectSiteFromResults(name);
    }

    public void searchJoinAndSelectSite(String siteName, String username) {
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Sites",
                "Site Finder");
        alfrescoDashboardSteps.insertSiteNameForSearch(siteName);
        alfrescoDashboardSteps.clickOnJoinSiteFromResults(username, siteName);
        alfrescoDashboardSteps.selectSiteFromResults(siteName);
    }

    public void searchAndLeaveSite(String siteName, String username) {
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Sites",
                "Site Finder");
        alfrescoDashboardSteps.insertSiteNameForSearch(siteName);
        alfrescoDashboardSteps.clickOnLeaveSiteFromResults(username, siteName);
    }

    public void navigateToSectionFromConsole(String option) {
        alfrescoDashboardSteps.selectSectionFromConsole(option);
    }
    public void navigateToActivitiWorkflowConsolePage() {
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("More...",
                "More...");
        alfrescoDashboardSteps.selectSectionFromConsole("Workflow");
        alfrescoDashboardSteps.clickOnActivitiWorkflowConsoleLink();
        alfrescoDocumentLibrarySteps.switchToNewestOpenedTab();
        String url = alfrescoDashboardSteps
                .getDriver()
                .getCurrentUrl()
                .replace("http://localhost:8080",
                        Constants.ALFRESCO_API_BASE_URL);
        alfrescoDashboardSteps.getDriver().get(url);
    }

    public void addNewCategory(String category) {
        alfrescoDashboardSteps.clickOnAddCategoryIcon();
    }

    public void navigateToAdvancedSearch() {
        alfrescoDashboardSteps.clickOnSearchIcon();
        alfrescoDashboardSteps.clickOnAdvancedSearchLink();
    }

    public void checkIfDocumentIsPresentInResultsList(String docName) {
        alfrescoSearchSteps.checkThatDocumentIsPresentInResultsList(docName);
    }

    public void checkIfDocumentIsNotPresentInResultsList(String docName) {
        alfrescoSearchSteps.checkThatDocumentIsNotPresentInResultsList(docName);
    }

    public void deleteCategory(String category) {
        alfrescoDashboardSteps.deleteCategory(category);
        alfrescoFilePreviewSteps.verifyPopupMessage(String.format(
                "Are you sure you want to delete: %s?",
                getVarargs(category)[getVarargs(category).length - 1]));
        alfrescoFilePreviewSteps.clickOnPopupButton("Delete");
    }

    public void clickOnSiteActionButton(String labels) {
        alfrescoSiteSteps.clickOnSiteActionButton(getVarargs(labels));
    }

    public void addDataListPageToTheSite() {
        alfrescoSiteSteps.clickOnSiteActionButton("Customize Site");
        alfrescoSiteSteps.dragAvailableSitePageToCurrentSitePages("Data List");
        alfrescoSiteSteps.clickOnCustomizeSiteOkButton();
    }

    public void typeUserNameToSearch(String userName) {
        alfrescoSearchSteps.inputModifierField(userName);
    }

    public void typeFileNameToSearch(String fileName) {
        alfrescoSearchSteps.inputNameField(fileName);
    }

    public void typeKeywordToSearch(String keyword) {
        alfrescoSearchSteps.insertSearchKeyword(keyword);
    }

    public void insertAdvancedKeyword(String keyword) {
        alfrescoSearchSteps.insertAdvancedKeyword(keyword);
    }

    public void clickOnSearchButtonFromResultsList() {
        alfrescoSearchSteps.clickOnSearchButtonFromResultsList();
    }

    public void typeStartingDateAndEndingDateToSearch(String dateFrom,
            String dateTo) {
        alfrescoSearchSteps.insertDateSearchFrom(DateUtils.toString(
                DateUtils.addDays(new Date(), Integer.parseInt(dateFrom)),
                "dd MMM yyyy"));
        alfrescoSearchSteps.insertDateSearchTo(DateUtils.toString(
                DateUtils.addDays(new Date(), Integer.parseInt(dateTo)),
                "dd MMM yyyy"));
    }

    public void selectTypeToSearch(String fileType) {
        alfrescoSearchSteps.clickOnMimetype();
        alfrescoSearchSteps.selectMimeType(fileType);
    }

    public void checkDocumentStatusInMyDocumentsSection(String docName,
            String actionName, String siteName) {
        alfrescoDashboardSteps.checkDocumentStatusInMyDocumentsList(docName,
                actionName, siteName);
    }

    public void checkTheResultsNumber(String number) {
        alfrescoSearchSteps.checkTheNumberOfSearchResults(number);
    }

    public void checkThatMenuOptionDoesntExists() {
        alfrescoDashboardSteps.checkThatMenuOptionDoesntExists("Sites",
                "Create Site");
    }
}
