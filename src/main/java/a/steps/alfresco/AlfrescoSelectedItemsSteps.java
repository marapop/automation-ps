package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoSelectedItemsSteps extends AbstractSteps{

	private static final long serialVersionUID = -1072860047588233632L;

	public AlfrescoSelectedItemsSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void clickOnSelectedItemsMenu() {
		selectedItemsPage().clickOnSelectedItemsMenu();
	}
	/*@Step
	public void bulkEditMetadata() {
		selectedItemsPage().bulkEditMetadata();
	}

	@Step
	public void clickOnCancelEditOfflineFromSelectedItems() {
		selectedItemsPage().clickOnCancelEditOffline();
	}
*/
	@Step
	public void clickOnDelete() {
		selectedItemsPage().clickOnDelete();
	}
	
	@Step
	public void clickOnMoveTo() {
		selectedItemsPage().clickOnMoveTo();
	}
    
	@Step
	public void clickOnLinkTo() {
		selectedItemsPage().clickOnLinkTo();
	}
/*
	@Step
	public void clickOnStartWorkflow() {
		selectedItemsPage().clickOnStartWorkflow();
	}
    
	@Step
	public void clickOnManagePermissions() {
		selectedItemsPage().clickOnManagePermissions();
	}*/
}
