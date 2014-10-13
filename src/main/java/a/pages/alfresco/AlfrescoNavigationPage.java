package a.pages.alfresco;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoNavigationPage extends AbstractPage {

	public AlfrescoNavigationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div[id*='default-navBar']")
	private WebElement docNavigationContainer;

	@FindBy(id = "ygtv1")
	private WebElement repoNavigationLeftContainer;

	public void navigateToFolder(String folderName) {
		element(docNavigationContainer).waitUntilVisible();
		List<WebElement> list = docNavigationContainer.findElements(By
				.cssSelector("a.folder"));
		for (WebElement elem : list) {
			if (elem.getText().contains(folderName)) {
				element(elem).waitUntilPresent();
				elem.click();
				break;
			}
		}
	}

	public void navigationToDocumentsProperties() {
		element(docNavigationContainer).waitUntilVisible();
		WebElement elemFound = docNavigationContainer.findElement(By
				.cssSelector("a[href*='folder-details']"));
		elemFound.click();
	}

	public void navigateToSingleFolder(String folderName) {

		element(repoNavigationLeftContainer).waitUntilVisible();
		waitABit(Constants.WAIT_TIME);
		List<WebElement> childFolders = repoNavigationLeftContainer
				.findElements(By.cssSelector("div.ygtvchildren div.ygtvitem"));

		searchBreak: for (WebElement childFolder : childFolders) {
			if (childFolder.findElement(By.tagName("table")).getText().trim()
					.contentEquals(folderName)) {

				element(childFolder).waitUntilVisible();
				System.out.println("Element '"
						+ childFolder.findElement(By.tagName("table"))
								.getText().trim() + "' was found, searching: "
						+ folderName);
				childFolder.findElement(By.tagName("table"))
						.findElement(By.tagName("a")).click();

				break searchBreak;
			}
		}

	}

	public void openFolderView(String folderName) {
		element(repoNavigationLeftContainer).waitUntilVisible();
		List<WebElement> childFolders = repoNavigationLeftContainer
				.findElements(By.cssSelector("div.ygtvchildren div.ygtvitem"));

		for (WebElement childFolder : childFolders) {

			if (childFolder.findElement(By.tagName("table")).getText().trim()
					.contentEquals(folderName)) {

				element(childFolder).waitUntilVisible();
				childFolder.findElement(
						By.cssSelector("table tbody tr td span.ygtvlabel"))
						.click();
			}
		}
	}

	public void verifyTreeViewItem(String treeView) {
		boolean isPresent = false;
		element(repoNavigationLeftContainer).waitUntilVisible();
		List<WebElement> childFolders = repoNavigationLeftContainer
				.findElements(By.cssSelector("div.ygtvchildren div.ygtvitem"));

		for (WebElement childFolder : childFolders) {

			if (childFolder.findElement(By.tagName("table")).getText().trim()
					.contains(treeView)) {
				isPresent = true;
				break;
			}
		}
		Assert.assertTrue("Assertion error: Element has not been found !", isPresent);
	}
}
