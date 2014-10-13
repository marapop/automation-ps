package a.pages.alfresco;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Constants;
import a.tools.alfresco.Delay;
import a.tools.alfresco.StringUtils;

public class AlfrescoDashboardPage extends AbstractPage {

	public AlfrescoDashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "tbody.dijitReset > tr#HEADER_USER_MENU_LOGOUT > td#HEADER_USER_MENU_LOGOUT_text > a")
	private WebElement logoutLink;

	@FindBy(css = "div.horizontal-widget span#HEADER_USER_MENU_POPUP_text")
	private WebElement userButton;

	@FindBy(css = "div[class*='sites'] tbody[class*='data']")
	private WebElement mySitesTable;

	@FindBy(css = "a[title *='Home']")
	private WebElement homeButton;
	
	@FindBy(css = "div.dashlet.my-tasks div:nth-child(2) > div >span:nth-child(2) a")
	private WebElement startWorkflowItem;

	@FindBy(css = "div[class*='dashlet my-tasks resizable yui-resize'] > div:nth-of-type(5) > div >table > tbody[class*='data']")
	private WebElement myTasksTable;

	@FindBy(css = "span#HEADER_REPOSITORY_text a")
	private WebElement repositoryItem;

	@FindBy(css = "div#HEADER_SEARCH_BOX input")
	private WebElement siteSearchInput;

	@FindBy(css = "div#HEADER_SEARCH_BOX_DROPDOWN_MENU > img.alf-search-icon")
	private WebElement searchIcon;

	@FindBy(css = "td#HEADER_SEARCH_BOX_ADVANCED_SEARCH_text > a.alfresco-menus-_AlfMenuItemMixin")
	private WebElement advancedSearchLink;

	@FindBy(css = "div.workflow-tools > a")
	private WebElement activitiWorkflowConsoleLink;

	@FindBy(css = "a[id*='invite-button'] span")
	private WebElement invitePeopleButton;

	@FindBy(css = "div[id*='HEADER_USER_MENU_POPUP_dropdown']")
	private WebElement administratorContainer;

	@FindBy(css = "span[id*='HEADER_USER_MENU_POPUP_text']")
	private WebElement administratorButton;

	@FindBy(css = "div.site-finder")
	private WebElement searchForSitesContainer;

	@FindBy(css = "div[id*='default-sites']")
	private WebElement searchedDefaultSitesContainer;

	@FindBy(css = "a[id*='_default-join-link']")
	private WebElement joinSiteButton;

	@FindBy(css = "[class*='suggested-actions']")
	private WebElement editTaskButtonsContainer;

	@FindBy(css = "div[class='body scrollableList']")
	private WebElement myTasksContainer;

	@FindBy(css = "#HEADER_SITES_MENU_text")
	private WebElement sites;

	@FindBy(css = "#HEADER_SITES_MENU_SITE_FINDER_text a")
	private WebElement siteFinder;

	@FindBy(css = "a[title='Admin Tools'] ")
	private WebElement adminTools;

	@FindBy(css = "a[href='users']")
	private WebElement users;

	@FindBy(css = "div[id*='default-search'] input[id*='search-text']")
	private WebElement userSearch;

	@FindBy(css = "div[id*='default-datatable'] tbody[class*='data'] td div a")
	private List<WebElement> searchUserNames;

	@FindBy(css = "button[id*='edituser']")
	private WebElement editUser;

	@FindBy(css = "input[id*='_default-update-groupfinder-search-text']")
	private WebElement groups;

	@FindBy(css = "td[class*='col-actions yui-dt-last'] button[id*='button']")
	private WebElement addGroupButton;

	@FindBy(xpath = "//div[contains(@id, 'update-groups')]/span[contains(text(),'Ixxus Staff')]")
	private WebElement deleteGroupIxxusStaffButton;

	@FindBy(xpath = "//div[contains(@id, 'update-groups')]/span[contains(text(),'ALFRESCO_ADMINISTRATORS')]")
	private WebElement deleteGourpAdministratorButton;

	@FindBy(css = "button[id*='updateuser-save']")
	private WebElement saveUserChanges;

	@FindBy(css = "a[id*='createSite'] span")
	private WebElement createSiteFromUserDashboard;

	@FindBy(css = "span[id*='HEADER_SITES_MENU_text']")
	private WebElement createSiteFromSitesMenu;

	@FindBy(css = "td[id='HEADER_SITES_MENU_CREATE_SITE_text']")
	private WebElement createSiteFromSitesMenuDropDown;

	@FindBy(css = "input[id*='createSite-instance-title']")
	private WebElement siteName;

	@FindBy(css = "input[id*='createSite-instance-shortName']")
	private WebElement siteURL;

	@FindBy(css = "button[id*='createSite-instance-ok']")
	private WebElement createSiteOKButton;

	@FindBy(css = "div[id='alfresco-createSite-instance-dialog_c']")
	private WebElement createSitePopUp;

	public boolean verifyElementAbsent(String css) throws Exception {
		try {
			getDriver().findElement(By.cssSelector(css));
			// System.out.println("Element Present");
			return false;

		} catch (Exception e) {
			// System.out.println("Element absent");
			return true;
		}
	}

	public void invitePeopleButton() throws Exception {
		boolean siteAbsent;
		siteAbsent = verifyElementAbsent("a[id*='invite-button'] span");
		if (invitePeopleButton.isDisplayed()) {
			element(invitePeopleButton).waitUntilVisible();
			invitePeopleButton.click();
			siteAbsent = true;
		}
		Assert.assertTrue("The 'Invite People' was not found", siteAbsent);
	}

	public void checkInvitePeople() throws Exception {
		boolean buttonIsAbsent = false;
		boolean verifyIfButtonIsAbsent = false;
		verifyIfButtonIsAbsent = verifyElementAbsent("a[id*='invite-button'] span");

		if (verifyIfButtonIsAbsent == true) {
			buttonIsAbsent = true;
		}
		Assert.assertTrue("The 'Invite People' button is displayed",
				buttonIsAbsent);
	}

	public void checkCreateSite() throws Exception {
		element(createSiteFromSitesMenu).waitUntilVisible();
		createSiteFromSitesMenu.click();
		boolean buttonIsAbsent = false;
		boolean verifyIfButtonIsAbsent = false;
		verifyIfButtonIsAbsent = verifyElementAbsent("td[id='HEADER_SITES_MENU_CREATE_SITE_text']");

		if (verifyIfButtonIsAbsent == true) {
			buttonIsAbsent = true;
		}
		Assert.assertTrue("The 'Create Site' button is displayed",
				buttonIsAbsent);
	}

	public void clickSiteFinder() {
		element(sites).waitUntilVisible();
		sites.click();
		waitABit(1000);
		element(siteFinder).waitUntilVisible();
		siteFinder.click();
	}

	public boolean logoutIfLoggedIn() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		waitABit(1000);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		clickOnButtonIfExists(By
				.cssSelector("div.horizontal-widget span#HEADER_USER_MENU_POPUP_text"));
		return clickOnButtonIfExists(By
				.cssSelector("tbody.dijitReset > tr#HEADER_USER_MENU_LOGOUT > td#HEADER_USER_MENU_LOGOUT_text > a"));
	}

	public void clickOnStartWorkflowItem() {
		element(startWorkflowItem).waitUntilVisible();
		element(startWorkflowItem).click();
	}

	public void clickOnRepositoryItem() {
		element(repositoryItem).waitUntilVisible();
		element(repositoryItem).click();
	}

	public void verifyLoggedInUserDisplayedName(String firstname,
			String lastname) {
		Assert.assertTrue("Element is not visible", element(userButton)
				.isVisible());
		String userNameContainer = userButton.getText();
		Assert.assertTrue("The first name displayed is different!",
				userNameContainer.contains(firstname));
		Assert.assertTrue("The last anme displayed is different!",
				userNameContainer.contains(lastname));
	}

	public boolean checkIfUserIsLoggedIn() {
		return checkIfElementExists(By
				.cssSelector("span.user-items span[id*='user'] button"));
	}

	public boolean isSiteOnDashboard(String siteName) {
		waitABit(2000);
		homeButton.click();	
		element(mySitesTable).waitUntilVisible();
		List<WebElement> siteList = mySitesTable.findElements(By
				.cssSelector("tr"));
		for (WebElement site : siteList) {
			String siteTitle = site.findElement(
					By.cssSelector("td > div > h3[class*='site-title'] > a"))
					.getText();
			if (siteTitle.contains(siteName)) {
				return true;
			}
		}
		return false;
	}

	public void clickCreateSiteFromUserDashboard() {
		element(createSiteFromUserDashboard).waitUntilVisible();
		createSiteFromUserDashboard.click();

	}

	public void clickCreateSiteFromSitesMenu() {
		boolean createSite = false;
		element(createSiteFromSitesMenu).waitUntilVisible();
		createSiteFromSitesMenu.click();
		if (createSiteFromSitesMenuDropDown.isDisplayed()) {
			element(createSiteFromSitesMenuDropDown).waitUntilVisible();
			createSiteFromSitesMenuDropDown.click();
			createSite = true;
		}
		Assert.assertTrue("The create site option is not available", createSite);
	}

	public void verifyIfTheCreateSitePopUpAppear() {
		boolean checkPopUp = false;
		if (createSitePopUp.isDisplayed()) {
			checkPopUp = true;
		}
		Assert.assertTrue("The pop-up 'Create Site' was not found", checkPopUp);
	}

	public void createSite(String siteName1) {
		element(siteName).waitUntilVisible();
		siteName.click();
		waitABit(1000);
		siteName.sendKeys(siteName1);
		waitABit(1000);
		createSiteOKButton.click();
		waitABit(3000);
	}

	public void selectSiteFromDashboard(String siteName) {
		waitForAllStringsToAppear(
				By.cssSelector("div[class*='sites'] tbody[class*='data']"),
				Delay.REASONABLE, siteName);
		element(mySitesTable).waitUntilVisible();
		List<WebElement> siteList = mySitesTable.findElements(By
				.cssSelector("tr"));
		boolean foundSite = false;
		for (WebElement site : siteList) {
			WebElement siteTitleContainer = site.findElement(By
					.cssSelector("td > div > h3[class*='site-title'] > a"));
			String siteTitle = siteTitleContainer.getText();
			if (siteTitle.contains(siteName)) {
				foundSite = true;
				siteTitleContainer.click();
				break;
			}
		}
		Assert.assertTrue("The site named '" + siteName + "' was not found!",
				foundSite);
	}

	public boolean isTaskOnDashboard(String taskName) {
		element(myTasksTable).waitUntilVisible();
		List<WebElement> taskList = myTasksTable.findElements(By
				.cssSelector("tr"));
		for (WebElement task : taskList) {
			String taskTitle = task.findElement(
					By.cssSelector("td > div[class*='yui-dt-liner'] > h3 > a"))
					.getText();
			if (taskTitle.contains(taskName)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkTaskStatus(String taskname, String statusTask) {
		element(myTasksTable).waitUntilVisible();
		List<WebElement> taskList = myTasksTable.findElements(By
				.cssSelector("tr"));
		for (WebElement task : taskList) {
			WebElement taskTitleContainer = task.findElement(By
					.cssSelector("td > div[class*='yui-dt-liner'] > h3 > a"));
			String taskTitle = taskTitleContainer.getText();

			if (taskTitle.contains(taskname)) {

				WebElement taskStatusContainer = task.findElement(By
						.cssSelector("td > div[class*='yui-dt-liner'] > div"));

				String taskStatus = taskStatusContainer.getText();
				if (taskStatus.contains(statusTask)) {
					return true;
				}
			}

		}
		return false;
	}

	public void checkTaskWarningNotification(String taskname) {
		element(myTasksTable).waitUntilVisible();
		List<WebElement> taskList = myTasksTable.findElements(By
				.cssSelector("tr"));
		for (WebElement task : taskList) {
			WebElement taskTitleContainer = task.findElement(By
					.cssSelector("td > div[class*='yui-dt-liner'] > h3 > a"));
			String taskTitle = taskTitleContainer.getText();

			if (taskTitle.contains(taskname)) {
				System.out.println("111111111111" + taskTitle);
				String taskStatusContainer = task
						.findElement(
								By.cssSelector("td > div[class*='yui-dt-liner'] > h4> span"))
						.getAttribute("class");
				System.out.println("~~~~~~~~~~" + taskStatusContainer);

				Assert.assertTrue("The notification is not present",
						taskStatusContainer.contains("task-delayed"));
			}
		}
	}

	public void selectTaskFromDashboard(String... taskIdentifiers) {
		getElementWithSpecifiedTextFromList(
				By.cssSelector("div[class*='dashlet my-tasks resizable yui-resize'] > div:nth-of-type(5) > div > table > tbody[class*='data'] > tr"),
				true, false, taskIdentifiers).findElement(
				By.cssSelector("td > div[class*='yui-dt-liner'] > h3 > a"))
				.click();
	}

	public void verifyThatTheTaskIsNotInTheDashlet(String... taskIdentifiers) {
		boolean present = checkIfElementWithSpecifiedTextExistsInList(
				By.cssSelector("div[class*='dashlet my-tasks resizable yui-resize'] > div:nth-of-type(5) > div > table > tbody[class*='data'] > tr"),
				true, false, taskIdentifiers);
		Assert.assertFalse(
				String.format(
						"The task containing the '%s' terms should not be present in the dashlet!",
						StringUtils
								.getConcatenatedStringRepresentationOfTheElementsOfAnArray(
										", ", taskIdentifiers)), present);
	}

	public String getUsernameFromTitle() {
		return getDriver().findElement(By.cssSelector("div.title h1 span"))
				.getText();
	}

	public void clickOnDashboardHeaderButton(String... buttonTitles) {
		getElementWithSpecifiedTextFromList(
				By.cssSelector("div.horizontal-widget > div.alf-menu-bar > div.dijitMenuBar > div > span[id*='_text']"),
				true, false, buttonTitles[0]).click();
		if (buttonTitles.length > 1)
			getElementWithSpecifiedTextFromList(
					By.cssSelector("div[id*='_dropdown'] > div > div > div.alf-menu-group-items > table > tbody > tr > td.dijitReset.dijitMenuItemLabel"),
					true, false, buttonTitles[1]).click();
		waitABit(3000);
	}

	public void addGroup(String groupName, String searchedUserName) {
		element(adminTools).waitUntilVisible();
		adminTools.click();
		waitABit(1000);
		element(users).waitUntilVisible();
		users.click();
		waitABit(1000);
		element(userSearch).waitUntilVisible();
		users.click();
		waitABit(1000);
		userSearch.sendKeys(searchedUserName);
		userSearch.sendKeys(Keys.ENTER);
		waitABit(1000);
		boolean searchName = false;
		for (WebElement user : searchUserNames) {
			if (user.getText().contains(searchedUserName)) {
				user.click();
				searchName = true;
				break;
			}
		}
		Assert.assertTrue("The user was not found!", searchName);
		element(editUser).waitUntilVisible();
		editUser.click();
		waitABit(1000);
		element(groups).waitUntilVisible();
		groups.sendKeys(groupName);
		waitABit(1000);
		groups.sendKeys(Keys.ENTER);
		element(addGroupButton).waitUntilVisible();
		addGroupButton.click();
		waitABit(1000);
		element(saveUserChanges).waitUntilVisible();
		saveUserChanges.click();
	}

	public void deleteGroup(String searchedUserName) {
		element(adminTools).waitUntilVisible();
		adminTools.click();
		waitABit(1000);
		element(users).waitUntilVisible();
		users.click();
		element(userSearch).waitUntilVisible();
		users.click();
		waitABit(1000);
		userSearch.sendKeys(searchedUserName);
		userSearch.sendKeys(Keys.ENTER);
		waitABit(1000);
		boolean searchName = false;
		for (WebElement user : searchUserNames) {
			if (user.getText().contains(searchedUserName)) {
				user.click();
				searchName = true;
				break;
			}
		}
		Assert.assertTrue("The user was not found!", searchName);
		element(editUser).waitUntilVisible();
		editUser.click();
		waitABit(1000);
		element(deleteGroupIxxusStaffButton).waitUntilVisible();
		deleteGroupIxxusStaffButton.click();
		waitABit(1000);
		deleteGourpAdministratorButton.click();
		waitABit(1000);
		element(saveUserChanges).waitUntilVisible();
		saveUserChanges.click();
	}

	public void checkThatMenuOptionDoesntExists(String... menuOption) {
		if (menuOption.length > 1) {
			getElementWithSpecifiedTextFromList(
					By.cssSelector("div.horizontal-widget > div.alf-menu-bar > div.dijitMenuBar > div > span[id*='_text']"),
					true, false, menuOption[0]).click();
		}
		Assert.assertTrue(
				"The option is present",
				getElementWithSpecifiedTextFromListIfExists(
						By.cssSelector("div[id*='_dropdown'] > div > div > div.alf-menu-group-items > table > tbody > tr > td.dijitReset.dijitMenuItemLabel"),
						true, false, menuOption[menuOption.length - 1]) == null);

	}

	public void insertSiteNameForSearch(String name) {
		siteSearchInput.sendKeys(name);
		waitABit(1000);
		siteSearchInput.sendKeys(Keys.RETURN);
	}

	public void selectSiteFromResults(String name) {
		getElementWithSpecifiedTextFromList(
				By.cssSelector("div.results.yui-dt > table > tbody > tr > td:nth-child(2) > div.yui-dt-liner > h3.sitename > a"),
				true, false, name).click();
	}

	public void clickOnJoinSiteFromResults(String username, String siteName) {
		getElementWithSpecifiedTextInsideElementFromList(
				By.cssSelector("div.results.yui-dt > table > tbody > tr"),
				By.cssSelector("td:nth-child(2) > div.yui-dt-liner > h3.sitename > a"),
				true, false, siteName)
				.findElement(
						By.cssSelector("td:nth-child(3) > div.yui-dt-liner > span > span > span > button"))
				.click();
		verifyNotificationMessage(String.format(
				"Successfully added user %s to site %s", username, siteName));
	}

	public void clickOnLeaveSiteFromResults(String username, String siteName) {
		getElementWithSpecifiedTextInsideElementFromList(
				By.cssSelector("div.results.yui-dt > table > tbody > tr"),
				By.cssSelector("td:nth-child(2) > div.yui-dt-liner > h3.sitename > a"),
				true, false, siteName)
				.findElement(
						By.cssSelector("td:nth-child(3) > div.yui-dt-liner > span > span > span > button"))
				.click();
		verifyNotificationMessage(String
				.format("Successfully removed user %s from site %S", username,
						siteName));
	}

	public void selectSectionFromConsole(String term) {
		List<WebElement> sectionList = getDriver().findElements(
				By.cssSelector("div[id*='alf-filters'] ul li"));
		boolean foundOption = false;
		for (WebElement option : sectionList) {
			WebElement filterName = option.findElement(By.cssSelector("a"));
			if (filterName.getText().contains(term)) {
				filterName.sendKeys("");
				filterName.click();
				foundOption = true;
				break;
			}
		}
		Assert.assertTrue("The option was not found!", foundOption);
		waitABit(6000);
	}

	public void clickOnAddCategoryIcon() {
		mouseOver(getDriver()
				.findElement(
						By.cssSelector("div[id*='default-category-manager']>div:first-child>div:first-child>div:first-child >table[class*='ygtv-highlight0'] tr>td:nth-child(2)")));
		waitABit(2000);
		getDriver()
				.findElement(
						By.cssSelector("div[id*='default-category-manager']>div:first-child>div:first-child>div:first-child >table[class*='ygtv-highlight0'] tr>td:nth-child(2)>span span"))
				.sendKeys("");
		waitABit(2000);
		getDriver()
				.findElement(
						By.cssSelector("div[id*='default-category-manager']>div:first-child>div:first-child>div:first-child >table[class*='ygtv-highlight0'] tr>td:nth-child(2)>span span"))
				.click();
	}

	public void clickOnSearchIcon() {
		element(searchIcon).waitUntilVisible();
		element(searchIcon).click();
	}

	public void clickOnAdvancedSearchLink() {
		element(advancedSearchLink).waitUntilVisible();
		element(advancedSearchLink).sendKeys("");
		element(advancedSearchLink).click();
	}

	public void deleteCategory(String categoryName) {
		WebElement category = getElementWithSpecifiedTextFromList(
				By.cssSelector("div[class*='align-left'] div[id='ygtvc1'] div[class*='ygtvitem'] span.ygtvlabel"),
				true, false, categoryName);

		WebElement deleteIcon = category.findElement(By
				.cssSelector("span:nth-of-type(3)"));
		mouseOver(category);
		waitABit(2000);
		deleteIcon.sendKeys("");
		waitABit(2000);
		deleteIcon.click();
		waitABit(2000);

	}

	public void checkDocumentStatusInMyDocumentsList(String docName,
			String actionName, String siteName) {
		waitABit(5000);
		WebElement document = getElementWithSpecifiedTextFromList(
				By.cssSelector("div[id*='default-documents'] tbody[class*='data'] h3>a"),
				true, false, docName);
		if (document.getText().contains(docName)) {
			WebElement action = getElementWithSpecifiedTextFromList(
					By.cssSelector("div[id*='default-documents'] tbody[class*='data'] span[class*='item']"),
					true, false, actionName);
			if (action.getText().contains(actionName)) {
				WebElement username = getElementWithSpecifiedTextFromList(
						By.cssSelector("div[id*='default-documents'] tbody[class*='data'] span[class*='item'] a"),
						true, false, siteName);
				Assert.assertTrue("The action was not found!", username
						.getText().contains(siteName));
			}
		}
		Assert.assertTrue("The document was not found!", document.getText()
				.contains(docName));
	}

	public void clickOnActivitiWorkflowConsoleLink() {
		activitiWorkflowConsoleLink.click();
	}

	public void clickOnJoinSiteButton() {
		element(joinSiteButton).waitUntilVisible();
		joinSiteButton.click();
	}

	public void searchTheSiteCreatedByOther(String siteName) {
		element(searchForSitesContainer).waitUntilVisible();
		WebElement inputS = searchForSitesContainer.findElement(By
				.tagName("input"));
		inputS.clear();
		inputS.sendKeys(siteName);
		searchForSitesContainer.findElement(By.tagName("button")).click();
	}

	public void openTheSiteFound(String siteName) {
		element(searchedDefaultSitesContainer).waitUntilVisible();
		List<WebElement> sitesList = searchedDefaultSitesContainer
				.findElements(By.cssSelector("a[href*='page/site']"));
		for (WebElement siteFound : sitesList) {
			if (siteFound.getText().contains(siteName)) {
				siteFound.click();
				break;
			}
		}
	}

	public void clickOnAcceptInvitation() {
		element(editTaskButtonsContainer).waitUntilVisible();
		WebElement inviteLink = editTaskButtonsContainer.findElement(By
				.cssSelector("button[id*='accept-button']"));
		element(inviteLink).waitUntilVisible();
		inviteLink.click();
		waitABit(Constants.WAIT_TIME_SHORT);
	}

	public void acceptRoleInvitation() {
		waitABit(Constants.WAIT_TIME);
		element(myTasksContainer).waitUntilVisible();
		WebElement myInvitation = myTasksContainer.findElement(By
				.cssSelector("td[headers*='title'] div h3 a"));
		element(myInvitation).waitUntilPresent();
		myInvitation.click();
	}

	public void clickOnAdministrationButton() {
		element(administratorContainer).waitUntilVisible();
		element(administratorButton).waitUntilVisible();
		administratorButton.click();
	}

	public void clickOnLogOut() {
		element(administratorButton).waitUntilVisible();
		administratorButton.click();
		waitABit(2000);
		element(administratorButton).waitUntilVisible();
		administratorContainer.findElement(
				By.cssSelector("td[id*='HEADER_USER_MENU_LOGOUT_text']"))
				.click();
	}
}
