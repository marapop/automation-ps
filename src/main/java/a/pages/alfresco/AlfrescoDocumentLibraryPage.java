package a.pages.alfresco;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;
import a.tools.alfresco.Delay;
import a.tools.alfresco.RobotUtils;

public class AlfrescoDocumentLibraryPage extends AbstractPage {

	public AlfrescoDocumentLibraryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "table#yuievtautoid-0 > tbody.yui-dt-data")
	private WebElement documentLibraryElementsContainer;


    @FindBy(css = "input[id*='default-createFolder_prop_cm_name")
    private WebElement folderNameField;

	@FindBy(css = "div[class*='crumb documentDroppable documentDroppableHighlights'] a")
	public List<WebElement> crumbDocumentList;

    @FindBy(css = "button[id*='default-createFolder-form-submit-button")
    private WebElement saveFolderButton;

	@FindBy(css = "form.bd > div.form-fields > div.set > div.form-field:nth-child(1) > input")
	private WebElement newFolderNameInput;

	@FindBy(css = "form.bd > div.form-fields > div.set > div.form-field:nth-child(2) > input")
	private WebElement newFolderTitleInput;

	@FindBy(css = "form.bd > div.form-fields > div.set > div.form-field:nth-child(3) > textarea")
	private WebElement newFolderDescriptionInput;

	@FindBy(css = "div.yui-u.first.edit-metadata.flat-button > span > span.first-child > a")
	private WebElement allPropertiesButton;

	@FindBy(css = "div[id*='default-form-buttons'] >span:first-child button")
	private WebElement saveButton;

    @FindBy(css = "button[id*='default-aspects-ok-button']")
    private WebElement applyChangesButton;
    
	@FindBy(css = "span[id*='createContent-button'] button")
	private WebElement createContentLink;

	@FindBy(css = "div[id*='default-form-fields']> div > div:first-child input")
	private WebElement contentName;

	@FindBy(css = "div[id*='default-form-fields'] > div textarea")
	private WebElement contentSectionContent;

	@FindBy(css = "input[name='prop_cm_name']")
	private WebElement documentNameInput;

	@FindBy(css = "div[class*='bdft']> span[id*='categories-cntrl-ok'] button")
	private WebElement okButtonAddCatgories;


    @FindBy(css = "button[id*='createContent-button-button']")
    private WebElement createContentButton;

	@FindBy(css = "textarea[id*='description']")
	private WebElement fileDescriptionPropertyInput;


	@FindBy(css = "div#prompt > div.ft > span.button-group > span > span.first-child > button")
	private WebElement conversionCompletedOkButton;

	@FindBy(css = "div#prompt > div.ft > span.button-group > span.default > span.first-child > button")
	private WebElement conversionCompletedCancelButton;

	@FindBy(css = "div#prompt > div.bd")
	private WebElement conversionCompletedMessageContainer;
    
    @FindBy(css = "div[id*='HEADER_USER_MENU_POPUP_dropdown']")
	private WebElement administratorContainer;


	@FindBy(css = "span[id*='HEADER_USER_MENU_POPUP_text']")
	private WebElement administratorButton;
	
