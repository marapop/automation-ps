package a.jbehave.alfresco;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import a.steps.alfresco.AlfrescoCreateSiteSteps;
import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.steps.alfresco.AlfrescoSearchSiteSteps;
import a.steps.alfresco.AlfrescoSitesDropdownSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;

@Story(Application.BasicFunctionality.CreateSite.class)
@RunWith(ThucydidesRunner.class)
public class CreateSiteTest {
	
	@Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = Constants.ALFRESCO_URL)
    public Pages pages;
    
    @Steps
    private AlfrescoLoginSteps loginStep;
    @Steps
    private AlfrescoDashboardSteps dashboardSteps;
    @Steps
    private AlfrescoSearchSiteSteps searchSiteSteps;
    @Steps
    private AlfrescoCreateSiteSteps createSiteSteps;
    @Steps
    private AlfrescoSitesDropdownSteps sitesDropdownSteps;

    private String userName = "marklar";
    private String userPass = "marklar";
    private String siteName = RandomStringUtils.randomAlphabetic(3);
    private static String siteDescription = "demo Text, " + String.valueOf(System.nanoTime());
    
    @Test
    public void createAlfrescoSite(){
    	
    	loginStep.loginToSite(userName, userPass);

    	createSiteSteps.createSiteModal(siteName, siteDescription);
    	//sitesDropdownSteps.openSiteDashboard(siteName);
    	searchSiteSteps.searchSiteModal(siteName);
    	
    }

}
