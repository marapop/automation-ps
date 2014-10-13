package a.pages.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoLinkToPage extends AbstractPage{

	public AlfrescoLinkToPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div[id*='default-copyMoveTo-dialog_c']")
	private WebElement copyMoveToDialogBoxContainer;
	
	@FindBy(css = "button[id*='default-copyMoveTo-ok-button']")
	private WebElement linkButton;
	
	@FindBy(css = "span[id*='default-copyMoveTo-create']")
	private WebElement createButtonContainer;
	
	@FindBy(css = "div[class*='yui-menu-button-menu visible']")
	private WebElement createFolderAndCollectionContainer;
	
	public void selectTheSiteToLink(String siteName) {
		element(copyMoveToDialogBoxContainer).waitUntilVisible();
		WebElement siteContainer = copyMoveToDialogBoxContainer.findElement(By
				.cssSelector("div.site-picker"));
		List<WebElement> list = siteContainer.findElements(By
				.cssSelector("div a h4"));
		for (WebElement elem : list) {
			if (elem.getText().contains(siteName)) {
				element(elem).waitUntilPresent();
				elem.click();
				break;
			}
		}
	}

	public void selectTheFolderToLink(String documentPath) {
		element(copyMoveToDialogBoxContainer).waitUntilVisible();
		WebElement siteContainer = copyMoveToDialogBoxContainer.findElement(By
				.cssSelector("div.treeview"));
		String[] pathNodes = documentPath.split(Constants.PATH_SEPARATOR);

		for (String nodeNow : pathNodes) {
			List<WebElement> spanList = siteContainer.findElements(By
					.tagName("span"));

			theFor: for (WebElement elemNow : spanList) {
				element(elemNow).waitUntilVisible();
				if (elemNow.getText().contains(nodeNow)) {
					elemNow.click();
					waitABit(Constants.WAIT_TIME_SHORT);
					break theFor;
				}

			}
		}
	}
	
	public void clickOnLinkButton() {
		element(linkButton).waitUntilVisible();
		linkButton.click();
	}
	
	public void clickOnCreateButton() {
		element(createButtonContainer).waitUntilVisible();
		createButtonContainer.findElement(By.tagName("button")).click();
	}
}
