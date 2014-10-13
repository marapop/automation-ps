package a.steps.alfresco;

import org.junit.Assert;

import a.tools.alfresco.AbstractJBSteps;
import a.tools.alfresco.Constants;
import a.tools.alfresco.RandomGenerators;

public class AlfrescoAPIJBSteps extends AbstractJBSteps {

	public void thenICreateAnAlfrescoTestUser() throws Exception {
		if (alfrescoHttpHelper.checkIfUserExists(Constants.TEST_USERNAME))
			alfrescoHttpHelper.deleteUser(Constants.TEST_USERNAME);
		alfrescoHttpHelper.addNewPerson(Constants.TEST_USERNAME,
				Constants.TEST_LASTNAME, Constants.TEST_FIRSTNAME,
				Constants.TEST_EMAIL, Constants.TEST_PASSWORD);
	}

	public void createAlfrescoUser(String userName, String lastName,
			String firstName, String email, String password) throws Exception {
		if (alfrescoHttpHelper.checkIfUserExists(userName))
			alfrescoHttpHelper.deleteUser(userName);
		alfrescoHttpHelper.addNewPerson(userName, lastName, firstName, email,
				password);
	}

	public void deleteAnAlfrescoUser(String userName) throws Exception {
		alfrescoHttpHelper.deleteUser(userName);
	}

	public void deleteAnAlfrescoGroup(String identifier) throws Exception {
		alfrescoHttpHelper.deleteGroup(identifier);
	}

	public void deleteAnAlfrescoWorkflow(String workflowId) throws Exception {
		alfrescoHttpHelper.deleteWorkflow(workflowId);
	}

	public void checkIfTheAlfrescoUserExists(String userName) throws Exception {
		alfrescoHttpHelper.checkIfUserExists(userName);
	}

	public void checkIfTheAlfrescoWorkflowExists(String workflowId)
			throws Exception {
		alfrescoHttpHelper.checkIfWorkflowExists(workflowId);
	}

	public void createAnAlfrescoSite(String siteName, String siteTitle,
			String siteDescription, String siteVisibility) throws Exception {
		if (alfrescoHttpHelper.checkIfSiteExists(siteName))
			alfrescoHttpHelper.deleteSite(siteName);
		alfrescoHttpHelper.createSite(siteName, siteTitle, siteDescription,
				siteVisibility);
	}

	public void createAnAlfrescoSite(String siteName) throws Exception {
		if (alfrescoHttpHelper.checkIfSiteExists(siteName))
			alfrescoHttpHelper.deleteSite(siteName);
		alfrescoHttpHelper.createSite(siteName);
	}

	public void createAnAlfrescoSite() throws Exception {
		String siteName = RandomGenerators.getRandomString("siteName", 9);
		String siteTitle = RandomGenerators.getRandomString("siteTitle", 9);
		String siteDescription = RandomGenerators.getRandomString(
				"siteDescription", 9);
		String siteVisibility = Constants.SITE_VISIBILITIES[RandomGenerators
		                                                    .getRandomInteger(Constants.SITE_VISIBILITIES.length)];
		if (alfrescoHttpHelper.checkIfSiteExists(siteName))
			alfrescoHttpHelper.deleteSite(siteName);
		alfrescoHttpHelper.createSite(siteName, siteTitle, siteDescription,
				siteVisibility);
	}

	public void deleteAnAlfrescoSite(String siteName) throws Exception {
		// if (alfrescoHttpHelper.checkIfSiteExists(siteName))
		alfrescoHttpHelper.deleteSite(siteName);
	}

	public void verifyThatTheSiteExists(String siteName) throws Exception {
		Assert.assertTrue("The Alfresco site named '" + siteName
				+ "' doesn't exist!",
				alfrescoHttpHelper.checkIfSiteExists(siteName));
	}

	public void verifyThatTheSiteDoesntExist(String siteName) throws Exception {
		Assert.assertFalse("The Alfresco site named '" + siteName
				+ "' shouldn't exist!",
				alfrescoHttpHelper.checkIfSiteExists(siteName));
	}

	public String uploadAFileToTheSite(String fileName, String path,
			String siteName) throws Exception {
		return alfrescoHttpHelper.uploadFile(siteName, fileName, path);
	}
}
