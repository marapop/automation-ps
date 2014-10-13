package a.pages.alfresco;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoUploadDialogPage extends AbstractPage {

	public AlfrescoUploadDialogPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[id*='documentlibrary_x0023_default-dialog_c']")
	private WebElement uploadDiablogContainer;

	@FindBy(css = "[class*='dnd-file-selection-button']")
	private WebElement uploadInput;

	@FindBy(id = "template_x002e_html-upload_x002e_document-details_x0023_default-minorVersion")
	private WebElement minorRadioButton;


	public String uploadMinorVersion(String uploadFilePath, String uploadComment) {
		element(uploadDiablogContainer).waitUntilVisible();
		uploadInput.sendKeys(uploadFilePath);
		element(minorRadioButton).waitUntilVisible();
		String minorVersion = minorRadioButton.getText();

		minorVersion = minorVersion.replace("minor changes (", "")
				.replace(")", "").trim();
		System.out.println("Uploaded Minor Version: " + minorVersion);
		waitABit(Constants.WAIT_TIME);
		waitForCondition().until(
				ExpectedConditions.invisibilityOfElementLocated(By
						.id("message")));

		return minorVersion;
	}

}
