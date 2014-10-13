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
public class AlfrescoAdvancedSearchPage extends AbstractPage {

	public AlfrescoAdvancedSearchPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "div[class*='keywords-box']")
	private WebElement keywordsContainer;

	@FindBy(css = "input[id*='default-search-text']")
	private WebElement keywordSearchField;

	@FindBy(css = "div[id*='form-fields']")
	private WebElement searchFormContainer;

	@FindBy(css = "input[name='prop_cm_name']")
	private WebElement nameField;

	@FindBy(css = "textarea[name='prop_cm_title']")
	private WebElement titleField;

	@FindBy(css = "button[id*='default-search-button-1-button']")
	private WebElement searchButton;

	@FindBy(css = "select[id*='prop_mimetype']")
	private WebElement mimeTypeCombo;

	@FindBy(css = "textarea[name='prop_cm_description']")
	private WebElement descriptionField;

	@FindBy(css = "span.selected-form-button")
	private WebElement lookForContainer;

	@FindBy(css = "fieldset#setAsset")
	private WebElement assetExpandContainer;

	@FindBy(css = "div[class*='results-right']")
	private WebElement inputCheckbox;



	public void inputName(String contentName) {
		element(searchFormContainer).waitUntilVisible();
		element(nameField).waitUntilVisible();
		nameField.clear();
		nameField.sendKeys(contentName);
		waitABit(Constants.WAIT_TIME_SHORT);
	}

	public void clickSearchButton() {
		element(searchButton).waitUntilVisible();
		element(searchButton).click();

	}

	public void inputKeyword(String keyword) {
		element(keywordsContainer).waitUntilVisible();
		element(keywordSearchField).waitUntilVisible();
		keywordSearchField.clear();
		keywordSearchField.sendKeys(keyword);
		waitABit(Constants.WAIT_TIME_SHORT);

	}

	public void inputTitle(String contentTitle) {
		element(searchFormContainer).waitUntilVisible();
		element(titleField).waitUntilVisible();
		titleField.clear();
		element(titleField).type(contentTitle);
		waitABit(Constants.WAIT_TIME_SHORT);
	}

	public void selectMimeType(String mimeType) {
		element(searchFormContainer).waitUntilVisible();
		element(mimeTypeCombo).waitUntilVisible();
		element(mimeTypeCombo).selectByVisibleText(mimeType);
		waitABit(Constants.WAIT_TIME_SHORT);
	}

	public void inputDescription(String contentDescription) {
		element(searchFormContainer).waitUntilVisible();
		element(descriptionField).waitUntilVisible();
		descriptionField.clear();
		element(descriptionField).type(contentDescription);
		waitABit(Constants.WAIT_TIME_SHORT);
	}

	public void clickOnLookForDropdown() {
		element(lookForContainer).waitUntilVisible();
		lookForContainer.findElement(By.tagName("span")).click();
	}

	public void selectTypeOfSearch(String assetType){
		element(lookForContainer).waitUntilVisible();
		List<WebElement> list= lookForContainer.findElements(By.cssSelector("div li span[class*='form-type-name']"));
		for(WebElement elem:list){
			if(elem.getText().contains(Constants.ASSET_SEARCH_LABEL)){
				elem.sendKeys("");
				elem.click();
			}
		}
	}

	public void clickOnAssetExapnd(){
		element(assetExpandContainer).waitUntilVisible();
		WebElement assetExpand= assetExpandContainer.findElement(By.tagName("legend"));
		if(assetExpand.getAttribute("class").contains("collapsed")){
			assetExpand.click();
		}
	}

	public void verifyResutsListSize(int size) {
		waitABit(Constants.WAIT_TIME);
		element(inputCheckbox).waitUntilVisible();
		List<WebElement> resultList = inputCheckbox.findElements(By.tagName("input"));
		Assert.assertTrue("Result list was expected to be: " + size + ", actual size is: " + resultList.size(), resultList.size() == size);
	}
}
