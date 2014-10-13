package a.steps.alfresco;

import a.pages.alfresco.AlfrescoUploadAssetsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class AlfrescoUploadAssetsSteps extends ScenarioSteps {
    private static final long serialVersionUID = 1L;

    public AlfrescoUploadAssetsSteps(Pages pages) {
        super(pages);
    }

    AlfrescoUploadAssetsPage alfrescoUploadAssetsPage;

    @Step
    public void clickOnSelectFilesButton() {
        alfrescoUploadAssetsPage.clickOnSelectFile();
    }

    @Step
    public void insertFilePath(String filePath) {
        alfrescoUploadAssetsPage.insertFilePath(filePath);
    }

    @Step
    public void clickOnUploadFileButton() {
        alfrescoUploadAssetsPage.clickOnUploadFileButton();
    }

    @Step
    public void clickOnCancelUploadButton() {
        alfrescoUploadAssetsPage.clickOnCancelOkUpload();
    }

    @Step
    public void clickOnOkUploadButton() {
        alfrescoUploadAssetsPage.clickOnCancelOkUpload();
    }

    @Step
    public void selectVersionType(String versionType) {
        alfrescoUploadAssetsPage.selectVersionType(versionType);
    }

    @Step
    public void inputCommentField(String comment) {
        alfrescoUploadAssetsPage.inputCommentField(comment);
    }

    @Step
    public void checkThatUploadButtonIsDisabled() {
        alfrescoUploadAssetsPage.checkThatUploadButtonIsDisabled();
    }

    @Step
    public void clickOnRemoveFile() {
        alfrescoUploadAssetsPage.clickOnRemoveFile();
    }

    @Step
    public void checkThatNoFilesWereSelected(String message) {
        alfrescoUploadAssetsPage.checkThatNoFilesWereSelected(message);
    }

}
