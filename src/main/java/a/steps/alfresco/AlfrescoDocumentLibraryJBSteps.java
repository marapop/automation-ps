package a.steps.alfresco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import a.tools.alfresco.AbstractJBSteps;
import a.tools.alfresco.Constants;

public class AlfrescoDocumentLibraryJBSteps extends AbstractJBSteps {

	public void uploadDocument(String fileName) {
		alfrescoDocumentLibrarySteps
		.clickOnDocumentLibraryActionButton(Constants.UPLOAD);
		alfrescoUploadAssetsSteps.clickOnSelectFilesButton();
		alfrescoUploadAssetsSteps.insertFilePath(Constants.FILES_FOLDER
				+ fileName);
		// alfrescoUploadAssetsSteps.clickOnUploadFileButton();
		// alfrescoUploadAssetsSteps.clickOnOkUploadButton();
		alfrescoFilePreviewSteps
		.verifyNotificationMessage("Document is being uploaded...");
	}

	public void clickOnUploadAndOKButtons() {
		alfrescoUploadAssetsSteps.clickOnUploadFileButton();
		alfrescoUploadAssetsSteps.clickOnOkUploadButton();
		alfrescoFilePreviewSteps
		.verifyNotificationMessage("Document is being uploaded...");
	}

	public void clickOnUploadFilesButton() {
		alfrescoUploadAssetsSteps.clickOnUploadFileButton();
		alfrescoFilePreviewSteps
		.verifyNotificationMessage("Document is being uploaded...");
	}

	public void selectFileToUpload(String fileName) {
		alfrescoUploadAssetsSteps.clickOnSelectFilesButton();
		alfrescoUploadAssetsSteps.insertFilePath(Constants.FILES_FOLDER
				+ fileName);
	}

	public void selectDocumentFromDocumentLibrary(String documentName) {
		alfrescoDocumentLibrarySteps
		.selectDocumentFromDocumentLibrary(getVarargs(documentName));
	}

	public void clickOnDocumentCheckboxFromDocumentLibrary(String documentName) {
		alfrescoDocumentLibrarySteps
		.clickOnDocumentCheckboxFromDocumentLibrary(getVarargs(documentName));
	}

	public void verifyDocumentExists(String documentName) {
		alfrescoDocumentLibrarySteps
		.checkThatDocumentExists(getVarargs(documentName));
	}

	public void deleteDocumentIfExists(String documentName) throws Exception {
		int i = 0;
		while (alfrescoDocumentLibrarySteps.checkIfDocumentExists(documentName)
				&& i < 5) {
			i++;
			alfrescoDocumentLibrarySteps
			.clickOnDocumentActionFromDocumentLibrary("Delete",
					getVarargs(documentName));
			alfrescoFilePreviewSteps
			.verifyPopupMessage(String
					.format("Are you sure you want to delete '%s'?",
							getVarargs(documentName)[getVarargs(documentName).length - 1]));
			alfrescoFilePreviewSteps
			.clickOnPopupButtonWithResultMessage(
					"Delete",
					String.format(
							"'%s' was deleted",
							getVarargs(documentName)[getVarargs(documentName).length - 1]));
		}
	}

	public void checkThatDocumentDoesntExist(String documentName) {
		alfrescoDocumentLibrarySteps
		.checkThatDocumentDoesntExist(getVarargs(documentName));
	}

	public void clickOnDocumentActionWithResultMessage(String actionTitle,
			String message) {
		alfrescoFilePreviewSteps.clickOnDocumentActionWithResultMessage(
				actionTitle, message);
	}

	public void clickOnDocumentActionFromDocumentLibrary(String action,
			String message, String docPath) {
		alfrescoDocumentLibrarySteps
		.clickOnDocumentActionFromDocumentLibraryWithMessage(action,
				message, getVarargs(docPath));
	}


	public void clickOnDocumentActionFromDocumentLibrary(String actionTitle,
			String docPath) {
		alfrescoDocumentLibrarySteps.clickOnDocumentActionFromDocumentLibrary(
				actionTitle, getVarargs(docPath));
	}

	public void checkThatTheDocumentActionFromDocumentLibraryIsPresent(
			String action, String docPath) {
		alfrescoDocumentLibrarySteps
		.checkThatTheDocumentActionFromDocumentLibraryIsPresent(action,
				getVarargs(docPath));
	}

