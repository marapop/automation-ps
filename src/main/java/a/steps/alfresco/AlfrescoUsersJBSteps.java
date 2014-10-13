package a.steps.alfresco;

import a.tools.alfresco.AbstractJBSteps;

public class AlfrescoUsersJBSteps extends AbstractJBSteps {

    public void createAnAlfrescoUser(String firstName, String lastName,
            String email, String userName, String password) throws Exception {
        if (alfrescoHttpHelper.checkIfUserExists(userName))
            alfrescoHttpHelper.deleteUser(userName);
        alfrescoUsersSteps.clickOnNewUserButton();
        alfrescoUsersSteps.inputFirstName(firstName);
        alfrescoUsersSteps.inputLastNameField(lastName);
        alfrescoUsersSteps.inputEmail(email);
        alfrescoUsersSteps.inputUserName(userName);
        alfrescoUsersSteps.inputPassword(password);
        alfrescoUsersSteps.inputVerifyPassword(password);
        alfrescoUsersSteps.clickOnCreateUserButton();
    }

    public void createAnAlfrescoUser(String firstName, String lastName,
            String email, String userName, String password, String groups)
            throws Exception {
        if (alfrescoHttpHelper.checkIfUserExists(userName))
            alfrescoHttpHelper.deleteUser(userName);
        alfrescoUsersSteps.clickOnNewUserButton();
        alfrescoUsersSteps.inputFirstName(firstName);
        alfrescoUsersSteps.inputLastNameField(lastName);
        alfrescoUsersSteps.inputEmail(email);
        alfrescoUsersSteps.inputUserName(userName);
        alfrescoUsersSteps.inputPassword(password);
        alfrescoUsersSteps.inputVerifyPassword(password);
        for (String group : getVarargs(groups)) {
            alfrescoUsersSteps.insertSearchForGroupKeyword(group);
            alfrescoUsersSteps.clickOnSearchPeopleButton();
            alfrescoUsersSteps.selectGroupFromSearchResultsForInvite(group);
        }
        alfrescoUsersSteps
                .verifyThatTheUserHasBeenAssignedToGroups(getVarargs(groups));
        alfrescoUsersSteps.clickOnCreateUserButton();
    }

    public void inviteUserToSite(String userName, String userRole) {
        alfrescoUsersSteps.clickOnInvitePeopleButton();
        alfrescoUsersSteps.enterNameForSearchPeople(userName);
        alfrescoUsersSteps.clickOnSearchPeopleButton();
        alfrescoUsersSteps.selectUserFromSearchResultsForInvite(userName);
        alfrescoUsersSteps.selectRoleForUser(userRole, userName);
        alfrescoUsersSteps.clickOnInviteButton();
    }
}