//	------------------------------------------------

	@FindBy(css = "[id $= 'default-fileUpload-button-button']")
	private WebElement uploadButton;

	@FindBy(css = "div[id $= 'default-flashuploader-div'] > *")
	private WebElement selectFileButton;

	@FindBy(css = "[id $= 'default-upload-button-button']")
	private WebElement uploadFileButton;

	@FindBy(css = "[id $= 'default-cancelOk-button-button']")
	private WebElement uploadOkButton;

	@FindBy(css = "div.site-navigation")
	private WebElement siteNavigationContainer;

	@FindBy(css = "[id $= 'default-fileSelect-button-button']")
	private WebElement selectButton;

	@FindBy(className = "selectAll")
	private WebElement allLink;

	@FindBy(css = "span.contents-file")
	private WebElement contentsButton;

	@FindBy(css = "span.text-file")
	private WebElement plainFileButton;

	@FindBy(css = "span.book-file")
	private WebElement booksButton;

	@FindBy(css = "[id $= 'default_prop_cm_name']")
	private WebElement contentNameField;

	@FindBy(css = "[id $= 'default-form-submit-button']")
	private WebElement createSubmitButton;

	@FindBy(css = "[id $= 'default_prop_cm_title']")
	private WebElement contentTitleField;

	@FindBy(css = "[id $= 'default_prop_cm_description']")
	private WebElement contentDescriptionField;

	@FindBy(css = "div.node-path > span:last-child > a")
	private WebElement createdCollectionButton;

	@FindBy(css = "[id $= 'selectedItems-button-button']")
	private WebElement selectedItemsButton;

	@FindBy(css = "span.onActionDelete")
	private WebElement deleteButton;

	@FindBy(css = "div#prompt > div.ft button")
	private WebElement deleteButton2;

	@FindBy(css = "span.label")
	private WebElement collectionDetails;

	@FindBy(css = "a[title='Manage Aspects']")
	private WebElement manageAspectsButton;

	@FindBy(css = "[id $= 'default-newFolder-button-button']")
	private WebElement newFolderButton;

	@FindBy(css = "[id $= 'default-aspects-cancel-button']")
	private WebElement cancelButton;

	@FindBy(css = "span.onActionCopyTo")
	private WebElement copyToButton;

	@FindBy(css = "span.onActionMoveTo")
	private WebElement moveToButton;

	@FindBy(css = "span.onActionLinkTo")
	private WebElement linkToButton;

	@FindBy(css = "span.onActionManagePermissions")
	private WebElement managePermissionsButton;

	@FindBy(css = "span.onActionDeselectAll")
	private WebElement deselectAllButton;

	@FindBy(css = "[id $= 'default-copyMoveTo-title']")
	private WebElement copyItemPopUpScreen;

	@FindBy(css = "[id $= 'default-permissions-title']")
	private WebElement managePermissionsPopUpScreen;

	@FindBy(css = "[id $= 'default-permissions-cancel-button']")
	private WebElement managePermissionsCancelButton;

	@FindBy(css = "a[title='Edit Properties'] > span")
	private WebElement editPropertiesButton;

	@FindBy(id = "HEADER_SITE_DOCUMENTLIBRARY_text")
	private WebElement documentLibrary;

	@FindBy(css = "div[id$='default-documents']")
	private WebElement defaultDocuments;
	
	@FindBy(css = "a[id*='invite-button'] span")
	private WebElement invitePeopleButton;


	public void logout() {
		element(administratorContainer).waitUntilVisible();
		element(administratorButton).waitUntilVisible();
		administratorButton.click();

		waitABit(2000);
		element(administratorContainer).waitUntilVisible();
		administratorContainer.findElement(By.cssSelector("td[id*='HEADER_USER_MENU_LOGOUT_text']")).click();

	}
	public void openDetailsView() {
		element(collectionDetails).waitUntilVisible();
		collectionDetails.click();
		waitABit(Constants.WAIT_TIME);
	}

	public void inputFolderName(String folderName) {
		element(folderNameField).waitUntilVisible();
		element(folderNameField).type(folderName);
	}


	public void clickOnSaveFolderButton() {
		element(saveFolderButton).waitUntilVisible();
		element(saveFolderButton).click();
	}
    
	public void clickOnCreateContentLink() {
		element(createContentLink).waitUntilVisible();
		element(createContentLink).click();

	}

	public void inputContentName(String name) {
		element(contentName).waitUntilVisible();
		element(contentName).type(name);
	}

	public void inputContentSectionContent(String contentSection) {
		element(contentSectionContent).type(contentSection);
	}

	public void clickOnCreateContentButton() {
		element(createContentButton).waitUntilVisible();
		element(createContentButton).click();
		waitABit(5000);
	}

	public void clickOnDocumentLibraryActionButton(String... buttonTitles) {
		WebElement container = getElementWithSpecifiedTextFromList(
				By.cssSelector("div.header-bar.flat-button.theme-bg-2 > div > div.hideable.DocListTree > *"),
				true, false, buttonTitles[0]);
		container.findElement(By.cssSelector("span > button")).click();
		if (buttonTitles.length > 1)
			getElementWithSpecifiedTextFromList(
					By.cssSelector("div.yuimenu.yui-module.yui-overlay.yui-button-menu.yui-menu-button-menu.visible > div.bd > ul.first-of-type > li > a > span"),
					true, false, buttonTitles[1]).click();
	}

	public void verifyNodesInBreadcrumbs(String... nodes) {
		for (int k = 0; k < 10; k++) {
			try {
				implicitlyWaitSmall();
				boolean foundFirstNode = false;
				// first we try to find the breadcrumbs from the files list
				List<WebElement> breadCrumbDocuments = getDriver()
						.findElements(
								By.cssSelector("div.breadcrumb.hideable.DocListTree.DocListCategories > div.crumb.documentDroppable.documentDroppableHighlights a"));
				// we remove the folder icons from the list
				if (breadCrumbDocuments.size() > 0) {
					breadCrumbDocuments = removeTheElementsHavingTheSpecifiedTextInAtributeFromList(
							breadCrumbDocuments, "class", "icon");
					waitForAllStringsToAppear(
							By.cssSelector("div.breadcrumb.hideable.DocListTree.DocListCategories"),
							Delay.SMALL, nodes[0]);
					for (int i = 0; i < breadCrumbDocuments.size(); i++) {
						System.out.println("--------------------------------- "
								+ i);
						WebElement breadCrumb = breadCrumbDocuments.get(i);
						String currentNodeText = breadCrumb.getText();
						if (currentNodeText.equals(nodes[0])) {
							foundFirstNode = true;
							for (int j = 1; j < nodes.length; j++) {
								String currentNode = nodes[j];
								waitForAllStringsToAppear(
										By.cssSelector("div.breadcrumb.hideable.DocListTree.DocListCategories"),
										Delay.SMALL, currentNode);
								breadCrumb = breadCrumbDocuments.get(i + j);
								currentNodeText = breadCrumb.getText();
								Assert.assertTrue(
										String.format(
												"The current node should be '%s' but it is '%s'!",
												currentNode, currentNodeText),
												currentNode.equals(currentNodeText));
							}
							break;
						}
					}
				} else {
					// then we try to find the breadcrumbs from the file preview
					breadCrumbDocuments = getDriver()
							.findElements(
									By.cssSelector("div[id*='node-header'] > div.node-header > div.node-info > div.node-path > span.folder-link > a"));
					if (nodes.length > 1) {
						waitForAllStringsToAppear(
								By.cssSelector("div[id*='node-header'] > div.node-header > div.node-info > div.node-path"),
								Delay.SMALL, nodes[0]);
						for (int i = 0; i < breadCrumbDocuments.size(); i++) {
							System.out
							.println("--------------------------------- "
									+ i);
							WebElement breadCrumb = breadCrumbDocuments.get(i);
							String currentNodeText = breadCrumb.getText();
							if (currentNodeText.equals(nodes[0])) {
								foundFirstNode = true;
								for (int j = 1; j < nodes.length - 1; j++) {
									String currentNode = nodes[j];
									waitForAllStringsToAppear(
											By.cssSelector("div[id*='node-header'] > div.node-header > div.node-info > div.node-path"),
											Delay.SMALL, currentNode);
									breadCrumb = breadCrumbDocuments.get(i + j);
									currentNodeText = breadCrumb.getText();
									Assert.assertTrue(
											String.format(
													"The current node should be '%s' but it is '%s'!",
													currentNode,
													currentNodeText),
													currentNode.equals(currentNodeText));
								}
								waitForAllStringsToAppear(
										By.cssSelector("div[id*='node-header'] > div.node-header > div.node-info > div.node-path"),
										Delay.SMALL, nodes[nodes.length - 1]);
								break;
							}
						}
					} else {
						foundFirstNode = checkIfAllStringsAppear(
								By.cssSelector("div[id*='node-header'] > div.node-header > div.node-info > h1.thin.dark"),
								Delay.SMALL, nodes[0]);
					}
				}
				Assert.assertTrue(String.format(
						"The '%s' node was not found in the breadcrumbs!",
						nodes[0]), foundFirstNode);
				implicitlyWaitDefault();
				break;
			} catch (Exception e) {
				Assert.fail("The node title could not be retreived!");
			}
		}
	}
	
	public void selectDocumentFromDocumentLibrary(String... docPath) {
		WebElement document = getDocumentElementFromDocumentLibrary(true,
				docPath)
				.findElement(
						By.cssSelector("td[headers*='fileName'] > div > h3[class*='filename'] > span > a"));
		document.click();
	}

	public void clickOnDocumentCheckboxFromDocumentLibrary(String... docPath) {
		WebElement documentCheckbox = getDocumentElementFromDocumentLibrary(
				true, docPath).findElement(
						By.cssSelector("td[headers*='nodeRef'] > div > input"));
		documentCheckbox.click();
	}

	public void clickOnDocumentActionFromDocumentLibrary(String action,
			String... docPath) {
		WebElement document = getDocumentElementFromDocumentLibrary(true,
				docPath);
		document.findElement(By.cssSelector("h3.filename span a")).sendKeys("");
		mouseOver(document
				.findElement(By.cssSelector("div.yui-dt-liner > div")));
		List<WebElement> documentActions = document
				.findElements(By
						.cssSelector("td[headers*='actions'] > div > div[id*='actions'] > div[class*='action'] > div > a > span"));
		boolean foundAction = false;
		for (WebElement documentAction : documentActions) {
			if (documentAction.getText().contains(action)) {
				foundAction = true;
				documentAction.click();
				break;
			}
		}
		if (!foundAction) {
			jQueryNoConflict();
			documentActions.get(documentActions.size() - 1).click();
			documentActions = document
					.findElements(By
							.cssSelector("td[headers*='actions'] > div > div[id*='actions'] > div[class*='action'] > div[class*='more-actions'] > div > a"));
			for (WebElement documentAction : documentActions) {
				mouseOver(documentAction);
				if (documentAction.getText().contains(action)) {
					foundAction = true;
					documentAction.click();
					break;
				}
			}
		}
		Assert.assertTrue(String.format(
				"The '%s' document action was not found!", action), foundAction);
	}

	public boolean checkIfTheDocumentActionFromDocumentLibraryIsPresent(
			String action, String... docPath) {
		WebElement document = getDocumentElementFromDocumentLibrary(true,
				docPath);
		document.findElement(By.cssSelector("h3.filename span a")).sendKeys("");
		mouseOver(document
				.findElement(By.cssSelector("div.yui-dt-liner > div")));
		List<WebElement> documentActions = document
				.findElements(By
						.cssSelector("td[headers*='actions'] > div > div[id*='actions'] > div[class*='action'] > div > a > span"));
		Assert.assertTrue("No document actions were found!",
				documentActions.size() > 0);
		boolean foundAction = false;
		for (WebElement documentAction : documentActions) {
			if (documentAction.getText().contains(action)) {
				foundAction = true;
				break;
			}
		}
		if (!foundAction) {
			WebElement moreOption = documentActions
					.get(documentActions.size() - 1);
			$(moreOption).waitUntilVisible();
			moreOption.click();
			documentActions = document
					.findElements(By
							.cssSelector("td[headers*='actions'] > div > div[id*='actions'] > div[class*='action'] > div[class*='more-actions'] > div > a > span"));
			Assert.assertTrue("No document actions were found!",
					documentActions.size() > 0);
			for (WebElement documentAction : documentActions) {
				if (documentAction.getText().contains(action)) {
					foundAction = true;
					break;
				}
			}
		}
		return foundAction;
	}

	public void checkThatTheDocumentActionFromDocumentLibraryIsPresent(
			String action, String... docPath) {
		Assert.assertTrue(
				String.format("The '%s' document action is not present!",
						action),
						checkIfTheDocumentActionFromDocumentLibraryIsPresent(action,
								docPath));
	}

	public void checkThatTheDocumentActionFromDocumentLibraryIsNotPresent(
			String action, String... docPath) {
		Assert.assertFalse(
				String.format(
						"The '%s' document action should not be present!",
						action),
						checkIfTheDocumentActionFromDocumentLibraryIsPresent(action,
								docPath));
	}

	public void clickOnInvitePeople() {
		invitePeopleButton.click();
		Assert.assertTrue("The e'Invite people' button was not found", invitePeopleButton.isDisplayed());
	}
	
	public void checkThatDocumentExists(String... docPath) {
		getDocumentElementFromDocumentLibrary(true, docPath);
	}

	public boolean checkIfDocumentExists(String documentName) {
		return checkIfElementWithSpecifiedTextExistsInList(
				By.cssSelector("div.documents.yui-dt > table > tbody.yui-dt-data > tr td[headers*='fileName'] > div > h3[class*='filename'] > span > a"),
				true, false, documentName);
	}

	public void checkThatDocumentDoesntExist(String... docPath) {
		getDocumentElementFromDocumentLibrary(false, docPath);
	}

	public void checkThatTheDocumentIsLocked(String message, String... docPath) {
		WebElement document = getDocumentElementFromDocumentLibrary(true,
				docPath);
		WebElement notification = document.findElement(By
				.cssSelector("div[class*='info-banner']"));

		Assert.assertTrue("The banner is not present", notification.getText()
				.contains(message));
	}

	private WebElement getDocumentElementFromDocumentLibrary(
			boolean shouldExist, String... docPath) {
		boolean foundDoc = false;
		for (int i = 0; i < docPath.length; i++) {
			String pathElement = docPath[i];
			if (i < docPath.length - 1 || shouldExist)
				waitForAllStringsToAppear(
						By.cssSelector("div.documents.yui-dt > table > tbody.yui-dt-data"),
						Delay.REASONABLE, pathElement);
			waitForRenderedElements(By
					.cssSelector("div.documents.yui-dt > table > tbody.yui-dt-data > tr"));
			List<WebElement> documentsList = getDriver()
					.findElements(
							By.cssSelector("div.documents.yui-dt > table > tbody.yui-dt-data > tr"));
			for (WebElement document : documentsList) {
				WebElement docTitle = document
						.findElement(By
								.cssSelector("td[headers*='fileName'] > div > h3[class*='filename'] > span > a"));
				String documentTitle = docTitle.getText();
				if (documentTitle.equals(pathElement)) {
					foundDoc = true;
					if (i < docPath.length - 1) {
						docTitle.click();
						break;
					} else
						return document;
				}
			}
			if (shouldExist)
				Assert.assertTrue("The node named '" + docPath[i]
						+ "' was not found!", foundDoc);
			else
				Assert.assertFalse("The node named '"
						+ docPath[docPath.length - 1] + "' should not exist!",
						foundDoc);
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void waitForPageToFinishRendering(WebDriver oDriver,
			int timeout) {
		ExpectedCondition e = new ExpectedCondition() {
			@SuppressWarnings("unused")
			public Boolean apply(WebDriver d) {
				JavascriptExecutor js = (JavascriptExecutor)d;
				Boolean isReady = (Boolean)js
						.executeScript("return AdfPage.PAGE.isSynchronizedWithServer()");
				return isReady;
			}

			public Object apply(Object arg0) {
				return null;
			}
		};
		WebDriverWait w = new WebDriverWait(oDriver, timeout, 100);
		w.until(e);
	}

	public void clickOnDocumentLibraryHeaderButton(String buttonTitle) {
		getElementWithSpecifiedTextFromList(
				By.cssSelector("div.header-bar > div.left > div.hideable.DocListTree button"),
				false, false, buttonTitle);
	}

	public void insertNewFolderName(String name) {
		newFolderNameInput.sendKeys(name);
	}

	public void insertNewFolderTitle(String title) {
		newFolderTitleInput.sendKeys(title);
	}

	public void insertNewFolderDescription(String description) {
		newFolderDescriptionInput.sendKeys(description);
	}

	public void clickOnNewFolderSaveButton(String name) {
		saveFolderButton.click();
		verifyNotificationMessage(String.format("Folder '%s' created", name));
	}

	public void clickOnApplyChangesForAspectsButton() {
		applyChangesButton.click();
		verifyNotificationMessage("Successfully updated aspects");
	}

	public void selectAspects(String... aspects) {
		for (String aspect : aspects) {

			getElementWithSpecifiedTextFromList(
					By.cssSelector("form.bd tbody.yui-dt-data > tr"), false,
					false, aspect).findElement(
							By.cssSelector("td:nth-child(3) > div > a > span.addIcon"))
							.click();
		}

	}

	public void selectCategory(String... categories) {
		mouseOver(getDriver().findElement(
				(By.cssSelector("div[id*='categories-cntrl-picker-results']"))));
		for (String category : categories) {
			WebElement categoryName = getElementWithSpecifiedTextFromList(
					By.cssSelector("table[id*='yuievtautoid-0'] tbody.yui-dt-data >tr"),
					false, false, category).findElement(
							By.cssSelector("td:nth-child(3) > div > a > span.addIcon"));
			categoryName.sendKeys("");
			categoryName.click();
		}

	}

	public void clickOnAllPropertiesButton() {
		allPropertiesButton.click();
	}

	public void clickOnSelectButtonWithSpecifiedLabel(String labelTitle) {
		getElementWithSpecifiedTextInsideElementFromList(
				By.cssSelector("div.form-fields > div.set > div.form-field"),
				By.cssSelector("label"), false, false, labelTitle).findElement(
						By.cssSelector("div.object-finder span span")).click();
	}

	public void checkTextWithSpecifiedLabel(String labelTitle, String text) {
		WebElement textField = getElementWithSpecifiedTextInsideElementFromList(
				By.cssSelector("div.form-fields > div.set > div.form-field"),
				By.cssSelector("label"), false, false, labelTitle).findElement(
						By.cssSelector("div[id*='currentValueDisplay'] > div"));
		System.out.println("-----------" + textField.getText());

		Assert.assertTrue("The expected text was not found", textField
				.getText().contains(text));
	}

	public void selectRightsStatus(String status) {
		$(getElementWithSpecifiedTextFromList(By.cssSelector("div.form-fields > div.set > div.form-field"),
						false, false, "Rights Status").findElement(By.cssSelector("select"))).selectByVisibleText(status);
	}

	public void selectAssetFromPopupBox(String... assetPath) {
		for (int i = 0; i < assetPath.length - 1; i++) {
			String pathElement = assetPath[i];
			getElementWithSpecifiedTextFromList(
					By.cssSelector("tbody.yui-dt-data > tr h3.item-name > a"),
					true, false, pathElement).click();
			waitForAllStringsToAppear(By.cssSelector("tbody.yui-dt-data"),
					Delay.MEDIUM, assetPath[i + 1]);
		}
		getElementWithSpecifiedTextFromList(
				By.cssSelector("tbody.yui-dt-data > tr"), true, false,
				assetPath[assetPath.length - 1]).findElement(
						By.cssSelector("span.addIcon")).click();
	}

	public void clickOnPopupButton(String buttonTitle) {
		getElementWithSpecifiedTextFromList(
				By.cssSelector("div.bdft > span > span > button"), false,
				false, buttonTitle).click();
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void linkItemTo(String destination, String site, String... path) {
		getElementWithSpecifiedTextFromList(
				By.cssSelector("div.wrapper > div.mode.flat-button > div.yui-buttongroup > span > span > button"),
				true, false, destination).click();
		if (!site.isEmpty())
			getElementWithSpecifiedTextFromList(
					By.cssSelector("div.wrapper > div.site > div.site-picker > div > a"),
					true, false, site).click();
		waitABit(1000);
		waitForRenderedElements(By
				.cssSelector("div.wrapper > div.path > div.treeview > div.ygtvitem > div.ygtvchildren > div.ygtvitem"));
		WebElement branch = getElementWithSpecifiedTextFromList(
				By.cssSelector("div.wrapper > div.path > div.treeview > div.ygtvitem > div.ygtvchildren > div.ygtvitem"),
				true, false, path[0]);
		waitForRenderedElements(By
				.cssSelector("table.ygtvtable > tbody > tr.ygtvrow > td:last-child"));
		waitUntilElementAttributeDoesntContainText(
				branch.findElement(By
						.cssSelector("table.ygtvtable > tbody > tr.ygtvrow > td:last-child")),
						"class", "loading", Delay.MEDIUM);
		branch.findElement(
				By.cssSelector("table.ygtvtable > tbody > tr.ygtvrow > td > span.ygtvlabel"))
				.click();
		for (int i = 1; i < path.length; i++) {
			waitABit(1000);
			branch = getElementWithSpecifiedTextFromListInsideParentElement(
					branch, By.cssSelector("div.ygtvchildren > div.ygtvitem"),
					true, false, path[i]);
			waitForRenderedElements(By
					.cssSelector("table.ygtvtable > tbody > tr.ygtvrow > td:last-child"));
			waitUntilElementAttributeDoesntContainText(
					branch.findElement(By
							.cssSelector("table.ygtvtable > tbody > tr.ygtvrow > td:last-child")),
							"class", "loading", Delay.DEFAULT);
			branch.findElement(
					By.cssSelector("table.ygtvtable > tbody > tr.ygtvrow > td > span.ygtvlabel"))
					.click();
		}
	}

	public void selectContentType(String contentType) {
		List<WebElement> contentTypeList = getDriver()
				.findElements(
						By.cssSelector("div[id*='createContent-menu'] > div[class*='bd']>ul li span"));
		boolean foundType = false;
		for (WebElement typecontent : contentTypeList) {
			if (typecontent.getText().contains(contentType)) {
				foundType = true;
				typecontent.sendKeys("");
				clickOn(typecontent);
				break;
			}

		}
		Assert.assertTrue("The " + contentType + " type was not found!",
				foundType);

	}

	public void selectLifecycleStage(String lifecycle) {
		getDriver()
		.findElement(
				By.cssSelector("div[id*='form-container']>form > div:first-child > div > div:nth-of-type(7) select"))
				.click();
		List<WebElement> lifecycleList = getDriver()
				.findElements(
						By.cssSelector("div[id*='form-container']>form > div:first-child > div > div:nth-of-type(7) select > option"));

		boolean foundOption = false;
		for (WebElement stage : lifecycleList) {
			if (stage.getText().contains(lifecycle)) {
				System.out.println("!!!!!!!!!!!!!!!!!" + stage.getText());
				foundOption = true;
				stage.sendKeys("");
				stage.click();
				break;
			}

		}
		Assert.assertTrue("The " + lifecycle + " stage was not found!",
				foundOption);
	}

	public void clickOnInheritPermissionsButton() {
		WebElement inheritPermissions = getDriver().findElement(
				By.cssSelector("span[id*='default-inheritedButton'] button"));
		inheritPermissions.click();
	}

	public void clickOnAddUserOrGroupFromPermissionsPage() {
		WebElement addUserOrGroup = getDriver().findElement(
				By.cssSelector("span[id*='addUserGroupButton'] button"));
		addUserOrGroup.click();
	}

	public void inputUserOrGroupToSearch(String name) {
		WebElement userOrGroup = getDriver().findElement(
				By.cssSelector("div[class*='search-bar'] input"));
		userOrGroup.sendKeys(name);
	}

	public void clickOnSearchButtonFromPermissionsPage() {
		WebElement searchButton = getDriver().findElement(
				By.cssSelector("span[id*='authority-search-button'] button"));
		searchButton.click();
	}

	public void selectUserFromSearchResultsForInvite(String... identifiers) {
		waitForTextToDisappear(
				getDriver()
				.findElement(
						By.cssSelector("div[id*='authorityFinder-results'] tbody.yui-dt-message")),
				"Enter a search term to find start");
		getElementWithSpecifiedTextInsideElementFromList(
				By.cssSelector("div[class*='results'] tbody[class*='data'] tr"),
				By.cssSelector("h3.itemname"), true, false, identifiers)
				.findElement(By.cssSelector("div.yui-dt-liner button")).click();

	}

	public void selectPermission(String permission) {
		getDriver()
		.findElement(
				By.cssSelector("div[id*='directPermissions'] table tbody.yui-dt-data td:nth-child(3) button"))
				.click();

		List<WebElement> rolesList = getDriver().findElements(
				By.cssSelector("div.bd ul li a"));

		boolean foundOption = false;
		for (WebElement role : rolesList) {
			System.out.println("!!!!!!!!!!!!!!!!!!!" + role.getText());
			if (role.getText().equals(permission)) {
				foundOption = true;
				role.sendKeys("");
				role.click();
				break;
			}

		}
		Assert.assertTrue("Role not found!", foundOption);
	}

	public void clickOnSaveForPermissions() {
		WebElement saveButton = getDriver().findElement(
				By.cssSelector("span[id*='default-okButton'] button"));
		saveButton.click();
	}

	public void selectRolePermission(String role, String permission) {
		WebElement permissionsContainer = getElementWithSpecifiedTextInsideElementFromList(
				By.cssSelector("div.permissions > div.bd > div.groups > div.yui-gd"),
				By.cssSelector("div.yui-u.first.right> label"), true, false,
				role);
		permissionsContainer
		.findElement(
				By.cssSelector("div.yui-u.flat-button > span > span.first-child > button"))
				.click();
		getElementWithSpecifiedTextFromListInsideParentElement(
				permissionsContainer,
				By.cssSelector("div.yui-u.flat-button > div.yui-module.yui-overlay.yuimenu.yui-button-menu.yui-menu-button-menu.visible > div.bd > ul.first-of-type > li.yuimenuitem > a"),
				true, false, permission).click();
	}

	public void clickOnOkToAddCategories() {
		element(okButtonAddCatgories).sendKeys("");
		element(okButtonAddCatgories).click();
	}

	public void insertDocumentName(String documentName) {
		documentNameInput.clear();
		documentNameInput.sendKeys(documentName);
	}

	public void verifyDocumentVersion(String docPath, String version) {
		WebElement documentElement = getDocumentElementFromDocumentLibrary(
				true, docPath);
		documentElement.findElement(By.cssSelector("h3.filename span a"))
		.sendKeys("");
		mouseOver(documentElement.findElement(By
				.cssSelector("div.yui-dt-liner > div")));
		String versionNumber = documentElement.findElement(
				By.cssSelector("h3.filename > span.document-version"))
				.getText();
		Assert.assertTrue(String.format(
				"The document version is '%s' and it should be '%s'!",
				versionNumber, version), versionNumber.contains(version));
	}

	public void insertFileDescriptionProperty(String description) {
		fileDescriptionPropertyInput.clear();
		fileDescriptionPropertyInput.sendKeys(description);
	}

	public void checkConversionCompletedMessage() {
		String conversionCompletedMessage = conversionCompletedMessageContainer
				.getText();
		Assert.assertTrue(
				String.format(
						"The conversion completed message should be '%s' but it is '%s'!",
						Constants.CONVERSION_COMPLETED_MESSAGE,
						conversionCompletedMessage), conversionCompletedMessage
						.equals(Constants.CONVERSION_COMPLETED_MESSAGE));
	}

	public void clickOnConversionCompletedOkButton() {
		checkConversionCompletedMessage();
		conversionCompletedOkButton.click();
	}

	public void clickOnConversionCompletedCancelButton() {
		checkConversionCompletedMessage();
		conversionCompletedCancelButton.click();
	}

	public Map<String, String> getReferencesOffAllNodesInsideCurrentFolder() {
		Map<String, String> referencesMap = new HashMap<String, String>();
		List<WebElement> documentsList = getDriver()
				.findElements(
						By.cssSelector("div.documents.yui-dt > table > tbody.yui-dt-data > tr"));
		for (WebElement document : documentsList) {
			String documentTitle = document
					.findElement(By.cssSelector("td[headers*='fileName'] > div > h3[class*='filename'] > span > a"))
							.getText();
			String documentReference = document.findElement(
					By.cssSelector("td > div > input")).getAttribute("value");
			referencesMap.put(documentTitle, documentReference);
		}
		return referencesMap;
	}

	public Map<String, WebElement> checkSuccessfullTransformations(
			Map<String, String> referencesMap) {
		implicitlyWaitSmall();
		List<WebElement> tableHeaders = getDriver().findElements(
				By.cssSelector("body > p"));
		System.out.println("****************************** tableHeaders "
				+ tableHeaders.size());
		List<WebElement> transformationsTables = getDriver().findElements(
				By.cssSelector("body > table"));
		System.out
		.println("****************************** transformationsTables "
				+ transformationsTables.size());
		Map<String, WebElement> documentLinksMap = new LinkedHashMap<String, WebElement>();
		for (int i = 0; i < tableHeaders.size(); i++) {
			WebElement tableHeader = tableHeaders.get(i);
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^ tableHeader "
					+ tableHeader.getText());
			if (tableHeader.getText().contains("succeeded")) {
				List<WebElement> transformations = transformationsTables.get(i)
						.findElements(By.cssSelector("tbody > tr > td > a"));
				System.out
				.println("################################ transformations "
						+ transformations.size());
				List<String> transformationsReferences = getVisibleTextOfWebElements(transformations);
				for (Entry<String, String> entry : referencesMap.entrySet()) {
					System.out.println("---------------------------- "
							+ entry.getKey());
					System.out.println("---------------------------- "
							+ entry.getValue());
					Assert.assertTrue(
							String.format(
									"The transformation failed for the '%s' document as its reference '%s' was not found in the successful transformations table!",
									entry.getKey(), entry.getValue()),
									transformationsReferences.contains(entry.getValue()));
					documentLinksMap.put(entry.getKey(), transformations
							.get(transformationsReferences.indexOf(entry
									.getValue())));

				}
				break;
			}
		}
		implicitlyWaitDefault();
		return documentLinksMap;
	}

	public Map<String, WebElement> checkFailedTransformations(
			Map<String, String> referencesMap) {
		List<WebElement> tableHeaders = getDriver().findElements(
				By.cssSelector("body > p"));
		System.out.println("****************************** tableHeaders "
				+ tableHeaders.size());
		List<WebElement> transformationsTables = getDriver().findElements(
				By.cssSelector("body > table"));
		System.out
		.println("****************************** transformationsTables "
				+ transformationsTables.size());
		Map<String, WebElement> documentLinksMap = new HashMap<String, WebElement>();
		for (int i = 0; i < tableHeaders.size(); i++) {
			WebElement tableHeader = tableHeaders.get(i);
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^ tableHeader "
					+ tableHeader.getText());
			if (tableHeader.getText().contains("failed")) {
				List<WebElement> transformations = transformationsTables.get(i)
						.findElements(By.cssSelector("tbody > tr > td > a"));
				System.out
				.println("################################ transformations "
						+ transformations.size());
				List<String> transformationsReferences = getVisibleTextOfWebElements(transformations);
				for (Entry<String, String> entry : referencesMap.entrySet()) {
					System.out.println("---------------------------- "
							+ entry.getKey());
					System.out.println("---------------------------- "
							+ entry.getValue());
					Assert.assertTrue(
							String.format(
									"The transformation for the '%s' document did not fail as its reference '%s' was not found in the failed transformations table!",
									entry.getKey(), entry.getValue()),
									transformationsReferences.contains(entry.getValue()));
					documentLinksMap.put(entry.getKey(), transformations
							.get(transformationsReferences.indexOf(entry
									.getValue())));

                }
                break;
            }
        }
        return documentLinksMap;
    }

//-----------------------------------------------------------------------

	public String selectSite(String siteName) {
		getDriver().get(Constants.SHARE_URL + Constants.SITE_PREFIX + siteName.toLowerCase() + Constants.SITE_SUFIX);
		return getDriver().getTitle();
	}

/**
 * Navigates to a specific site document library
 */
public String selectSiteDocumentLibrary(String siteName) {
	getDriver().get(Constants.SHARE_URL + Constants.DOCUMENT_LIBRARY_PREFIX + siteName.toLowerCase() + Constants.DOCUMENT_LIBRARY_SUFIX);
	return getDriver().getTitle();
}

/**
 * Clicks on the "Document Library" button
 */

public void clickOnDocumentLibraryButton() {
	element(documentLibrary).waitUntilVisible();
	documentLibrary.click();
	element(defaultDocuments).waitUntilVisible();
	waitABit(Constants.WAIT_TIME);
	// List<WebElement> navigationButtons =
	// siteNavigationContainer.findElements(By.cssSelector("span a"));
	// for (WebElement buttonNow : navigationButtons) {
	// if (buttonNow.getText().contains(Constants.DOCUMENT_LIBRARY)) {
	// buttonNow.click();
	// break;
	// }
	// }

}


/**
 * Uploads a file
 */
public void uploadFile(String filePath) throws AWTException {
	element(uploadButton).waitUntilVisible();
	uploadButton.click();
	waitABit(Constants.WAIT_TIME);
	element(selectFileButton).waitUntilVisible();
	selectFileButton.click();
	waitABit(Constants.WAIT_TIME);
	RobotUtils.robotFileUpload(filePath);
	waitABit(Constants.WAIT_TIME);
	element(uploadFileButton).waitUntilPresent();
	uploadFileButton.click();
	waitABit(Constants.WAIT_TIME);
	element(uploadOkButton).waitUntilPresent();
	uploadOkButton.click();
	waitABit(Constants.WAIT_TIME);
}

/**
 * Tries to upload a restricted file
 */
public void uploadRestrictedFile(String filePath) throws AWTException {
	element(uploadButton).waitUntilVisible();
	uploadButton.click();
	waitABit(Constants.WAIT_TIME);
	element(selectFileButton).waitUntilVisible();
	selectFileButton.click();
	waitABit(Constants.WAIT_TIME);
	RobotUtils.robotFileUpload(filePath);
	waitABit(Constants.WAIT_TIME);
	element(uploadFileButton).waitUntilPresent();
	uploadFileButton.click();
	waitABit(Constants.WAIT_TIME);
}

/**
 * Verifies that a file cannot be uploaded
 */
public void verifyFileCannotBeUploaded(String fileName) {
	WebElement uploadFailedRow = getDriver().findElement(By.cssSelector("span[title='Failure']"));
	element(uploadFailedRow).waitUntilVisible();
	Assert.assertTrue(uploadFailedRow.getText().contains(fileName));

	element(uploadOkButton).waitUntilPresent();
	uploadOkButton.click();
	waitABit(Constants.WAIT_TIME);
}

public void clickOnSelectedItems() {
	int n = 0;
	boolean b = false;
	do {
		n++;
		WebElement selectedItemsButton = getDriver().findElement(
				By.cssSelector("[id $= 'selectedItems-button-button']"));
		element(selectedItemsButton).waitUntilVisible();
		selectedItemsButton.click();
		waitABit(Constants.WAIT_TIME);

		WebElement dropDownContent = getDriver().findElement(
				By.cssSelector("[id $= 'default-selectedItems-menu']"));

		if (dropDownContent.isDisplayed()) {
			b = true;
		} else {
			// getDriver().navigate().refresh();
		}

	} while (b == false && n < 10);
	Assert.assertTrue("Click on Selected Items failed", b);
}

public void clickOnDelete() {
	element(deleteButton).waitUntilVisible();
	deleteButton.click();
	waitABit(Constants.WAIT_TIME);
	element(deleteButton2).waitUntilVisible();
	deleteButton2.click();
	//		waitForRenderedElementsToBePresent(By.cssSelector("div#message"));
	//		waitForRenderedElementsToDisappear(By.cssSelector("div#message"));
	waitABit(5000);
}

public void clickOnLinkTo() {
	element(selectedItemsButton).waitUntilVisible();
	selectedItemsButton.click();
	waitABit(Constants.WAIT_TIME);

	element(linkToButton).waitUntilVisible();
	linkToButton.click();
	waitABit(Constants.WAIT_TIME);
}

/**
 * Deletes an item from Document Library
 */
public void deleteItem(String itemName, String deleteLinksAlso) {
	List<WebElement> itemsList = getDriver().findElements(
			By.cssSelector("div[id $= 'default-documents'] > table > tbody.yui-dt-data > tr"));
	//deleteLinksAlso "yes" "no"
	for (WebElement elem : itemsList) {
		if(deleteLinksAlso.contains("yes")) {
			if (elem.getText().contains(itemName) && elem.getText().contains("Link")) {
				elem.findElement(By.cssSelector("div.yui-dt-liner > input")).click();
				waitABit(Constants.WAIT_TIME);
				break;
			}
		} else if(deleteLinksAlso.contains("no")) {
			if (elem.getText().contains(itemName) && !elem.getText().contains("Link")) {
				elem.findElement(By.cssSelector("div.yui-dt-liner > input")).click();
				waitABit(Constants.WAIT_TIME);
				break;
			}
		}
	}
	clickOnSelectedItems();
	clickOnDelete();
}


/**
 * Clicks on the "Manage Aspects" button in the details view of a folder
 */
public void openManageAspectsMenu() {
	element(manageAspectsButton).waitUntilVisible();
	manageAspectsButton.click();
	waitABit(Constants.WAIT_TIME);
}

/**
 * Selects an aspect
 */
public void selectAspect(String aspect) {
	List<WebElement> aspectsList = getDriver().findElements(
			By.cssSelector("div[id $= 'default-aspects-left'] tr.yui-dt-rec"));
	for (WebElement elem : aspectsList) {
		if (elem.getText().contains(aspect)) {
			elem.findElement(By.cssSelector("a[title='Add']")).click();
			break;
		}
	}
	waitABit(Constants.WAIT_TIME);
}

/**
 * Removes an aspect
 */
public void removeAspect(String aspect) {
	List<WebElement> aspectsList = getDriver().findElements(
			By.cssSelector("div[id $= 'default-aspects-right'] tr.yui-dt-rec"));
	for (WebElement elem : aspectsList) {
		if (elem.getText().contains(aspect)) {
			elem.findElement(By.cssSelector("a[title='Remove']")).click();
			break;
		}
	}
	waitABit(Constants.WAIT_TIME);
}

/**
 * Applies changes after aspects have been selected
 */
public void applyChanges() {
	element(applyChangesButton).waitUntilVisible();
	applyChangesButton.click();
	waitForRenderedElementsToBePresent(By.cssSelector("div#message"));
	waitForRenderedElementsToDisappear(By.cssSelector("div#message"));

}

/**
 * Clicks on the "New Folder" button
 */
public void clickOnNewFolderButton() {
	element(newFolderButton).waitUntilVisible();
	newFolderButton.click();
	waitABit(Constants.WAIT_TIME);
}

/**
 * Inserts a folder name
 */
public void insertFolderName(String folderName) {
	element(folderNameField).waitUntilVisible();
	folderNameField.sendKeys(folderName);
	waitABit(Constants.WAIT_TIME);
}

/**
 * Clicks on the "Save" Folder button
 */
public void saveFolder() {
	element(saveFolderButton).waitUntilVisible();
	saveFolderButton.click();
	waitForRenderedElementsToBePresent(By.cssSelector("div#message"));
	waitForRenderedElementsToDisappear(By.cssSelector("div#message"));
}

/**
 * Verifies that an aspect is set for a folder
 */
public void verifyAspectIsSet(String aspect) {
	List<WebElement> selectedAspectsList = getDriver().findElements(
			By.cssSelector("div[id $= 'default-aspects-right'] tr.yui-dt-rec"));
	boolean b = false;
	for (WebElement elem : selectedAspectsList) {
		if (elem.getText().contains(aspect)) {
			b = true;
			break;
		}
	}
	Assert.assertTrue("aspect is not set", b);
}

/**
 * Verifies that a list of aspects are set
 */
public void verifyAspectsAreSet(List<String> aspect) {
	List<WebElement> selectedAspectsList = getDriver().findElements(
			By.cssSelector("div[id $= 'default-aspects-right'] tr.yui-dt-rec"));
	boolean b = false;
	for (String s : aspect) {
		b = false;
		for (WebElement elem : selectedAspectsList) {
			if (elem.getText().contains(s)) {
				b = true;
				break;
			}
		}
		Assert.assertTrue("aspect is not set", b);
	}
}

/**
 * Verifies that no aspects are set for a folder
 */
public void verifyNoAspectIsSet() {
	List<WebElement> selectedAspectsList = getDriver().findElements(
			By.cssSelector("div[id $= 'default-aspects-right'] tbody.yui-dt-data > *"));
	Assert.assertTrue("There are aspects set although there should not be", selectedAspectsList.size() == 0);
}

/**
 * Clicks on the Cancel button in the Manage Aspects menu
 */
public void clickOnCancelButton() {
	element(cancelButton).waitUntilVisible();
	cancelButton.click();
	waitABit(Constants.WAIT_TIME);
}

/**
 * Clicks on All from the Select dropdown
 */
public void clickOnSelectButton() {
	int n = 0;
	boolean b = false;
	do {
		n++;
		WebElement selectButton = getDriver().findElement(
				By.cssSelector("[id $= 'default-fileSelect-button-button']"));
		element(selectButton).waitUntilVisible();
		selectButton.click();
		waitABit(Constants.WAIT_TIME);

		WebElement dropDownContent = getDriver().findElement(
				By.cssSelector("[id $= 'default-fileSelect-menu']"));

		if (dropDownContent.isDisplayed()) {
			b = true;
		} else {
			// getDriver().navigate().refresh();
		}

	} while (b == false && n < 10);
	Assert.assertTrue("Click on Selected Items failed", b);

	// element(selectButton).waitUntilVisible();
	// selectButton.click();
	System.out.println("11111111111111");
	element(allLink).waitUntilVisible();
	allLink.click();
	waitABit(Constants.WAIT_TIME);
}

/**
 * Verifies if a list of items is displayed in the Document Library
 */
public void verifyListIsDisplayedInDocLib(List<String> nodes) {
	List<WebElement> itemsList = getDriver().findElements(
			By.cssSelector("div[id $= 'default-documents'] > table > tbody.yui-dt-data > tr"));
	boolean b = false;
	for (String s : nodes) {
		for (WebElement elem : itemsList) {
			if (elem.getText().contains(s)) {
				Assert.assertTrue("Node " + s + "is not visible ", elem.isDisplayed());
				b = true;
				break;
			}
		}
		Assert.assertTrue("Node " + s + "is not visible", b);
	}
}

/**
 * Clicks on the "Copy to..." button from the Selected Items dropdown
 */
public void clickOnCopyToButton() {
	element(copyToButton).waitUntilVisible();
	copyToButton.click();
	element(copyItemPopUpScreen).waitUntilVisible();
	Assert.assertTrue(copyItemPopUpScreen.isDisplayed());
}

/**
 * Clicks on the "Move to..." button from the Selected Items dropdown
 */
public void clickOnMoveToButton() {
	element(moveToButton).waitUntilVisible();
	moveToButton.click();
	element(copyItemPopUpScreen).waitUntilVisible();
	Assert.assertTrue(copyItemPopUpScreen.isDisplayed());
}

/**
 * Clicks on the "Link to..." button from the Selected Items dropdown
 */
public void clickOnLinkToButton() {
	element(linkToButton).waitUntilVisible();
	linkToButton.click();
	element(copyItemPopUpScreen).waitUntilVisible();
	Assert.assertTrue(copyItemPopUpScreen.isDisplayed());
}

/**
 * Clicks on the "Manage Permissions..." button from the Selected Items
 * dropdown
 */
public void clickOnManagePermissionsButton() {
	element(managePermissionsButton).waitUntilVisible();
	managePermissionsButton.click();
	element(managePermissionsPopUpScreen).waitUntilVisible();
	Assert.assertTrue(managePermissionsPopUpScreen.isDisplayed());
}

/**
 * Clicks on the "Manage Permissions" Cancel button
 */
public void clickOnManagePermissionsCancelButton() {
	waitABit(Constants.WAIT_TIME);
	element(managePermissionsCancelButton).waitUntilVisible();
	managePermissionsCancelButton.click();
	waitABit(Constants.WAIT_TIME);
}

/**
 * Clicks on the "Copy to" Cancel button
 */
public void clickDeselectAllButton() {
	element(deselectAllButton).waitUntilVisible();
	deselectAllButton.click();
	waitABit(Constants.WAIT_TIME);
}

/**
 * Verifies that all the items are unchecked
 */
public void verifyAllItemsAreUnchecked() {
	List<WebElement> itemsList = getDriver()
			.findElements(
					By.cssSelector("div[id $= 'default-documents'] > table > tbody.yui-dt-data > tr div.yui-dt-liner > input"));
	for (WebElement elem : itemsList) {
		Assert.assertFalse(elem.isSelected());
	}
}


/**
 * Opens the "Link To..." menu from the "More..." menu
 */
public void clickOnLinkToFromTheMoreMenu(String itemName) {
	Actions action = new Actions(getDriver());
	List<WebElement> itemsList = getDriver().findElements(
			By.cssSelector("div[id $= 'default-documents'] > table > tbody.yui-dt-data > tr"));
	for (WebElement elem : itemsList) {

		if (elem.getText().contains(itemName)) {
			WebElement hiddenContainer = elem.findElement(By.cssSelector("div.yui-dt-liner > div"));
			action.moveToElement(hiddenContainer).build().perform();
			waitABit(Constants.WAIT_TIME);
			WebElement moreButton = elem.findElement(By.cssSelector("div.yui-dt-liner > div a.show-more > span"));
			moreButton.click();
			waitABit(Constants.WAIT_TIME);
			WebElement linkToButton = elem.findElement(By.cssSelector("div.yui-dt-liner > div a[title='Link To...'] > span"));
			linkToButton.click();
			waitABit(Constants.WAIT_TIME);
			break;
		}
	}
}

/**
 * Clicks on the "Edit Properties" button in the folder details view
 */
public void clickOnEditProperties() {
	element(editPropertiesButton).waitUntilVisible();
	editPropertiesButton.click();
	waitABit(Constants.WAIT_TIME);
}

/**
 * Verifies if an option exists or not in the "Selected Items" menu
 */
public void verifyOptionExists(String optionName) {
	List<WebElement> optionsList = getDriver().findElements(
			By.cssSelector("div[id $= 'default-selectedItems-menu'] > div > ul > li"));
	boolean b = false;
	for (WebElement elem : optionsList) {
		if (elem.getText().contains(optionName)) {
			b = true;
		}
		Assert.assertFalse(b);
	}
}


/**
 * Clicks on the "Contents" button from the "Create Content" dropdown
 */
public void clickOnContents() {
	element(contentsButton).waitUntilVisible();
	contentsButton.click();
	waitABit(Constants.WAIT_TIME);
}

}

