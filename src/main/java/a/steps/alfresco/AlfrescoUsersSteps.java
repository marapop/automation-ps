package a.steps.alfresco;

import junit.framework.Assert;
import a.pages.alfresco.AlfrescoUsersPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("deprecation")
public class AlfrescoUsersSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    public AlfrescoUsersSteps(Pages pages) {
        super(pages);
    }

    private AlfrescoUsersPage alfrescoUsersPage;

    @Step
    public void inputSearchUser(String username) {
        alfrescoUsersPage.inputSearchField(username);

    }

    @Step
    public void clickOnSearchButton() {
        alfrescoUsersPage.clickOnSearchButton();
    }

    @Step
    public void selectUserFromSearchResults(String... identifiers) {
        alfrescoUsersPage.selectUserFromSearchResults(identifiers);
    }

    @Step
    public void clickOnNewUserButton() {
        alfrescoUsersPage.clickOnNewUserButton();
    }

    @Step
    public void clickOnDeleteUserButton() {
        alfrescoUsersPage.clickOnDeleteUserButton();
    }

    @Step
    public void clickOnEditUserButton() {
        alfrescoUsersPage.clickOnEditUserButton();
    }

    @Step
    public void inputFirstName(String firstName) {
        alfrescoUsersPage.inputFirstNameField(firstName);
    }

    @Step
    public void inputLastNameField(String lastName) {
        alfrescoUsersPage.inputLastNameField(lastName);
    }

    @Step
    public void inputEmail(String email) {
        alfrescoUsersPage.inputEmailField(email);
    }

    @Step
    public void inputUserName(String userName) {
        alfrescoUsersPage.inputUserNameField(userName);
    }

    @Step
    public void inputPassword(String password) {
        alfrescoUsersPage.inputPasswordField(password);
    }

    @Step
    public void inputVerifyPassword(String verifyPassword) {
        alfrescoUsersPage.inputVerifyPasswordField(verifyPassword);
    }

    @Step
    public void clickOnCreateUserButton() {
        alfrescoUsersPage.clickOnCreateUserButton();
    }

    @Step
    public void enterNameForSearchPeople(String firstName) {
        alfrescoUsersPage.enterNameForSearchPeople(firstName);
    }

    @Step
    public void insertSearchForGroupKeyword(String searchTerm) {
        alfrescoUsersPage.insertSearchForGroupKeyword(searchTerm);
    }

    @Step
    public void clickOnSearchPeopleButton() {
        alfrescoUsersPage.clickOnSearchPeopleButton();
    }

    @Step
    public void verifyThatUserExistsInSearchResults(String... identifiers) {
        Assert.assertTrue(alfrescoUsersPage
                .checkIfUserExistsInSearchResultsForInvite(identifiers));
    }

    @Step
    public void verifyThatUserDoesntExistInSearchResults(String... identifiers) {
        Assert.assertFalse(alfrescoUsersPage
                .checkIfUserExistsInSearchResultsForInvite(identifiers));
    }

    @Step
    public void selectUserFromSearchResultsForInvite(String... identifiers) {
        alfrescoUsersPage.selectUserFromSearchResultsForInvite(identifiers);
    }

    @Step
    public void selectGroupFromSearchResultsForInvite(String... identifiers) {
        alfrescoUsersPage.selectGroupFromSearchResultsForInvite(identifiers);
    }

    @Step
    public void clickOnInvitePeopleButton() {
        alfrescoUsersPage.clickOnInvitePeopleButton();
    }

    @Step
    public void selectRoleForUser(String userRole, String... identifiers) {
        alfrescoUsersPage.selectRoleForUser(userRole, identifiers);
    }

    @Step
    public void verifyThatTheUserHasBeenAssignedToGroups(String... groups) {
        alfrescoUsersPage.verifyThatTheUserHasBeenAssignedToGroups(groups);
    }

    @Step
    public void clickOnInviteButton() {
        alfrescoUsersPage.clickOnInviteButton();
    }
}
