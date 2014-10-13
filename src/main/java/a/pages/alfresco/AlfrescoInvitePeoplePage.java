package a.pages.alfresco;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;

public class AlfrescoInvitePeoplePage extends AbstractPage {

	public AlfrescoInvitePeoplePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div[class='inviteusersbyemail']")
	private WebElement invitePeople;

	public void checkIfAddExternalUsersScetionExsits() {
		Assert.assertTrue("The expected text was not found",
				invitePeople.isDisplayed());
	}

}
