package a.pages.alfresco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoCustomizeDashboardPage extends AbstractPage{

	public AlfrescoCustomizeDashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "td[id*='HEADER_CUSTOMIZE_SITE_DASHBOARD_text']")
	private WebElement customizeDashboardButton;
	
	@FindBy(css = "button[id*='addDashlets-button-button']")
	private WebElement addButton;

	@FindBy(css = "ul.availableList > li:nth-child(10)")
	private WebElement incompleteAssetsSource;

	@FindBy(css = "ul[id*='default-column-ul-1'] li:last-child")
	private WebElement currentSiteDestination;
	
	
	
	public void clickOnCustomizeDashboard(){
		element(customizeDashboardButton).waitUntilVisible();
		customizeDashboardButton.click();
	}

//
//	public void clickOnAddDashlet() {
//		element(addButton).waitUntilVisible();
//		addButton.click();		
//		waitABit(Constants.WAIT_TIME_SHORT);
//	}
//	
	public void dragAndDropCollectionsDashlet(){
		currentSiteDestination.sendKeys("");
		waitABit(Constants.WAIT_TIME_SHORT);
		
		Actions newAction = new Actions(getDriver());
		newAction.dragAndDrop(incompleteAssetsSource, currentSiteDestination).perform();
		waitABit(Constants.WAIT_TIME_SHORT);
	}

}