	public void checkThatTheDocumentActionFromDocumentLibraryIsNotPresent(
			String action, String docPath) {
		alfrescoDocumentLibrarySteps
		.checkThatTheDocumentActionFromDocumentLibraryIsNotPresent(
				action, getVarargs(docPath));
	}

	public void addAspectsToSelectedDocument(String aspects) {
		alfrescoDocumentLibrarySteps.selectAspects(aspects);
		alfrescoDocumentLibrarySteps.clickOnApplyChangesForAspectsButton();
	}

	public void addCategoriesToSelectedDocument(String categories) {
		alfrescoDocumentLibrarySteps.selectCategories(categories);
		alfrescoDocumentLibrarySteps.clickOnOkToAddCategories();

	}

	public void selectAssetFromPopupBox(String assetPath) {
		alfrescoDocumentLibrarySteps
		.selectAssetFromPopupBox(getVarargs(assetPath));
		alfrescoDocumentLibrarySteps.clickOnPopupButton("OK");
	}

	public void clickOnSelectButtonWithSpecifiedLabel(String label) {
		alfrescoDocumentLibrarySteps
		.clickOnSelectButtonWithSpecifiedLabel(label);
	}

	public void checkIfTextExistForSpecifiedLabel(String labelTitle, String text) {
		alfrescoDocumentLibrarySteps.checkTextWithSpecifiedLabel(labelTitle,
				text);
	}

	public void selectRightsStatus(String status) {
		alfrescoDocumentLibrarySteps.selectRightsStatus(status);
	}

	public void createANewFolder(String name, String title, String description) {
		alfrescoDocumentLibrarySteps.clickOnDocumentLibraryActionButton(
				Constants.CREATE, Constants.FOLDER);
		alfrescoDocumentLibrarySteps.insertNewFolderName(name);
		alfrescoDocumentLibrarySteps.insertNewFolderTitle(title);
		alfrescoDocumentLibrarySteps.insertNewFolderDescription(description);
		alfrescoDocumentLibrarySteps.clickOnNewFolderSaveButton(name);
	}

	public void deleteDocumentFromDocumentLibrary(String docPath) {
		alfrescoDocumentLibrarySteps.clickOnDocumentActionFromDocumentLibrary(
				"Delete", getVarargs(docPath));
		alfrescoFilePreviewSteps.verifyPopupMessage(String.format(
				"Are you sure you want to delete '%s'?",
				getVarargs(docPath)[getVarargs(docPath).length - 1]));
		alfrescoFilePreviewSteps.clickOnPopupButtonWithResultMessage("Delete",
				String.format("'%s' was deleted",
						getVarargs(docPath)[getVarargs(docPath).length - 1]));
	}

	public void deleteTheSelectedDocument(String name) {
		alfrescoFilePreviewSteps.clickOnDocumentAction("Delete");
		alfrescoFilePreviewSteps.verifyPopupMessage(String.format(
				"Are you sure you want to delete '%s'?", name));
		alfrescoFilePreviewSteps.clickOnPopupButton("Delete");
	}

	public void clickOnDocumentAction(String actionTitle) {
		alfrescoFilePreviewSteps.clickOnDocumentAction(actionTitle);
	}

	public void clickOnAllPropertiesButton() {
		alfrescoDocumentLibrarySteps.clickOnAllPropertiesButton();
	}

	public void clickOnSaveButton() {
		alfrescoDocumentLibrarySteps.clickOnSaveButton();
	}

	public void changeDocumentNameFromDocumentLybrary(String fileName,
			String newFileName) {
		clickOnDocumentActionFromDocumentLibrary("Edit Properties", fileName);
		alfrescoDocumentLibrarySteps.insertDocumentName(newFileName);
		// alfrescoDocumentLibrarySteps.clickOnSaveButton();
		alfrescoDocumentLibrarySteps.clickOnPopupButton("Save");
		alfrescoFilePreviewSteps
		.verifyNotificationMessage("Details updated successfully");
	}

	public void changeDocumentDescriptionFromDocumentLybrary(String fileName,
			String description) {
		clickOnDocumentActionFromDocumentLibrary("Edit Properties", fileName);
		alfrescoDocumentLibrarySteps.insertFileDescriptionProperty(description);
		// alfrescoDocumentLibrarySteps.clickOnSaveButton();
		alfrescoDocumentLibrarySteps.clickOnPopupButton("Save");
		alfrescoFilePreviewSteps
		.verifyNotificationMessage("Details updated successfully");
	}

	public void checkThatDocumentActionIsPresent(String actionTitle) {
		alfrescoFilePreviewSteps.checkThatDocumentActionIsPresent(actionTitle);
	}

