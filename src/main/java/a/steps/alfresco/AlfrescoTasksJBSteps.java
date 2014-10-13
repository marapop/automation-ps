package a.steps.alfresco;

import java.util.Date;

import a.tools.alfresco.AbstractJBSteps;
import a.tools.alfresco.DateUtils;

public class AlfrescoTasksJBSteps extends AbstractJBSteps {
   
    public void startAWorkflowOfGivenType(String type) {
        alfrescoTasksSteps.clickOnSelectWorkflowButton();
        alfrescoTasksSteps.selectWorkflowType(type);
    }

    public void createWorkflow(String message, String subject,
            String dueDateDaysInFuture, String userName) {
        alfrescoTasksSteps.inputMessageField(message);
        alfrescoTasksSteps.inputDueDateField(DateUtils.toString(
                DateUtils.addDays(new Date(),
                        Integer.parseInt(dueDateDaysInFuture)), "dd MMM yyyy"));
        alfrescoTasksSteps.clickOnSelectReviewerButton();
        alfrescoTasksSteps.selectReviewer(userName);
        alfrescoTasksSteps.saveWorkflowButon();
    }

    public void createWorkflowWithPriority(String message, String subject,
            String dueDateDaysInFuture, String priority, String userName) {
        alfrescoTasksSteps.inputMessageField(message);
        alfrescoTasksSteps.inputDueDateField(DateUtils.toString(
                DateUtils.addDays(new Date(),
                        Integer.parseInt(dueDateDaysInFuture)), "dd MMM yyyy"));
        alfrescoTasksSteps.selectPriority(priority);
        alfrescoTasksSteps.clickOnSelectReviewerButton();
        alfrescoTasksSteps.selectReviewer(userName);
        alfrescoTasksSteps.saveWorkflowButon();
    }

    public void completeTheWorkflowFields(String message, String subject,
            String dueDateDaysInFuture, String userName) {
        alfrescoTasksSteps.inputMessageField(message);
        alfrescoTasksSteps.inputDueDateField(DateUtils.toString(
                DateUtils.addDays(new Date(),
                        Integer.parseInt(dueDateDaysInFuture)), "dd MMM yyyy"));
        alfrescoTasksSteps.clickOnSelectReviewerButton();
        alfrescoTasksSteps.selectReviewer(userName);
    }

    public void saveWorkflow() {
        alfrescoTasksSteps.saveWorkflowButon();
    }

    public void selectPriorityForWorkflow(String priority) {
        alfrescoTasksSteps.selectPriority(priority);
    }

    public void clickToAddFiles() {
        alfrescoTasksSteps.clickOnTaskItemsActionButton("Add");
    }

    public void changeDueDate(String dueDateDaysInFuture) {
        alfrescoTasksSteps.inputEditDueDateField(DateUtils.toString(
                DateUtils.addDays(new Date(),
                        Integer.parseInt(dueDateDaysInFuture)), "dd MMM yyyy"));
        alfrescoTasksSteps.clickOnSaveAndCloseButton();
    }

    public void acceptInvitationToSIte() {
        alfrescoTasksSteps.clickOnAcceptInvitationSiteButton();
    }

    public void addCommentAndApproveTask(String comment) {
        alfrescoTasksSteps.inputCommentField(comment);
        alfrescoTasksSteps.clickOnApproveTaskButton();
    }

    public void clickOnApproveButton() {
        alfrescoTasksSteps.clickOnApproveTaskButton();
    }

    public void addCommentAndRejectTask(String comment) {
        alfrescoTasksSteps.inputCommentField(comment);
        alfrescoTasksSteps.clickOnRejectTaskButton();
    }

    public void checkThatRejectButtonIsDisabled() {
        alfrescoTasksSteps.checkRejectButtonIsDisabled();
    }

    public void selectWorkflowStatus(String status) {
        alfrescoTasksSteps.clickOnSelectStatus();
        alfrescoTasksSteps.selectWorkflowStatus(status);
        alfrescoTasksSteps.clickOnSaveAndCloseButton();
    }

    public void downloadAllFilesAsZip(String fileName) {
        alfrescoTasksSteps.clickOnTaskItemsActionButton("Select All");
        alfrescoTasksSteps.checkThatAllItemsAddedToWorkflowAreSelected();
        alfrescoTasksSteps.clickOnTaskItemsActionButton("Download");
        alfrescoTasksSteps.inputFileNameZipField(fileName);
        alfrescoTasksSteps.clickOnDownloadZipButton();
    }

    public void downloadSpecifiedFilesAsZip(String files, String fileName) {
        alfrescoTasksSteps.selectItemsAddedToWorkflow(getVarargs(files));
        alfrescoTasksSteps.clickOnTaskItemsActionButton("Download");
        alfrescoTasksSteps.inputFileNameZipField(fileName);
        alfrescoTasksSteps.clickOnDownloadZipButton();
    }

