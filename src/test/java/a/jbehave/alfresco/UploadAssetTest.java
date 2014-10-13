package a.jbehave.alfresco;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.WithDriver;
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
import a.steps.alfresco.AlfrescoSiteHeaderSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;
import a.tools.alfresco.SeleniumTestUtils;
import a.tools.alfresco.constants.DataDrivenFiles;

/**
 * Upload works only on firefox due to input element rendering differently
 * (chrome and FF).
 * 
 * @author vladvoicu
 * 
 */
@Story(Application.Assets.Upload.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH
		+ DataDrivenFiles.UPLOAD_ASSET, separator = Constants.CSV_SEPARATOR)
public class UploadAssetTest {

	// test data
	private String username;
	private String password;
	private String uploadFile;
	private String uploadFileName;
	private String siteN = RandomStringUtils.randomAlphabetic(6);
//	private static String siteD = String.valueOf(System.nanoTime());

	@Qualifier
	public String getQualifier() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = SeleniumTestUtils.getAbsoluteFilePath(uploadFile);
		this.uploadFileName = uploadFile;
	}

	public void setFolderPath(String folderPath) {
	}

	// test setup
	@Managed(uniqueSession = true, driver = Constants.FIREFOX)
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
	@WithDriver(Constants.FIREFOX)
	public void uploadAssetFile() {

		loginStep.loginToSite(username, password);

		dashboardSteps.openSiteModal(siteN);

		siteHeaderSteps.openDocumentLibrary();

//		System.out.println("Folder path: " + folderPath);
//		repositorySteps.navigateToFolder(folderPath);

		createContentSteps.uploadDocument(uploadFile);

		// System.out.println("File name: " + uploadFileName);
		listActionsSteps.verifyFileIsPresent(uploadFileName);

	}
}
