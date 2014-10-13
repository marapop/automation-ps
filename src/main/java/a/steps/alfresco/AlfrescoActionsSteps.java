package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoActionsSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;
	public AlfrescoActionsSteps(Pages pages) {
		super(pages);
	}
	
	@Step
	public void verifyCancelEditingButtonIsPresent() {
		actionsPage().verifyCancelEditingButtonIsPresent();
	}
	
	@Step
	public void expandFolderActions(){
		actionsPage().expandFolderActionsFields();
	}
	
	@Step
	public void expandPropertiesProperties(){
		actionsPage().expandPropertiesFields();
	}
	
	@Step
	public void expandDocumentActions(){
		actionsPage().expandActionsFields();
	}
	
	@Step
	public void clickOnEditProperties() {
		actionsPage().clickOnEditProperties();
	}
	@Step
	public void clickOnEditPropertiesNoExpand() {
		actionsPage().clickOnEditPropertiesNoExpand();
	}

	@StepGroup
	public void clickOnManageAspects() {
		actionsPage().expandActionsFields();
		actionsPage().clickOnManageAspects();
	}
	
	@Step
	public void clickOnChangeType(){
		actionsPage().clickOnChangeType();
	}
	
	@Step
	public void clickOnManagePermissions() {
		actionsPage().clickOnManagePermissions();
	}
	
	@Step
	public void clickOnEditOffline() {
		actionsPage().clickOnEditOffline();
	}

	@Step
	public void clickOnCancelEditing() {
		actionsPage().clickOnCancelEditing();
	}
	
	@Step
	public void clickOnDeleteDocument() {
		actionsPage().clickOnDeleteDocument();	
	}
	
	@Step
	public void clickOnLinkTo() {
		actionsPage().clickOnLinkTo();	
	}
	
	@Step
	public void clickOnUploadNewVersion(){
		actionsPage().clickOnUploadNewVersion();
	}
	
	@Step
	public void clickOnTemporaryShareContentDocumentView(){
		actionsPage().clickOnTemporaryShareContentDocumentView();
	}
	
	@Step
	public void verifyCancelEditingButtonNotPresent() {
		actionsPage().verifyCancelEditingButtonNotPresent();
	}
	
	@Step
	public void verifyTheEditOfflineMessageIsPresent(String message) {
		actionsPage().verifyTheEditOfflineMessageIsPresent(message);
	}

	@Step
	public void clickOnFolderEditProperties() {
		actionsPage().expandFolderActionsFields();
		actionsPage().clickOnEditPropertiesNoExpand();
		
	}

	@Step
	public void clickOnStartWorkflow() {
		actionsPage().clickOnStartWorkflow();
	}
		    
	@Step
	public void clickOnStartTransformation() {
		actionsPage().clickOnStartTransformation();
	}
    
	@Step
	public void clickOnMoveTo() {
		actionsPage().clickOnMoveTo();
	}
	

}
