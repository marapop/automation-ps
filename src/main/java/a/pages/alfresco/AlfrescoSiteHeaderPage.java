package a.pages.alfresco;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;


public class AlfrescoSiteHeaderPage extends AbstractPage{

	public AlfrescoSiteHeaderPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div[class*='dijitMenuPassive dijitMenuBar']")
	private WebElement siteNavigationContainer;

	@FindBy(css = "div[id*='HEADER_SITE_CONFIGURATION_DROPDOWN']")
	private WebElement moreButtonContainer;
	
	@FindBy(css = "div[id*='HEADER_SITE_DOCUMENTLIBRARY']")
	private WebElement documentLibraryButton;
	
	@FindBy(css = "div[id*='HEADER_SITE_MEMBERS']")
	private WebElement siteMembersButton;
	
	@FindBy(css = "div[id*='HEADER_SITE_DASHBOARD']")
	private WebElement siteDashboardButton;
	
	@FindBy(css = "div[id*='HEADER_SITE_CONFIGURATION_DROPDOWN_dropdown']")
	private WebElement moreButtonMenuContainer;
	
	public void clickOnMoreButton() {
		element(moreButtonContainer).waitUntilVisible();
		moreButtonContainer.click();
	}

	public void clickOnDocumentLibraryButton() {
		element(siteNavigationContainer).waitUntilVisible();
		element(documentLibraryButton).waitUntilVisible();
		documentLibraryButton.click();
	}

	public void clickOnMembersButton() {
		element(siteNavigationContainer).waitUntilVisible();
		element(siteMembersButton).waitUntilVisible();
		siteMembersButton.click();
	}

	public void clickOnSiteDashboardButton() {
		element(siteNavigationContainer).waitUntilVisible();
		element(siteDashboardButton).waitUntilVisible();
		siteDashboardButton.click();
	}
}