	public void checkThatDocumentActionIsNotPresent(String actionTitle) {
		alfrescoFilePreviewSteps
		.checkThatDocumentActionIsNotPresent(actionTitle);
	}

	public void verifyDocumentActionResultMessage(String message) {
		alfrescoFilePreviewSteps.verifyNotificationMessage(message);
	}

	public void createFolder(String folderName) {
		alfrescoDocumentLibrarySteps.clickOnDocumentLibraryActionButton(
				Constants.CREATE, Constants.FOLDER);
		alfrescoDocumentLibrarySteps.inputFolderName(folderName);
		alfrescoDocumentLibrarySteps.clickOnSaveFolderButton();
	}

	public void clickOnDocumentLibraryActionButton(String buttonTitles) {
		alfrescoDocumentLibrarySteps
		.clickOnDocumentLibraryActionButton(getVarargs(buttonTitles));
	}

	public void switchToNewestOpenedTab() {
		alfrescoDocumentLibrarySteps.switchToNewestOpenedTab();
	}

	public void closeNewestOpenedTab() {
		alfrescoDocumentLibrarySteps.closeNewestOpenedTab();
	}

	public void verifyPageContainsTerms(String terms) {
		//not implemented
		alfrescoDocumentLibrarySteps.verifyPageContainsTerms(true,
				getVarargs(terms));
	}

	public void seledctVersionType(String versionType, String comment) {
		alfrescoUploadAssetsSteps.selectVersionType(versionType);
		alfrescoUploadAssetsSteps.inputCommentField(comment);
	}

	public void verifyDocumentVersion(String docPath, String versionIndex) {
		alfrescoDocumentLibrarySteps.verifyDocumentVersion(docPath,
				versionIndex);
	}

	public void verifyVersionNumber(String versionIndex) {
		alfrescoFilePreviewSteps.assertDocumentVersion(versionIndex);
	}

	public void linkItemTo(String destination, String site, String path) {
		alfrescoDocumentLibrarySteps.linkItemTo(destination, site,
				getVarargs(path));
		alfrescoDocumentLibrarySteps.clickOnPopupButtonWithResultMessage(
				"Link", "Successfully linked 1 item(s)");
	}

	public void checkThatUploadButtonIsDisabled() {
		alfrescoUploadAssetsSteps.checkThatUploadButtonIsDisabled();
	}

	public void checkThatDocumentIsPartOfWorkflow(String message,
			String taskName) {
		alfrescoFilePreviewSteps.checkThatDocumentIsPartOfWorkflow(message,
				taskName);
	}

	public void verifyPropertyValue(String propertyName, String propertyValue) {
		alfrescoFilePreviewSteps.verifyPropertyValue(propertyName,
				propertyValue);
	}

	public void createContentFromDocumentLibrary(String contentType,
			String name, String content) {
		alfrescoDocumentLibrarySteps.clickOnCreateContentLink();
		alfrescoDocumentLibrarySteps.selectContentType(contentType);
		alfrescoDocumentLibrarySteps.inputContentName(name);
		alfrescoDocumentLibrarySteps.inputContentSectionContent(content);
		alfrescoDocumentLibrarySteps.clickOnCreateContentButton();
	}

	public void selectLifecycleStage(String stage) {
		alfrescoDocumentLibrarySteps.selectLifecycleStage(stage);
	}

	public void navigateToNextPage() {
		alfrescoFilePreviewSteps.navigateToNextPage();
	}
	
	public void checkIfCommentExists(String comment, String userName) {
		alfrescoFilePreviewSteps.checkIfCommentIsPresent(userName, comment);
	}

	public void checkIfCommentDoesntExists(String comment, String userName) {
		alfrescoFilePreviewSteps.checkIfCommentDoesntExists(userName, comment);
	}

	public void checkIfCommentAndActionExists(String userName, String message,
			String actionName) {
		alfrescoFilePreviewSteps.checkIfCommentIsPresent(userName, message,
				actionName);
	}

	public void clickOnInheritPermissions() {
		alfrescoDocumentLibrarySteps.clickOnInheritPermissionsButton();
		alfrescoFilePreviewSteps.verifyPopupMessage(String.format(
				"Are you sure you do not want to inherit permissions?", ""));
		alfrescoFilePreviewSteps.clickOnPopupButton("Yes");
	}

