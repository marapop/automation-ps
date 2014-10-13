package a.steps.alfresco;

import java.awt.AWTException;
import java.io.File;
import java.util.List;
import java.util.Map;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import org.openqa.selenium.WebElement;

import a.pages.alfresco.AlfrescoDocumentLibraryPage;
import a.pages.alfresco.AlfrescoFilePreviewPage;
import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoDocumentLibrarySteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    public AlfrescoDocumentLibrarySteps(Pages pages) {
        super(pages);
    }

    private AlfrescoDocumentLibraryPage alfrescoDocumentLibraryPage;
    private AlfrescoFilePreviewPage alfrescoFilePreviewPage;
    private AbstractPage abstractPage;

    @Step
    public void clickOnDocumentLibraryActionButton(String... buttonTitles) {
        alfrescoDocumentLibraryPage
                .clickOnDocumentLibraryActionButton(buttonTitles);
    }

    @Step
    public void verifyNodesInBreadcrumbs(String... nodes) {
        alfrescoDocumentLibraryPage.verifyNodesInBreadcrumbs(nodes);
    }

    @Step("Click on 'Invite people'")
	public void clickOnInvitePeople() {
		alfrescoDocumentLibraryPage.clickOnInvitePeople();
	}
    
    @Step
    public void selectDocumentFromDocumentLibrary(String... docPath) {
        alfrescoDocumentLibraryPage.selectDocumentFromDocumentLibrary(docPath);
    }

    @Step
    public void clickOnDocumentCheckboxFromDocumentLibrary(String... docPath) {
        alfrescoDocumentLibraryPage
                .clickOnDocumentCheckboxFromDocumentLibrary(docPath);
    }

    @Step
    public void checkThatDocumentExists(String... docPath) {
        alfrescoDocumentLibraryPage.checkThatDocumentExists(docPath);
    }

    @Step
    public boolean checkIfDocumentExists(String documentName) {
        return alfrescoDocumentLibraryPage.checkIfDocumentExists(documentName);
    }

    @Step
    public void inputFolderName(String folderName) {
        alfrescoDocumentLibraryPage.inputFolderName(folderName);
    }

    @Step
    public void clickOnSaveFolderButton() {
        alfrescoDocumentLibraryPage.clickOnSaveFolderButton();
    }

    @Step
    public void switchToNewestOpenedTab() {
        alfrescoDocumentLibraryPage.switchToNewestOpenedTab();
    }

    @Step
    public void closeNewestOpenedTab() {
        alfrescoDocumentLibraryPage.closeNewestOpenedTab();
    }


    @Step
    public void verifyTextContainsTerms(String text, boolean ignoreCase,
            String... strTerms) {
        abstractPage.verifyTextContainsTerms(text, ignoreCase, strTerms);
    }


    @Step
    public void checkThatDocumentDoesntExist(String... docPath) {
        alfrescoDocumentLibraryPage.checkThatDocumentDoesntExist(docPath);
    }

    @Step
    public void clickOnDocumentActionFromDocumentLibraryWithMessage(
            String action, String message, String... docPath) {
        alfrescoDocumentLibraryPage.clickOnDocumentActionFromDocumentLibrary(
                action, docPath);
        alfrescoFilePreviewPage.verifyNotificationMessage(message);
    }

    @Step
    public void clickOnDocumentActionFromDocumentLibrary(String action,
            String... docPath) {
        alfrescoDocumentLibraryPage.clickOnDocumentActionFromDocumentLibrary(
                action, docPath);
    }

    @Step
    public void checkThatTheDocumentActionFromDocumentLibraryIsNotPresent(
            String action, String... docPath) {
        alfrescoDocumentLibraryPage
                .checkThatTheDocumentActionFromDocumentLibraryIsNotPresent(
                        action, docPath);
    }

    @Step
    public void checkThatTheDocumentActionFromDocumentLibraryIsPresent(
            String action, String... docPath) {
        alfrescoDocumentLibraryPage
                .checkThatTheDocumentActionFromDocumentLibraryIsPresent(action,
                        docPath);
    }

    @Step
    public void insertNewFolderName(String name) {
        alfrescoDocumentLibraryPage.insertNewFolderName(name);
    }

    @Step
    public void insertNewFolderTitle(String title) {
        alfrescoDocumentLibraryPage.insertNewFolderTitle(title);
    }

    @Step
    public void insertNewFolderDescription(String description) {
        alfrescoDocumentLibraryPage.insertNewFolderDescription(description);
    }

    @Step
    public void clickOnNewFolderSaveButton(String name) {
        alfrescoDocumentLibraryPage.clickOnNewFolderSaveButton(name);
    }

    @Step
    public void clickOnApplyChangesForAspectsButton() {
        alfrescoDocumentLibraryPage.clickOnApplyChangesForAspectsButton();
    }

    @Step
    public void selectAspects(String... aspectTitle) {
        alfrescoDocumentLibraryPage.selectAspects(aspectTitle);
    }

    @Step
    public void selectCategories(String... categoryTitle) {
        alfrescoDocumentLibraryPage.selectCategory(categoryTitle);
    }

    @Step
    public void clickOnAllPropertiesButton() {
        alfrescoDocumentLibraryPage.clickOnAllPropertiesButton();
    }

    @Step
    public void clickOnSelectButtonWithSpecifiedLabel(String labelTitle) {
        alfrescoDocumentLibraryPage
                .clickOnSelectButtonWithSpecifiedLabel(labelTitle);
    }

    @Step
    public void checkTextWithSpecifiedLabel(String labelTitle, String text) {
        alfrescoDocumentLibraryPage.checkTextWithSpecifiedLabel(labelTitle,
                text);
    }

    @Step
    public void selectRightsStatus(String status) {
        alfrescoDocumentLibraryPage.selectRightsStatus(status);
    }

    @Step
    public void selectAssetFromPopupBox(String... assetPath) {
        alfrescoDocumentLibraryPage.selectAssetFromPopupBox(assetPath);
    }

    @Step
    public void clickOnPopupButton(String buttonTitle) {
        alfrescoDocumentLibraryPage.clickOnPopupButton(buttonTitle);

    }

    @Step
    public void clickOnPopupButtonWithResultMessage(String buttonTitle,
            String message) {
        alfrescoDocumentLibraryPage.clickOnPopupButton(buttonTitle);
        alfrescoFilePreviewPage.verifyNotificationMessage(message);
    }

    @Step
    public void clickOnSaveButton() {
        alfrescoDocumentLibraryPage.clickOnSaveButton();
    }

    @Step
    public void linkItemTo(String destination, String site, String... path) {
        alfrescoDocumentLibraryPage.linkItemTo(destination, site, path);
    }

    @Step
    public void clickOnCreateContentLink() {
        alfrescoDocumentLibraryPage.clickOnCreateContentLink();
    }

    @Step
    public void selectContentType(String contentType) {
        alfrescoDocumentLibraryPage.selectContentType(contentType);
    }

    @Step
    public void inputContentName(String contentName) {
        alfrescoDocumentLibraryPage.inputContentName(contentName);
    }

    @Step
    public void inputContentSectionContent(String contentSection) {
        alfrescoDocumentLibraryPage.inputContentSectionContent(contentSection);
    }

    @Step
    public void clickOnCreateContentButton() {
        alfrescoDocumentLibraryPage.clickOnCreateContentButton();
    }

    @Step
    public void selectLifecycleStage(String lifecycle) {
        alfrescoDocumentLibraryPage.selectLifecycleStage(lifecycle);
    }

    @Step
    public void selectRolePermission(String role, String permission) {
        alfrescoDocumentLibraryPage.selectRolePermission(role, permission);
    }

    @Step
    public void insertDocumentName(String documentName) {
        alfrescoDocumentLibraryPage.insertDocumentName(documentName);
    }

    @Step
    public void verifyDocumentVersion(String docPath, String version) {
        alfrescoDocumentLibraryPage.verifyDocumentVersion(docPath, version);
    }

    @Step
    public void clickOnOkToAddCategories() {
        alfrescoDocumentLibraryPage.clickOnOkToAddCategories();
    }

    @Step
    public void checkThatTheDocumentIsLocked(String message, String... docPath) {
        alfrescoDocumentLibraryPage.checkThatTheDocumentIsLocked(message,
                docPath);
    }

    @Step
    public void insertFileDescriptionProperty(String description) {
        alfrescoDocumentLibraryPage.insertFileDescriptionProperty(description);
    }

    @Step
    public void clickOnInheritPermissionsButton() {
        alfrescoDocumentLibraryPage.clickOnInheritPermissionsButton();
    }

    @Step
    public void clickOnAddUserOrGroupFromPermissionsPage() {
        alfrescoDocumentLibraryPage.clickOnAddUserOrGroupFromPermissionsPage();
    }

    @Step
    public void inputUserOrGroupToSearch(String name) {
        alfrescoDocumentLibraryPage.inputUserOrGroupToSearch(name);
    }

    @Step
    public void clickOnSearchButtonFromPermissionsPage() {
        alfrescoDocumentLibraryPage.clickOnSearchButtonFromPermissionsPage();
    }

    @Step
    public void selectUserFromSearchResultsForInvite(String... identifiers) {
        alfrescoDocumentLibraryPage
                .selectUserFromSearchResultsForInvite(identifiers);
    }

    @Step
    public void selectPermission(String permission) {
        alfrescoDocumentLibraryPage.selectPermission(permission);
    }

    @Step
    public void clickOnSaveForPermissions() {
        alfrescoDocumentLibraryPage.clickOnSaveForPermissions();
    }

    @Step
    public void clickOnConversionCompletedOkButton() {
        alfrescoDocumentLibraryPage.clickOnConversionCompletedOkButton();
    }

    @Step
    public void clickOnConversionCompletedCancelButton() {
        alfrescoDocumentLibraryPage.clickOnConversionCompletedCancelButton();
    }

    @Step
    public Map<String, String> getReferencesOffAllNodesInsideCurrentFolder() {
        return alfrescoDocumentLibraryPage
                .getReferencesOffAllNodesInsideCurrentFolder();
    }

    @Step
    public Map<String, WebElement> checkSuccessfullTransformations(
            Map<String, String> referencesMap) {
        return alfrescoDocumentLibraryPage
                .checkSuccessfullTransformations(referencesMap);
    }

    @Step
    public Map<String, WebElement> checkFailedTransformations(
            Map<String, String> referencesMap) {
        return alfrescoDocumentLibraryPage
                .checkFailedTransformations(referencesMap);
    }

	public void verifyPageContainsTerms(boolean b, String[] varargs) {
		
	}

	public void chooseToSaveFileInBrowserPopup() {
	}
	
	//-------------------------------------------------------------------
	

	@Step
	public void addAspect(String aspect) {
		alfrescoDocumentLibraryPage.openDetailsView();
		alfrescoDocumentLibraryPage.openManageAspectsMenu();
		alfrescoDocumentLibraryPage.selectAspect(aspect);
		alfrescoDocumentLibraryPage.applyChanges();
	}
	@Step
	public void clickOnDocumentLibraryButton() {
		alfrescoDocumentLibraryPage.clickOnDocumentLibraryButton();
	}
	@Step
	public void createFolder(String folderName) {
		alfrescoDocumentLibraryPage.clickOnNewFolderButton();
		alfrescoDocumentLibraryPage.insertFolderName(folderName);
		alfrescoDocumentLibraryPage.saveFolder();
	}
	@Step
	public void uploadFile(String fileName) throws AWTException {
		String absolutePath = new File(Constants.TESTDATA_FILES_PATH, fileName).getAbsolutePath();
		alfrescoDocumentLibraryPage.uploadFile(absolutePath);
	}
	@Step
	public void uploadRestrictedFile(String fileName) throws AWTException {
		String absolutePath = new File(Constants.TESTDATA_FILES_PATH, fileName).getAbsolutePath();
		alfrescoDocumentLibraryPage.uploadRestrictedFile(absolutePath);
	}
	@Step
	public void addRestriction() {
		alfrescoDocumentLibraryPage.openDetailsView();
		alfrescoDocumentLibraryPage.openManageAspectsMenu();
		alfrescoDocumentLibraryPage.selectAspect(Constants.RESTRICTED_CHILD_ASSOCIATION);
		alfrescoDocumentLibraryPage.applyChanges();
	}
	@Step
	public void addAspectToFolder(String aspect, String folderName) throws Exception {
	//	navigateToFolder(folderName);
		alfrescoDocumentLibraryPage.openDetailsView();
		alfrescoDocumentLibraryPage.openManageAspectsMenu();
		alfrescoDocumentLibraryPage.selectAspect(aspect);
		alfrescoDocumentLibraryPage.applyChanges();
	}
	@Step
	public void removeAspect(String aspect) {
		alfrescoDocumentLibraryPage.openDetailsView();
		alfrescoDocumentLibraryPage.openManageAspectsMenu();
		alfrescoDocumentLibraryPage.removeAspect(aspect);
		alfrescoDocumentLibraryPage.applyChanges();
	}

	@Step
	public void clickOnSelectedItems() {
		alfrescoDocumentLibraryPage.clickOnSelectedItems();
	}
	
	@Step
	public void wait_milliseconds(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}
	@Step
	public void clickOnSelectButton() {
		alfrescoDocumentLibraryPage.clickOnSelectButton();
	}
	@Step
	public void deleteItem(String itemName, String deleteLinksAlso) {
		alfrescoDocumentLibraryPage.deleteItem(itemName, deleteLinksAlso);
	}
	@Step
	public void openCopyToMenu() {
		alfrescoDocumentLibraryPage.clickOnCopyToButton();
	}
	@Step
	public void clickOnEditProperties() {
		alfrescoDocumentLibraryPage.clickOnEditProperties();
	}
	
	@Step
	public void verifyFileCannotBeUploaded(String nodeName) {
		alfrescoDocumentLibraryPage.verifyFileCannotBeUploaded(nodeName);
	}
	@Step
	public void verifyAspectIsSet(String aspect) {
		alfrescoDocumentLibraryPage.openManageAspectsMenu();
		alfrescoDocumentLibraryPage.verifyAspectIsSet(aspect);
		alfrescoDocumentLibraryPage.clickOnCancelButton();
	}
	@Step
	public void verifyNoAspectIsSet() {
		alfrescoDocumentLibraryPage.openManageAspectsMenu();
		alfrescoDocumentLibraryPage.verifyNoAspectIsSet();
		alfrescoDocumentLibraryPage.clickOnCancelButton();
	}
	@Step
	public void verifyListIsDisplayedInDocLib(List<String> table) {
		alfrescoDocumentLibraryPage.verifyListIsDisplayedInDocLib(table);
	}

	@Step
	public void clickOnManagePermissionsButton() {
		alfrescoDocumentLibraryPage.clickOnManagePermissionsButton();
		alfrescoDocumentLibraryPage.clickOnManagePermissionsCancelButton();
	}
	@Step
	public void verifyAllItemsAreUnchecked() {
		alfrescoDocumentLibraryPage.clickDeselectAllButton();
		alfrescoDocumentLibraryPage.verifyAllItemsAreUnchecked();
	}
	@Step
	public void verifyOptionExists(String optionName) {
		alfrescoDocumentLibraryPage.verifyOptionExists(optionName);
	}

	@Step
	public void verifyAspectsAreSet(List<String> table) {
		alfrescoDocumentLibraryPage.openManageAspectsMenu();
		alfrescoDocumentLibraryPage.verifyAspectsAreSet(table);
		alfrescoDocumentLibraryPage.clickOnCancelButton();

	}


}
