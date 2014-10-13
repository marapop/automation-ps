package a.pages.alfresco;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;

public class AlfrescoSitesDropdownPage extends AbstractPage{

	public AlfrescoSitesDropdownPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div[id*='HEADER_SITES_MENU_dropdown']")
	private WebElement createSitesOptionContainer;
	
	public void clickOnCreateSitesButton() {
		element(createSitesOptionContainer).waitUntilVisible();
		WebElement createSite = createSitesOptionContainer.findElement(By
				.cssSelector("tr[id*='HEADER_SITES_MENU_CREATE_SITE']"));
		element(createSite).waitUntilVisible();
		createSite.click();

	}
	
	public void searchForSites() {
		element(createSitesOptionContainer).waitUntilVisible();
		WebElement sitesList = createSitesOptionContainer.findElement(By
				.cssSelector("tr[id*='HEADER_SITES_MENU_SITE_FINDER']"));
		element(sitesList).waitUntilVisible();
		sitesList.click();
	}
}
