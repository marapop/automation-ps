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
public class AlfrescoManagePermissionsPage extends AbstractPage {

	public AlfrescoManagePermissionsPage(WebDriver driver) {
		super(driver);
	}
    
	@FindBy(css = "button[id*='addUserGroupButton-button']")
	private WebElement resultsContainer;
	
	@FindBy(css = "button[id*='addUserGroupButton-button']")
	private WebElement addUserButton;
	
	@FindBy(css = "input[id*='authorityFinder-search-text']")
	private WebElement addUserSearchInput;

	@FindBy(css = "button[id*='authorityFinder-authority-search-button-button']")
	private WebElement addUserSearchButton;

	@FindBy(css = "table[id='yuievtautoid-1']")
	private WebElement searchResultListContainer;
	
	@FindBy(css = "[class='results yui-dt']")
	private WebElement resultsListContainer;
	
	@FindBy(css = "table[id='yuievtautoid-2']")
	private WebElement searchResultList2Container;
	
	@FindBy(css = "span[id='alf-id2'] button")
	private WebElement addButton;

	@FindBy(css = "div[id*='default-directPermissions']")
	private WebElement userListContainer;
	
	@FindBy(css = "div[class*='yui-menu-button-menu visible']")
	private WebElement roleDropdownContainer;

	@FindBy(css = "button[id*='okButton-button']")
	private WebElement saveButton;
	
	@FindBy(css = "div[id*='default-directPermissions']")
	private WebElement permissionsContainer;
	
	@FindBy(css = "button[id*='default-okButton-button']")
	private WebElement permissionsOkButton;
	
	@FindBy(css = "button[id*='default-inheritedButton-button']")
	private WebElement inheritPermissionsButton;

	@FindBy(css = "div.shadow")
	private WebElement inheritPermissionsButtonPopUp;
	
	@FindBy(css = "div[id*='inheritedPermissions']")
	private WebElement inheritPermissionsContainer;

	
	public void clickOnInheritPermissionsButton(){
		element(inheritPermissionsButton).waitUntilVisible();
		inheritPermissionsButton.click();
	}
	
	public void clickYesOnInheritPermissionsPopup(){
		element(inheritPermissionsButtonPopUp).waitUntilVisible();
		inheritPermissionsButtonPopUp.findElement(By.cssSelector("span.yui-push-button-hover span button")).click();
	}	
	
	public void verifyInheritedPermissionsUserAndRole(String user, String role){
		boolean isPresent = false;
		element(inheritPermissionsContainer).waitUntilVisible();
		List<WebElement> listItems = inheritPermissionsContainer.findElements(By.cssSelector("tbody.yui-dt-data tr"));
		
		theFor:
		for(WebElement userNow:listItems){
			String nameNow = userNow.findElement(By.className("yui-dt-col-displayName")).getText();
			String roleNow = userNow.findElement(By.className("yui-dt-col-role")).getText();
			if(nameNow.contains(user) &&  roleNow.contains(role)){
				isPresent = true;
				break theFor;
			}
		}
		
		Assert.assertTrue("User has not been found in the inherited list.", isPresent);
	}
	
	
	/**
	 * Call this method to add a user with permissions
	 * 
	 * @param userName
	 */
	public void searchForUser(String userName) {
		element(addUserButton).waitUntilVisible();
		addUserButton.click();

		element(addUserSearchInput).waitUntilVisible();
		addUserSearchInput.sendKeys(userName);

		element(addUserSearchButton).waitUntilVisible();
		addUserSearchButton.click();

		waitABit(Constants.WAIT_TIME_SHORT);
		addUserFromSearchResults2(userName);
	}

