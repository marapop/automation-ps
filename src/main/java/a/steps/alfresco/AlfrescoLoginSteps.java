package a.steps.alfresco;

import junit.framework.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import a.pages.alfresco.AlfrescoLoginPage;

@SuppressWarnings("deprecation")
public class AlfrescoLoginSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    public AlfrescoLoginSteps(Pages pages) {
        super(pages);
    }

    private AlfrescoLoginPage alfrescoLoginPage;


    @Step("Open login page")
	public void openLoginPage(String url) {
		alfrescoLoginPage.openLoginPage(url);
    }
    
    @Step
    public void navigateToUrl(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }
    
    @Step("Close the browser")
    public void closeBrowser(){
     alfrescoLoginPage.closeBrowser();
    }

    @Step
    public void verifyLoginPageIsOpen() {
        Assert.assertTrue(
                "Current page is not the login page!",
                alfrescoLoginPage.getDriver().getTitle()
                        .matches("Alfresco.*Login"));
    }

    @Step
    public void enterUsername(String userName) {
        alfrescoLoginPage.enterUsername(userName);
    }

    @Step
    public void enterPassword(String password) {
        alfrescoLoginPage.enterPassword(password);
    }

    @Step
    public void enterPasswordAndCheckPasswordField(String password) {
        enterPassword(password);
        Assert.assertEquals(password.length(),
                alfrescoLoginPage.getEnteredPasswordLength());
        Assert.assertEquals("password",
                alfrescoLoginPage.getPasswordFieldType());
    }

    @Step
    public void clickLoginButton() {
        alfrescoLoginPage.clickLoginButton();
    }

    @Step
    public void close() {
        alfrescoLoginPage.getDriver().close();
    }

    @Step
    public void loginToSite(String userName, String password){
    	alfrescoLoginPage.enterUsername(userName);
    	alfrescoLoginPage.enterPassword(password);
    	alfrescoLoginPage.clickLoginButton();
    }
    
    @Step
    public void login(String userName, String password){
    	alfrescoLoginPage.enterUsername(userName);
    	alfrescoLoginPage.enterPassword(password);
    	alfrescoLoginPage.clickLoginButton();
    }
    
    @Step
    public void verifyThatUsernameFieldIsEmpty() {
        alfrescoLoginPage.verifyThatUsernameFieldIsEmpty();
    }

    @Step
    public void verifyThatPasswordFieldIsEmpty() {
        alfrescoLoginPage.verifyThatPasswordFieldIsEmpty();
    }

    @Step
    public void verifyThatTheErrorMessageIsDisplayed() {
        alfrescoLoginPage.verifyThatTheErrorMessageBoxIsDisplayed();
    }

    @Step
    public void verifyThatTheCorrectErrorMessageIsDisplayed(
            String expectedMessage) {
        alfrescoLoginPage
                .verifyThatCorrectErrorMessageIsDisplayed(expectedMessage);
    }
}
