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

import a.steps.alfresco.AlfrescoAdvancedSearchSteps;
import a.steps.alfresco.AlfrescoCreateContentSteps;
import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.steps.alfresco.AlfrescoSearchSteps;
import a.steps.alfresco.AlfrescoSiteHeaderSteps;
import a.tools.alfresco.Application;
import a.tools.alfresco.Constants;

@Story(Application.Search.Advanced.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = Constants.TESTDATA_FILES_PATH + "AdvancedSearchTest.csv", separator = Constants.CSV_SEPARATOR)
public class AdvancedSearchTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = Constants.ALFRESCO_URL)
	public Pages pages;

	public String username;
	public String password;
	public String contentName;
	public String contentTitle;
	public String contentDescription;
	public String contentBody;
	public String siteN;

	// search properties
	public String searchName = "";
	public String searchTitle = "";
	public String searchKeyword = "";
	public String searchDescription = "";
	// public String searchMimetype = "";
	// public String searchModifier = "";

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

	public void setContentName(String contentName) {
		this.contentName = contentName + RandomStringUtils.randomAlphabetic(4);
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle
				+ RandomStringUtils.randomAlphabetic(4);
	}

	public void setContentBody(String contentBody) {
		this.contentBody = contentBody + RandomStringUtils.randomAlphabetic(4);

	}

	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription
				+ RandomStringUtils.randomAlphabetic(4);
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public void setSearchDescription(String searchDescription) {
		this.searchDescription = searchDescription;

	}
	

	@Steps
	private AlfrescoLoginSteps loginSteps;

	@Steps
	private AlfrescoDashboardSteps dashboardSteps;

	@Steps
	private AlfrescoSiteHeaderSteps siteHeaderSteps;

	@Steps
	private AlfrescoAdvancedSearchSteps advancedSearchSteps;

	@Steps
	private AlfrescoSearchSteps searchSteps;

	@Steps
	private AlfrescoCreateContentSteps creaContentSteps;
	
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
	public void advancedSearchTest() {

		loginSteps.loginToSite(username, password);

		dashboardSteps.openSiteModal(siteN);

		siteHeaderSteps.openDocumentLibrary();

		creaContentSteps.clickOnPlaceholderAsset();
		
		searchTermsHandler();

		/*appMenuSteps.clickAdvancedSearch();

		advancedSearchSteps.fillAdvancedSearchFields(searchKeyword, searchName,
				searchTitle, searchDescription);
		searchSteps.isElementPresentInSearchResult(contentName);
*/
	}

	private void searchTermsHandler() {
		if (searchKeyword.contains(Constants.TRUE)) {
			searchKeyword = contentName;
		} else {
			searchKeyword = "";
		}
		if (searchName.contains(Constants.TRUE)) {
			searchName = contentName;
		} else {
			searchName = "";
		}
		if (searchTitle.contains(Constants.TRUE)) {
			searchTitle = contentTitle;
		} else {
			searchTitle = "";
		}
		if (searchDescription.contains(Constants.TRUE)) {
			searchDescription = contentDescription;
		} else {
			searchDescription = "";
		}

	}
}
