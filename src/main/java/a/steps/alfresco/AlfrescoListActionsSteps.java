package a.steps.alfresco;

import java.util.List;

import junit.framework.Assert;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;
import a.tools.alfresco.Constants;

@SuppressWarnings("deprecation")
public class AlfrescoListActionsSteps extends AbstractSteps {

	private static final long serialVersionUID = 4971473013236546966L;

	public AlfrescoListActionsSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void markFile(String fileName) {
		waitABit(Constants.WAIT_TIME);
		listActionsPage().markFile(fileName);
	}

	@Step
	public void openDocmentForVerifyingRoles() {
		listActionsPage().openDocmentForVerifyingRoles();
	}

	@Step
	public void openFile(String fileName) {
		listActionsPage().openFileView(fileName);
	}

	@Step
	public void editFileName(String fileName) {
		listActionsPage().editFileName(fileName);
	}

	@Step
	public void clickOnMoreAndManageAspects(String fileName) {
		listActionsPage().clickOnMoreAndManageAspects(fileName);
	}
	
	@Step
	public void clickOnMoreAndDelete(String fileName) {
		listActionsPage().clickOnMoreAndDelete(fileName);
	}

	@Step
	public void clickOnDeleteIcon(String fileName) {
		waitABit(Constants.WAIT_TIME_LONG);
		listActionsPage().clickOnDelete(fileName);
	}

	@Step
	public void verifyDocumentLibraryIcon(String fileName, String iconType) {
		listActionsPage().verifyIcon(fileName, iconType);
	}

	@Step
	public void verifyFileNameAndRagStatus(String fileName, String ragColour) {
		listActionsPage().verifyFileNameAndRagStatus(fileName, ragColour);
	}

	@Step
	public void verifyDeleteMassage(String deleteMessage, String fileName) {
		Assert.assertTrue(
				"Restriction message is not as expected ",
				deleteMessage.contains("'" + fileName + "'"
						+ Constants.DELETE_MESSAGE_SUFFIX));
	}

	@Step
	public void verifyIfFileIsDeleted(String fileName) {
		listActionsPage().verifyIfFileIsDeleted(fileName);
	}

	@Step
	public void verifyFileIsPresent(String fileName) {
		listActionsPage().verifyFileIsPresent(fileName);
	}

	@Step
	public void clickOnTag(String tagName) {
		listActionsPage().clickOnTag(tagName);
		listActionsPage().verifyTagIsSelected(tagName);
	}

	@StepGroup
	public void verifyFilesArePresent(List<String> taggedList) {
		for(String fileNow:taggedList){
			verifyFileIsPresent(fileNow);
		}
		listActionsPage().verifyFileCount(taggedList.size());
	}

	public void clickOnEditProperties(String fileName) {
		markFile(fileName);
		listActionsPage().clickOnEditProperties(fileName);
		
	}
	
	@Step
	public void verifyResutsListSize(int size) {
		listActionsPage().verifyResutsListSize(size);
	}
	
	@StepGroup
	public void verifyListOfAssets(int size, List<String> list) {
		waitABit(Constants.WAIT_TIME_SHORT);
		if (list.size() > 0) {
			verifyResutsListSize(size);
			for (int i = 0; i > size; i++) {
				searchResultsPage().isElementPresentInSearchResult(list.get(i));
			}
		}
	}
    
	@Step
	public void verifyFileIsNotPresent(String file) {
		listActionsPage().verifyFileIsNotPresent(file);
	}

}
