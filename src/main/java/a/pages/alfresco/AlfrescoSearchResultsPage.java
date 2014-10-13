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
public class AlfrescoSearchResultsPage extends AbstractPage{

	public AlfrescoSearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "tbody.yui-dt-data")
	private WebElement resultsTableContainer;

	public void isElementPresentInSearchResult(String itemName){
		element(resultsTableContainer).waitUntilVisible();
		boolean isPresent = false;
		waitABit(Constants.WAIT_TIME_SHORT);
		List<WebElement> resultsList = resultsTableContainer.findElements(By.tagName("tr"));
		
		for(WebElement resultNow:resultsList){
			element(resultNow).waitUntilVisible();
			
			if(resultNow.findElement(By.cssSelector("h3.itemname a")).getText().contains(itemName)){
				isPresent = true;
				break;
			}
		}
		
		Assert.assertTrue("Searched element has not been found in the list: " + itemName, isPresent);
	}
	
}
