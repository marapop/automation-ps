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
public class AlfrescoListViewsPage extends AbstractPage{

	public AlfrescoListViewsPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(css = "div.right div.options-select div.bd")
	private WebElement viewModeContainer;
	
	public void clickOnSimpleView() {
		element(viewModeContainer).waitUntilVisible();
		viewModeContainer.findElement(
				By.cssSelector("span[class*=" + Constants.SIMPLE_VIEW
						+ "]")).click();
	}
	
	public void verifyCurrentView(Constants.ENUM_VIEWS cView) {
		element(viewModeContainer).waitUntilVisible();
		List<WebElement> viewsList = viewModeContainer.findElements(By.cssSelector("ul.first-of-type li"));
		
		for(WebElement viewNow:viewsList){
			if(viewNow.getAttribute("class").contains("checked")){
				String classDescription = viewNow.getAttribute("class");
				System.out.println("class Description: " + classDescription);
				switch(cView){
				    case SIMPLE_VIEW: Assert.assertTrue("This is Not simple view... ", classDescription.contains(Constants.SIMPLE_VIEW));
					case DETAILED_VIEW: Assert.assertTrue("This is Not detailed view... ", classDescription.contains(Constants.DETAILED_VIEW)); break;
					case GALLERY_VIEW: Assert.assertTrue("This is Not gallery view... ", classDescription.contains(Constants.GALLERY_VIEW)); break;
					case FILMSTRIP_VIEW: Assert.assertTrue("This is Not simple view... ", classDescription.contains(Constants.FILMSTRIP_VIEW)); break;
					case TABLE_VIEW: Assert.assertTrue("This is Not simple view... ", classDescription.contains(Constants.TABLE_VIEW)); break;
					case AUDIO_VIEW: Assert.assertTrue("This is Not simple view... ", classDescription.contains(Constants.AUDIO_VIEW)); break;
					case MEDIA_VIEW: Assert.assertTrue("This is Not simple view... ", classDescription.contains(Constants.MEDIA_VIEW)); break;
				default:
					Assert.assertTrue("No matching case", false);
					break;
				}
			}
		}
	}

	public void clickOnDetailedView() {
		element(viewModeContainer).waitUntilVisible();
		viewModeContainer.findElement(
				By.cssSelector("li:nth-child(7)")).click();
	}
}
