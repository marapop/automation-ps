package a.pages.alfresco;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.findby.How;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Delay;

public class AlfrescoOldAlfrescoPage extends AbstractPage {

    public AlfrescoOldAlfrescoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = "select[id='wizard:wizard-body:action']")
    private WebElement selectActionDropdown;

    @FindBy(how = How.CSS, using = "select[id='script-action:scripts-list']")
    private WebElement setActionValuesDropdown;

    @FindBy(how = How.CSS, using = "input[id='wizard:wizard-body:set-add-button']")
    private WebElement setValuesAndAddButton;

    @FindBy(how = How.CSS, using = "input[id='script-action:ok-button']")
    private WebElement runActionWizardOkButton;

    @FindBy(how = How.CSS, using = "input[id='wizard:finish-button']")
    private WebElement runActionWizardFinishButton;

    @FindBy(how = How.CSS, using = "input[id='loginForm:user-name']")
    private WebElement userNameInput;

    @FindBy(how = How.CSS, using = "input[id='loginForm:user-password']")
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = "input[id='loginForm:submit']")
    private WebElement loginButton;

    public void insertUserName(String userName) {
        userNameInput.clear();
        userNameInput.sendKeys(userName);
    }

    public void insertPassword(String password) {
        //		$(passwordInput).typeAndEnter(password);
        passwordInput.sendKeys(password);
        //		passwordInput.sendKeys(Keys.ENTER);
    }

    public void clickOnLoginButton() {
        //		loginButton.sendKeys(Keys.ENTER);
        loginButton.click();
    }

    public boolean checkIfLoginButtonIsPresent() {
        return checkIfElementExists(By.cssSelector("input[id='loginForm:submit']"));
    }

    public void navigateInLeftMenu(String... options) {
        getElementWithSpecifiedTextFromList(
                By.cssSelector("div.navigator > div > a"), false, true,
                options[0]).click();
        WebElement parentElement = getElementWhenVisible(
                By.cssSelector("div.navigatorPanelBody > div#treeContainer > div.ygtvitem > div.ygtvchildren"),
                Delay.SMALL);
        for (int i = 1; i < options.length; i++) {
            WebElement childElement = getElementWithSpecifiedTextFromListInsideParentElement(
                    parentElement, By.cssSelector("div.ygtvitem"), true, false,
                    options[i]);
            if (i < options.length - 1)
                childElement
                        .findElement(
                                By.cssSelector("div.treeNode > table > tbody > tr > td:first-child > img"))
                        .click();
            else {
                childElement.findElement(By.cssSelector("span.treeNodeLabel"))
                        .click();
            }
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    parentElement = getElementWhenVisible(
                            By.cssSelector("div.navigatorPanelBody > div#treeContainer > div.ygtvitem > div.ygtvchildren"),
                            Delay.SMALL);
                }
                childElement = getElementWithSpecifiedTextFromListInsideParentElement(
                        parentElement, By.cssSelector("div.ygtvitem"), true,
                        false, options[j]);
                parentElement = childElement.findElement(By
                        .cssSelector("div.ygtvchildren"));
            }
        }
    }

    public void clickOnSiteMenuAction(String... actionPath) {
        WebElement actionContainer = getElementWithSpecifiedTextFromList(
                By.cssSelector("form#browse > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(4) > td:nth-child(2) > table > tbody > tr > td"),
                true, false, actionPath[0]);
        actionContainer.findElement(By.tagName("a")).click();
        if (actionPath.length > 1) {
            getElementWithSpecifiedTextFromListInsideParentElement(
                    actionContainer,
                    By.cssSelector("div[id*='browse'] > table > tbody > tr a"),
                    true, false, actionPath[1]).click();
        }
    }

    public void clickOnViewDetailsAction(String action) {
        getElementWithSpecifiedTextFromList(
                By.cssSelector("form#dialog > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr:nth-child(6) > td:nth-child(2) > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td:nth-child(2) > table > tbody > tr > td:nth-child(2) > a"),
                true, false, action).click();
    }

    public void selectActionForRunActionWizard(String action) {
        $(selectActionDropdown).selectByVisibleText(action);
    }

    public void selectActionValues(String action) {
        $(setActionValuesDropdown).selectByVisibleText(action);
    }

    public void clickOnSetValuesAndAddButton() {
        setValuesAndAddButton.click();
    }

    public void clickOnRunActionWizardOkButton() {
        runActionWizardOkButton.click();
    }

    public void clickOnRunActionWizardFinishButton() {
        runActionWizardFinishButton.click();
    }
}