	public void searchAndAddUserOrGroupForSettingPersmissions(String name) {
		alfrescoDocumentLibrarySteps.clickOnAddUserOrGroupFromPermissionsPage();
		alfrescoDocumentLibrarySteps.inputUserOrGroupToSearch(name);
		alfrescoDocumentLibrarySteps.clickOnSearchButtonFromPermissionsPage();
		alfrescoDocumentLibrarySteps.selectUserFromSearchResultsForInvite(name);
	}

	public void changePermission(String role) {
		alfrescoDocumentLibrarySteps.selectPermission(role);
		alfrescoDocumentLibrarySteps.clickOnSaveForPermissions();
	}

	public void selectRolePermission(String permission, String role) {
		alfrescoDocumentLibrarySteps.selectRolePermission(role, permission);
		alfrescoDocumentLibrarySteps.clickOnPopupButtonWithResultMessage(
				"Save", "Permissions on 1 items updated successfully");
	}

	public void revertToAPreviousVersion(String version, String versionType,
			String comment) {
		alfrescoFilePreviewSteps.clickOnRevertIcon(version);
		alfrescoUploadAssetsSteps.selectVersionType(versionType);
	}

	public void clickOnPreviewOnlineIcon(String versionNumber) {
		alfrescoFilePreviewSteps.clickOnPreviewOnlineIcon(versionNumber);
	}

	public void checkThatTheDocumentIsLockedFromDocumentLibrary(String message,
			String docPath) {
		alfrescoDocumentLibrarySteps.checkThatTheDocumentIsLocked(message,
				docPath);
	}

	public void checkIfDocumentIsLockedFromFilePreview(String message) {
		alfrescoFilePreviewSteps.checkIfDocumentIsLocked(message);
	}

	public void addCommentToDocument(String content) {
		alfrescoFilePreviewSteps.clickOnAddCommentButton();
		alfrescoFilePreviewSteps.insertCommentContent(content);
		alfrescoFilePreviewSteps.clickOnSubmitCommentButton();
	}

	public void checkMessageWhenPreviewOlderVersion(String message, String file) {
		alfrescoFilePreviewSteps.checkMessageForOnlinePreview(message, file);
	}

	public void removeSelectedFileAndCheckMessage(String message) {
		alfrescoUploadAssetsSteps.clickOnRemoveFile();
		alfrescoUploadAssetsSteps.checkThatNoFilesWereSelected(message);
	}

	public void verifyNodesInBreadcrumbs(String nodes) {
		alfrescoDocumentLibrarySteps
		.verifyNodesInBreadcrumbs(getVarargs(nodes));
	}

	public void cancelToUploadANewversion() {
		alfrescoUploadAssetsSteps.clickOnCancelUploadButton();
	}

	public void verifyUploadFileTime(String fileName, String path,
			String siteName) throws Exception {
		alfrescoHttpHelper.uploadFile(siteName, fileName, path);
		Date systemDate = new Date();
		alfrescoDashboardSteps.clickOnDashboardHeaderButton("Home");
		alfrescoDashboardSteps.selectSiteFromDashboard(siteName);
		alfrescoSiteSteps.selectSiteNavigationItem(Constants.DOCUMENT_LIBRARY);
		selectDocumentFromDocumentLibrary(fileName);
		alfrescoFilePreviewSteps
		.checkThatDateCorespondWithSystemTime(systemDate);
	}

	public void clickOnConversionCompletedOkButton() {
		alfrescoDocumentLibrarySteps.clickOnConversionCompletedOkButton();
	}

	public void clickOnConversionCompletedCancelButton() {
		alfrescoDocumentLibrarySteps.clickOnConversionCompletedCancelButton();
	}

