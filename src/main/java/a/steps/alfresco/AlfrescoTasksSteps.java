package a.steps.alfresco;

import java.util.Date;

import a.pages.alfresco.AlfrescoTasksPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class AlfrescoTasksSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    public AlfrescoTasksSteps(Pages pages) {
        super(pages);
    }

    AlfrescoTasksPage alfrescoTasksPage;

    @Step
    public void clickOnSelectWorkflowButton() {
        alfrescoTasksPage.clickOnSelectWorkflowButton();
    }

    @Step
    public void selectWorkflowOption(String optionTitle) {
        alfrescoTasksPage.selectWorkflowOption(optionTitle);
    }

    @Step
    public void inputMessageField(String message) {
        alfrescoTasksPage.inputMessageField(message);
    }

    @Step
    public void inputDueDateField(String dueDate) {
        alfrescoTasksPage.inputDueDateField(dueDate);
    }

    @Step
    public void inputEditDueDateField(String editDueDate) {
        alfrescoTasksPage.inputEditDueDateField(editDueDate);
    }

    @Step
    public void clickOnSelectReviewerButton() {
        alfrescoTasksPage.clickOnSelectReviewerButton();
    }

    @Step
    public void selectReviewer(String userName) {
        alfrescoTasksPage.selectReviewer(userName);
    }

    @Step
    public void selectWorkflowType(String type) {
        alfrescoTasksPage.selectWorkflowType(type);
    }

    @Step
    public void saveWorkflowButon() {
        alfrescoTasksPage.saveWorkflowButon();
    }

    //	@Step
    //	public void clickOnAddFiles() {
    //		alfrescoTasksPage.clickOnAddFiles();
    //	}

    @Step
    public void clickOnTaskItemsActionButton(String action) {
        alfrescoTasksPage.clickOnTaskItemsActionButton(action);
    }

    @Step
    public void clickOnAcceptInvitationSiteButton() {
        alfrescoTasksPage.clickOnAcceptInvitationSiteButton();
    }

    @Step
    public void clickOnSaveAndCloseButton() {
        alfrescoTasksPage.clickOnSaveAndCloseButton();
    }

    @Step
    public void inputCommentField(String comment) {
        alfrescoTasksPage.inputCommentField(comment);
    }

    @Step
    public void clickOnApproveTaskButton() {
        alfrescoTasksPage.clickOnApproveTaskButton();
    }

    @Step
    public boolean clickOnApproveTaskButtonIfExists() {
        return alfrescoTasksPage.clickOnApproveTaskButtonIfExists();
    }

    @Step
    public void clickOnRejectTaskButton() {
        alfrescoTasksPage.clickOnRejectTaskButton();
    }

    @Step
    public boolean clickOnRejectTaskButtonIfExists() {
        return alfrescoTasksPage.clickOnRejectTaskButtonIfExists();
    }

    @Step
    public void checkRejectButtonIsDisabled() {
        alfrescoTasksPage.checkRejectButtonIsDisabled();
    }

    @Step
    public void selectWorkflowStatus(String status) {
        alfrescoTasksPage.selectWorkflowStatus(status);
    }

    @Step
    public void clickOnSelectStatus() {
        alfrescoTasksPage.clickOnSelectStatus();
    }

    //	@Step
    //	public void clickOnDownloadButton() {
    //		alfrescoTasksPage.clickOnDownloadButton();
    //	}
    //
    //	@Step
    //	public void clickOnSelectAllButton() {
    //		alfrescoTasksPage.clickOnSelectAllButton();
    //	}

    @Step
    public void inputFileNameZipField(String fileName) {
        alfrescoTasksPage.inputFileNameZipField(fileName);
    }

    @Step
    public void clickOnDownloadZipButton() {
        alfrescoTasksPage.clickOnDownloadZipButton();
    }

    @Step
    public void selectItemsAddedToWorkflow(String... items) {
        alfrescoTasksPage.selectItemsAddedToWorkflow(items);
    }

    @Step
    public void checkThatAllItemsAddedToWorkflowAreSelected() {
        alfrescoTasksPage.checkThatAllItemsAddedToWorkflowAreSelected();
    }

    @Step
    public void selectWorkflowFromList(String workflowName) {
        alfrescoTasksPage.selectWorkflowFromList(workflowName);
    }

    @Step
    public String getWorkflowID(String workflowSubject) {
        return alfrescoTasksPage.getWorkflowID(workflowSubject);
    }

    @Step
    public void cancelWorkflowFromList(String workflowName) {
        alfrescoTasksPage.cancelWorkflowFromList(workflowName);
    }

    @Step
    public void clickOnTaskAction(String workflowName, String action) {
        alfrescoTasksPage.clickOnTaskAction(workflowName, action);
    }

    @Step
    public void clickOnCancelWorkflowButton() {
        alfrescoTasksPage.clickOnCancelWorkflowButton();
    }

    @Step
    public void clickOnTaskDoneButton() {
        alfrescoTasksPage.clickOnTaskDoneButton();
    }

    @Step
    public void waitForFirstPageOfTasksListToLoad() {
        alfrescoTasksPage.waitForFirstPageOfTasksListToLoad();
    }

    @Step
    public boolean clickOnTaskDoneButtonIfExists() {
        return alfrescoTasksPage.clickOnTaskDoneButtonIfExists();
    }

    @Step
    public void verifyThatWorkflowExists(String workflowName) {
        alfrescoTasksPage.verifyThatWorkflowExists(workflowName);
    }

    @Step
    public boolean checkIfWorkflowExists(String workflowName) {
        return alfrescoTasksPage.checkIfWorkflowExists(workflowName);
    }

    @Step
    public void checkThatItemHasActions(String fileName, String... actionNames) {
        alfrescoTasksPage.checkThatItemHasActions(fileName, actionNames);
    }

    @Step
    public void selectPriority(String priority) {
        alfrescoTasksPage.selectPriority(priority);
    }

    @Step
    public void checkPriority(String priority) {
        alfrescoTasksPage.checkPriority(priority);
    }

    @Step
    public void clickOnDocumentActionFromTaskPage(String fileName,
            String actionName) {
        alfrescoTasksPage.clickOnDocumentActionFromTaskPage(fileName,
                actionName);
    }

    @Step
    public void checkPageTile(String title) {
        alfrescoTasksPage.checkPageTile(title);
    }

    @Step
    public void clickOnTaskFilter() {
        alfrescoTasksPage.clickOnTaskFilter();
    }

    @Step
    public void selectTaskFilter(String filter) {
        alfrescoTasksPage.selectTaskFilter(filter);
    }

    @Step
    public void checkTaskTypeInMyTaskPage(String workflowName, String type) {
        alfrescoTasksPage.checkTaskTypeInMyTaskPage(workflowName, type);
    }

    @Step
    public void checkTaskTypeInWorkflowDetailsPage(String type) {
        alfrescoTasksPage.checkTaskTypeInWorkflowDetailsPage(type);
    }

    @Step
    public void editPriorityFromDataList(String priority) {
        alfrescoTasksPage.editPriorityFromDataList(priority);
    }

    @Step
    public void editStatusFromDataList(String status) {
        alfrescoTasksPage.editStatusFromDataList(status);
    }

    @Step
    public void clickOnSaveButtonWhenYouEditTaskFromDataList() {
        alfrescoTasksPage.clickOnSaveButtonWhenYouEditTaskFromDataList();
    }

    @Step
    public void checkIfDateCorespondWithSystemTimeInDataList(String systemDate) {
        alfrescoTasksPage
                .checkIfDateCorespondWithSystemTimeInDataList(systemDate);
    }

    @Step
    public void checkIfDateCorespondsWithSystemTimeInDataList(Date systemDate) {
        alfrescoTasksPage
                .checkIfDateCorespondsWithSystemTimeInDataList(systemDate);
    }

    @Step
    public void checkWorkflowSubjectFromWorkflowDetailsPage(String subject) {
        alfrescoTasksPage.checkWorkflowSubjectFromWorkflowDetailsPage(subject);
    }

    @Step
    public void checkWorkflowSubjectFromTaskDetailsPage(String subject) {
        alfrescoTasksPage.checkWorkflowSubjectFromTaskDetailsPage(subject);
    }

    @Step
    public void inputDocumentName(String name) {
        alfrescoTasksPage.inputDocumentName(name);
    }

    @Step
    public void inputComponentnameInLifecyleReport(String name) {
        alfrescoTasksPage.inputComponentnameInLifecyleReport(name);
    }

    @Step
    public void clickOnFilterButton() {
        alfrescoTasksPage.clickOnFilterButton();
    }

    @Step
    public void selectLifecycleStage(String lifecycle) {
        alfrescoTasksPage.selectLifecycleStage(lifecycle);
    }

    @Step
    public void selectTaskStatus(String status) {
        alfrescoTasksPage.selectTaskStatus(status);
    }

    @Step
    public void clickOnSelectLasModifierOrWorkflowInitiatorButton() {
        alfrescoTasksPage.clickOnSelectLasModifierOrWorkflowInitiatorButton();
    }

    @Step
    public void clickOnSelectWorkflowInitiatorButton() {
        alfrescoTasksPage.clickOnSelectLasModifierOrWorkflowInitiatorButton();
    }

    @Step
    public void selectLastModifier(String modifier) {
        alfrescoTasksPage.selectLastModifier(modifier);
    }

    @Step
    public void selectWorkflowInitiator(String initiator) {
        alfrescoTasksPage.selectWorkflowInitiator(initiator);
    }

    @Step
    public void selectWorkflowAssignedTo(String username) {
        alfrescoTasksPage.selectWorkflowAssignedTo(username);
    }

    @Step
    public void clickOnAssignedToButton() {
        alfrescoTasksPage.clickOnAssignedToButton();
    }

    @Step
    public void clickOnClearFiltersButton() {
        alfrescoTasksPage.clickOnClearFiltersButton();
    }

    @Step
    public void inputComponentNameInDataList(String component) {
        alfrescoTasksPage.inputComponentNameInDataList(component);
    }

    @Step
    public void verifyTaskMessage(String taskMessage) {
        alfrescoTasksPage.verifyTaskMessage(taskMessage);
    }
}
