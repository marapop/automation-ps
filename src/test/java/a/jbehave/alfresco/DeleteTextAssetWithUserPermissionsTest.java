package a.jbehave.alfresco;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import a.steps.alfresco.AlfrescoActionsSteps;
import a.steps.alfresco.AlfrescoCreateContentSteps;
import a.steps.alfresco.AlfrescoCreateUserSteps;
import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoListActionsSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.steps.alfresco.AlfrescoMembersSteps;
import a.steps.alfresco.AlfrescoSiteHeaderSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;

@Story(Application.Permissions.Asset.class)
@RunWith(ThucydidesParameterizedRunner.class)
//@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH
//		+ DataDrivenFiles.DELETE_TEXT_ASSET_USER_PERMISSIONS, separator = Constants.CSV_SEPARATOR)
public class DeleteTextAssetWithUserPermissionsTest {

	// test data properties
	private String username;
	private String password;

	// create site data
	private String siteN = RandomStringUtils.randomAlphabetic(6);
//	private static String siteD = String.valueOf(System.nanoTime());
	// create user data
	private String clientPass;
	private String clientName;
	private String userEmail;
	private String lastName;
	private String firstName;
	private String userRole;

	@Qualifier
	public String getQualifier() {
		return userRole;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName + RandomStringUtils.randomAlphabetic(6);
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = RandomStringUtils.randomAlphabetic(6) + userEmail;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName + RandomStringUtils.randomAlphabetic(6);
	}

	public void setClientPass(String clientPass) {
		this.clientPass = clientPass;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	// test setup
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.ALFRESCO_URL)
	public Pages pages;

	@Steps
	private AlfrescoLoginSteps loginStep;
	@Steps
	private AlfrescoDashboardSteps dashboardSteps;
	@Steps
	private AlfrescoCreateUserSteps createUserSteps;
	@Steps
	private AlfrescoMembersSteps membersSteps;
	@Steps
	private AlfrescoSiteHeaderSteps siteHeaderSteps;
	@Steps
	private AlfrescoCreateContentSteps createContentSteps;
	@Steps
	private AlfrescoListActionsSteps listActionsSteps;
	@Steps
	private AlfrescoActionsSteps actionsSteps;
	
	@Before
	public void setupData(){
		
		try {

			InputStream in = getClass().getResourceAsStream(Constants.GLOBAL_CONFIG_PATH);
			Properties properties = new Properties();
			properties.load(in);
			in.close();
			
			siteN = properties.getProperty("siteName");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void deleteTextAssetWithUserPermissionsTest() {

		loginStep.loginToSite(username, password);

//		// create user
//		appMenuSteps.createNewUser();
//		appMenuSteps.clickOnCreateNewUserButton();

		createUserSteps.fillNewUserDetails(firstName, lastName, userEmail,
				clientName, clientPass);

		dashboardSteps.openSiteModal(siteN);

		// add member -> created user

		siteHeaderSteps.openDocumentLibrary();
		siteHeaderSteps.openSiteMembers();
		membersSteps.invitePeopleToJoin(firstName);
		membersSteps.selectRoleAndInviteUser(userRole);
		dashboardSteps.logout();

		// login as client -> accept the invitation

		loginStep.loginToSite(clientName, clientPass);
		dashboardSteps.acceptRoleInvitation();
		dashboardSteps.clickOnAcceptInvitation();

		dashboardSteps.openSiteModal(siteN);

		
	}
}
