package a.steps.alfresco;

import java.util.List;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;
import a.tools.alfresco.Constants;


public class AlfrescoWorkflowSteps extends AbstractSteps{

	private static final long serialVersionUID = -3696449063779626322L;

	public AlfrescoWorkflowSteps(Pages pages) {
		super(pages);
	}
	
	@Step
	public void updateTaskAdhoc(String status, String commentText){
		taskFormPage().changeStatus(status);
		taskFormPage().inputComment(commentText);
		taskFormPage().clickOnTaskDone();
		waitABit(Constants.WAIT_TIME);
	}
	
	@StepGroup
	public void reassignUser(String userName){
		reassignPage().inputUserName(userName);
		reassignPage().clickOnSearch();
		clickOnSelect(userName);
		
	}
	@Step
	public void clickOnSelect(String userName){
		reassignPage().clickOnSelect(userName);
		waitABit(Constants.WAIT_TIME_LONG);
	}

	@Step
	public void verifyTaskFiles(List<String> assetList) {
		for(String itemNow:assetList){
			taskFormPage().verifyTaskFiles(itemNow);
		}
	}
  
	@Step
	public void selectWorkflowTypeFilter(String workflowType) {
		workflowsStartedPage().selectWorkflowTypeFilter(workflowType);
	}
    
	@Step
	public void selectTheReviewedWorkflow(String workflowName) {
		workflowsStartedPage().selectTheReviewedWorkflow(workflowName);
	}
    
	@Step
	public void verifyCurrentTaskStatus(String workflowApproved) {
		workflowsStartedPage().verifyCurrentTaskStatus(workflowApproved);
	}
  
    
	@Step
	public void clickOnEditTask() {
		workflowsStartedPage().clickOnEditTask();
	}
	
}


