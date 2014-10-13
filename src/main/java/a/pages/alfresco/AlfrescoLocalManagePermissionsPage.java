package a.pages.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;

public class AlfrescoLocalManagePermissionsPage extends AbstractPage{

	public AlfrescoLocalManagePermissionsPage(WebDriver driver) {
		super(driver);
		
	}
    
	@FindBy(css= "div[id*='default-permissions-dialog_c']")
	private WebElement managePermissionsContainer;
	
	@FindBy(css= "button[id*='default-permissions-siteconsumer']")
	private WebElement consumerDropdownContainer;
	
	@FindBy(css= "button[id*='default-permissions-sitecontributor']")
	private WebElement contributorDropdownContainer;
	
	@FindBy(css= "div[class*='yui-menu-button-menu visible']")
	private WebElement dropdownContainer;
	
	@FindBy(css= "button[id*='default-permissions-ok-button']")
	private WebElement saveButton;

	public void selectRoleForConsumer(String userRole) {
		
		element(dropdownContainer).waitUntilVisible();
		
		List<WebElement> list= dropdownContainer.findElements(By.cssSelector("ul li a"));
		for(WebElement item:list){
			if(item.getText().contains(userRole)){
				item.sendKeys("");
				item.click();
			}
		}
	}
	
	public void clickOnDropdownRoleForConsumer() {
		element(managePermissionsContainer).waitUntilVisible();
		consumerDropdownContainer.sendKeys("");
		consumerDropdownContainer.click();
	}

	public void clickOnSaveButton() {
		element(saveButton).waitUntilVisible();
		saveButton.click();
	}

	public void clickOnDropdownRoleForContributor() {
		element(managePermissionsContainer).waitUntilVisible();
		contributorDropdownContainer.sendKeys("");
		contributorDropdownContainer.click();
		
	}

	public void selectRoleForContributor(String userRole) {
     element(dropdownContainer).waitUntilVisible();
		
		List<WebElement> list= dropdownContainer.findElements(By.cssSelector("ul li a"));
		for(WebElement item:list){
			if(item.getText().contains(userRole)){
				item.sendKeys("");
				item.click();
			}
		}
	}
}
