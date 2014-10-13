package a.pages.alfresco;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.DateUtils;
import a.tools.alfresco.Delay;

public class AlfrescoFilePreviewPage extends AbstractPage {
    public AlfrescoFilePreviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.action-set > div > a > span")
    private List<WebElement> documentActionsList;

    @FindBy(css = "div[class*='yui-u']> div:nth-child(7) div[class*='panel-body'] > div:first-child")
    private WebElement workflowMessage;

    @FindBy(css = "#tinymce > p")
    private WebElement commentInputField;

    @FindBy(css = "div.comments-list-actions > div.left > div[id*='default-actions'] > span > span.first-child > button")
    private WebElement addCommentButton;

    @FindBy(css = "div.comment-form > form > div.buttons > span.yui-button.yui-submit-button > span > button")
    private WebElement submitCommentButton;

    @FindBy(css = "iframe[id*='default-add-content_ifr']")
    private WebElement commentContentIframe;

    @FindBy(css = "html > body.mceContentBody")
    private WebElement commentContentInput;

    public void clickOnDocumentAction(String actionTitle) {
        boolean foundAction = false;
        waitForAllStringsToAppear(By.cssSelector("div.action-set"),
                Delay.MEDIUM, actionTitle);
        List<WebElement> documentActionsList = getDriver().findElements(
                By.cssSelector("div.action-set > div > a > span"));
        for (WebElement action : documentActionsList) {
            if (action.getText().contains(actionTitle)) {
                foundAction = true;
                action.click();
                break;
            }
        }
        Assert.assertTrue("The '" + actionTitle
                + "' document action was not found!", foundAction);
    }

    public boolean checkIfTheDocumentActionIsPresent(String actionTitle) {
        for (WebElement action : documentActionsList) {
            if (action.getText().contains(actionTitle)) {
                return true;
            }
        }
        return false;
    }

    public void checkThatDocumentActionIsPresent(String actionTitle) {
        Assert.assertTrue("The '" + actionTitle
                + "' document action is not present!",
                checkIfTheDocumentActionIsPresent(actionTitle));
    }

    public void checkThatDocumentActionIsNotPresent(String actionTitle) {
        Assert.assertFalse("The '" + actionTitle
                + "' document action should not be present!",
                checkIfTheDocumentActionIsPresent(actionTitle));
    }

    public void clickOnPopupButton(String buttonTitle) {
        boolean foundButton = false;
        List<WebElement> popupButtons = getDriver()
                .findElements(
                        By.cssSelector("div#prompt > div.ft > span.button-group > span"));
        for (WebElement button : popupButtons) {
            String title = button.getText();
            if (title.contains(buttonTitle)) {
                foundButton = true;
                button.click();
                break;
            }
        }
        Assert.assertTrue(
                String.format(
                        "The popup button with title '%s' was not found!",
                        buttonTitle), foundButton);
    }

    public void assertDocumentVersion(String version) {
        waitABit(4000);
        String versionNumber = getDriver().findElement(
                By.cssSelector("h1[class*='thin dark'] span.document-version"))
                .getText();
        Assert.assertTrue(String.format(
                "The document version is '%s' and it should be '%s'!",
                versionNumber, version), versionNumber.contains(version));
    }

    public void checkThatDocumentIsPartOfWorkflow(String message,
            String taskName) {
        WebElement workflowsContainer = getElementWithSpecifiedTextInsideElementFromListIfExists(
                By.cssSelector("div.yui-gc > div:nth-child(2) > div"),
                By.tagName("h2"), true, false, "Workflows");
        WebElement messageContainer = workflowsContainer
                .findElement(By
                        .cssSelector("div:first-child > div:nth-of-type(1) > div:nth-of-type(1) > div:first-child"));
        String messageText = messageContainer.getText();
        Assert.assertTrue(String.format(
                "The message should be '%s' and it is '%s'!", message,
                messageText), messageText.contains(message));
        getElementWithSpecifiedTextFromListInsideParentElement(
                workflowsContainer,
                By.cssSelector("div[class*='panel-body'] > div:nth-of-type(2) a"),
                true, false, taskName);
    }

