package a.pages.alfresco;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.junit.Assert;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;
import a.tools.alfresco.DateUtils;
import a.tools.alfresco.Delay;
import a.tools.alfresco.StringUtils;

public class AlfrescoTasksPage extends AbstractPage {

    public AlfrescoTasksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span[class*='selected-form-button'] > span[id*='default-workflow-definition-button'] button")
    private WebElement selectWorkflowButton;

    @FindBy(css = "span[class*='selected-form-button'] > div[id*='default-workflow-definition-menu'] span")
    private List<WebElement> workflowOptionList;

    @FindBy(css = "div[class*='alf-textarea'] textarea")
    private WebElement messageField;

    @FindBy(css = "input[id*='workflowDueDate-cntrl-date']")
    private WebElement dueDateField;

    @FindBy(css = "input[id*='dueDate-cntrl-date']")
    private WebElement editDueDateField;

    @FindBy(css = "div[id*='form-container'] > form >div[class*='form-fields'] >div:nth-of-type(3) > div:nth-child(2) button")
    private WebElement selectReviewerButton;

    @FindBy(css = "input[id$='cntrl-picker-searchText']")
    private WebElement searchReviewerField;

    @FindBy(css = "[id*='cntrl-picker-searchContainer'] button")
    private WebElement searchReviewerButton;

    @FindBy(css = "div.yui-panel-container[style*='visible']")
    private WebElement reviewContainer;

    @FindBy(css = "span[class*='selected-form-button'] > div[id*='default-workflow-definition-menu'] > div >ul >li:nth-child(2)")
    private WebElement reviewApproveLink;

    @FindBy(css = "span[id*='default-startWorkflowForm-alf-id3-form-submit'] button")
    private WebElement saveWorkflowButon;

    @FindBy(css = "div[id*='inviteOutcome-buttons'] > span:first-child > span > button")
    private WebElement acceptInvitationSiteButton;

    @FindBy(css = "div[id*='default-form-buttons'] >span:first-child button")
    private WebElement saveAndCloseButton;

    @FindBy(css = "div[id*='reviewOutcome'] > span:first-child > span > button")
    private WebElement approveTaskButton;

    @FindBy(css = "div[class*='form-field'] textarea")
    private WebElement commentField;

    @FindBy(css = "div[id*='reviewOutcome'] > span:nth-child(2) > span > button")
    private WebElement rejectTaskButton;

    @FindBy(css = "select[id*='default_prop_bpm_status']")
    private WebElement workflowStatus;

    @FindBy(css = "div[class*='bd'] > div:first-child > input")
    private WebElement fileNameZipField;

    @FindBy(css = "div[class*='ft']>span>span:nth-child(2) button")
    private WebElement downloadZipButton;

    @FindBy(css = "div[id*='default-workflows'] tbody[class*='data']")
    private WebElement allWorkflowTable;

    @FindBy(css = "div[id*='bd'] > div > div:nth-of-type(3) button")
    private WebElement cancelWorkflowButton;

    @FindBy(css = "div[id*='prop_transitions-buttons'] > span > span > button")
    private WebElement taskDoneButton;

    @FindBy(css = "div[id*='form-fields']> div:nth-child(2) div[class*='form-field'] select")
    private WebElement priorityDropDownList;

    @FindBy(css = "div[id*='alfresco/header/Title'] a")
    private WebElement pageTitle;

    @FindBy(css = "div.form-fields > div.set:first-child span.viewmode-value")
    private WebElement taskMessageContainer;

    
    
    
    public void clickOnSelectWorkflowButton() {
        element(selectWorkflowButton).waitUntilVisible();
        element(selectWorkflowButton).click();
    }

    public void inputMessageField(String message) {
        element(messageField).waitUntilVisible();
        element(messageField).type(message);
    }

    public void inputDueDateField(String dueDate) {
        element(dueDateField).waitUntilVisible();
        element(dueDateField).clear();
        element(dueDateField).type(dueDate);
    }

    public void inputEditDueDateField(String editDueDate) {
        element(editDueDateField).waitUntilVisible();
        element(editDueDateField).clear();
        element(editDueDateField).type(editDueDate);
    }

    public void clickOnSelectReviewerButton() {
        element(selectReviewerButton).waitUntilVisible();
        element(selectReviewerButton).click();
        // waitABit(10000);
    }

