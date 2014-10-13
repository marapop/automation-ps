package a.pages.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoSearchSitePage extends AbstractPage {

	public AlfrescoSearchSitePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div.site-finder")
	private WebElement searchForSitesContainer;

	@FindBy(css = "div.results")
	private WebElement searchedDefaultSitesContainer;
	
	@FindBy(css = "input[id*='default-term']")
	private WebElement inputSearchSite;

	@FindBy(id = "template_x002e_site-finder_x002e_site-finder_x0023_default-button")
	private WebElement searchSiteButton;

	@FindBy(id = "template_x002e_site-finder_x002e_site-finder_x0023_default-sites")
	private WebElement deleteSiteContainer;

	@FindBy(css = "span[id*='deleteButton']")
	private WebElement deleteSiteButton;
	
	
	public void searchTheSiteToDelete(String siteName) {
		element(inputSearchSite).waitUntilVisible();
		inputSearchSite.clear();
		inputSearchSite.sendKeys(siteName);
		element(searchSiteButton).waitUntilVisible();
		searchSiteButton.click();
	}

	public void deleteTheSiteFound() {
		element(deleteSiteContainer).waitUntilVisible();
		element(deleteSiteButton).waitUntilVisible();
		deleteSiteButton.click();
	}

	public void searchTheSiteCreatedByOther(String siteName) {
		element(searchForSitesContainer).waitUntilVisible();
		WebElement inputS = searchForSitesContainer.findElement(By
				.tagName("input"));
		inputS.clear();
		inputS.sendKeys(siteName);
		searchForSitesContainer.findElement(By.tagName("button")).click();
		waitABit(Constants.WAIT_TIME_SHORT);
	}

	public void openTheSiteFound(String siteName) {
		waitABit(Constants.WAIT_TIME_SHORT);
		element(searchedDefaultSitesContainer).waitUntilVisible();

		WebElement resultsTable = searchedDefaultSitesContainer.findElement(By
				.tagName("table"));

		List<WebElement> sitesList = resultsTable.findElements(By
				.cssSelector("tbody.yui-dt-data tr"));
		System.out.println("Search results list size: " + sitesList.size());
		for (WebElement siteFound : sitesList) {
			System.out.println("Site Element -> " + siteFound.getText());
			if (siteFound.getText().contains(siteName)) {
				System.out.println("! Found site in list !");
				WebElement siteLink = siteFound.findElement(By
						.cssSelector("td:first-child div a"));
				element(siteLink).waitUntilVisible();
				siteLink.click();
				break;
			}
		}
	}
	
	public void deleteSite(String siteName){
		waitABit(Constants.WAIT_TIME_SHORT);
		element(searchedDefaultSitesContainer).waitUntilVisible();

		WebElement resultsTable = searchedDefaultSitesContainer.findElement(By.tagName("table"));

		List<WebElement> sitesList = resultsTable.findElements(By.cssSelector("tbody.yui-dt-data tr"));
		
		System.out.println("Search results list size: " + sitesList.size());
		
		thisfor:
		for (WebElement siteFound : sitesList) {
			System.out.println("Site Element -> " + siteFound.getText());
			if (siteFound.getText().contains(siteName)) {
				System.out.println("! Found site in list !");
				List<WebElement> siteButtons = siteFound.findElements(By.tagName("button"));
				for(WebElement buttonNow:siteButtons){
					if(buttonNow.getText().contains(Constants.BUTTON_DELETE)){
						element(buttonNow).waitUntilVisible();
						buttonNow.click();
						break thisfor;
					}
				}

				break;
			}
		}
	}
}
