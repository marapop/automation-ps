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
public class AlfrescoListActionsPage extends AbstractPage{

	public AlfrescoListActionsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div[id*='default-documents']")
	private WebElement documentsListContainer;

	@FindBy(css = "ul[id*='_default-tags']")
	private WebElement tagsContainer;
	
	@FindBy(css = "div.documents.yui-dt")
	private WebElement inputCheckboxContainer;
	
	public void clickOnDelete(String fileName) {
		element(documentsListContainer).waitUntilVisible();

		waitABit(Constants.WAIT_TIME_SHORT);

		List<WebElement> documentList = documentsListContainer.findElements(By.cssSelector("tr[class*='yui-dt-rec']"));
	
		for (WebElement documentNow : documentList) {

			WebElement docDetails = documentNow.findElement(By.cssSelector("h3.filename"));

			if (docDetails.getText().contains(fileName)) {
				
				WebElement moreButton = documentNow.findElement(By.cssSelector("a[title='Delete Link']"));

				moreButton.click();
				waitABit(Constants.WAIT_TIME_SHORT);
				break;
			}
		}
	}

	public void markFile(String fileName) {
		element(documentsListContainer).waitUntilVisible();
		waitABit(Constants.WAIT_TIME_SHORT);

		List<WebElement> documentList = documentsListContainer.findElements(By.cssSelector("tr[class*='yui-dt-rec']"));
	
		for (WebElement documentNow : documentList) {
			WebElement docDetails = documentNow.findElement(By.cssSelector("h3.filename"));

			if (docDetails.getText().contains(fileName)) {
				System.out.println(("Searched file has been found: " + fileName));

				documentNow.findElement(By.cssSelector("td:first-child div.yui-dt-liner input")).click();
				break;
			}
		}
	}
	
	public void editFileName(String fileName){
		element(documentsListContainer).waitUntilVisible();
		
		List<WebElement> documentList = documentsListContainer.findElements(By.cssSelector("tr[class*='yui-dt-rec']"));
				
		for(WebElement documentNow:documentList){

			WebElement docTitle = documentNow.findElement(By.cssSelector("h3.filename span a"));
			if(docTitle.getText().contains(fileName)){
				System.out.println(("Searched file has been found: " + fileName));
				elementjQueryMouseOver("div[class=yui-dt-liner] h3[class=filename]");
				elementjQueryClick("div[class=yui-dt-liner] h3[class=filename]");

				break;
			}
		}
	}
	
	public void clickOnTag(String tagName){
		element(documentsListContainer).waitUntilVisible();
		element(tagsContainer).waitUntilVisible();
		waitABit(Constants.WAIT_TIME_SHORT);
		List<WebElement> tagList = tagsContainer.findElements(By.tagName("li"));
		
		theFor:
		for(WebElement tagNow:tagList){
			if(tagNow.getText().contains(tagName.toLowerCase())){
				tagNow.click();
				tagNow.findElement(By.tagName("span")).click();
				tagNow.findElement(By.tagName("a")).click();
				tagNow.sendKeys(" ");
				break theFor;
			}
			waitABit(Constants.WAIT_TIME_SHORT);
		}
		
	}
	
	public void verifyTagIsSelected(String tagName){
		waitABit(Constants.WAIT_TIME_SHORT);
		WebElement selectedTag = getDriver().findElement(By.cssSelector("li.selected"));
		Assert.assertTrue("Tag has not been selected. ", selectedTag.getText().contains(tagName.toLowerCase()));
	}
	
	public void openFileView(String fileName) {
		element(documentsListContainer).waitUntilVisible();

		List<WebElement> documentList = documentsListContainer.findElements(By
				.cssSelector("tr[class*='yui-dt-rec']"));

		for (WebElement documentNow : documentList) {

			WebElement docDetails = documentNow.findElement(By
					.cssSelector("h3.filename"));
			if (docDetails.getText().contains(fileName)) {
				System.out
						.println(("Searched file has been found: " + fileName));
				docDetails.findElement(By.cssSelector("span a")).click();
				break;
			}
		}
	}

	public void openDocmentForVerifyingRoles(){
		element(documentsListContainer).waitUntilVisible();
		waitABit(Constants.WAIT_TIME_LONG);
		
		WebElement elemFound= documentsListContainer.findElement(By.cssSelector("td[headers*='fileName'] a"));
		element(elemFound).waitUntilVisible();
		elemFound.click();
		
	}
	
