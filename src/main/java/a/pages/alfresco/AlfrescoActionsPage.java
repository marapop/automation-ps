package a.pages.alfresco;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

@SuppressWarnings("deprecation")
public class AlfrescoActionsPage extends AbstractPage{

	public AlfrescoActionsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div.action-set")
	private WebElement documentActionsContainer;

	@FindBy(css = "div[id*='default-actionSet']")
	private WebElement docActionsContainer;

	@FindBy(className = "document-change-type")
	private WebElement changeType;

	@FindBy(css = "a[title='Edit Properties']")
	private WebElement editProperties;

	@FindBy(css = "a[title='Manage Aspects']")
	private WebElement manageAspects;

	@FindBy(css = "a[title='Delete Document']")
	private WebElement deleteDocument;

	@FindBy(css = "a[title*='Link To']")
	private WebElement linkTo;

	@FindBy(css = "a[title='Manage Permissions']")
	private WebElement managePermissions;

	@FindBy(css = "a[title='Edit Offline']")
	private WebElement editOffline;

	@FindBy(css = "a[title='Cancel Editing']")
	private WebElement cancelEditing;

	@FindBy(css = "a[title='Start Workflow']")
	private WebElement startWorkflow;

	@FindBy(css = "a[title='Start transformation']")
	private WebElement startTransformation;

	@FindBy(css = "a[title*='Move to']")
	private WebElement moveTo;

	@FindBy(className = "document-delete")
	private WebElement deleteButton;

	@FindBy(className = "document-upload-new-version")
	private WebElement uploadButton;

	@FindBy(css = "div.node-header > div:first-child > span")
	private WebElement lockedMessage;




	public void clickOnUploadNewVersion() {
		expandActionsFields();
		disableFlash();
		element(uploadButton).waitUntilVisible();
		uploadButton.findElement(By.tagName("a")).click();
	}

	public void clickOnChangeType() {
		element(changeType).waitUntilVisible();
		changeType.findElement(By.tagName("a")).click();
	}

	public void clickOnManagePermissions() {
		element(managePermissions).waitUntilVisible();
		managePermissions.click();
	}

	public void clickOnEditProperties() {
		element(editProperties).waitUntilVisible();
		editProperties.click();
	}
	public void clickOnEditPropertiesNoExpand() {	
		element(editProperties).waitUntilVisible();
		editProperties.click();
	}

	public void clickOnDeleteDocument() {
		element(deleteDocument).waitUntilVisible();
		deleteDocument.click();
	}

	public void clickOnManageAspects() {
		element(manageAspects).waitUntilVisible();
		manageAspects.click();
	}

	public void clickOnEditOffline() {
		expandActionsFields();
		element(editOffline).waitUntilVisible();
		editOffline.click();
		waitABit(Constants.WAIT_TIME_SHORT);
	}

	public void clickOnCancelEditing() {
		element(cancelEditing).waitUntilVisible();
		cancelEditing.click();
	}

	public void verifyCancelEditingButtonIsPresent() {
		Assert.assertTrue(element(cancelEditing).isVisible());
	}

	public void clickOnLinkTo() {
		element(linkTo).waitUntilVisible();
		linkTo.click();
	}

	public void clickOnTemporaryShareContentDocumentView() {
		getDriver().navigate().refresh();
		element(documentActionsContainer).waitUntilVisible();
		WebElement temporarilyShareContentButton = documentActionsContainer
				.findElement(By.cssSelector("div a[title='Temporarily Share Content']"));
		System.out.println(("Searched elem title: " + 
				temporarilyShareContentButton.getAttribute("title")));
		waitABit(Constants.WAIT_TIME_SHORT);
		temporarilyShareContentButton.sendKeys("");
		temporarilyShareContentButton.sendKeys(" ");
		temporarilyShareContentButton.click();

	}

	public void deleteAsset() {
		element(deleteButton).waitUntilVisible();
		deleteButton.findElement(By.tagName("a")).click();
	}

	public void verifyCancelEditingButtonNotPresent() {
		element(docActionsContainer).waitUntilVisible();
		Assert.assertFalse(docActionsContainer.getText().contains("Cancel Editing"));
	}

	public void verifyTheEditOfflineMessageIsPresent(String message) {
		element(lockedMessage).waitUntilVisible();
		Assert.assertTrue(lockedMessage.getText().contains(message));
	}

	public void clickOnStartWorkflow() {
		element(startWorkflow).waitUntilVisible();
		startWorkflow.click();
	}

	public void clickOnStartTransformation() {
		element(startTransformation).waitUntilVisible();
		startTransformation.click();
	}

	public void clickOnMoveTo() {
		element(moveTo).waitUntilVisible();
		moveTo.click();
	}
}
