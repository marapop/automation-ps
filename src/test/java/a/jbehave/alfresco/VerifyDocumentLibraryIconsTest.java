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
import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoListActionsSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.steps.alfresco.AlfrescoPathRibbonSteps;
import a.steps.alfresco.AlfrescoSiteHeaderSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;
import a.tools.alfresco.constants.DataDrivenFiles;
import a.tools.alfresco.constants.IconsSrcs;

@Story(Application.GeneralFeatures.Project.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH + DataDrivenFiles.VERIFY_ICONS, separator = Constants.CSV_SEPARATOR)
public class VerifyDocumentLibraryIconsTest {

	//test data
	private String username;
	private String password;
	private String projectName;
//	private String isbn;
//	private String otherId;
//	private String otherIdType;
	String wTitle;
//	private String title;
//	private String description;
//	private String author;
//	private String dropOption;
//	private String targetDate;
//	private String publicationDate;
//	private String campYear;
//	private String publGroup;
//	private String prodType;
//	private String targetTerr;
//	private String rightsRequir;
//	private String linkedLoc;
	private String siteN = RandomStringUtils.randomAlphabetic(6);
//	private String siteD = String.valueOf(System.nanoTime());
	
//	private String rootFolder;

	// asset icon type
	private String assetIcon;

	@Qualifier
	public String getQualifier() {
		return assetIcon;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName + RandomStringUtils.randomAlphabetic(5);
	}

//	public void setIsbn(String isbn) {
//		this.isbn = isbn;
//	}
//
//	public void setOtherId(String otherId) {
//		this.otherId = otherId;
//	}
//
//	public void setOtherIdType(String otherIdType) {
//		this.otherIdType = otherIdType;
//	}
//
//	public void setWorkingTitle(String wTitle) {
//		this.wTitle = wTitle;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public void setDropOption(String dropOption) {
//		this.dropOption = dropOption;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	public void setTargetDate(String targetDate) {
//		this.targetDate = targetDate;
//	}
//
//	public void setPublicationDate(String publicationDate) {
//		this.publicationDate = publicationDate;
//	}
//
//	public void setCampaignYear(String campYear) {
//		this.campYear = campYear;
//	}
//
//	public void setPublishGroup(String publGroup) {
//		this.publGroup = publGroup;
//	}
//
//	public void setProductType(String prodType) {
//		this.prodType = prodType;
//	}
//
//	public void setTargetTerritories(String targetTerr) {
//		this.targetTerr = targetTerr;
//	}
//
//	public void setRightsRequirements(String rightsRequir) {
//		this.rightsRequir = rightsRequir;
//	}
//
//	public void setLinkedLocations(String linkedLoc) {
//		this.linkedLoc = linkedLoc;
//	}

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
	private AlfrescoSiteHeaderSteps siteHeaderSteps;
	@Steps
	private AlfrescoCreateContentSteps createContentSteps;
	@Steps
	private AlfrescoPathRibbonSteps pathRibbonSteps;
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
	public void verifyAssetIcon() {
		loginStep.loginToSite(username, password);

		dashboardSteps.openSiteModal(siteN);
		siteHeaderSteps.openDocumentLibrary();

		if (assetIcon.contains(IconsSrcs.PROJECT_LABEL)) {

			createContentSteps.clickOnCreateContent();
			createContentSteps.clickOnCreateOupProject();
			wTitle += " " + RandomStringUtils.randomAlphabetic(4);
			
			siteHeaderSteps.openDocumentLibrary();
//			assetsViewSteps.backToCreateNewDoc(projectName);
//			rootFolder= "Documents";
//			sitesSteps.navigateToFolder(rootFolder);
			listActionsSteps.markFile(projectName);
			listActionsSteps.verifyDocumentLibraryIcon(projectName,
					IconsSrcs.PROJECT_FOLDER);

		}
		
			siteHeaderSteps.openDocumentLibrary();
//			assetsViewSteps.backToCreateNewDoc(projectName);
//			rootFolder= "Documents";
//			sitesSteps.navigateToFolder(rootFolder);
			listActionsSteps.markFile(projectName);
			listActionsSteps.verifyDocumentLibraryIcon(projectName,
					IconsSrcs.COLLECTION_FOLDER);
		}

	}


