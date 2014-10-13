package a.steps.alfresco;

import a.tools.alfresco.AbstractJBSteps;

public class AlfrescoGroupsJBSteps extends AbstractJBSteps {

    public void createAnAlfrescoGroup(String identifier, String displayName)
            throws Exception {
        if (alfrescoHttpHelper.checkIfGroupExists(identifier))
            alfrescoHttpHelper.deleteGroup(identifier);
        alfrescoGroupsSteps.clickOnBrowseButton();
        alfrescoGroupsSteps.clickOnNewGroupButton();
        alfrescoGroupsSteps.insertGroupIdentifier(identifier);
        alfrescoGroupsSteps.insertGroupName(displayName);
        alfrescoGroupsSteps.clickOnCreateGroupButton();
    }
}