    public void clickOnRevertIcon(String versionNumber) {
        WebElement versionContainer = getElementWithSpecifiedTextInsideElementFromListIfExists(
                By.cssSelector("div.yui-gc > div:nth-child(2) > div"),
                By.tagName("h2"), true, false, "Version");
        List<WebElement> olderVersionsList = versionContainer
                .findElements(By
                        .cssSelector("div[class*='yui-dt version-list'] tbody[class*='yui-dt-data'] tr"));
        boolean foundAction = false;
        for (WebElement version : olderVersionsList) {
            WebElement numberVersion = version.findElement(By
                    .cssSelector("td span[class*='document-version']"));
            System.out.println("!!!!!!!!!!!!!!!!" + numberVersion.getText());
            if (numberVersion.getText().equals(versionNumber)) {
                WebElement revertIcon = version
                        .findElement(By
                                .cssSelector("td span[class*='actions']>a:first-child"));
                revertIcon.click();
                foundAction = true;
            }
        }

        Assert.assertTrue("The action was not found", foundAction);
    }

    public void clickOnPreviewOnlineIcon(String versionNumber) {
        WebElement versionContainer = getElementWithSpecifiedTextInsideElementFromListIfExists(
                By.cssSelector("div.yui-gc > div:nth-child(2) > div"),
                By.tagName("h2"), true, false, "Version");
        List<WebElement> olderVersionsList = versionContainer
                .findElements(By
                        .cssSelector("div[class*='yui-dt version-list'] tbody[class*='yui-dt-data'] tr"));
        boolean foundAction = false;
        for (WebElement version : olderVersionsList) {
            WebElement numberVersion = version.findElement(By
                    .cssSelector("td span[class*='document-version']"));
            System.out.println("!!!!!!!!!!!!!!!!" + numberVersion.getText());
            if (numberVersion.getText().equals(versionNumber)) {
                WebElement previewIcon = version
                        .findElement(By
                                .cssSelector("td span[class*='actions']>a:nth-child(4)"));
                previewIcon.click();
                foundAction = true;
            }
        }

        Assert.assertTrue("The action was not found", foundAction);
    }

    public void verifyPropertyValue(String propertyName, String propertyValue) {
        String actualValue = getElementWithSpecifiedTextFromList(
                By.cssSelector("div.yui-u > div[id*='metadata'] > div[id*='metadata'] > div.folder-metadata-header.folder-details-panel div.set > div.form-field > div.viewmode-field"),
                false, false, propertyName).findElement(
                By.cssSelector("span.viewmode-value")).getText();
        Assert.assertTrue(
                String.format(
                        "The document '%s' property value should be '%s' and it is '%s'!",
                        propertyName, propertyValue, actualValue), actualValue
                        .equals(propertyValue));
    }

    public void insertCommentForAnnotation(String annotation) {
        element(commentInputField).waitUntilVisible();
        commentInputField.sendKeys(annotation);
        waitABit(5000);
    }

    public void navigateToNextPage() {
        WebElement nextButton = getDriver()
                .findElement(
                        By.cssSelector("div[id*='ice-main'] > div:nth-child(8)>div:first-child>button:nth-child(3)"));
        nextButton.click();
        waitABit(5000);
    }

    public void checkIfCommentDoesntExists(String userName, String message) {
        List<WebElement> commentList = getDriver()
                .findElements(
                        By.cssSelector("div[id*='comments-list'] table > tbody[class*='data'] > tr"));
        boolean foundComment = false;
        for (WebElement comment : commentList) {
            WebElement username = comment.findElement(By
                    .cssSelector("div[class*='details'] > span:first-child a"));
            if (username.getText().contains(userName)) {
                WebElement commentText = comment.findElement(By
                        .cssSelector("div[class*='details'] div:nth-child(3)"));
                if (commentText.getText().contains(message)) {
                    foundComment = true;
                    break;
                }
            }
        }
        Assert.assertFalse(
                String.format("The '%s' comment should not exist!", message),
                foundComment);
    }

    public void checkIfCommentIsPresent(String userName, String message) {
        List<WebElement> commentList = getDriver()
                .findElements(
                        By.cssSelector("div[id*='comments-list'] table > tbody[class*='data'] > tr"));
        boolean foundUser = false;
        boolean foundComment = false;
        for (WebElement comment : commentList) {
            WebElement username = comment.findElement(By
                    .cssSelector("div[class*='details'] > span:first-child a"));
            if (username.getText().contains(userName)) {
                foundUser = true;
                WebElement commentText = comment.findElement(By
                        .cssSelector("div[class*='details'] div:nth-child(3)"));
                if (commentText.getText().contains(message)) {
                    foundComment = true;
                    break;
                }
            }
        }
        Assert.assertTrue(String.format(
                "No comment submitted by '%s' was found!", userName), foundUser);
        Assert.assertTrue(
                String.format("The '%s' comment was not found!", message),
                foundComment);
    }