    public void cancelWorkflow(String workflowName) {
        alfrescoTasksSteps.selectWorkflowFromList(workflowName);
        alfrescoTasksSteps.clickOnCancelWorkflowButton();
        alfrescoFilePreviewSteps.verifyPopupMessage(String
                .format("Are you sure you want to cancel the workflow?"));
        alfrescoFilePreviewSteps.clickOnPopupButton("Yes");
        alfrescoFilePreviewSteps
                .verifyNotificationMessage("Workflow was successfully cancelled");
    }

    public void selectWorkflowFromList(String workflowName) {
        alfrescoTasksSteps.selectWorkflowFromList(workflowName);
    }

    public void cancelWorkflowFromMyTasksPage(String workflowName) {
        int i = 0;
        String url = alfrescoTasksSteps.getDriver().getCurrentUrl();
        while (alfrescoTasksSteps.checkIfWorkflowExists(workflowName) && i < 10) {
            i++;
            alfrescoTasksSteps.clickOnTaskAction(workflowName, "View Workflow");
            alfrescoTasksSteps.clickOnCancelWorkflowButton();
            alfrescoFilePreviewSteps.verifyPopupMessage(String
                    .format("Are you sure you want to cancel the workflow?"));
            alfrescoFilePreviewSteps.clickOnPopupButton("Yes");
            alfrescoFilePreviewSteps
                    .verifyNotificationMessage("Workflow was successfully cancelled");
        }
        alfrescoLoginSteps.navigateToUrl(url);
        alfrescoTasksSteps.waitForFirstPageOfTasksListToLoad();
    }

    public void cancelWorkflowFromList(String workflowName) throws Exception {
        int i = 0;
        String url = alfrescoTasksSteps.getDriver().getCurrentUrl();
        while (alfrescoTasksSteps.checkIfWorkflowExists(workflowName) && i < 10) {
            i++;
            alfrescoTasksSteps.clickOnTaskAction(workflowName, "View Workflow");
            alfrescoTasksSteps.clickOnCancelWorkflowButton();
            alfrescoFilePreviewSteps
                    .verifyPopupMessage("Are you sure you want to delete the workflow?");
            alfrescoFilePreviewSteps.clickOnPopupButton("Yes");
            
            alfrescoFilePreviewSteps
                    .verifyNotificationMessage("Workflow was successfully cancelled");
        }
        alfrescoLoginSteps.navigateToUrl(url);
        alfrescoTasksSteps.waitForFirstPageOfTasksListToLoad();
    }

   
    public void cancelWorkflowIfExists(String workflowName) throws Exception {
        int i = 0;
        String url = alfrescoTasksSteps.getDriver().getCurrentUrl();
        while (alfrescoTasksSteps.checkIfWorkflowExists(workflowName) && i < 10) {
            i++;
            alfrescoTasksSteps.cancelWorkflowFromList(workflowName);
            alfrescoFilePreviewSteps
                    .verifyPopupMessage("Are you sure you want to cancel the workflow?");
            alfrescoFilePreviewSteps.clickOnPopupButton("Yes");
            alfrescoFilePreviewSteps
                    .verifyNotificationMessage("Workflow was successfully cancelled");
        }
        alfrescoLoginSteps.navigateToUrl(url);
        alfrescoTasksSteps.waitForFirstPageOfTasksListToLoad();
    }

    public void deleteWorkflowIfExists(String workflowName) throws Exception {
        int i = 0;
        String url = alfrescoTasksSteps.getDriver().getCurrentUrl();
        while (alfrescoTasksSteps.checkIfWorkflowExists(workflowName) && i < 10) {
            i++;
            alfrescoTasksSteps.cancelWorkflowFromList(workflowName);
            alfrescoFilePreviewSteps
                    .verifyPopupMessage("Are you sure you want to delete the workflow?");
            alfrescoFilePreviewSteps.clickOnPopupButton("Yes");
            alfrescoFilePreviewSteps
                    .verifyNotificationMessage("Workflow was successfully cancelled");
        }
        alfrescoLoginSteps.navigateToUrl(url);
        alfrescoTasksSteps.waitForFirstPageOfTasksListToLoad();
    }

    public void clickOnTaskDoneButton() {
        alfrescoTasksSteps.clickOnTaskDoneButton();
    }

    public void checkThatItemHasAnActions(String fileName, String actionNames) {
        alfrescoTasksSteps.checkThatItemHasActions(fileName,
                getVarargs(actionNames));
    }

    public void verifyThatWorkflowExists(String workflowName) {
        alfrescoTasksSteps.verifyThatWorkflowExists(workflowName);
    }

    public void checkTaskPriority(String priority) {
        alfrescoTasksSteps.checkPriority(priority);
    }

    public void clickOnDocumentActionFromTaskPage(String actionName,
            String fileName) {
        alfrescoTasksSteps.clickOnDocumentActionFromTaskPage(fileName,
                actionName);
    }

