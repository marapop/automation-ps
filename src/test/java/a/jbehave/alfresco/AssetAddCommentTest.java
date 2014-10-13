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

import a.steps.alfresco.AlfrescoCreateContentSteps;
import a.steps.alfresco.AlfrescoCreateUserSteps;
import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoListActionsSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.steps.alfresco.AlfrescoMembersSteps;
import a.steps.alfresco.AlfrescoSiteHeaderSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;
import a.tools.alfresco.constants.DataDrivenFiles;

/**
 * USS 170.6
 *  Scenario 1: Commenting on an Asset
 *  Given I have permission to comment on an Asset
 *  When I submit a comment
 *  Then that comment is saved against the Asset
 *  And other users can see my comment when they view the Asset 
 *  
 * - log in as admin
 *  - create the first user
 * - add member -> the user (collaborator)
 * - log in as user
 * - accept role invitation
 * - log in as admin
 * - create folder and inside a placeholder asset
 * - verify assets properties
 * - add a comment to the asset
 * - log in as user
 * -  navigate to the asset properties to verify admins comment
 *  
 *
 */
@Story(Application.Assets.Comments.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value= Constants.TESTDATA_FILES_PATH + DataDrivenFiles.ASSET_ADD_COMMENT, separator = Constants.CSV_SEPARATOR)
public class AssetAddCommentTest {
	
	//test data properties
	private String username;
	private String password;
	private String siteName;
//	private String siteN = RandomStringUtils.randomAlphabetic(6);
//	private static String siteD = String.valueOf(System.nanoTime());
	// data folder 
	private String folderName;
	// data plain text
	private String contentName;
	
	private String userRole;

	
	// new user
	private String firstName;
	private String lastName;
	private String userEmail;
	private String clientName;
	private String clientPass;
	
	
	
	@Qualifier
	public String getQualifier(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setFolderName(String folderName){
		this.folderName = folderName + RandomStringUtils.randomAlphabetic(6);
	}
	
	public void setContentName(String contentName){
		this.contentName = contentName + RandomStringUtils.randomAlphabetic(6);
	}
	
	
	public void setFirstName(String firstName){
		this.firstName = firstName+ RandomStringUtils.randomAlphabetic(3);
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public void setUserEmail(String userEmail){
		this.userEmail = RandomStringUtils.randomAlphabetic(3)+userEmail;
	}
	
	public void setClientName(String clientName){
		this.clientName = clientName+ RandomStringUtils.randomAlphabetic(3);
	}
	
	public void setClientPass(String clientPass){
		this.clientPass = clientPass;
	}
	
	
	//Test setup
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.ALFRESCO_URL)
	public Pages pages;

	@Steps
	private AlfrescoLoginSteps loginStep;
	@Steps
	private AlfrescoDashboardSteps dashboardSteps;
	@Steps
	private AlfrescoSiteHeaderSteps siteHeaderSteps;
	@Steps
	private AlfrescoListActionsSteps listActionsSteps;
	@Steps
	private AlfrescoCreateContentSteps createContentSteps;
	@Steps
    private AlfrescoMembersSteps membersSteps;
	@Steps
	private AlfrescoCreateUserSteps createUserSteps;


	
	@Before
	public void setupData(){
		
		try {

			InputStream in = getClass().getResourceAsStream(Constants.GLOBAL_CONFIG_PATH);
			Properties properties = new Properties();
			properties.load(in);
			in.close();
			
			siteName = properties.getProperty("siteName");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createAssetAndAddComment(){
		
		loginStep.loginToSite(username, password);
		
		// create the first user
		//appMenuSteps.createNewUser();
		//appMenuSteps.clickOnCreateNewUserButton();

		createUserSteps.fillNewUserDetails(firstName, lastName, userEmail, clientName, clientPass); 
		
		dashboardSteps.openSiteModal(siteName);
		
		 //add member -> the second user
		siteHeaderSteps.openSiteMembers();
		membersSteps.invitePeopleToJoin(firstName);
		membersSteps.selectRoleAndInviteUser(userRole);
		dashboardSteps.logout();
		
		// log in as user
		loginStep.loginToSite(clientName, clientPass);

		// accept role invitation
		dashboardSteps.acceptRoleInvitation();
		dashboardSteps.clickOnAcceptInvitation();
		
		// log in as admin
		dashboardSteps.logout();
		loginStep.loginToSite(username, password);
		
		dashboardSteps.openSiteModal(siteName);
		
		siteHeaderSteps.openDocumentLibrary();
		// create folder
		
		listActionsSteps.openFile(folderName);
		
		// create placeholder asset
		
		
		
		
    	dashboardSteps.logout();
    	
    	// log in as user
    	loginStep.loginToSite(clientName, clientPass);
    	dashboardSteps.openSiteModal(siteName);
    	
    	// navigate to the asset properties to verify admins comment
    	siteHeaderSteps.openDocumentLibrary();
    	listActionsSteps.markFile(folderName);
    	listActionsSteps.openFile(folderName);
    	listActionsSteps.markFile(contentName);
    	listActionsSteps.openFile(contentName);
    	
   
	
		
  	  
		
	}

}
