package a.steps.alfresco;

import java.util.Date;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import a.pages.alfresco.AlfrescoFilePreviewPage;

public class AlfrescoFilePreviewSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    public AlfrescoFilePreviewSteps(Pages pages) {
        super(pages);
    }

    private AlfrescoFilePreviewPage alfrescoFilePreviewPage;

    @Step
    public void clickOnDocumentAction(String actionTitle) {
        alfrescoFilePreviewPage.clickOnDocumentAction(actionTitle);
    }

    @Step
    public void checkThatDocumentActionIsPresent(String actionTitle) {
        alfrescoFilePreviewPage.checkThatDocumentActionIsPresent(actionTitle);
    }

    @Step
    public void checkThatDocumentActionIsNotPresent(String actionTitle) {
        alfrescoFilePreviewPage
                .checkThatDocumentActionIsNotPresent(actionTitle);
    }

    @StepGroup
    public void clickOnDocumentActionWithResultMessage(String actionTitle,
            String message) {
        clickOnDocumentAction(actionTitle);
        verifyNotificationMessage(message);
    }

    @Step
    public void verifyNotificationMessage(String... message) {
        alfrescoFilePreviewPage.verifyNotificationMessage(message);
    }

    @Step
    public void verifyPopupMessage(String message) {
        alfrescoFilePreviewPage.verifyPopupMessage(message);
    }

    @Step
    public void clickOnPopupButton(String buttonTitle) {
        alfrescoFilePreviewPage.clickOnPopupButton(buttonTitle);
    }

    @StepGroup
    public void clickOnPopupButtonWithResultMessage(String buttonTitle,
            String message) {
        clickOnPopupButton(buttonTitle);
        verifyNotificationMessage(message);
    }

    @Step
    public void assertDocumentVersion(String version) {
        alfrescoFilePreviewPage.assertDocumentVersion(version);
    }

    @Step
    public void checkThatDocumentIsPartOfWorkflow(String message,
            String taskName) {
        alfrescoFilePreviewPage.checkThatDocumentIsPartOfWorkflow(message,
                taskName);
    }

    @Step
    public void verifyPropertyValue(String propertyName, String propertyValue) {
        alfrescoFilePreviewPage
                .verifyPropertyValue(propertyName, propertyValue);
    }

    @Step
    public void insertCommentForAnnotation(String annotation) {
        alfrescoFilePreviewPage.insertCommentForAnnotation(annotation);
    }

    @Step
    public void navigateToNextPage() {
        alfrescoFilePreviewPage.navigateToNextPage();
    }

    @Step
    public void checkIfCommentIsPresent(String userName, String message) {
        alfrescoFilePreviewPage.checkIfCommentIsPresent(userName, message);
    }

    @Step
    public void checkIfCommentDoesntExists(String userName, String message) {
        alfrescoFilePreviewPage.checkIfCommentDoesntExists(userName, message);
    }

    @Step
    public void checkIfCommentIsPresent(String userName, String message,
            String actionName) {
        alfrescoFilePreviewPage.checkIfCommentIsPresent(userName, message,
                actionName);
    }

    @Step
    public void clickOnRevertIcon(String versioNumber) {
        alfrescoFilePreviewPage.clickOnRevertIcon(versioNumber);

    }

    @Step
    public void clickOnPreviewOnlineIcon(String versionNumber) {
        alfrescoFilePreviewPage.clickOnPreviewOnlineIcon(versionNumber);
    }

    @Step
    public void checkIfDocumentIsLocked(String message) {
        alfrescoFilePreviewPage.checkIfDocumentIsLocked(message);
    }

    @Step
    public void clickOnAddCommentButton() {
        alfrescoFilePreviewPage.clickOnAddCommentButton();
    }

    @Step
    public void clickOnSubmitCommentButton() {
        alfrescoFilePreviewPage.clickOnSubmitCommentButton();
    }

    @Step
    public void insertCommentContent(String content) {
        alfrescoFilePreviewPage.insertCommentContent(content);
    }

    @Step
    public void checkMessageForOnlinePreview(String message, String file) {
        alfrescoFilePreviewPage.checkMessageForOnlinePreview(message, file);
    }

    @Step
    public void checkThatDateCorespondWithSystemTime(Date systemDate) {
        alfrescoFilePreviewPage
                .checkThatDateCorespondWithSystemTime(systemDate);
    }

    @Step
    public void verifyDocumentTitle(String title) {
        alfrescoFilePreviewPage.verifyDocumentTitle(title);
    }

}
