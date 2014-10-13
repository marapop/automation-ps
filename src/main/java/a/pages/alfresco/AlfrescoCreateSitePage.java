package a.pages.alfresco;

import java.util.List;

import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoCreateSitePage extends AbstractPage {
	public AlfrescoCreateSitePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div.bd > form> div:nth-child(2)> div>input")
	private WebElement nameField;

	@FindBy(css = "div.bd > form> div:nth-child(4)> div>textarea")
	private WebElement descriptionField;

	@FindBy(css = "div.bd > form> div:nth-child(5)>div>select")
	private WebElement typeOption;

	@FindBy(css = "div.bd > form> div:nth-child(8)>span:first-child>span >button")
	private WebElement okButton;

	@FindBy(css = "div.alf-menu-title > a.alf-menu-title-text")
	private WebElement siteNameContainer;

	@FindBy(css = "form#alfresco-createSite-instance-form > div")
	private List<WebElement> visibilities;
	
	
	@FindBy(id = "alfresco-createSite-instance-dialog_c")
	private WebElement createSitesDialogBoxContainer;

	@FindBy(css = "input#alfresco-createSite-instance-title")
	private WebElement inputSitesName;

	@FindBy(css = "div.yui-u textarea")
	private WebElement inputSitesDescription;

	@FindBy(css = "button#alfresco-createSite-instance-ok-button-button")
	private WebElement createSiteOkButton;


	private WebDriver driver;


	public void inputNameField(String name) {
		element(nameField).waitUntilVisible();
		element(nameField).type(name);

	}

	public void inputDescriptionField(String siteDescription) {
		element(descriptionField).waitUntilVisible();
		element(descriptionField).type(siteDescription);
	}

	public void selectTypeOption(String siteType) {
		element(typeOption).waitUntilVisible();
		element(typeOption).selectByVisibleText(siteType);
	}

	public void clickOnOkButton() {
		element(okButton).waitUntilVisible();
		okButton.click();
		verifyNotificationMessage("Site is being created...");
	}

	public void verifySiteName(String siteName) {
		element(siteNameContainer).waitUntilVisible();
		//waitFor(ExpectedConditions.textToBePresentInElement(siteNameContainer, siteName));
		String actualSiteName = element(siteNameContainer).getTextValue().trim();
		Assert.assertTrue(String.format("The site name was expected to be '%s' but it is '%s'!",
				siteName, actualSiteName), actualSiteName.equalsIgnoreCase(siteName));
	}

	public void selectSiteVisibility(String siteVisibility) {
		boolean foundVisibility = false;
		// the visibility options start from the 5th element (index 4)
		for (int i = 4; i < visibilities.size(); i++) {
			WebElement visibility = visibilities.get(i);
			if (visibility.getText().contains(siteVisibility)) {
				foundVisibility = true;
				WebElement visibilityInput = visibility.findElement(By.tagName("input"));
				if (!(element(visibilityInput).isSelected())) {
					visibilityInput.click();
				}
				break;
			}
		}
		Assert.assertTrue("The site visibility '" + siteVisibility + "' was not found!", foundVisibility);
	}
	
	public void fillCreateSiteDialogBox(String siteName, String siteDescription) {
		element(createSitesDialogBoxContainer).waitUntilVisible();
		element(inputSitesName).waitUntilVisible();
		inputSitesName.clear();
		inputSitesName.sendKeys(siteName);
		element(inputSitesDescription).waitUntilVisible();
		inputSitesDescription.clear();
		inputSitesDescription.sendKeys(siteDescription);
	}
	
	public void createSite() {
		element(createSiteOkButton).waitUntilVisible();
		createSiteOkButton.click();
		waitABit(Constants.WAIT_TIME_LONG);
	}
	 public Object evaluateJavascript(final String script) {
	        addJQuerySupport();
	        JavascriptExecutorFacade js = new JavascriptExecutorFacade(driver);
	        return js.executeScript(script);
	    }
}
