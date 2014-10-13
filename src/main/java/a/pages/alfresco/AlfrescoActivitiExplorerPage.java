package a.pages.alfresco;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Delay;

public class AlfrescoActivitiExplorerPage extends AbstractPage {

    public AlfrescoActivitiExplorerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[class*='embedded-browser'] iframe")
    private WebElement loginIframe;

    @FindBy(css = "input[name='username']")
    private WebElement userNameField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordField;

    @FindBy(css = "div.login-button span")
    private WebElement loginButton;

    public void selectCategoryFromToolbar(String categoryTitle) {
        getElementWithSpecifiedTextFromList(
                By.cssSelector("div.v-horizontallayout.v-horizontallayout-toolbar.toolbar > div > div span > span"),
                true, false, categoryTitle).click();
    }

    public void selectWorkflowFromList(String workflowID) {
        List<WebElement> workflowsList = getDriver()
                .findElements(
                        By.cssSelector("div.v-gridlayout.v-gridlayout-small.small > div.v-gridlayout-margin table.v-table-table > tbody > tr > td:nth-child(2) > div"));
        boolean foundWorkflow = false;
        String lastLoadedWorkflow = null;
        int i = 0;
        System.out.println("************************* initial size "
                + workflowsList.size());
        while (i < workflowsList.size()) {
            System.out.println("lastLoadedWorkflow " + lastLoadedWorkflow);
            System.out.println("---------------------- " + i);
            WebElement workflow = workflowsList.get(i);
            String workflowTitle = workflow.getText();
            System.out.println("workflowTitle " + workflowTitle);
            if (workflowTitle.contains(workflowID)) {
                foundWorkflow = true;
                workflow.click();
                break;
            }
            // we need to re-initialize the workflowsList because when the page
            // loads the list is not complete, it updates as you scroll down
            if (i == workflowsList.size() - 1) {
                lastLoadedWorkflow = workflowTitle;
                workflow.click();
                scrollPageDown(workflow, 2);
                waitUntilElementNotPresentOrInvisible(
                        By.cssSelector("div.v-table-scrollposition > span"),
                        Delay.REASONABLE);
                waitABit(1000);
                // mouseOver(workflow);
                // ((JavascriptExecutor) getDriver()).executeScript(
                // "arguments[0].scrollIntoView(true);", workflow);
                // mouseOver(workflow);
                workflowsList = getDriver()
                        .findElements(
                                By.cssSelector("div.v-gridlayout.v-gridlayout-small.small > div.v-gridlayout-margin table.v-table-table > tbody > tr > td:nth-child(2) > div"));
                System.out
                        .println("^^^^^^^^^^^^^^^^^^^^^^^^^^^ intermediary size "
                                + workflowsList.size());
                if (workflowsList.get(workflowsList.size() - 1).getText()
                        .equals(lastLoadedWorkflow)) {
                    break;
                } else {
                    i = 0;
                    continue;
                }
            }
            i++;
        }
        Assert.assertTrue(
                String.format("The '%s' workflow was not found!", workflowID),
                foundWorkflow);
    }

    public void verifyWorkflowMessage(String message) {
        WebElement workflowMessageContainer = getElementWithSpecifiedTextInsideElementFromList(
                By.cssSelector("table.v-table-table > tbody > tr"),
                By.cssSelector("td > div"), true, false, "bpm_description")
                .findElement(By.cssSelector("td:nth-child(2) > div"));
        String workflowMessage = workflowMessageContainer.getText();
        Assert.assertTrue(String.format(
                "The workflow message should be '%s' but it is '%s'!", message,
                workflowMessage), message.equalsIgnoreCase(workflowMessage));
    }

    public void verifyWorkflowSubject(String subject) {
        WebElement workflowSubjectContainer = getElementWithSpecifiedTextInsideElementFromList(
                By.cssSelector("table.v-table-table > tbody > tr"),
                By.cssSelector("td > div"), true, false,
                "wccwf_workflowSubject").findElement(
                By.cssSelector("td:nth-child(2) > div"));
        String workflowSubject = workflowSubjectContainer.getText();
        Assert.assertTrue(String.format(
                "The workflow subject should be '%s' but it is '%s'!", subject,
                workflowSubject), subject.equalsIgnoreCase(workflowSubject));
    }

    public void verifyWorkflowSite(String site) {
        WebElement workflowSiteContainer = getElementWithSpecifiedTextInsideElementFromList(
                By.cssSelector("table.v-table-table > tbody > tr"),
                By.cssSelector("td > div"), true, false, "currentSiteShortName")
                .findElement(By.cssSelector("td:nth-child(2) > div"));
        String workflowSite = workflowSiteContainer.getText();
        Assert.assertTrue(String.format(
                "The workflow site should be '%s' but it is '%s'!", site,
                workflowSite), site.equalsIgnoreCase(workflowSite));
    }

    public void switchToLoginIframe() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(loginIframe);

    }

    public void insertUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void insertPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
        getDriver().switchTo().defaultContent();
    }
}
