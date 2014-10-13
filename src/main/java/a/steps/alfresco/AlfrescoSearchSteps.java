package a.steps.alfresco;

import a.pages.alfresco.AlfrescoSearchPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class AlfrescoSearchSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    public AlfrescoSearchSteps(Pages pages) {
        super(pages);
    }

    private AlfrescoSearchPage alfrescoSearchPage;

    @Step
    public void clickOnSearchButtonFromResultsList() {
        alfrescoSearchPage.clickOnSearchButtonFromResultsList();
    }

    @Step
    public void checkThatDocumentIsPresentInResultsList(String docName) {
        alfrescoSearchPage.checkThatDocumentIsPresentInResultsList(docName);
    }

    @Step
    public void checkThatDocumentIsNotPresentInResultsList(String docName) {
        alfrescoSearchPage.checkThatDocumentIsNotPresentInResultsList(docName);
    }

    @Step
    public void inputModifierField(String userName) {
        alfrescoSearchPage.inputModifierField(userName);
    }

    @Step
    public void inputNameField(String fileName) {
        alfrescoSearchPage.inputNameField(fileName);
    }

    @Step
    public void selectMimeType(String fileType) {
        alfrescoSearchPage.selectMimeType(fileType);
    }

    @Step
    public void clickOnMimetype() {
        alfrescoSearchPage.clickOnMimetype();
    }

    @Step
    public void insertSearchKeyword(String keyword) {
        alfrescoSearchPage.insertSearchKeyword(keyword);
    }

    @Step
    public void insertAdvancedKeyword(String keyword) {
        alfrescoSearchPage.insertAdvancedKeyword(keyword);
    }

    @Step
    public void checkTheNumberOfSearchResults(String number) {
        alfrescoSearchPage.checkTheNumberOfSearchResults(number);
    }

    @Step
    public void insertDateSearchFrom(String dateFrom) {
        alfrescoSearchPage.insertDateSearchFrom(dateFrom);
    }

    @Step
    public void insertDateSearchTo(String dateTo) {
        alfrescoSearchPage.insertDateSearchTo(dateTo);
    }
}
