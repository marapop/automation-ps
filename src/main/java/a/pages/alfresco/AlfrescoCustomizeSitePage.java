package a.pages.alfresco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoCustomizeSitePage extends AbstractPage{

	public AlfrescoCustomizeSitePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div[class*='page-list-wrapper available-pages'] li[id*='wiki'] img")
	private WebElement wikiSource;

	@FindBy(css = "div[class*='page-list-wrapper current-pages'] ul li")
	private WebElement currentSiteDestination;
	
	@FindBy(css = "button[id*='default-save-button']")
	private WebElement okOrSaveButton;
	

	public void clickOnOkOrSaveButton() {
		element(okOrSaveButton).waitUntilPresent();
		okOrSaveButton.click();
	}	

	public void dragAndDropWikiPage() {
		Actions newAction = new Actions(getDriver());
		newAction.dragAndDrop(wikiSource, currentSiteDestination).perform();
		waitABit(Constants.WAIT_TIME_SHORT);
	}
}
