package a.pages.alfresco;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

@SuppressWarnings("deprecation")
public class AlfrescoWorkflowsStartedPage extends AbstractPage{

	public AlfrescoWorkflowsStartedPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="div#template_x002e_workflow-type-filter_x002e_my-workflows")
	private WebElement workflowTypeContainer;
	
	@FindBy(css="div[id*='default-workflows']")
	private WebElement workflowsListContainer;
	
	@FindBy(css="tr[class*='yui-dt-last yui-dt-even']")
	private WebElement currentTaskContainer;
	
	@FindBy(css = "div.start-workflow")
	private WebElement startWorkflowContainer;

	public void selectWorkflowTypeFilter(String workflowType) {
		element(workflowTypeContainer).waitUntilVisible();
		
		List<WebElement> list= workflowTypeContainer.findElements(By.cssSelector("li a"));
		
		for(WebElement item:list){
			if(item.getText().equals(workflowType)){
				item.sendKeys("");
				item.click();
				break;
			}
		}		
	}

	public void selectTheReviewedWorkflow(String workflowName) {
       element(workflowsListContainer).waitUntilVisible();
		
		List<WebElement> list= workflowsListContainer.findElements(By.cssSelector("div.yui-dt-liner h3 a"));
		
		for(WebElement item:list){
			if(item.getText().equals(workflowName)){
				item.sendKeys("");
				item.click();
				break;
			}
		}
	}
	
	public void selectWorkflowType(String workflow){
		element(startWorkflowContainer).waitUntilVisible();
		WebElement workflowButton = startWorkflowContainer.findElement(By.cssSelector("button[id*='default-workflow-definition-button-button']"));
		
		workflowButton.click();
		waitABit(Constants.WAIT_TIME_SHORT);
		
		WebElement workflowDropdown = startWorkflowContainer.findElement(By.cssSelector("div[id*='default-workflow-definition-menu']"));
		List<WebElement> workflowOptions = workflowDropdown.findElements(By.cssSelector("li span:first-child"));
		
		for(WebElement elementNow:workflowOptions){
			
			if(elementNow.getText().contentEquals(workflow)){
				elementNow.click();
				break;
			}
		}		
	}

	public void verifyCurrentTaskStatus(String workflowApproved) {
		 element(currentTaskContainer).waitUntilVisible();
		 WebElement status= currentTaskContainer.findElement(By.cssSelector("div[class*='task-edit-link']"));
		 System.out.println("XXX : "+ workflowApproved);
		 Assert.assertTrue("! Current status is : " + status.getText(), status.getText().contains(workflowApproved));
	}

	public void clickOnEditTask() {
		 element(currentTaskContainer).waitUntilVisible();
		 currentTaskContainer.findElement(By.cssSelector("div[class*='task-edit-link']")).click();
	}
}
