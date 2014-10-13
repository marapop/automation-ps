package a.pages.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoReassignPage extends AbstractPage{

	public AlfrescoReassignPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(css = "div[id*='default-reassignPanel_c']")
	private WebElement reassignContainer;


	public void inputUserName(String userName){
		element(reassignContainer).waitUntilVisible();
		WebElement searchInput = reassignContainer.findElement(By.cssSelector("input[id*='default-peopleFinder-search-text']"));
		searchInput.sendKeys(userName);
	}
	
	
	public void clickOnSearch(){
		element(reassignContainer).waitUntilVisible();
		WebElement searchButton = reassignContainer.findElement(By.cssSelector("button[id*='default-peopleFinder-search-button-button']"));
		searchButton.click();
	}


	public void clickOnSelect(String userName) {		
		element(reassignContainer).waitUntilVisible();
		List<WebElement> searchList = reassignContainer.findElements(By.cssSelector("div[id*='default-peopleFinder-results'] tr"));
		waitABit(Constants.WAIT_TIME);
		
		for(WebElement resultNow:searchList){
			if(resultNow.getText().contains(userName)){
				resultNow.findElement(By.tagName("button")).click();
				break;
			}
		}
		
	}
	
	
	

}
