package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoLocalManagePermissionsSteps  extends AbstractSteps{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlfrescoLocalManagePermissionsSteps(Pages pages) {
		super(pages);
	}
    
	@StepGroup
	public void selectLocalRoleForConsumer(String userRole) {
		clickOnDropdownRoleForConsumer(); 
		selectRoleForConsumer(userRole);
		clickOnSaveButton();
	}
	
	@Step
	public void selectRoleForConsumer(String userRole){
		localManagePermissionsPage().selectRoleForConsumer(userRole);
	}
	
	@Step
	public void selectRoleForContributor(String userRole){
		localManagePermissionsPage().selectRoleForContributor(userRole);
	}
	
	@Step
	public void clickOnDropdownRoleForConsumer() {
		localManagePermissionsPage().clickOnDropdownRoleForConsumer(); 
	}
	
	@Step
	public void clickOnDropdownRoleForContributor() {
		localManagePermissionsPage().clickOnDropdownRoleForContributor(); 
	}
	
	@Step
	public void clickOnSaveButton(){
		localManagePermissionsPage().clickOnSaveButton();
	}
    
	@StepGroup
	public void selectLocalRoleForContributor(String userRole) {
		clickOnDropdownRoleForContributor(); 
		selectRoleForContributor(userRole);
		clickOnSaveButton();
	}

}
