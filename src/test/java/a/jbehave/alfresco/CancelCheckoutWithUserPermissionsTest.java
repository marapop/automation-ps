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
import a.tools.alfresco.SeleniumTestUtils;

/**
 * 
 * +----------------------------------------+ 
 *  | Test steps and assertions: | 
 * +----------------------------------------+ 
 * - log in into site as admin 
 * - create site
 * - create two users
 * - each of them is invited to user role 
 * - log out the admin
 * - login as user1
 * - upload a file "awine_glasses.jpg"
 * - open the file and make it edit offline
 * - log out as users1
 * - log in as user2
 * - search and open the site 
 * - open the uploaded file created by user1
 *  - if user role is "oup manager", "manager" click on edit offline
 * - if user is "collaborator" check if cancel edit offline button is disabled
 * - if user role is "consumer", "contributor" verify that on edit offline is not present
 * 
 * @author mariusph
 *
 */

@Story(Application.Permissions.CancelEditing.class)
@RunWith(ThucydidesParameterizedRunner.class)
//@UseTestDataFrom(value=Constants.TESTDATA_FILES_PATH + DataDrivenFiles.CANCEL_CHECKOUT_WITH_USER_PERMISSIONS, separator=Constants.CSV_SEPARATOR)
public class CancelCheckoutWithUserPermissionsTest {
	
	//test data properties

	private String siteN = RandomStringUtils.randomAlphabetic(6);
//	private static String siteD = String.valueOf(System.nanoTime());
	private String userRole;
	
	// data folder 
	private String folderName; 
	//private String folderTitle;
	//private String folderDescription=String.valueOf(System.nanoTime());

	private String username = "admin";
	private String password = "admin";
	private String firstName = "John";
	private String lastName= "Doe";
	private String userEmail = "jd@example.com";
	private String clientName = "john";
	private String clientPass = "johndoe";
	private String firstName1 = "Jane";
	private String userEmail1 = "jane@example.com";
	private String userName1 = "Doe";
	private String uploadFile = "awine_glasses.jpg";
	private String fileName = "awine_glasses.jpg";

	
	    
	
	@Qualifier
    public String getQualifier() {
        return userRole;
    }
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
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
	
	public void setUserRole(String userRole){
		this.userRole = userRole;
	}
	
	public void setFirstName1(String firstName1){
		this.firstName1 = firstName1+ RandomStringUtils.randomAlphabetic(3);
	}
	
	public void setUserEmail1(String userEmail1){
		this.userEmail1 = RandomStringUtils.randomAlphabetic(6)+userEmail1;
	}
	
	public void setUserName1(String userName1){
		this.userName1 = userName1+ RandomStringUtils.randomAlphabetic(3);
	}
	
	public void setUploadFile(String uploadFile){	
	    this.uploadFile = SeleniumTestUtils.getAbsoluteFilePath(uploadFile);
	}
	
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	
	public void setFolderName(String folderName){
		this.folderName = folderName + RandomStringUtils.randomAlphabetic(6);
	}
	
	
	
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
    public void cancelCheckOutWithUsersPermissions(){
    	
		loginStep.loginToSite(username, password);
		
		//create user 1
//		appMenuSteps.createNewUser();
//		appMenuSteps.clickOnCreateNewUserButton();

		createUserSteps.fillNewUserDetails(firstName, lastName, userEmail, clientName, clientPass);
		
		//create user 2
//		appMenuSteps.createNewUser();
//		appMenuSteps.clickOnCreateNewUserButton();

		createUserSteps.fillNewUserDetails(firstName1, lastName, userEmail1,
				userName1, clientPass);
		
		//create site
		dashboardSteps.openSiteModal(siteN);

        //add member -> created user1
		siteHeaderSteps.openSiteMembers();
		membersSteps.invitePeopleToJoin(firstName);
		membersSteps.selectRoleAndInviteUser(userRole);
		
		//add member -> created user2
		siteHeaderSteps.openSiteMembers();
		membersSteps.invitePeopleToJoin(firstName1);
		membersSteps.selectRoleAndInviteUser(userRole);

		dashboardSteps.logout();
		
		//login as user2 -> accept the invitation
		loginStep.loginToSite(userName1, clientPass);
		
		dashboardSteps.acceptRoleInvitation();
		dashboardSteps.clickOnAcceptInvitation();
		dashboardSteps.logout();
        
		
		//login as user1 -> upload a file
		loginStep.loginToSite(clientName, clientPass);
		
		dashboardSteps.acceptRoleInvitation();
		dashboardSteps.clickOnAcceptInvitation();
//		dashboardSteps.logOut();
		
		dashboardSteps.openSiteModal(siteN);
		siteHeaderSteps.openDocumentLibrary();
		
		if (userRole.contains(Constants.USER_ROLE_MANAGER)){
//				|| userRole.contains(Constants.USER_ROLE_COLLABORATOR)
//				|| userRole.contains(Constants.USER_ROLE_CONTRIBUTOR)) {
			
			
			createContentSteps.uploadDocument(uploadFile);
			listActionsSteps.openFile(fileName);

			actionsSteps.clickOnEditOffline();

			dashboardSteps.logout();

			// login as user2 -> and cancel edit offline
			loginStep.loginToSite(userName1, clientPass);
			dashboardSteps.openSiteModal(siteN);
			siteHeaderSteps.openDocumentLibrary();
			listActionsSteps.markFile(folderName);
			listActionsSteps.openFile(folderName);
			listActionsSteps.openFile(fileName);
			
			if (userRole.contains(Constants.USER_ROLE_CONTRIBUTOR)
				|| userRole.contains(Constants.USER_ROLE_CONTRIBUTOR))
			actionsSteps.verifyCancelEditingButtonNotPresent();
			

			actionsSteps.clickOnCancelEditing();
			
//		} else if (userRole.contains(Constants.USER_ROLE_CONTRIBUTOR)){
////			actionsSteps.verifyCancelEditingButtonNotPresent();
//			createContentSteps.verifyIfCreateContentIsDisabled();
		}  else if (userRole.contains(Constants.USER_ROLE_CONSUMER)) {
			createContentSteps.verifyIfCreateContentIsDisabled();
		}
    	
    }
}
