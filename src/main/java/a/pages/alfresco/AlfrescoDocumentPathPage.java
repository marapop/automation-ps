package a.pages.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;

public class AlfrescoDocumentPathPage extends AbstractPage{

	public AlfrescoDocumentPathPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div.node-path")
	private WebElement folderDetailsContainer;
	
	
	public void backToCreateNewDoc(String folderName) {
		element(folderDetailsContainer).waitUntilVisible();
		List <WebElement> list = folderDetailsContainer.findElements(By
				.cssSelector("span[class*='folder-link'] a"));
		for(WebElement item:list){
			if(item.getText().contains(folderName)){
				item.sendKeys("");
				item.click();
				break;
			}
		}
	}
}