    public void navigateToTheSnapshotReportOfTasks() {
        navigateToTheSnapshotReportOfTasks(null);
    }

    public void navigateToTheSnapshotReportOfTasks(String statusReportLabel) {
        if (statusReportLabel == null || statusReportLabel.isEmpty()) {
            statusReportLabel = "Data Lists";
        }
        alfrescoSiteSteps.selectSiteNavigationItem(statusReportLabel);
        alfrescoSiteSteps.clickOnTaskInfoLink();
    }

    public void navigateToTheLifeCycleReport() {
        navigateToTheLifeCycleReport(null);
    }

    public void navigateToTheLifeCycleReport(String statusReportLabel) {
        if (statusReportLabel == null || statusReportLabel.isEmpty()) {
            statusReportLabel = "Data Lists";
        }
        alfrescoSiteSteps.selectSiteNavigationItem(statusReportLabel);
        alfrescoSiteSteps.clickOnLifeCycleStatusReportLink();
    }

    public void checkPageTitle(String pageTitle) {
        alfrescoTasksSteps.checkPageTile(pageTitle);
    }

    public void applyFilterOnTasks(String filterName) {
        alfrescoTasksSteps.clickOnTaskFilter();
        alfrescoTasksSteps.selectTaskFilter(filterName);
    }

    public void checkTaskTypeinMyTaskPage(String workflowName, String type) {
        alfrescoTasksSteps.checkTaskTypeInMyTaskPage(workflowName, type);
    }

    public void checkTaskTypeInWorkflowDetails(String type) {
        alfrescoTasksSteps.checkTaskTypeInWorkflowDetailsPage(type);
    }

    public void editPriorityFromDataList(String newPriority) {
        alfrescoTasksSteps.editPriorityFromDataList(newPriority);
        alfrescoTasksSteps.clickOnSaveButtonWhenYouEditTaskFromDataList();
    }

    public void editStatusFromDataList(String newStatus) {
        alfrescoTasksSteps.editStatusFromDataList(newStatus);
        alfrescoTasksSteps.clickOnSaveButtonWhenYouEditTaskFromDataList();
    }

    public void clickOnExportAsXlsButton() {
        alfrescoSiteSteps.clickOnExportAsXlsButton();
    }

    public void checkWorkflowSubjectFromWorkflowDetialsPage(String subject) {
        alfrescoTasksSteps.checkWorkflowSubjectFromWorkflowDetailsPage(subject);
    }

    public void checkWorkflowSubjectFromTaskDetialsPage(String workflowName,
            String subject) {
        alfrescoTasksSteps.clickOnTaskAction(workflowName, "View Task");
        alfrescoTasksSteps.checkWorkflowSubjectFromTaskDetailsPage(subject);
    }

    public void filterByDocumentName(String name) {
        alfrescoTasksSteps.inputDocumentName(name);
        alfrescoTasksSteps.clickOnFilterButton();
    }

    public void verifyTaskMessage(String taskMessage) {
        alfrescoTasksSteps.verifyTaskMessage(taskMessage);
    }

    public void filterByComponentNameInLifecycleReport(String name) {
        alfrescoTasksSteps.inputComponentnameInLifecyleReport(name);
        alfrescoTasksSteps.clickOnFilterButton();
    }

    public void filterByLifecycleStage(String lifecycle) {
        alfrescoTasksSteps.selectLifecycleStage(lifecycle);
        alfrescoTasksSteps.clickOnFilterButton();
    }

    public void filterByLastModifier(String modifier) {
        alfrescoTasksSteps.clickOnSelectLasModifierOrWorkflowInitiatorButton();
        alfrescoTasksSteps.selectLastModifier(modifier);
        alfrescoTasksSteps.clickOnFilterButton();
    }

    public void filterByWorkflowInitiator(String initiator) {
        alfrescoTasksSteps.clickOnSelectLasModifierOrWorkflowInitiatorButton();
        alfrescoTasksSteps.selectWorkflowInitiator(initiator);
        alfrescoTasksSteps.clickOnFilterButton();
    }

    public void filterByAssignedTo(String userName) {
        alfrescoTasksSteps.clickOnAssignedToButton();
        alfrescoTasksSteps.selectWorkflowAssignedTo(userName);
        alfrescoTasksSteps.clickOnFilterButton();
    }

    public void clearFilters() {
        alfrescoTasksSteps.clickOnClearFiltersButton();
        alfrescoTasksSteps.clickOnFilterButton();
    }

    public void filterByComponentNameInDataList(String name) {
        alfrescoTasksSteps.inputComponentNameInDataList(name);
        alfrescoTasksSteps.clickOnFilterButton();
    }

    public void filterByTaskStatusInDataList(String status) {
        alfrescoTasksSteps.selectTaskStatus(status);
        alfrescoTasksSteps.clickOnFilterButton();
    }
}
