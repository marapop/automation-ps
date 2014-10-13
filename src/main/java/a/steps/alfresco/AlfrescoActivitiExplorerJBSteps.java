package a.steps.alfresco;

import a.tools.alfresco.AbstractJBSteps;
import a.tools.alfresco.Constants;

public class AlfrescoActivitiExplorerJBSteps extends AbstractJBSteps {

    public void selectCategoryFromToolbar(String categoryTitle) {
        activitiExplorerSteps.selectCategoryFromToolbar(categoryTitle);
    }

    public void verifyWorkflowSite(String workflowSubject, String site) {
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Tasks",
                "Workflows I've Started");
        String workflowID = alfrescoTasksSteps.getWorkflowID(workflowSubject);
        alfrescoLoginSteps
                .navigateToUrl(Constants.ACTIVITY_WORKFLOW_CONSOLE_URL);
        activitiExplorerSteps.switchToLoginIframe();
        activitiExplorerSteps.insertUserName(Constants.ALFRESCO_ADMIN_USERNAME);
        activitiExplorerSteps.insertPassword(Constants.ALFRESCO_ADMIN_PASSWORD);
        activitiExplorerSteps.clickOnLoginButton();
        activitiExplorerSteps.selectCategoryFromToolbar("Process instances");
        activitiExplorerSteps.selectWorkflowFromList(
                workflowID);
        //		activitiExplorerSteps.selectWorkflowFromList(workflowMessage,
        //				workflowID);
        activitiExplorerSteps.verifyWorkflowSubject(workflowSubject);
        activitiExplorerSteps.verifyWorkflowSite(site);
        // alfrescoDocumentLibrarySteps.closeNewestOpenedTab();
        alfrescoLoginSteps.navigateToUrl(Constants.SHARE_URL);
    }
}