    public void checkIfCommentIsPresent(String userName, String message,
            String... actionNames) {
        List<WebElement> commentList = getDriver()
                .findElements(
                        By.cssSelector("div[id*='comments-list'] table > tbody[class*='data'] > tr"));
        boolean foundUser = false;
        boolean foundComment = false;
        for (WebElement comment : commentList) {
            WebElement username = comment
                    .findElement(By
                            .cssSelector("div.comment-details > div.details > span.info > a"));

            if (username.getText().contains(userName)) {
                foundUser = true;
                WebElement commentText = comment
                        .findElement(By
                                .cssSelector("div.comment-details > div.details > div.comment-content > p"));

                if (commentText.getText().contains(message)) {
                    foundComment = true;
                    mouseOver(comment);
                    List<WebElement> actionsList = comment
                            .findElements(By
                                    .cssSelector("div.comment-details > div.details > span.comment-actions > a"));
                    for (String actionName : actionNames) {
                        boolean foundAction = false;
                        for (WebElement action : actionsList) {
                            mouseOver(action);
                            String actualActionTitle = action
                                    .getAttribute("title");
                            if (actualActionTitle.equals(actionName)) {
                                foundAction = true;
                                break;
                            }
                        }
                        Assert.assertTrue(String.format(
                                "The '%s' action was not found!", actionName),
                                foundAction);
                    }
                    break;
                }
            }
        }
        Assert.assertTrue(String.format(
                "No comment submitted by '%s' was found!", userName), foundUser);
        Assert.assertTrue(
                String.format("The '%s' comment was not found!", message),
                foundComment);
    }

    public void checkIfDocumentIsLocked(String message) {
        WebElement notification = getDriver()
                .findElement(
                        By.cssSelector("div[class*='node-header']>div:first-child span"));
        Assert.assertTrue("The notification is not present", notification
                .getText().contains(message));
    }

    public void clickOnAddCommentButton() {
        addCommentButton.click();
    }

    public void clickOnSubmitCommentButton() {
        getDriver().switchTo().defaultContent();
        submitCommentButton.click();
    }

    public void insertCommentContent(String content) {
        getDriver().switchTo().frame(commentContentIframe);
        commentContentInput.sendKeys(content);
    }

    public void checkMessageForOnlinePreview(String message, String file) {
        WebElement messageField = getDriver().findElement(
                By.cssSelector("div[class*='versioned-link-wrapper'] span"));
        boolean foundMessage = false;
        if (messageField.getText().contains(message)) {
            WebElement fileName = getDriver().findElement(
                    By.cssSelector("div[class*='versioned-link-wrapper'] a"));
            if (fileName.getText().contains(file)) {
                foundMessage = true;
            }
        }
        Assert.assertTrue("The message is not present!", foundMessage);
    }

    public void checkThatDateCorespondWithSystemTime(Date systemDate) {
        String date = getDriver()
                .findElement(By.cssSelector("span[class*='modifier'] span"))
                .getText();
        String dateTime = DateUtils
                .toString(systemDate, "EEE d MMM yyyy HH:mm:ss");
        DateUtils.checkDatesWithErrorMargin(dateTime, "EEE d MMM yyyy HH:mm:ss",
                date, "EEE d MMM yyyy HH:mm:ss", 1, Calendar.MINUTE);
    }

    public void verifyDocumentTitle(String title) {
        implicitlyWaitReasonable();
        System.out.println("1111111111111111111111111111111111111111");
        String documentVersion = getElementWhenVisible(
                By.cssSelector("div.node-info > h1 > span#document-version"),
                Delay.REASONABLE).getText();
        System.out.println("22222222222222222222222222222222222222222222");
        String docTitle = getElementWhenVisible(
                By.cssSelector("div.node-info > h1"), Delay.REASONABLE)
                .getText().replace(documentVersion, "").trim();
        Assert.assertTrue(String.format(
                "The document title is '%s' and it should be '%s'!", docTitle,
                title), docTitle.contains(title));
        implicitlyWaitDefault();
    }
}
