package a.pages.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.StringUtils;

public class AlfrescoUsersPage extends AbstractPage {

    public AlfrescoUsersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div[id*='default-search'] input")
    private WebElement searchField;

    @FindBy(css = "div[id*='default-search'] button[id$='search-button-button']")
    private WebElement searchButton;

    @FindBy(css = "div[id*='default-datatable'] > table > tbody:nth-of-type(2)")
    private WebElement usersTable;

    @FindBy(css = "span[class*='newuser-button'] button")
    private WebElement newUserButton;

    @FindBy(css = "div.deleteuser-button button")
    private WebElement deleteUserButton;

    @FindBy(css = "div.edituser-button button")
    private WebElement editUserButton;

    @FindBy(css = "input[id$='create-firstname']")
    private WebElement firstNameField;

    @FindBy(css = "input[id$='create-lastname']")
    private WebElement lastNameInput;

    @FindBy(css = "input[id$='create-email']")
    private WebElement emailField;

    @FindBy(css = "input[id$='create-username']")
    private WebElement userNameField;

    @FindBy(css = "input[id$='create-password']")
    private WebElement passwordField;

    @FindBy(css = "input[id$='verifypassword']")
    private WebElement verifyPasswordField;

    @FindBy(css = "div[class*='createuser-ok-button left'] button")
    private WebElement createUserButton;

    @FindBy(css = "div.search-text input")
    private WebElement inputSearchForPeople;

    @FindBy(css = "div.search-text input[id*='groupfinder']")
    private WebElement searchGroupInput;

    @FindBy(css = "button[id*='finder']")
    private WebElement searchPeopleButton;

    @FindBy(css = "img.alf-user-icon")
    private WebElement invitePeopleButton;

    @FindBy(css = "div[id*='default-inviteelist'] tbody[class*='data'] tr")
    private List<WebElement> invitedUsersList;

    @FindBy(css = "div[class*='sinvite'] button")
    private WebElement inviteButton;

    public void enterNameForSearchPeople(String searchTerm) {
        inputSearchForPeople.clear();
        element(inputSearchForPeople).sendKeys(searchTerm);
    }

    public void insertSearchForGroupKeyword(String searchTerm) {
        searchGroupInput.clear();
        searchGroupInput.sendKeys(searchTerm);
    }

    public void clickOnSearchPeopleButton() {
        element(searchPeopleButton).click();
    }

    public void clickOnInvitePeopleButton() {
        element(invitePeopleButton).waitUntilVisible();
        element(invitePeopleButton).click();
    }

    public void clickOnInviteButton() {
        element(inviteButton).waitUntilVisible();
        element(inviteButton).click();
    }

    public boolean checkIfUserExistsInSearchResultsForInvite(
            String... identifiers) {
        return checkIfElementWithSpecifiedTextExistsInList(
                By.cssSelector("div[id*='results'] tbody[class*='data'] > tr h3.itemname"),
                true, false, identifiers);
    }

    public void selectUserFromSearchResultsForInvite(String... identifiers) {
        waitForTextToDisappear(
                getDriver()
                        .findElement(
                                By.cssSelector("div[id*='default-results'] tbody.yui-dt-message")),
                "Enter a search term to find users");
        getElementWithSpecifiedTextInsideElementFromList(
                By.cssSelector("div[class*='results'] tbody[class*='data'] tr"),
                By.cssSelector("h3.itemname"), true, false, identifiers)
                .findElement(By.cssSelector("div.yui-dt-liner button")).click();

    }

    public void selectGroupFromSearchResultsForInvite(String... identifiers) {
        getElementWithSpecifiedTextInsideElementFromList(
                By.cssSelector("div[class*='results'] tbody[class*='data'] tr"),
                By.cssSelector("h3.itemname"), true, false, identifiers)
                .findElement(By.cssSelector("div.yui-dt-liner button")).click();

    }

    public void selectRoleForUser(String userRole, String... identifiers) {
        WebElement userRow = getElementWithSpecifiedTextInsideElementFromList(
                By.cssSelector("div[id*='default-inviteelist'] tbody[class*='data'] tr"),
                By.cssSelector("h3.itemname"), true, false, identifiers);
        userRow.findElement(By.cssSelector("span.first-child > button"))
                .click();
        getElementWithSpecifiedTextFromListInsideParentElement(userRow,
                By.cssSelector("ul.first-of-type > li"), true, false, userRole)
                .click();
    }

    public void verifyThatTheUserHasBeenAssignedToGroups(String... groups) {
        StringUtils
                .verifyThatAllStringsExistInTheList(
                        getVisibleTextOfWebElements(getDriver()
                                .findElements(
                                        By.cssSelector("div.groupselection-row > span.group-item"))),
                        groups);
    }

    public void inputSearchField(String text) {
        element(searchField).waitUntilVisible();
        element(searchField).type(text);
    }

    public void clickOnSearchButton() {
        element(searchButton).waitUntilVisible();
        element(searchButton).click();
    }

    public void clickOnNewUserButton() {
        element(newUserButton).waitUntilVisible();
        element(newUserButton).click();
    }

    public void clickOnDeleteUserButton() {
        element(deleteUserButton).waitUntilVisible();
        element(deleteUserButton).click();
    }

    public void clickOnEditUserButton() {
        element(editUserButton).waitUntilVisible();
        element(editUserButton).click();
    }

    public void inputFirstNameField(String firstName) {
        element(firstNameField).waitUntilVisible();
        element(firstNameField).type(firstName);
    }

    public void inputLastNameField(String lastName) {
        element(lastNameInput).waitUntilVisible();
        element(lastNameInput).type(lastName);
    }

    public void inputEmailField(String email) {
        element(emailField).waitUntilVisible();
        element(emailField).type(email);
    }

    public void inputUserNameField(String userName) {
        element(userNameField).waitUntilVisible();
        element(userNameField).type(userName);
    }

    public void inputPasswordField(String password) {
        element(passwordField).waitUntilVisible();
        element(passwordField).type(password);
    }

    public void inputVerifyPasswordField(String verifyPassword) {
        element(verifyPasswordField).waitUntilVisible();
        element(verifyPasswordField).type(verifyPassword);
    }

    public void clickOnCreateUserButton() {
        element(createUserButton).waitUntilVisible();
        element(createUserButton).click();
        verifyNotificationMessage("Successfully created new user.");
    }

    public boolean checkIfUserExistsInSearchResults(String... identifiers) {
        return checkIfElementWithSpecifiedTextExistsInList(
                By.cssSelector("div[id*='default-datatable'] > table > tbody:nth-of-type(2) > tr td > div > a"),
                true, false, identifiers);
    }

    public void selectUserFromSearchResults(String... identifiers) {
        getElementWithSpecifiedTextInsideElementFromList(
                By.cssSelector("div[id*='default-datatable'] > table > tbody:nth-of-type(2) > tr"),
                By.cssSelector("td:nth-child(3) > div"), true, false,
                identifiers).findElement(By.cssSelector("td > div > a"))
                .click();
    }
}
