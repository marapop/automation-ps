package a.pages.alfresco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;

public class AlfrescoGroupsPage extends AbstractPage {

    public AlfrescoGroupsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[id*='browse']")
    private WebElement browseButton;

    @FindBy(css = "button[id*='creategroup-ok-button']")
    private WebElement createGroupButton;

    @FindBy(css = "span.groups-newgroup-button")
    private WebElement newGroupButton;

    @FindBy(css = "input[id*='create-shortname']")
    private WebElement groupIdentifierInput;

    @FindBy(css = "input[id*='create-displayname']")
    private WebElement groupNameInput;

    public void clickOnBrowseButton() {
        browseButton.click();
    }

    public void clickOnNewGroupButton() {
        newGroupButton.click();
    }

    public void clickOnCreateGroupButton() {
        createGroupButton.click();
    }

    public void insertGroupIdentifier(String groupIdentifier) {
        groupIdentifierInput.sendKeys(groupIdentifier);
    }

    public void insertGroupName(String groupName) {
        groupNameInput.sendKeys(groupName);
    }
}
