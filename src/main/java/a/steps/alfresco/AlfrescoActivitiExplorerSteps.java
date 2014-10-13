package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import a.pages.alfresco.AlfrescoActivitiExplorerPage;

public class AlfrescoActivitiExplorerSteps {

    private AlfrescoActivitiExplorerPage activitiExplorerPage;

    @Step
    public void selectCategoryFromToolbar(String categoryTitle) {
        activitiExplorerPage.selectCategoryFromToolbar(categoryTitle);
    }

    @Step
    public void selectWorkflowFromList(String workflowID) {
        activitiExplorerPage.selectWorkflowFromList(workflowID);
    }

    @Step
    public void verifyWorkflowMessage(String message) {
        activitiExplorerPage.verifyWorkflowMessage(message);
    }

    @Step
    public void verifyWorkflowSubject(String subject) {
        activitiExplorerPage.verifyWorkflowSubject(subject);
    }

    @Step
    public void verifyWorkflowSite(String site) {
        activitiExplorerPage.verifyWorkflowSite(site);
    }

    @Step
    public void switchToLoginIframe() {
        activitiExplorerPage.switchToLoginIframe();
    }

    @Step
    public void insertUserName(String userName) {
        activitiExplorerPage.insertUserName(userName);
    }

    @Step
    public void insertPassword(String password) {
        activitiExplorerPage.insertPassword(password);
    }

    @Step
    public void clickOnLoginButton() {
        activitiExplorerPage.clickOnLoginButton();
    }
}