	public void clickOnMoreAndManageAspects(String fileName){
		element(documentsListContainer).waitUntilVisible();
		waitABit(Constants.WAIT_TIME_SHORT);

		List<WebElement> documentList = documentsListContainer.findElements(By.cssSelector("tr[class*='yui-dt-rec']"));
	
		for (WebElement documentNow : documentList) {
			WebElement docDetails = documentNow.findElement(By.cssSelector("h3.filename"));

			if (docDetails.getText().contains(fileName)) {
				String elemHeader= docDetails.getCssValue("class");
				
				elementjQueryMouseOver(""+elemHeader+" div.internal-show-more a span");
				waitABit(Constants.WAIT_TIME_SHORT);

				elementjQueryClick(""+elemHeader+" div.internal-show-more a span");
				waitABit(Constants.WAIT_TIME_SHORT);
				
				WebElement moreListContainer = documentsListContainer.findElement(By.cssSelector("div.more-actions div.document-manage-aspects"));
				waitABit(Constants.WAIT_TIME_SHORT);
				moreListContainer.sendKeys("");
				moreListContainer.sendKeys(" ");
				moreListContainer.findElement(By.tagName("a")).click();
				waitABit(Constants.WAIT_TIME_LONG);
				
				break;
			}
		}
	}

	public void clickOnMoreAndDelete(String fileName){
		element(documentsListContainer).waitUntilVisible();

		waitABit(Constants.WAIT_TIME_SHORT);

		List<WebElement> documentList = documentsListContainer.findElements(By.cssSelector("tr[class*='yui-dt-rec']"));
	
		for (WebElement documentNow : documentList) {

			WebElement docDetails = documentNow.findElement(By.cssSelector("h3.filename"));

			if (docDetails.getText().contains(fileName)) {			
				String elemHeader= docDetails.getCssValue("class");
				elementjQueryMouseOver(""+elemHeader+" div.internal-show-more a span");
				waitABit(Constants.WAIT_TIME_SHORT);

				elementjQueryClick(""+elemHeader+" div.internal-show-more a span");
				waitABit(Constants.WAIT_TIME_SHORT);
			
				WebElement moreListContainer = documentNow.findElement(By.cssSelector("div.more-actions div.document-delete"));
				System.out.println(("Searched elem ID: " + moreListContainer.getAttribute("id")));
				waitABit(Constants.WAIT_TIME_SHORT);
				moreListContainer.sendKeys("");
				moreListContainer.sendKeys(" ");
				moreListContainer.findElement(By.tagName("a")).click();
				waitABit(Constants.WAIT_TIME_LONG);
				
				break;
			}
		}
	}
	
	public void verifyFileIsPresent(String fileName) {

		boolean isPresent = false;
		System.out.println("File name : " + fileName);
		element(documentsListContainer).waitUntilVisible();

		List<WebElement> documentList = documentsListContainer.findElements(By
				.cssSelector("tr[class*='yui-dt-rec']"));

		for (WebElement documentNow : documentList) {
			WebElement docDetails = documentNow.findElement(By
					.cssSelector("h3.filename"));

			if (docDetails.getText().contains(fileName)) {
				System.out
						.println(("Searched file has been found: " + fileName));
				isPresent = true;
				break;
			}
		}

		Assert.assertTrue("File has not been found! ", isPresent);
	}
	
	public void verifyFileIsNotPresent(String fileName) {

		boolean isNotPresent = false;
		System.out.println("File name : " + fileName);
		element(documentsListContainer).waitUntilVisible();

		List<WebElement> documentList = documentsListContainer.findElements(By
				.cssSelector("tr[class*='yui-dt-rec']"));

		for (WebElement documentNow : documentList) {
			WebElement docDetails = documentNow.findElement(By
					.cssSelector("h3.filename"));

			if (docDetails.getText().contains(fileName)) {
				System.out
						.println(("Searched file has been found: " + fileName));
				isNotPresent = true;
				break;
			}
		}

		Assert.assertFalse("File has been found! ", isNotPresent);
	}
	
	public void verifyFileCount(int fileCount) {
		
		System.out.println("File count : " + fileCount);
		element(documentsListContainer).waitUntilVisible();
		List<WebElement> documentList = documentsListContainer.findElements(By
				.cssSelector("tr[class*='yui-dt-rec']"));
		Assert.assertTrue("Count does not match. " + documentList.size(), documentList.size() == fileCount);
	}
	