    public void selectWorkflowType(String type) {
        getElementWithSpecifiedTextFromList(
                By.cssSelector("div.form-manager.start-workflow span.selected-form-button div.bd > ul.first-of-type > li > span:first-child"),
                true, false, type).click();
    }

    public void saveWorkflowButon() {
        element(saveWorkflowButon).waitUntilVisible();
        element(saveWorkflowButon).click();
    }

    public void clickOnAcceptInvitationSiteButton() {
        element(acceptInvitationSiteButton).waitUntilVisible();
        element(acceptInvitationSiteButton).click();
    }

    public void clickOnSaveAndCloseButton() {
        element(saveAndCloseButton).waitUntilVisible();
        element(saveAndCloseButton).sendKeys("");
        element(saveAndCloseButton).click();
    }

    public void clickOnApproveTaskButton() {
        element(approveTaskButton).waitUntilVisible();
        element(approveTaskButton).click();
    }

    public boolean clickOnApproveTaskButtonIfExists() {
        return clickOnButtonIfExists(By
                .cssSelector("div[id*='reviewOutcome'] > span:first-child > span > button"));
    }

    public void inputCommentField(String comment) {
        element(commentField).waitUntilVisible();
        element(commentField).type(comment);
    }

    public void clickOnRejectTaskButton() {
        element(rejectTaskButton).waitUntilVisible();
        element(rejectTaskButton).click();
    }

    public boolean clickOnRejectTaskButtonIfExists() {
        return clickOnButtonIfExists(By
                .cssSelector("div[id*='reviewOutcome'] > span:nth-child(2) > span > button"));
    }

    public void clickOnSelectStatus() {
        element(workflowStatus).waitUntilVisible();
        element(workflowStatus).click();
    }

    public void clickOnTaskItemsActionButton(String action) {
        getElementWithSpecifiedTextFromList(
                By.cssSelector("div.show-picker > span > span.first-child > button"),
                true, true, action).click();
    }

    public void inputFileNameZipField(String fileName) {
        element(fileNameZipField).waitUntilVisible();
        element(fileNameZipField).clear();
        element(fileNameZipField).type(fileName);
    }

    public void clickOnDownloadZipButton() {
        element(downloadZipButton).waitUntilVisible();
        element(downloadZipButton).click();
    }

    public void clickOnCancelWorkflowButton() {
        WebElement cancelWorkflowButton = getDriver()
                .findElement(
                        By.cssSelector("div[id*='bd'] >div>div:nth-of-type(3) button[id*='button']"));
        element(cancelWorkflowButton).waitUntilVisible();
        element(cancelWorkflowButton).click();
    }

    public void clickOnTaskDoneButton() {
        element(taskDoneButton).waitUntilVisible();
        element(taskDoneButton).click();
    }

    public boolean clickOnTaskDoneButtonIfExists() {
        return clickOnButtonIfExists(By
                .cssSelector("div[id*='bd'] > div > div:nth-of-type(3) button"));
    }

    public void selectWorkflowOption(String optionTitle) {
        boolean foundOption = false;
        for (WebElement option : workflowOptionList) {
            if (option.getText().contains(optionTitle)) {
                foundOption = true;
                option.click();
                break;
            }
        }
        Assert.assertTrue("The " + optionTitle + " option was not found!",
                foundOption);
    }

