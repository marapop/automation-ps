package a.pages.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoSelectedItemsPage extends AbstractPage{

	public AlfrescoSelectedItemsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[id*='default-selectedItems-menu']")
	private WebElement selectedItemsMenuContainer;
	
	@FindBy(css = "[id*='default-selectedItems-button-button']")
	private WebElement selectedItemsMenu;
	
	
	public void clickOnSelectedItemsMenu() {
		element(selectedItemsMenu).waitUntilVisible();
		selectedItemsMenu.click();
	}


	public void clickOnDelete() {
		element(selectedItemsMenuContainer).waitUntilVisible();
		List<WebElement> selectedItemsButtons = selectedItemsMenuContainer.findElements(By.cssSelector("div ul li a"));
		
		for(WebElement buttonNow: selectedItemsButtons){
			if(buttonNow.getText().contains(Constants.DELETE_FROM_SELECTED_ITEMS)){
				buttonNow.click();
				break;
			}
		}	
	}

/*	public void bulkEditMetadata() {
		element(selectedItemsMenuContainer).waitUntilVisible();
		List<WebElement> selectedItemsButtons = selectedItemsMenuContainer.findElements(By.cssSelector("div ul li a"));
		
		for(WebElement buttonNow: selectedItemsButtons){
			if(buttonNow.getText().contains(Constants.BULK_EDIT_METADATA)){
				buttonNow.click();
				break;
			}
		}
	}*/

	public void clickOnMoveTo() {
		element(selectedItemsMenuContainer).waitUntilVisible();
		List<WebElement> selectedItemsButtons = selectedItemsMenuContainer.findElements(By.cssSelector("div ul li a"));
		
		for(WebElement buttonNow: selectedItemsButtons){
			if(buttonNow.getText().contains(Constants.MOVE_TO_FROM_SELECTED_ITEMS)){
				buttonNow.sendKeys("");
				buttonNow.click();
				break;
			}
		}	
		waitABit(Constants.WAIT_TIME);
	}

	public void clickOnLinkTo() {
		element(selectedItemsMenuContainer).waitUntilVisible();
		List<WebElement> selectedItemsButtons = selectedItemsMenuContainer.findElements(By.cssSelector("div ul li a"));
		
		for(WebElement buttonNow: selectedItemsButtons){
			if(buttonNow.getText().contains(Constants.LINK_TO_FROM_SELECTED_ITEMS)){
				buttonNow.sendKeys("");
				buttonNow.click();
				break;
			}
		}	
	}

/*	public void clickOnStartWorkflow() {
		element(selectedItemsMenuContainer).waitUntilVisible();
		List<WebElement> selectedItemsButtons = selectedItemsMenuContainer.findElements(By.cssSelector("div ul li a"));
		
		for(WebElement buttonNow: selectedItemsButtons){
			if(buttonNow.getText().contains(Constants.START_WORKFLOW)){
				buttonNow.sendKeys("");
				buttonNow.click();
				break;
			}
		}	
		
	}*/
/*
	public void clickOnManagePermissions() {
		element(selectedItemsMenuContainer).waitUntilVisible();
		List<WebElement> selectedItemsButtons = selectedItemsMenuContainer.findElements(By.cssSelector("div ul li a"));
		
		for(WebElement buttonNow: selectedItemsButtons){
			if(buttonNow.getText().contains(Constants.MANAGE_PERMISSIONS_FROM_SELECTED_ITEMS)){
				buttonNow.sendKeys("");
				buttonNow.click();
				break;
			}
		}	
	}*/
}