	public void verifyIcon(String fileName, String iconType) {
		element(documentsListContainer).waitUntilVisible();
		
		// for the page to load
		waitABit(Constants.WAIT_TIME_SHORT);
		
		List<WebElement> documentList = documentsListContainer.findElements(By.cssSelector("tr[class*='yui-dt-rec']"));
		
		for (WebElement documentNow : documentList) {
			
			WebElement docDetails = documentNow.findElement(By.cssSelector("h3.filename"));
			WebElement docIcon = documentNow.findElement(By.cssSelector("td[headers*='th-thumbnail'] div span a img"));
			
			if (docDetails.getText().contains(fileName)) {
				System.out.println(("Searched file has been found: " + fileName));
				System.out.println(("Searched file icon: " + docIcon.getAttribute("src")));
				System.out.println(("Icon Type: " + iconType));
				
				Assert.assertTrue("Icon " + docIcon.getAttribute("src") + " , is not the one expected: " + iconType, docIcon.getAttribute("src").contains(iconType));
				
				break;
			}
		}
	}

	public void verifyFileNameAndRagStatus(String fileName, String ragColour) {
		element(documentsListContainer).waitUntilVisible();
		waitABit(Constants.WAIT_TIME_SHORT);
		
		List<WebElement> documentList = documentsListContainer.findElements(By.cssSelector("tr[class*='yui-dt-rec']"));
		
		for (WebElement documentNow : documentList) {
			
			WebElement docDetails = documentNow.findElement(By.cssSelector("h3.filename"));
			WebElement docStatus = documentsListContainer.findElement(By
					.cssSelector("td[headers*='status']"));
			WebElement docIcon = documentNow.findElement(By.cssSelector("td[headers*='th-thumbnail'] div span a img"));
			
			
			if (docDetails.getText().contains(fileName)) {
				WebElement docStatusIcon = docStatus.findElement(By
						.cssSelector("div div img[title*='" + ragColour + "']"));
				System.out.println(("Searched file has been found: " + fileName));
				System.out.println(("Searched file icon: " + docIcon.getText()));
				System.out.println(("Rag colour: " + ragColour));
				
				Assert.assertTrue("Doc's rag status does not contain the text: "
						+ docStatusIcon.getAttribute("title"),
						docStatusIcon.getAttribute("title").contains(ragColour));
				break;
			}
		}
	}

	public void verifyIfFileIsDeleted(String fileName) {
		element(documentsListContainer).waitUntilVisible();

		waitABit(Constants.WAIT_TIME_SHORT);

		List<WebElement> documentList = documentsListContainer.findElements(By.cssSelector("tr[class*='yui-dt-rec']"));
	
		for (WebElement documentNow : documentList) {

			WebElement docDetails = documentNow.findElement(By.cssSelector("h3.filename"));
			Assert.assertFalse(
					"The document " + "'" + fileName + "'"
							+ " wasn't deleted/moved/link to from Document Library"
							+ docDetails.getText(), docDetails.getText()
							.contains(fileName));
			break;
		}
	}

	public void clickOnEditProperties(String fileName) {
		
		element(documentsListContainer).waitUntilVisible();

		waitABit(Constants.WAIT_TIME_SHORT);
		List<WebElement> documentList = documentsListContainer.findElements(By.cssSelector("tr[class*='yui-dt-rec']"));
	
		for (WebElement documentNow : documentList) {

			WebElement docDetails = documentNow.findElement(By.cssSelector("h3.filename"));
			if (docDetails.getText().contains(fileName)) {
				
				WebElement editPropButton = documentNow.findElement(By.cssSelector("a[title='Edit Properties']"));

				waitABit(Constants.WAIT_TIME_SHORT);
				editPropButton.sendKeys("");
				editPropButton.sendKeys(" ");
				
				editPropButton.click();
				waitABit(Constants.WAIT_TIME_SHORT);
				break;
			}
		}		
	}

	public void verifyResutsListSize(int size) {
		 waitABit(Constants.WAIT_TIME);
		   element(inputCheckboxContainer).waitUntilVisible();
		   List<WebElement> resultList = inputCheckboxContainer.findElements(By.tagName("input"));
		   
		   Assert.assertTrue("Result list was expected to be: " + size + ", actual size is: " + resultList.size(), resultList.size() == size);
	}
}