	public void verifyDocumentTitle(String title) {
		alfrescoFilePreviewSteps.verifyDocumentTitle(title);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void checkTheConversionResultsForTheDocumentsInsideTheFolders(
			String folderPaths, String successfulTransformationDocuments,
			String failedTransformationDocuments) {
		if (successfulTransformationDocuments != "" || failedTransformationDocuments != "") {
			Map<String, String> referencesMap = new HashMap<String, String>();
			for (String folderPath : getVarargs(folderPaths, ", ")) {
				alfrescoSiteSteps.selectSiteNavigationItem(Constants.DOCUMENT_LIBRARY);
				String[] folderPathNodes = getVarargs(folderPath);
				alfrescoDocumentLibrarySteps.selectDocumentFromDocumentLibrary(folderPathNodes);
				alfrescoDocumentLibrarySteps.verifyNodesInBreadcrumbs(Arrays.copyOfRange(folderPathNodes, 0, folderPathNodes.length));
				referencesMap.putAll(alfrescoDocumentLibrarySteps.getReferencesOffAllNodesInsideCurrentFolder());
				System.out.println("----------------- referencesMap " + referencesMap.size());
			}
			alfrescoDocumentLibrarySteps.switchToNewestOpenedTab();
			System.out.println("successfulTransformationDocuments " + successfulTransformationDocuments);
			if (successfulTransformationDocuments != "") {
				Map<String, String> successfulTransformationsMap = new HashMap<String, String>();
				for (Entry<String, String> entry : referencesMap.entrySet()) {
					System.out.println("entry.getValue() " + entry.getValue());
					if (Arrays.asList(getVarargs(successfulTransformationDocuments, ", ")).contains(entry.getKey())) {
						successfulTransformationsMap.put(entry.getKey(), entry.getValue());
						System.out.println("successfulTransformationsMap " + successfulTransformationsMap.size());
					}
				}
				System.out.println("+++++++++++++++++++++++++++++++++++++++ successfulTransformationsMap "
						+ successfulTransformationsMap.size());
				Map<String, WebElement> documentLinksMap = alfrescoDocumentLibrarySteps
						.checkSuccessfullTransformations(successfulTransformationsMap);
				List<String> documentTitles = new ArrayList(documentLinksMap.keySet());
				List<WebElement> documentLinks = new ArrayList(documentLinksMap.values());
				int mapSize = documentLinksMap.size();
				int i = 0;
				while (i < mapSize) {
					System.out.println("------------------------------------- documentTitle "
							+ documentTitles.get(i));
					System.out.println("------------------------------------- documentLink "
							+ documentLinks.get(i));
					documentLinks.get(i).click();
					alfrescoFilePreviewSteps.verifyDocumentTitle(documentTitles
							.get(i));
					alfrescoFilePreviewSteps.getDriver().navigate().back();
					// we need to re-initialize the list of elements after
					// returning to the page
					documentLinksMap = alfrescoDocumentLibrarySteps
							.checkSuccessfullTransformations(successfulTransformationsMap);
					Assert.assertTrue(
							String.format(
									"The successful conversions table initially had '%d' elements and now it has '%d'!",
									mapSize, documentLinksMap.size()),
									mapSize == documentLinksMap.size());
					documentTitles = new ArrayList(documentLinksMap.keySet());
					documentLinks = new ArrayList(documentLinksMap.values());
					i++;
				}
			}
			if (failedTransformationDocuments != "") {
				Map<String, String> failedTransformationsMap = new HashMap<String, String>();
				for (Entry<String, String> entry : referencesMap.entrySet()) {
					if (Arrays.asList(
							getVarargs(failedTransformationDocuments, ", "))
							.contains(entry.getKey())) {
						failedTransformationsMap.put(entry.getKey(),
								entry.getValue());
					}
				}
				System.out
				.println("+++++++++++++++++++++++++++++++++++++++ failedTransformationsMap "
						+ failedTransformationsMap.size());
				Map<String, WebElement> documentLinksMap = alfrescoDocumentLibrarySteps
						.checkFailedTransformations(failedTransformationsMap);
				List<String> documentTitles = new ArrayList(
						documentLinksMap.keySet());
				List<WebElement> documentLinks = new ArrayList(
						documentLinksMap.values());
				int mapSize = documentLinksMap.size();
				int i = 0;
				while (i < mapSize) {
					System.out
					.println("------------------------------------- documentTitle "
							+ documentTitles.get(i));
					System.out
					.println("------------------------------------- documentLink "
							+ documentLinks.get(i));
					documentLinks.get(i).click();
					alfrescoFilePreviewSteps.verifyDocumentTitle(documentTitles
							.get(i));
					alfrescoFilePreviewSteps.getDriver().navigate().back();
					// we need to re-initialize the list of elements after
					// returning to the page
					documentLinksMap = alfrescoDocumentLibrarySteps
							.checkFailedTransformations(failedTransformationsMap);
					Assert.assertTrue(
							String.format(
									"The failed conversions table initially had '%d' elements and now it has '%d'!",
									mapSize, documentLinksMap.size()),
									mapSize == documentLinksMap.size());
					documentTitles = new ArrayList(documentLinksMap.keySet());
					documentLinks = new ArrayList(documentLinksMap.values());
					i++;
				}
			}
			alfrescoDocumentLibrarySteps.closeNewestOpenedTab();
		}
	}
}
