package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoCreateUserSteps extends AbstractSteps{

	private static final long serialVersionUID = -3586799641850878196L;

	public AlfrescoCreateUserSteps(Pages pages) {
		super(pages);
	}
	
	/**
	 * Will input data for a new user and create it.
	 * @param firstName
	 * @param lastName
	 * @param userEmail
	 * @param clientName
	 * @param clientPass
	 */
	@StepGroup
	public void fillNewUserDetails(String firstName, String lastName, String userEmail, String clientName, String clientPass) {
		inputUserFirstName(firstName);
		inputUserLastName(lastName);
		inputUserEmail(userEmail);
		inputUserClientName(clientName);
		inputUserPassword(clientPass);
		clickOnCreateUser();
	}
	
	@StepGroup
	public void fillAllAddGroupToUser(String firstName, String lastName,
			String userEmail, String clientName, String clientPass,
			String cancelGroup) {
		inputUserFirstName(firstName);
		inputUserLastName(lastName);
		inputUserEmail(userEmail);
		inputUserClientName(clientName);
		inputUserPassword(clientPass);
		
		findGroupToUser(cancelGroup);
		clickOnSearchGroupButton();
		clickOnAddGroupButton();
		
		clickOnCreateUser();
	}

	@Step
	public void inputUserFirstName(String firstName){
		createUserPage().inputUserFirstName(firstName);
	}
	
	@Step
	public void inputUserLastName(String lastName){
		createUserPage().inputUserLastName(lastName);
	}
	
	@Step
	public void inputUserEmail(String userEmail){
		createUserPage().inputUserEmail(userEmail);
	}
	
	@Step
	public void inputUserClientName(String clientName){
		createUserPage().inputUserClientName(clientName);
	}
	
	@Step
	public void inputUserPassword(String clientPass){
		createUserPage().inputUserPassword(clientPass);
	}
	
	@Step
	public void clickOnCreateUser(){
		createUserPage().clickOnCreateUser();
	}
	
	@Step
	public void findGroupToUser(String cancelGroup){
		createUserPage().findGroupToUser(cancelGroup);
	}
	
	@Step
	public void clickOnSearchGroupButton(){
		createUserPage().clickOnSearchGroupButton();
	}
	
	@Step
	public void clickOnAddGroupButton(){
		createUserPage().clickOnAddGroupButton();
	}
	
}
