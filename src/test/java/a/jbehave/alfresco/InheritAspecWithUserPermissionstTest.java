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
import net.thucydides.junit.annotations.UseTestDataFrom;
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
import a.steps.alfresco.AlfrescoDocumentPathSteps;
import a.steps.alfresco.AlfrescoListActionsSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.steps.alfresco.AlfrescoMembersSteps;
import a.steps.alfresco.AlfrescoPathRibbonSteps;
import a.steps.alfresco.AlfrescoSiteHeaderSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;
import a.tools.alfresco.constants.DataDrivenFiles;

/**
 * 
 * +----------------------------------------+ | Test steps and assertions: |
 * +----------------------------------------+
 * 
 * - log in into site as admin - create site - click on create new folder - fill
 * in all the fields - open the folder for editing - click on manage aspects and
 * choose inheritable and language properties - click on edit properties for the
 * folder - in the edit mode check the inheritable aspect and fill the language
 * aspect field - navigate backwards to the folder and create a plain file -
 * verify the new file has the parent folder title, folder description and the
 * inherited language aspect
 * 
 * @author vladvoicu
 * 
 */

@Story(Application.Permissions.Asset.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH + DataDrivenFiles.INHERITS_ASPECT_USER_PERMISSIONS, separator = Constants.CSV_SEPARATOR)
public class InheritAspecWithUserPermissionstTest {

	// test data properties
	private String username;
	private String password;
	private String folderName;
//	private String folderTitle;
//	private String folderDescription;
	private String contentName;
//	private String contentTitle;
//	private String contentDescription;
//	private String contentBody;
//	private String langTopic;
	private String siteN = RandomStringUtils.randomAlphabetic(6);
	// private static String siteD = String.valueOf(System.nanoTime());
	// create user
	private String firstName;
	private String lastName;
	private String userEmail;
	private String clientName;
	private String clientPass;
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

	public void setContentName(String contentName) {
		this.contentName = contentName + RandomStringUtils.randomAlphabetic(4);
	}

//	public void setContentTitle(String contentTitle) {
//		this.contentTitle = contentTitle
//				+ RandomStringUtils.randomAlphabetic(4);
//	}
//
//	public void setContentDescription(String contentDescription) {
//		this.contentDescription = contentDescription;
//	}
//
//	public void setContentBody(String contentBody) {
//		this.contentBody = contentBody;
//	}

	public void setFolderName(String folderName) {
		this.folderName = folderName + RandomStringUtils.randomAlphabetic(5);
	}

//	public void setFolderTitle(String folderTitle) {
//		this.folderTitle = folderTitle;
//	}
//
//	public void setFolderDescription(String folderDescription) {
//		this.folderDescription = folderDescription;
//	}
//
//	public void setLangTopic(String langTopic) {
//		this.langTopic = langTopic;
//	}

	public void setFirstName(String firstName) {
		this.firstName = firstName + RandomStringUtils.randomAlphabetic(5);
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = RandomStringUtils.randomAlphabetic(3) + userEmail;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName + RandomStringUtils.randomAlphabetic(3);
	}

	public void setClientPass(String clientPass) {
		this.clientPass = clientPass;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	// Test setup

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
	private AlfrescoActionsSteps actionsSteps;
	@Steps
	private AlfrescoSiteHeaderSteps siteHeaderSteps;
	@Steps
	private AlfrescoCreateContentSteps createContentSteps;
	@Steps
	private AlfrescoListActionsSteps listActionsSteps;
	@Steps
	private AlfrescoPathRibbonSteps pathRibbonSteps;
	@Steps
	private AlfrescoDocumentPathSteps documentPathSteps;

	@Before
	public void setupData() {

		try {

			InputStream in = getClass().getResourceAsStream(
					Constants.GLOBAL_CONFIG_PATH);
			Properties properties = new Properties();
			properties.load(in);
			in.close();

			siteN = properties.getProperty("siteName");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void inheritAspectWithUserPermissions() {

		loginStep.loginToSite(username, password);

//		appMenuSteps.createNewUser();
//		appMenuSteps.clickOnCreateNewUserButton();

		createUserSteps.fillNewUserDetails(firstName, lastName, userEmail,
				clientName, clientPass);

		dashboardSteps.openSiteModal(siteN);

		// add member -> created user1
		siteHeaderSteps.openSiteMembers();
		membersSteps.invitePeopleToJoin(firstName);
		membersSteps.selectRoleAndInviteUser(userRole);

		dashboardSteps.logout();

		// login as user1 -> accept the invitation
		loginStep.loginToSite(clientName, clientPass);

		dashboardSteps.acceptRoleInvitation();
		dashboardSteps.clickOnAcceptInvitation();

		dashboardSteps.openSiteModal(siteN);
		siteHeaderSteps.openDocumentLibrary();

		if (userRole.contains(Constants.USER_ROLE_MANAGER)
				|| userRole.contains(Constants.USER_ROLE_CONTRIBUTOR)
				|| userRole.contains(Constants.USER_ROLE_COLLABORATOR)) {

			createContentSteps.createNewFolder();
	    //	placeholderAssetSteps.createNewFolderContent(folderName, folderTitle, folderDescription);
	    	listActionsSteps.markFile(folderName);
	    	listActionsSteps.openFile(folderName);

	    	createContentSteps.clickOnPlaceholderAsset();
	    	
	    //	placeholderAssetSteps.createContent(contentName, contentTitle, contentDescription, contentBody);
	    	
	    	documentPathSteps.backToCreateNewDoc(folderName);
	    	pathRibbonSteps.openFolderForEditPropertiesView();

	    	
//	    	actionsSteps.clickOnEditPropertiesNoExpand();
	    	actionsSteps.expandFolderActions();
	    	actionsSteps.clickOnEditProperties();
	    	
	
	    	
	    	documentPathSteps.backToCreateNewDoc(folderName);
	    	listActionsSteps.openFile(contentName);
	   
			
		} else {
			if (userRole.contains(Constants.USER_ROLE_CONSUMER)) {
				createContentSteps.verifyIfCreateContentIsDisabled();
			}
		}
	}
}
