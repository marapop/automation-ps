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
public class AlfrescoCreateContentPage extends AbstractPage {

	public AlfrescoCreateContentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[id*='default-createContent-button-button']")
	private WebElement createContentMenuForNewSite;
	
	@FindBy(css = "[id*='default-createContent-menu']")
	private WebElement createContentMenuContainer;
	
	@FindBy(css = "button[id*='createContent-button']")
	private WebElement createContentButton;

	@FindBy(css = "div[class*='yui-menu-button-menu visible']")
	private WebElement createContentMenu;

	@FindBy(css = "span[id*='default-newFolder-button']")
	private WebElement createFolderButton;
	
	@FindBy(xpath = "//div[contains(@class,'yui-menu-button-menu')]//a[@class='yuimenuitemlabel']/span[contains(.,'Folder')]")
	private WebElement createFolderButtonAlternative;
	
	@FindBy(css = "[id*='default-newFolder-button-button']")
	private WebElement createFolder;
	
	@FindBy(css = "button[id*='default-fileUpload-button-button']")
	private WebElement uploadButton;
	
	@FindBy(css = "[class*='yui-submit-button']")
	private WebElement uploadFileButton;

	@FindBy(css = "input[id*='default-filedata-file']")
	private WebElement uploadInputNoFlash;
	
	@FindBy(css = "button[id*='default-selectedItems-button-button']")
	private WebElement selectedItemsButton;

	
	public void createNewFolder() {
		element(createFolder).waitUntilVisible();
		createFolder.click();
	}
	
	public void clickOnCreateFolder() {
		element(createFolderButton).waitUntilVisible();
		createFolderButton.click();		
	}
	
	public void verifyCreateFolderIsDisabled(){
		element(createFolderButton).waitUntilVisible();
		System.out.println("button: " + createFolderButton.getAttribute("disabled"));
		Assert.assertTrue("Create Folder button is not disabled", createFolderButton.getAttribute("class").contains("yui-push-button-disabled"));
	}


	public void clickOnCreateCollection() {
		element(createContentMenu).waitUntilVisible();
		List<WebElement> plainTextLinks = createContentMenu.findElements(By
				.cssSelector("span"));

		for (WebElement elem : plainTextLinks) {
			if (elem.getText().contains(Constants.CREATE_COLLECTION)) {
				element(elem).waitUntilEnabled();
				System.out.println(">>>>" + elem.getText());
				elem.click();
				break;
			}
		}
	}
	
	public void clickOnPlaceholderAsset() {
		element(createContentMenuForNewSite).waitUntilVisible();
		createContentMenuForNewSite.click();
		element(createContentMenuContainer).waitUntilVisible();

		List<WebElement> linkList = createContentMenuContainer.findElements(By.cssSelector("li a"));
		
		for(WebElement linkNow:linkList){
			if(linkNow.getText().contains(Constants.CREATE_TEXT)){
				linkNow.click();
				break;
			}
		}
	}

	public void clickOnCreateContentPlainText() {
		element(createContentMenu).waitUntilVisible();
		List<WebElement> plainTextLinks = createContentMenu.findElements(By
				.cssSelector("span"));

		for (WebElement elem : plainTextLinks) {
			if (elem.getText().contains(Constants.CREATE_TEXT)) {
				element(elem).waitUntilEnabled();
				System.out.println(">>>>" + elem.getText());
				elem.click();
				break;
			}
		}
	}

	public void clickOnCreateContent() {
		element(createContentButton).waitUntilVisible();
		createContentButton.click();
	}

	public void clickOnCreateOupProject() {
		element(createContentMenu).waitUntilVisible();
		List<WebElement> createProjectLinks = createContentMenu.findElements(By
				.cssSelector("span"));

		for (WebElement elem : createProjectLinks) {
			if (elem.getText().contains(Constants.CREATE_PROJECT)) {
				element(elem).waitUntilEnabled();
				elem.click();
				break;
			}
		}
	}

	public void clickOnCreateAssetSpec() {
		element(createContentMenu).waitUntilVisible();
		List<WebElement> createProjectLinks = createContentMenu.findElements(By
				.cssSelector("span"));

		for (WebElement elem : createProjectLinks) {
			if (elem.getText().contains(Constants.CREATE_ASSET_SPEC)) {
				element(elem).waitUntilEnabled();
				elem.click();
				break;
			}
		}
	}
	

	public void verifyIfCreateContentIsDisabled() {
		element(createContentMenuForNewSite).waitUntilVisible();
		Assert.assertFalse("! Create Content is enabled "+createContentMenuForNewSite.isEnabled(), createContentMenuForNewSite.isEnabled());
	}

	
	
	/**
	 * Will Upload a document in the repository view. It will also disable flash
	 * on the page.
	 * 
	 * @param fileName
	 */
	public void uploadDocument(String fileName) {
		disableFlash();

		element(uploadButton).waitUntilVisible();
		uploadButton.click();
		uploadButton.sendKeys(" ");

		System.out.println("File path absolute : " + fileName);
		element(uploadInputNoFlash).waitUntilVisible();

		uploadInputNoFlash.sendKeys(fileName);

		element(uploadFileButton).waitUntilPresent();
		uploadFileButton.click();
		waitABit(Constants.WAIT_TIME_LONG);
	}

	public void verifyIfCreateCollectionIsDisabled() {
		element(createContentMenu).waitUntilVisible();
		Assert.assertFalse("Collection button is present. " + createContentMenu.getText(), createContentMenu.getText().contains(Constants.CREATE_COLLECTION));
		
	}

	public void clickOnCreateSeries() {
		element(createContentMenu).waitUntilVisible();
		List<WebElement> createProjectLinks = createContentMenu.findElements(By
				.cssSelector("span"));

		for (WebElement elem : createProjectLinks) {
			if (elem.getText().contains(Constants.CREATE_SERIES)) {
				element(elem).waitUntilEnabled();
				elem.click();
				break;
			}
		}
		
	}

	public void verifyIfCreateContentIsEnabled() {
		element(createContentMenuForNewSite).waitUntilVisible();
		Assert.assertTrue("! Create Content is not enabled "+createContentMenuForNewSite.isEnabled(), createContentMenuForNewSite.isEnabled());
	}

	
}
