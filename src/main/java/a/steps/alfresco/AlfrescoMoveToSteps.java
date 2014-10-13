package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoMoveToSteps extends AbstractSteps{

	private static final long serialVersionUID = 5990642649350294101L;

	public AlfrescoMoveToSteps(Pages pages) {
		super(pages);
	}

	
	@Step
	public void selectTheSiteToMove(String siteName) {
		moveToPage().selectTheSiteToMove(siteName);
	}


	@Step
	public void selectTheFolderToMove(String projectName) {
		moveToPage().selectTheFolderToMove(projectName);
	}
	
	@Step
	public void clickOnMoveButton() {
		moveToPage().clickOnMoveButton();
	}
	
	@Step
	public void clickOnCreateButton() {
		moveToPage().clickOnCreateButton();
	}
	
	@Step
	public void clickOnCollection(){
		moveToPage().clickOnCollection();
	}
	
	@StepGroup
	public void createCollection(){
		clickOnCreateButton();
		clickOnCollection();	
	}

	@Step
	public void selectDestination(String siteName) {
		moveToPage().selectDestination(siteName);
	}
}
