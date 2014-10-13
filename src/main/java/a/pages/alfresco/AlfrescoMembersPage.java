package a.pages.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;

public class AlfrescoMembersPage extends AbstractPage {

	public AlfrescoMembersPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "div.site-members")
	private WebElement siteSearchContainer;

	@FindBy(css = "input.search-term")
	private WebElement searchForPeopleContainer;

	@FindBy(css = "div.results.yui-dt")
	private WebElement resultsListContainer;

	@FindBy(css = "div.invitationlistwrapper")
	private WebElement inviteUsersContainer;

	@FindBy(css = "div.bd")
	private WebElement selectRoleDropConatainer;

	public void clickOnInvitePeopleButton() {
		element(siteSearchContainer).waitUntilVisible();
		siteSearchContainer.findElement(By.cssSelector("a[href='invite']"))
				.click();
	}

	public void searchForPeopleToInvite(String firstName) {
		element(searchForPeopleContainer).waitUntilVisible();
		WebElement searchInput = searchForPeopleContainer.findElement(By
				.tagName("input"));
		searchInput.clear();
		searchInput.sendKeys(firstName);
		searchForPeopleContainer.findElement(By.tagName("button")).click();
		// waitABit(Constants.WAIT_TIME_SHORT);
	}

	public void addUserFromList(String firstName) {
		waitForListToLoad();

		List<WebElement> list = searchForPeopleContainer.findElements(By
				.cssSelector("tr td div h3"));
		for (WebElement elem : list) {
			if (elem.findElement(By.cssSelector("a[href*='profile']"))
					.getText().contains(firstName)) {
				WebElement addButton = searchForPeopleContainer.findElement(By
						.cssSelector("tr td[headers*='actions'] button"));
				waitForTextToAppear(addButton, Constants.ADD_BUTTON_LABEL);
				addButton.click();
				break;
			}
		}
	}

	private void waitForListToLoad() {
		int waitCount = 0;
		boolean elementFound = false;
		do {
			waitABit(Constants.WAIT_TIME_SHORT);
			element(searchForPeopleContainer).waitUntilVisible();
			List<WebElement> usersList = resultsListContainer.findElements(By
					.cssSelector("tbody.yui-dt-data tr"));
			if (usersList.size() > 0) {
				elementFound = true;
			}

			waitCount++;
		} while (!elementFound && (waitCount <= Constants.EMAIL_WAIT_CYCLE));

	}

	public void clickOnSelectRoleForUser() {
		element(selectRoleDropConatainer).waitUntilVisible();
		WebElement selectR = selectRoleDropConatainer.findElement(By
				.tagName("button"));
		element(selectR).waitUntilVisible();
		selectR.click();
	}

	public void selectRoleDropDown(String userRole) {
		element(selectRoleDropConatainer).waitUntilVisible();
		List<WebElement> options = selectRoleDropConatainer.findElements(By
				.cssSelector("ul li a"));
		for (WebElement elem : options) {
			if (elem.getText().equals(userRole)) {
				elem.click();
				break;
			}
		}
	}

	public void clickToInvite() {
		element(inviteUsersContainer).waitUntilVisible();
		WebElement inviteButton = inviteUsersContainer.findElement(By
				.cssSelector("div.sinvite span span button"));
		element(inviteButton).waitUntilEnabled();
		inviteButton.click();
	}

}
