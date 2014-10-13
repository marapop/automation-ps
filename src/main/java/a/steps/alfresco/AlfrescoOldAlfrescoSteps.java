package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import a.pages.alfresco.AlfrescoOldAlfrescoPage;

public class AlfrescoOldAlfrescoSteps extends ScenarioSteps {

    public AlfrescoOldAlfrescoSteps(Pages pages) {
        super(pages);
    }

    private static final long serialVersionUID = 1L;

    public AlfrescoOldAlfrescoPage oldAlfrescoPage;

    @Step
    public void insertUserName(String userName) {
        oldAlfrescoPage.insertUserName(userName);
    }

    @Step
    public void insertPassword(String password) {
        oldAlfrescoPage.insertPassword(password);
    }

    @Step
    public void clickOnLoginButton() {
        oldAlfrescoPage.clickOnLoginButton();
    }

    @Step
    public boolean checkIfLoginButtonIsPresent() {
        return oldAlfrescoPage.checkIfLoginButtonIsPresent();
    }

    @Step
    public void navigateInLeftMenu(String... options) {
        oldAlfrescoPage.navigateInLeftMenu(options);
    }

    @Step
    public void clickOnSiteMenuAction(String... actionPath) {
        oldAlfrescoPage.clickOnSiteMenuAction(actionPath);
    }

    @Step
    public void clickOnViewDetailsAction(String action) {
        oldAlfrescoPage.clickOnViewDetailsAction(action);
    }

    @Step
    public void selectActionForRunActionWizard(String action) {
        oldAlfrescoPage.selectActionForRunActionWizard(action);
    }

    @Step
    public void selectActionValues(String action) {
        oldAlfrescoPage.selectActionValues(action);
    }

    @Step
    public void clickOnSetValuesAndAddButton() {
        oldAlfrescoPage.clickOnSetValuesAndAddButton();
    }

    @Step
    public void clickOnRunActionWizardOkButton() {
        oldAlfrescoPage.clickOnRunActionWizardOkButton();
    }

    @Step
    public void clickOnRunActionWizardFinishButton() {
        oldAlfrescoPage.clickOnRunActionWizardFinishButton();
    }
}
