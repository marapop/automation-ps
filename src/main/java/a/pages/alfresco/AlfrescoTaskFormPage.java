package a.pages.alfresco;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;

public class AlfrescoTaskFormPage extends AbstractPage{

	public AlfrescoTaskFormPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "form[id*='default-form']")
	private WebElement taskFormContainer;
	
	
	public void changeStatus(String status){
		element(taskFormContainer).waitUntilVisible();
		WebElement selectStatus = taskFormContainer.findElement(By.tagName("select"));
		element(selectStatus).selectByVisibleText(status);
	}
	
	public void inputComment(String commentText){
		element(taskFormContainer).waitUntilVisible();
		WebElement commentTextarea = taskFormContainer.findElement(By.tagName("textarea"));
		commentTextarea.sendKeys(commentText);
	}

	public void clickOnTaskDone(){
		element(taskFormContainer).waitUntilVisible();
		WebElement taskDoneButton = taskFormContainer.findElement(By.cssSelector("button[id*='rop_transitions-Next-button']"));
		taskDoneButton.click();
	}

	public void verifyTaskFiles(String assetItem) {
		boolean isPresent = false;
		element(taskFormContainer).waitUntilVisible();
		List<WebElement> taskItems = taskFormContainer.findElements(By.cssSelector("div[id*='packageItems-cntrl-currentValueDisplay'] tbody.yui-dt-data tr"));
		
		for(WebElement itemNow : taskItems){
			String itemName =  itemNow.findElement(By.className("name")).getText();
			if(itemName.contains(assetItem)){
				isPresent = true;
				break;
			}
		}
		Assert.assertTrue("Assertion failed: " + assetItem + " has not been found in list of items.", isPresent);
	}
}
