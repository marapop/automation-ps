package a.steps.alfresco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import a.pages.alfresco.AlfrescoDocumentLibraryPage;
import a.pages.alfresco.AlfrescoCopyMoveLinkToPage;
import a.tools.alfresco.WebDriverConfig;

public class AlfrescoCopyMoveLinkToSteps {

	WebDriver driver = WebDriverConfig.getCurrentDriver();
	AlfrescoCopyMoveLinkToPage copyMoveLinkToPage = PageFactory.initElements(driver, AlfrescoCopyMoveLinkToPage.class);
    private AlfrescoDocumentLibraryPage alfrescoDocumentLibraryPage;

    
	public void linkFromSelectedItemsMenu(String arg1, String arg2) {
		alfrescoDocumentLibraryPage.clickOnLinkTo();
		copyMoveLinkToPage.selectNode(arg2);
		copyMoveLinkToPage.clickOnLinkButton();
	}
	
	public void linkFromMoreMenu(String arg1, String arg2) {
		alfrescoDocumentLibraryPage.clickOnLinkToFromTheMoreMenu(arg1);
		copyMoveLinkToPage.linkToItemFromMoreMenu(arg2);
	}

	public void clickOnCopyToButton() {
		alfrescoDocumentLibraryPage.clickOnCopyToButton();
		copyMoveLinkToPage.clickOnCopyToCancelButton();
	}

	public void clickOnMoveToButton() {
		alfrescoDocumentLibraryPage.clickOnMoveToButton();
		copyMoveLinkToPage.clickOnCopyToCancelButton();
	}

	public void clickOnLinkToButton() {
		alfrescoDocumentLibraryPage.clickOnLinkToButton();
		copyMoveLinkToPage.clickOnCopyToCancelButton();
	}

	public void createLink() {
		alfrescoDocumentLibraryPage.clickOnLinkToButton();
		copyMoveLinkToPage.clickOnLinkButton();
	}

	public void clickOnCopyCancelButton() {
		copyMoveLinkToPage.clickOnCopyToCancelButton();
	}

	public void verifyItemIsRestricted(String nodeName) {
		copyMoveLinkToPage.verifyItemIsRestricted(nodeName);
		copyMoveLinkToPage.selectNode(nodeName);
		copyMoveLinkToPage.verifyCopyButtonIsDisabled();
	}

	public void verifyItemIsNotRestricted(String nodeName) {
		copyMoveLinkToPage.verifyItemIsNotRestricted(nodeName);
		copyMoveLinkToPage.selectNode(nodeName);
		copyMoveLinkToPage.verifyCopyButtonIsEnabled();
	}

}
