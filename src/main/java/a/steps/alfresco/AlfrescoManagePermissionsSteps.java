package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoManagePermissionsSteps extends AbstractSteps{

	private static final long serialVersionUID = -1579876847607362495L;

	public AlfrescoManagePermissionsSteps(Pages pages) {
		super(pages);
	}
	
//	@StepGroup
//	public void addUserSetRoleAndSave(String userName, String userRole){
//		searchAndAddUser(userName);
//		setUserRole(userName, userRole);
//		clickOnSave();
//	}
	
	
	@StepGroup
	public void addUserSetRoleAndSave(String userName, String userRole){
		setUserRole(userName, userRole);
		clickOnSave();
	}

	
	@StepGroup
	public void addUserRoleToInheritedProject(String userName, String userRole){
		searchAndAddUser(userName);
		setUserPermission(userName, userRole);
		clickOnSave();
	}
	
	@Step
	public void clickOnSave(){
		managePermissionsPage().clickOnSave();
	}
	
	@Step
	public void setUserPermission(String userName, String userRole) {
		managePermissionsPage().setUserRole(userName, userRole);
		
	}

	@StepGroup
	@Deprecated //fix the click and remove this line
	public void setUserRole(String userName, String userRole){
		clickOnManagePermissions();
		clickOnRoleDropdown(userName);
		selectRoleForUser(userRole);
        clickOnSaveButton();
	}
	
	
	@Step
	public void searchAndAddUser(String userName){
		managePermissionsPage().searchForUser(userName);
	}

	@StepGroup
	@Deprecated //fix the click and remove this line
	public void managePermissions(String userName, String userRole) {
		clickOnManagePermissions();
		clickOnRoleDropdown(userName);
		selectRoleForUser(userRole);
        clickOnSaveButton();
	}
	
	
	@Step
	public void clickOnRoleDropdown(String userName){
		managePermissionsPage().clickOnRoleDropdown(userName);
	}
	
	@Step
	public void selectRoleForUser(String userRole) {
		managePermissionsPage().selectRoleForUser(userRole);
	}
	
	@Step
	public void clickOnSaveButton(){
		managePermissionsPage().clickOnSaveButton();
	}
	
	@Step
	public void clickOnManagePermissions(){
		actionsPage().clickOnManagePermissions();
	}

	@Step
	public void verifyInheritedPermissions(String firstName, String userRole) {
		managePermissionsPage().verifyInheritedPermissionsUserAndRole(firstName, userRole);
		
	}

	@Step
	public void clickOnInheritPermissionsAndPopup() {
		managePermissionsPage().clickOnInheritPermissionsButton();
		managePermissionsPage().clickYesOnInheritPermissionsPopup();
		
		
	}
}
