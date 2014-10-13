package a.jbehave.alfresco;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import a.steps.alfresco.AlfrescoCreateSiteSteps;
import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.tools.alfresco.Constants;
import a.tools.alfresco.SeleniumTestUtils;

@RunWith(ThucydidesRunner.class)
public class CreateSiteAndWritePropertiesTest {

	private String siteName = RandomStringUtils.randomAlphabetic(6);
	private String username;
	private String password;
		
	
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.ALFRESCO_URL)
    public Pages pages;
    
    @Steps
    private AlfrescoLoginSteps loginStep;
    @Steps
    private AlfrescoDashboardSteps dashboardSteps;
    @Steps
    private AlfrescoCreateSiteSteps createSiteSteps;
    
	@Before
	public void setupData(){
		
		
		try {

			InputStream in = getClass().getResourceAsStream(Constants.GLOBAL_CONFIG_PATH);
			Properties properties = new Properties();
			properties.load(in);
			in.close();
			
			username = properties.getProperty("username");
			password = properties.getProperty("password");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	
	@Test
	public void createSite(){
		loginStep.loginToSite(username, password);
		
		createSiteSteps.createSiteModal(siteName, siteName + siteName);
		
		System.out.println("Site name: " + siteName);
		
		try {
			
			Properties prop = new Properties();
			prop.setProperty("siteName", siteName);
			prop.setProperty("username", username);
			prop.setProperty("password", password);
			
			String filePath = new File(Constants.TESTDATA_FILES_PATH, Constants.GLOBAL_CONFIG_FULL_NAME).getAbsolutePath();
			String targetPath = filePath.replace(SeleniumTestUtils.getGlobalConfigSRCPath(), SeleniumTestUtils.getGlobalConfigTargetPath());
			
			System.out.println("File path: " + filePath);
			
			prop.store(new FileOutputStream(filePath), null);
			prop.store(new FileOutputStream(targetPath), null);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
