package a.pages.alfresco;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Delay;

public class AlfrescoUploadAssetsPage extends AbstractPage {

    public AlfrescoUploadAssetsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[class $= 'file-selection-button']")
    private WebElement selectFilesButton;

    @FindBy(css = "div.bd > div:nth-child(7)>span:nth-child(2)")
    private WebElement cancelOkUploadButton;

    @FindBy(css = "div.yui-dt-bd")
    private WebElement uploadFilesContainer;

    // Upload
    @FindBy(css = "button[id*='default-fileUpload-button-button']")
    private WebElement uploadButton;

    @FindBy(css = "div.bd > div:nth-child(7) > span:first-child")
    private WebElement uploadFileButton;

    @FindBy(css = "input[id*='efault-filedata-file']")
    private WebElement uploadInputNoFlash;

    @FindBy(css = "div[class*='bd'] > div[id*='versionSection-div'] textarea")
    private WebElement commentField;

    public void clickOnSelectFile() {
        try {
            implicitlyWaitSmall();
            WebElement selectFilesButton = getDriver().findElement(
                    By.cssSelector("input.dnd-file-selection-button"));
            selectFilesButton.click();
        } catch (Exception e) {
            implicitlyWaitDefault();
            try {
                //clickOnButtonUsingSikuli(Constants.SIKULI_IMAGES_FOLDER + "SelectFilesToUploadButton.png");
            } catch (Exception e1) {
                e1.printStackTrace();
                Assert.fail("Could not click on the select file button!");
            }
        }
    }

    public void inputCommentField(String comment) {
        WebElement commentField = null;
        try {
            implicitlyWaitSmall();
            commentField = getDriver().findElement(
                    By.cssSelector("div.bd > div[id*='versionSection-div'] textarea"));
        } catch (Exception e) {
            commentField = waitUntilElementExists(
                    By.cssSelector("div[class*='bd'] > form[id*='htmlupload-form'] > fieldset > div[id*='versionSection-div'] textarea"), Delay.SMALL);
            implicitlyWaitDefault();
        }
        $(commentField).waitUntilVisible();
        commentField.sendKeys(comment);
    }

    public void clickOnUploadFileButton() {
        WebElement uploadFileButton = null;
        try {
            implicitlyWaitSmall();
            uploadFileButton = getDriver().findElement(
                    By.cssSelector("div.dnd-upload.yui-module.yui-overlay.yui-panel div.bd button[id*='default-upload-button-button']"));
        } catch (Exception e) {
            uploadFileButton = waitUntilElementExists(By.cssSelector("div.bd > div:nth-child(7) > span:first-child > span > button"), Delay.SMALL);
            implicitlyWaitDefault();
        }
        $(uploadFileButton).waitUntilVisible();
        uploadFileButton.click();
    }

    public void clickOnCancelOkUpload() {
        WebElement cancelOkUploadButton = getDriver().findElement(
                By.cssSelector("div.dnd-upload.yui-module.yui-overlay.yui-panel div.bd button[id*='default-cancelOk-button-button']"));
        element(cancelOkUploadButton).waitUntilVisible();
        element(cancelOkUploadButton).click();
    }

    public void insertFilePath(String filePath) {
        try {
            implicitlyWaitSmall();
            WebElement selectFilesButton = getDriver().findElement(
                    By.cssSelector("input.dnd-file-selection-button"));
            selectFilesButton.sendKeys(filePath);
        } catch (Exception e) {
            implicitlyWaitDefault();
            try {
            	System.out.println("Use Robot instead of Sikuli");
            } catch (Exception e1) {
                e1.printStackTrace();
                Assert.fail("Could not click on the upload file button!");
            }
            System.out.println("Use Robot instead of Sikuli");
        }
    }

    public void selectVersionType(String versionType) {
        List<WebElement> versionChanges = getDriver().findElements(By.cssSelector("div[id*='versionSection-div'] div"));
        boolean foundChanges = false;

        for (int i = 1; i < versionChanges.size(); i++) {
            WebElement changes = versionChanges.get(i);
            if (changes.getText().contains(versionType)) {
                foundChanges = true;
                WebElement changesInput = changes.findElement(By.cssSelector("input"));
                changesInput.click();
                break;
            }
        }
        Assert.assertTrue("The version option '" + versionType + "' was not found!", foundChanges);

    }

    public void checkThatUploadButtonIsDisabled() {
        String disabled = getDriver().findElement(
                By.cssSelector("div.dnd-upload.yui-module.yui-overlay.yui-panel div.bd > div.bdft > span:first-child > span > button"))
                .getAttribute("disabled");
        waitABit(5000);
        Assert.assertTrue("The button is enabled", disabled.contains("true"));
    }

    public void clickOnRemoveFile() {
        WebElement removeButton = getDriver().findElement(By.cssSelector("span[class*='fileButton-span']>span[class*='push-button'] button"));
        removeButton.click();
    }

    public void checkThatNoFilesWereSelected(String message) {
        WebElement notification = getDriver().findElement(By.cssSelector("div[class*='fileUpload'] div:nth-of-type(3) tbody[class*='message'] div"));
        Assert.assertTrue("The message is not displayed!", notification.getText().contains(message));
    }
}
