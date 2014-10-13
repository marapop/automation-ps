package a.pages.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;


public class AlfrescoPathRibbonPage extends AbstractPage{

	public AlfrescoPathRibbonPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div[id*='default-navBar']")
	private WebElement navBarContainer;

	public void openFolderForEditPropertiesView() {
		element(navBarContainer).waitUntilVisible();
		navBarContainer
				.findElement(By.cssSelector("a[href*='folder-details']"))
				.click();
	}
	
	public void navigateToFolderProperties(String folder){
		element(navBarContainer).waitUntilVisible();
		List<WebElement> list= navBarContainer.findElements(By.tagName("a"));
		for(WebElement item:list){
			if(item.getText().equals(folder)){
				item.sendKeys("");
				item.click();
				break;
			}
		}
	}
}