    public void selectReviewer(String userName) {
        element(reviewContainer).waitUntilVisible();
        WebElement searchInput = reviewContainer.findElement(By
                .cssSelector("input.search-input"));
        searchInput.click();
        searchInput.sendKeys(userName);
        WebElement searchButton = reviewContainer.findElement(By
                .cssSelector("span.search-button button"));
        searchButton.click();
        WebElement resultListContainer = reviewContainer
                .findElement(By
                        .cssSelector("div[id*='assoc_bpm_assignee-cntrl-picker-results']"));
        waitFor(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By
                        .cssSelector("div[id*='assoc_bpm_assignee-cntrl-picker-results'] tbody.yui-dt-data > tr")));
        List<WebElement> resultsList = resultListContainer.findElements(By
                .cssSelector("tbody.yui-dt-data > tr"));
        boolean foundUser = false;
        for (WebElement resultNow : resultsList) {
            String nameFieldValue = resultNow.findElement(
                    By.cssSelector("h3.item-name")).getText();
            if (nameFieldValue.contains(userName)) {
                foundUser = true;
                resultNow.findElement(By.cssSelector("span.addIcon")).click();
                break;
            }
        }
        Assert.assertTrue(String.format(
                "No user named '%s' was found in the results list!", userName),
                foundUser);
        WebElement okButton = reviewContainer
                .findElement(By
                        .cssSelector("span[id*='id3_assoc_bpm_assignee-cntrl-ok'] button"));
        okButton.click();
    }

    public void selectLastModifier(String userName) {
        element(reviewContainer).waitUntilVisible();
        WebElement searchInput = reviewContainer.findElement(By
                .cssSelector("input.search-input"));
        searchInput.click();
        searchInput.sendKeys(userName);
        WebElement searchButton = reviewContainer.findElement(By
                .cssSelector("span.search-button button"));
        searchButton.click();
        WebElement resultListContainer = reviewContainer.findElement(By
                .cssSelector("div[id*='lastModifier-cntrl-picker-results']"));
        waitFor(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By
                        .cssSelector("div[id*='lastModifier-cntrl-picker-results'] tbody.yui-dt-data > tr")));
        List<WebElement> resultsList = resultListContainer.findElements(By
                .cssSelector("tbody.yui-dt-data > tr"));
        boolean foundUser = false;
        for (WebElement resultNow : resultsList) {
            String nameFieldValue = resultNow.findElement(
                    By.cssSelector("h3.item-name")).getText();
            if (nameFieldValue.contains(userName)) {
                foundUser = true;
                resultNow.findElement(By.cssSelector("span.addIcon")).click();
                break;
            }
        }
        Assert.assertTrue(String.format(
                "No user named '%s' was found in the results list!", userName),
                foundUser);
        WebElement okButton = reviewContainer.findElement(By
                .cssSelector("span[id*='lastModifier-cntrl-ok'] button"));
        okButton.click();
    }

    public void selectWorkflowInitiator(String userName) {
        element(reviewContainer).waitUntilVisible();
        WebElement searchInput = reviewContainer.findElement(By
                .cssSelector("input.search-input"));
        searchInput.click();
        searchInput.sendKeys(userName);
        WebElement searchButton = reviewContainer.findElement(By
                .cssSelector("span.search-button button"));
        searchButton.click();
        WebElement resultListContainer = reviewContainer.findElement(By
                .cssSelector("div[id*='taskInitiator-cntrl-picker-results']"));
        waitFor(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By
                        .cssSelector("div[id*='taskInitiator-cntrl-picker-results'] tbody.yui-dt-data > tr")));
        List<WebElement> resultsList = resultListContainer.findElements(By
                .cssSelector("tbody.yui-dt-data > tr"));
        boolean foundUser = false;
        for (WebElement resultNow : resultsList) {
            String nameFieldValue = resultNow.findElement(
                    By.cssSelector("h3.item-name")).getText();
            if (nameFieldValue.contains(userName)) {
                foundUser = true;
                resultNow.findElement(By.cssSelector("span.addIcon")).click();
                break;
            }
        }
        Assert.assertTrue(String.format(
                "No user named '%s' was found in the results list!", userName),
                foundUser);
        WebElement okButton = reviewContainer.findElement(By
                .cssSelector("span[id*='taskInitiator-cntrl-ok'] button"));
        okButton.click();
    }

    public void selectWorkflowAssignedTo(String userName) {
        element(reviewContainer).waitUntilVisible();
        WebElement searchInput = reviewContainer.findElement(By
                .cssSelector("input.search-input"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(userName);
        WebElement searchButton = reviewContainer.findElement(By
                .cssSelector("span.search-button button"));
        searchButton.click();
        WebElement resultListContainer = reviewContainer.findElement(By
                .cssSelector("div[id*='assignedTo-cntrl-picker-results']"));
        waitFor(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By
                        .cssSelector("div[id*='assignedTo-cntrl-picker-results'] tbody.yui-dt-data > tr")));
        List<WebElement> resultsList = resultListContainer.findElements(By
                .cssSelector("tbody.yui-dt-data > tr"));
        boolean foundUser = false;
        for (WebElement resultNow : resultsList) {
            String nameFieldValue = resultNow.findElement(
                    By.cssSelector("h3.item-name")).getText();
            if (nameFieldValue.contains(userName)) {
                foundUser = true;
                resultNow.findElement(By.cssSelector("span.addIcon")).click();
                break;
            }
        }
        Assert.assertTrue(String.format(
                "No user named '%s' was found in the results list!", userName),
                foundUser);
        WebElement okButton = reviewContainer.findElement(By
                .cssSelector("span[id*='assignedTo-cntrl-ok'] button"));
        okButton.click();
    }

    public void clickOnAssignedToButton() {
        WebElement assignedToButton = getDriver()
                .findElement(
                        By.cssSelector("div[id*='extDgFilterForm'] div.set>div:nth-child(2)>div:nth-child(2) button"));
        element(assignedToButton).waitUntilVisible();
        element(assignedToButton).click();
    }

    public void checkRejectButtonIsDisabled() {
        Assert.assertFalse("The button is enabled",
                rejectTaskButton.isEnabled());
    }

    public void selectWorkflowStatus(String status) {
        WebElement statusDropdown = getDriver().findElement(
                By.cssSelector("select[id*='default_prop_bpm_status']"));
        statusDropdown.click();
        $(statusDropdown).selectByVisibleText(status);
    }

    public void selectItemsAddedToWorkflow(String... items) {
        implicitlyWaitMedium();
        for (String itemName : items) {
            getElementWithSpecifiedTextInsideElementFromList(
                    By.cssSelector("div.current-values.object-finder-list.yui-dt.form-element-border.form-element-background-color > table >tbody.yui-dt-data > tr"),
                    By.cssSelector("td:nth-child(3) > div > h3 > a"), true,
                    false, itemName).findElement(
                    By.cssSelector("td > div > input")).click();
        }
        implicitlyWaitDefault();
    }

    public void checkThatAllItemsAddedToWorkflowAreSelected() {
        implicitlyWaitMedium();
        List<WebElement> itemsList = getDriver()
                .findElements(
                        By.cssSelector("div.current-values.object-finder-list.yui-dt.form-element-border.form-element-background-color > table >tbody.yui-dt-data > tr"));
        for (WebElement item : itemsList) {
            String itemName = item.findElement(
                    By.cssSelector("td > div > h3.name > a")).getText();
            WebElement itemCheckbox = item.findElement(By
                    .cssSelector("td > div > input"));
            Assert.assertTrue(
                    String.format("The '%s' item is not selected!", itemName),
                    $(itemCheckbox).isSelected());
        }
    }

    public void checkThatItemHasActions(String fileName, String... actionNames) {
        waitABit(2000);
        implicitlyWaitMedium();
        List<WebElement> itemsList = getDriver()
                .findElements(
                        By.cssSelector("div.current-values.object-finder-list.yui-dt.form-element-border.form-element-background-color > table > tbody.yui-dt-data > tr"));
        boolean foundDocument = false;
        for (WebElement item : itemsList) {
            WebElement filename = item.findElement(By
                    .cssSelector("td > div > h3.name > a"));
            if (filename.getText().contains(fileName)) {
                foundDocument = true;
                List<WebElement> itemActions = item
                        .findElements(By
                                .cssSelector("td:nth-child(4) > div.yui-dt-liner > div.list-action > a"));
                for (String actionName : actionNames) {
                    boolean foundAction = false;
                    for (WebElement itemAction : itemActions) {
                        if (itemAction.getText().contains(actionName)) {
                            foundAction = true;
                            break;
                        }
                    }
                    Assert.assertTrue(
                            String.format(
                                    "The '%s' action is not present for the '%s' document!",
                                    actionName, fileName), foundAction);
                }
            }
        }
        Assert.assertTrue(
                String.format("The '%s' document  is not present!", fileName),
                foundDocument);
    }

    public void clickOnDocumentActionFromTaskPage(String fileName,
            String actionName) {
        waitABit(2000);
        implicitlyWaitMedium();
        List<WebElement> itemsList = getDriver()
                .findElements(
                        By.cssSelector("div.current-values.object-finder-list.yui-dt.form-element-border.form-element-background-color > table > tbody.yui-dt-data > tr"));
        boolean foundDocument = false;
        for (WebElement item : itemsList) {
            WebElement filename = item.findElement(By
                    .cssSelector("td[class*='name'] > div > h3.name > a"));
            if (filename.getText().contains(fileName)) {
                foundDocument = true;
                boolean foundAction = false;
                List<WebElement> itemActions = item
                        .findElements(By
                                .cssSelector("td[class*='action'] > div.yui-dt-liner > div.list-action > a"));
                for (WebElement itemAction : itemActions) {
                    if (itemAction.getText().contains(actionName)) {
                        foundAction = true;
                        itemAction.sendKeys("");
                        itemAction.click();
                        break;
                    }
                }
                Assert.assertTrue(
                        String.format(
                                "The '%s' action is not present for the '%s' document!",
                                actionName, fileName), foundAction);
            }
        }
        Assert.assertTrue(
                String.format("The '%s' document  is not present!", fileName),
                foundDocument);
    }

    public void verifyThatWorkflowExists(String workflowName) {
        Assert.assertTrue(
                String.format("The '%s' workflow was not found!", workflowName),
                checkIfWorkflowExists(workflowName));
    }

    public boolean checkIfWorkflowExists(String workflowName) {
        return getWorkflowElementFromList(workflowName, false) != null ? true
                : false;
    }

    public void selectWorkflowFromList(String workflowName) {
        getWorkflowElementFromList(workflowName, true)
                .findElement(
                        By.cssSelector("td.yui-dt-col-title > div.yui-dt-liner > h3 > a"))
                .click();
    }

    public WebElement getWorkflowElementFromList(String workflowName,
            boolean assertExists) {
        scrollToPageTop();
        boolean foundWorkflow = false;
        boolean hasMorePages = true;
        WebElement workflow = null;
        // we add a back-up escape from the infinite loop in case the navigation
        // to the next page fails
        int i = 0;
        while (!foundWorkflow && hasMorePages && i < 50) {
            workflow = getElementWithSpecifiedTextInsideElementFromListIfExists(
                    By.cssSelector("div.alfresco-datatable.yui-dt > table > tbody.yui-dt-data > tr"),
                    By.cssSelector("td.yui-dt-col-title > div.yui-dt-liner > h3 > a"),
                    true, true, workflowName);
            if (workflow == null) {
                WebElement noOfPagesContainer = getElementIfExists(
                        By.cssSelector("div.paginator.yui-pg-container > span.yui-pg-current"),
                        Delay.REASONABLE, TimeUnit.SECONDS);
                if (noOfPagesContainer != null
                        && !noOfPagesContainer.getText().isEmpty()) {
                    List<Integer> elementsPerPageRepartisationInfo = StringUtils
                            .getAllIntegerNumbersFromString(noOfPagesContainer
                                    .getText());
                    int currentPageElementsMaxIndex = elementsPerPageRepartisationInfo
                            .get(1);
                    int maxNoOfElementsInResults = elementsPerPageRepartisationInfo
                            .get(2);
                    hasMorePages = currentPageElementsMaxIndex < maxNoOfElementsInResults ? true
                            : false;
                    if (hasMorePages) {
                        WebElement nextPageButton = getElementIfExists(
                                By.cssSelector("div.paginator.yui-pg-container > a.yui-pg-next"),
                                Delay.REASONABLE, TimeUnit.SECONDS);
                        nextPageButton.click();
                        currentPageElementsMaxIndex = currentPageElementsMaxIndex
                                + Constants.MAX_NO_OF_WORKFLOWS_PER_PAGE < maxNoOfElementsInResults ? currentPageElementsMaxIndex
                                + Constants.MAX_NO_OF_WORKFLOWS_PER_PAGE
                                : maxNoOfElementsInResults;
                        waitForAllStringsToAppear(
                                By.cssSelector("div.paginator.yui-pg-container > span.yui-pg-current"),
                                Delay.REASONABLE,
                                String.format(
                                        "%d - %d of %d",
                                        (elementsPerPageRepartisationInfo
                                                .get(0) + Constants.MAX_NO_OF_WORKFLOWS_PER_PAGE),
                                        currentPageElementsMaxIndex,
                                        maxNoOfElementsInResults));
                    }
                } else {
                    hasMorePages = false;
                }
            } else {
                foundWorkflow = true;
            }
            i++;
        }
        if (assertExists)
            Assert.assertTrue(String.format(
                    "No workflow with subject '%s' was found in the list!",
                    workflowName), foundWorkflow);
        return workflow;
    }

    public String getWorkflowID(String workflowSubject) {
        String workflowIDContainer = getWorkflowElementFromList(
                workflowSubject, true)
                .findElement(
                        By.cssSelector("td.yui-dt-col-title > div.yui-dt-liner > h3 > a"))
                .getAttribute("href");
        return StringUtils.getFirstIntegerNumberAfterKeyFromString(
                workflowIDContainer, "activiti$").toString();
    }

    public void cancelWorkflowFromList(String workflowName) {
        WebElement workflow = getWorkflowElementFromList(workflowName, true);
        boolean success = false;
        int i = 0;
        while (!success && i < 10) {
            i++;
            try {
                workflow.findElement(
                        By.cssSelector("td.yui-dt-col-title > div.yui-dt-liner > h3 > a"))
                        .sendKeys("");
                mouseOver(workflow.findElement(By
                        .cssSelector("div.yui-dt-liner > div")));
                ((JavascriptExecutor)getDriver())
                        .executeScript(
                                "arguments[0].scrollIntoView();",
                                workflow.findElement(By
                                        .cssSelector("td.yui-dt-col-title > div.yui-dt-liner > h3 > a")));
                mouseOver(workflow.findElement(By
                        .cssSelector("div.yui-dt-liner > div")));
                workflow.findElement(
                        By.cssSelector("td.yui-dt-col-name.yui-dt-last > div.yui-dt-liner > div:nth-child(2) > a > span"))
                        .click();
                success = true;
            } catch (Exception e) {
                // e.printStackTrace();
                workflow.sendKeys(Keys.PAGE_DOWN);
            }
        }
        Assert.assertTrue("Could not click on 'Cancel' button!", success);
    }

    public void clickOnTaskAction(String workflowName, String action) {
        WebElement workflow = getWorkflowElementFromList(workflowName, true);
        workflow.findElement(
                By.cssSelector("td.yui-dt-col-title > div.yui-dt-liner > h3 > a"))
                .sendKeys("");
        mouseOver(workflow
                .findElement(By.cssSelector("div.yui-dt-liner > div")));
        ((JavascriptExecutor)getDriver())
                .executeScript(
                        "arguments[0].scrollIntoView();",
                        workflow.findElement(By
                                .cssSelector("td.yui-dt-col-title > div.yui-dt-liner > h3 > a")));

        mouseOver(workflow
                .findElement(By.cssSelector("div.yui-dt-liner > div")));
        getElementWithSpecifiedTextFromList(
                By.cssSelector("td.yui-dt-col-name.yui-dt-last > div.yui-dt-liner > div > a > span"),
                false, true, action).click();
        waitABit(4000);
    }

    public void selectPriority(String priorityName) {
        element(priorityDropDownList).waitUntilVisible();
        element(priorityDropDownList).click();
        // element(priorityDropDownList).selectByVisibleText(priorityName);
        List<WebElement> priorityList = getDriver()
                .findElements(
                        By.cssSelector("div[id*='form-fields']> div:nth-child(2) div[class*='form-field'] select option"));
        boolean foundOption = false;
        for (WebElement priority : priorityList) {
            if (priority.getText().equals(priorityName)) {
                priority.sendKeys("");
                priority.click();
                foundOption = true;
                break;
            }
        }
        Assert.assertTrue("The option was not found", foundOption);
    }

    public void checkPriority(String priority) {
        WebElement priorityName = getDriver()
                .findElement(
                        By.cssSelector("div[id*='form-fields']> div:nth-child(2)>div:first-child>div:nth-child(2) span[class*='value']"));

        Assert.assertTrue("The priority is not correct", priorityName.getText()
                .equals(priority));
    }

    public void checkPageTile(String title) {
        Assert.assertTrue(String.format(
                "The title should be '%s' but it is '%s'!", title,
                pageTitle.getText()), pageTitle.getText().contains(title));
    }

    public void clickOnTaskFilter() {
        WebElement taskFilter = getDriver()
                .findElement(
                        By.cssSelector("div[class*='dashlet my-tasks'] span[id*='default-filters'] button"));
        element(taskFilter).waitUntilVisible();
        element(taskFilter).click();
    }

    public void selectTaskFilter(String filter) {
        List<WebElement> filterList = getDriver()
                .findElements(
                        By.cssSelector("div[class*='my-tasks'] div[class*='menu-button'] div.bd ul li"));
        boolean foundOption = false;
        for (WebElement item : filterList) {
            if (item.getText().contains(filter)) {
                foundOption = true;
                item.click();
                break;
            }
        }
        Assert.assertTrue("The filter was not found", foundOption);
    }

    public void checkTaskTypeInMyTaskPage(String workflowName, String type) {
        WebElement workflow = getWorkflowElementFromList(workflowName, true);
        workflow.findElement(
                By.cssSelector("td.yui-dt-col-title > div.yui-dt-liner > h3 > a"))
                .sendKeys("");
        mouseOver(workflow
                .findElement(By.cssSelector("div.yui-dt-liner > div")));
        ((JavascriptExecutor)getDriver())
                .executeScript(
                        "arguments[0].scrollIntoView();",
                        workflow.findElement(By
                                .cssSelector("td.yui-dt-col-title > div.yui-dt-liner > h3 > a")));

        mouseOver(workflow
                .findElement(By.cssSelector("div.yui-dt-liner > div")));
        WebElement typeText = getElementWithSpecifiedTextFromList(
                By.cssSelector("td[class*='col-title'] div.type span"), false,
                true, type);
        boolean tasktype = false;
        if (typeText.getText().contains(type)) {
            tasktype = true;
        }
        Assert.assertTrue(String.format(
                "The type is '%s' and it should be '%s'", typeText, type),
                tasktype);
    }

    public void checkTaskTypeInWorkflowDetailsPage(String type) {
        WebElement typeText = getDriver()
                .findElement(
                        By.cssSelector("div[id*='workflowHistory'] tbody tr:first-child td[class*='col-name yui-dt-first'] a"));
        Assert.assertTrue("The type is not correct", typeText.getText()
                .contains(type));
    }

    public void editPriorityFromDataList(String priority) {
        WebElement priorityField = getDriver()
                .findElement(
                        By.cssSelector("div[id*='editDetails']>div.set div:nth-child(6) input"));
        element(priorityField).waitUntilVisible();
        element(priorityField).type(priority);
    }

    public void editStatusFromDataList(String status) {
        WebElement statusField = getDriver()
                .findElement(
                        By.cssSelector("div[id*='editDetails']>div.set div:nth-child(7) input"));
        element(statusField).clear();
        element(statusField).type(status);
    }

    public void clickOnSaveButtonWhenYouEditTaskFromDataList() {
        WebElement saveButton = getDriver()
                .findElement(
                        By.cssSelector("div[id*='editDetails-form-buttons'] span[id*='editDetails-form-submit'] button"));
        element(saveButton).waitUntilVisible();
        element(saveButton).click();
    }

    public void checkIfDateCorespondWithSystemTimeInDataList(String systemDate) {
        String date = getDriver()
                .findElement(
                        By.cssSelector("div.datagrid-meta div.last-update"))
                .getText().replace("Last Update: ", "");
        // String dateTime = DateUtils.toString(systemDate,
        // "EEE MMM d yyyy HH:mm:ss");
        DateUtils.checkDatesWithErrorMargin(systemDate,
                "dd MMM yyyy HH:mm:ss zzz", date, "EEE, d MMM yyyy HH:mm:ss",
                1, Calendar.MINUTE);
    }

    public void checkIfDateCorespondsWithSystemTimeInDataList(Date systemDate) {
        String date = getDriver()
                .findElement(
                        By.cssSelector("div.datagrid-meta div.last-update"))
                .getText().replace("Last Update: ", "");
        String dateTime = DateUtils.toString(systemDate,
                "EEE MMM d yyyy HH:mm:ss");
        DateUtils.checkDatesWithErrorMargin(dateTime,
                "EEE MMM d yyyy HH:mm:ss", date, "EEE, d MMM yyyy HH:mm:ss", 1,
                Calendar.MINUTE);
    }

    public void checkWorkflowSubjectFromWorkflowDetailsPage(String subject) {
        String workflowSubject = getDriver()
                .findElement(
                        By.cssSelector("div[id*='WorkflowForm']> div.set div:nth-child(5) span.viewmode-value"))
                .getText();
        Assert.assertTrue(String.format(
                "The subject should be '%s' but it is '%s'!", subject,
                workflowSubject), workflowSubject.contains(subject));
    }

    public void checkWorkflowSubjectFromTaskDetailsPage(String subject) {
        String workflowSubject = getDriver()
                .findElement(
                        By.cssSelector("div[id*='task-details']> div.set> div:nth-child(3) span.viewmode-value"))
                .getText();
        Assert.assertTrue(String.format(
                "The subject should be '%s' but it is '%s'!", subject,
                workflowSubject), workflowSubject.contains(subject));
    }

    public void inputDocumentName(String name) {
        WebElement documentNameField = getDriver()
                .findElement(
                        By.cssSelector("div[id*='extDgFilterForm'] div.set>div:first-child > div:first-child input"));
        element(documentNameField).waitUntilVisible();
        element(documentNameField).type(name);
    }

    public void inputComponentnameInLifecyleReport(String name) {
        WebElement documentNameField = getDriver()
                .findElement(
                        By.cssSelector("div[id*='extDgFilterForm'] div.set>div:first-child > div:nth-child(2) input"));
        element(documentNameField).waitUntilVisible();
        element(documentNameField).type(name);
    }

    public void clickOnFilterButton() {
        WebElement filterButton = getDriver().findElement(
                By.cssSelector("span[id*='filterform'] button"));
        element(filterButton).waitUntilVisible();
        element(filterButton).click();
    }

    public void selectLifecycleStage(String lifecycle) {
        List<WebElement> lifecycleList = getDriver()
                .findElements(
                        By.cssSelector("div[id*='extDgFilterForm'] div.set>div:first-child > div:nth-child(3) select option"));
        boolean foundOption = false;
        for (WebElement item : lifecycleList) {
            if (item.getText().equals(lifecycle)) {
                foundOption = true;
                item.click();
                break;
            }
        }
        Assert.assertTrue("The option was not found!", foundOption);
    }

    public void selectTaskStatus(String status) {
        List<WebElement> statusist = getDriver()
                .findElements(
                        By.cssSelector("div[id*='extDgFilterForm'] div.set> div:nth-child(3) select option"));
        boolean foundOption = false;
        for (WebElement item : statusist) {
            if (item.getText().equals(status)) {
                foundOption = true;
                item.click();
                break;
            }
        }
        Assert.assertTrue("The option was not found!", foundOption);
    }

    public void clickOnSelectLasModifierOrWorkflowInitiatorButton() {
        WebElement lastModifierButton = getDriver()
                .findElement(
                        By.cssSelector("div[id*='extDgFilterForm'] div.set>div:nth-child(2)>div:first-child button"));
        element(lastModifierButton).waitUntilVisible();
        element(lastModifierButton).click();
    }

    public void clickOnClearFiltersButton() {
        WebElement clearFilterButton = getDriver().findElement(
                By.cssSelector("span[id*='filterform-clear'] button"));
        element(clearFilterButton).waitUntilVisible();
        element(clearFilterButton).click();
    }

    public void inputComponentNameInDataList(String component) {
        WebElement componentNameField = getDriver()
                .findElement(
                        By.cssSelector("div[id*='extDgFilterForm'] div.set> div:nth-child(4) input"));
        element(componentNameField).waitUntilVisible();
        element(componentNameField).type(component);
    }

    public void verifyTaskMessage(String taskMessage) {
        String actualTaskMessage = taskMessageContainer.getText();
        Assert.assertTrue(String.format(
                "The task message should be '%s' but it is '%s'!", taskMessage,
                actualTaskMessage), actualTaskMessage.contains(taskMessage));
    }

    public void waitForFirstPageOfTasksListToLoad() {
        boolean result = waitUntilElementTextStartsWithGivenTextOrElementInvisible(
                By.cssSelector("div.paginator.yui-pg-container > span.yui-pg-current"),
                "1 - ", Delay.REASONABLE);
        Assert.assertTrue(
                String.format(
                        "The first page of the tasks list did not load after %d seconds!",
                        Delay.REASONABLE), result);
    }
}
