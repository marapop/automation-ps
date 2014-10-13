package a.steps.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;

public class AlfrescoRightsTemplatesPage extends AbstractPage{

	public AlfrescoRightsTemplatesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div[id*='docPicker-cntrl-picker-body']")
	private WebElement rightsTemplateContainer;
	
	@FindBy(css = "button[id*='docPicker-cntrl-ok-button']")
	private WebElement okButton;
	
	
	public void addTemplate(String templateName){
		element(rightsTemplateContainer).waitUntilVisible();
		List<WebElement> resultsPicker = rightsTemplateContainer.findElements(By.cssSelector("div[id*='docPicker-cntrl-picker-results'] tbody.yui-dt-data tr"));
		
		for(WebElement resultNow:resultsPicker){
			String itemName =  resultNow.findElement(By.className("item-name")).getText();
			if(itemName.contains(templateName)){
				resultNow.findElement(By.className("add-item")).click();
				break;
			}
		}
	}
	
	
	public void clickOnOk(){
		element(okButton).waitUntilVisible();
		okButton.click();
	}
}