	/**
	 * This method will search in the Add user serach results list for the
	 * userName and will click on ADD button. Search for user needs to be
	 * triggered first for this method to work.
	 * @param userName
	 */
	public void addUserFromSearchResults(String userName) {
		// may need a wait or method for waiting for list to load
		element(searchResultListContainer).waitUntilVisible();

		List<WebElement> resultsList = searchResultListContainer
				.findElements(By.cssSelector("tbody.yui-dt-data tr"));

		for (WebElement resultNow : resultsList) {
			System.out.println("Found : " + resultNow.getText());
			if (resultNow.getText()
//					if (resultNow.findElement(By.className("theme-color-1")).getText()
					.contains(userName)) {
				System.out.println("Found it");
				resultNow.click();
				waitABit(Constants.WAIT_TIME_SHORT);
				
				elementjQueryMouseOver("button#" + resultNow.findElement(By.tagName("button")).getAttribute("id"));
				elementjQueryClick("button#" + resultNow.findElement(By.tagName("button")).getAttribute("id"));
				
				WebElement addButton = resultNow.findElement(By.tagName("button"));
				addButton.click();
				waitABit(90000);
				break;
			}
		}

	}
	
	/**
	 * This method will search in the Add user serach results list for the
	 * userName and will click on ADD button. Search for user needs to be
	 * triggered first for this method to work.
	 * @param userName
	 */
	public void addUserFromSearchResults2(String userName) {
		// may need a wait or method for waiting for list to load
		element(resultsListContainer).waitUntilVisible();
		
		List<WebElement> resultsList = resultsListContainer
				.findElements(By
						.cssSelector("tr[class*='yui-dt-even'] td[headers*='fullName'] div h3 a"));

		System.out.println("TTT : ");
		for (WebElement resultNow : resultsList) {
			if (resultNow.getText().contains(userName)) {
				elementFocus("" + resultNow.getCssValue("class")
						+ "span#alf-id2 button");
				waitABit(Constants.WAIT_TIME_SHORT);
				elementjQueryClick("" + resultNow.getCssValue("class")
						+ "span#alf-id2 button");
				waitABit(Constants.WAIT_TIME_SHORT);
				break;
			}
		}
		

	}

	/**
	 * Will take the Local Permissions list - will find the user by name - and
	 * for that user will find the user role in the dropdown and select it.
	 * 
	 * @param userName
	 * @param userRole
	 */
	public void setUserRole(String userName, String userRole) {
		// may need a wait or method for waiting for list to load
		element(userListContainer).waitUntilVisible();

		List<WebElement> resultsList = userListContainer.findElements(By
				.cssSelector("tbody.yui-dt-data tr"));
		System.out.println("found List");
		theBigFor: for (WebElement resultNow : resultsList) {
			if (resultNow
					.findElement(By.cssSelector("td[headers*='displayName']"))
					.getText().contains(userName)) {
				System.out.println("found element");
				// click on the role dropdown
				resultNow.findElement(By.tagName("button")).click();
				// build the option list - for selecting the role
				List<WebElement> roleOptionsList = resultNow.findElements(By
						.cssSelector("ul.first-of-type li a"));

				for (WebElement optionNow : roleOptionsList) {
					if (optionNow.getText().contains(userRole)) {
						System.out.println("found role");
						optionNow.sendKeys("");
						optionNow.click();

						break theBigFor;
					}
				}
			}
		}
	}
	
	public void selectRoleForUser(String userRole) {
		element(roleDropdownContainer).waitUntilVisible();
		List<WebElement> list = roleDropdownContainer.findElements(By
				.cssSelector("ul li a"));
		for (WebElement elemFound : list) {
			if (elemFound.getText().contains(userRole)) {
				// element(elemFound).waitUntilPresent();
				elemFound.click();
				break;
			}
		}
	}

	/**
	 * Click on save button for User Roles
	 */
	public void clickOnSave() {
		element(saveButton).waitUntilVisible();
		saveButton.click();
	}
	
	public void clickOnRoleDropdown(String userName) {
		element(permissionsContainer).waitUntilVisible();
		List<WebElement> list = permissionsContainer.findElements(By
				.cssSelector("tbody.yui-dt-data tr"));
		for (WebElement userFound : list) {
			if (userFound.getText().contains(userName)) {
				userFound
						.findElement(
								By.cssSelector("td:nth-child(3) span[class*='menu-button']"))
						.click();
				break;
			}
		}
	}



	public void clickOnSaveButton() {
		element(permissionsOkButton).waitUntilVisible();
		permissionsOkButton.click();
	}

}
