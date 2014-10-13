package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoMembersSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;

	public AlfrescoMembersSteps(Pages pages) {
		super(pages);
		
	}
	
	
	@StepGroup
	public void invitePeopleToJoin(String firstName) {
		clickOnInvitePeopleButton();
		searchForPeopleToInvite(firstName);
		addUserFromList(firstName);
	}
	
	@StepGroup
	public void selectRoleAndInviteUser(String userRole){
		clickOnSelectRoleForUser();
		selectRoleDropDown(userRole);
	    clickToInvite();
	}
	
	@Step
	  public void searchForPeopleToInvite(String firstName){
		membersPage().searchForPeopleToInvite(firstName);
	}
	
	@Step
	 public void clickOnInvitePeopleButton(){
		membersPage().clickOnInvitePeopleButton();
	}
	
	@Step
	 public void addUserFromList(String firstName){
		membersPage().addUserFromList(firstName);
	}
	
	@Step
	public void clickOnSelectRoleForUser(){
		membersPage().clickOnSelectRoleForUser();
	}
	
	@Step
	public void selectRoleDropDown(String userRole){
		membersPage().selectRoleDropDown(userRole);
	}
	
	@Step
	public void clickToInvite(){
		membersPage().clickToInvite();
	}


}
