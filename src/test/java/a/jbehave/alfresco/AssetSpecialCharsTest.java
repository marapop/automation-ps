package a.jbehave.alfresco;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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
import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.steps.alfresco.AlfrescoSiteHeaderSteps;
import a.steps.alfresco.AlfrescoUploadSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;
import a.tools.alfresco.constants.DataDrivenFiles;


//@RunWith(JUnit4.class)
@Story(Application.Assets.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH + DataDrivenFiles.ASSET_SPECIAL_CHARS_TEST, separator = Constants.CSV_SEPARATOR)
public class AssetSpecialCharsTest {

	
	//test data properties
	private String username;
	private String password;
	private String siteN = RandomStringUtils.randomAlphabetic(6);

	
	@Qualifier
    public String getQualifier() {
        return username;
    }
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
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
	private AlfrescoActionsSteps actionsSteps;
	@Steps
	private AlfrescoUploadSteps uploadSteps;
	@Steps
	private AlfrescoSiteHeaderSteps siteHeaderSteps;
	@Steps
	private AlfrescoCreateContentSteps createContentSteps;
	
	
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
	public void assetSpecialChars() throws UnsupportedEncodingException{
//		String japaneseChars = "大家";
//		String chineseChars = "위키백과, 우리 모두의 백과사전";
//		String spanishChars = "á, é, í, ó, ú, ü, ñ, ¿, ¡";
		
		
//		String contentName = RandomStringUtils.randomAlphanumeric(5);
//		String contentTitle = japaneseChars + spanishChars;
//		String contentDescription = chineseChars;
//		String contentBody = spanishChars;
//		
		loginStep.loginToSite(username, password);
		dashboardSteps.openSiteModal(siteN);
		
		siteHeaderSteps.openDocumentLibrary();
		createContentSteps.clickOnPlaceholderAsset();
    	

	}
}
