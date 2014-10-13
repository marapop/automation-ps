package a.steps.alfresco;

import a.tools.alfresco.AbstractJBSteps;

public class AlfrescoCreateSiteJBSteps extends AbstractJBSteps {

    public void createASite(String siteName, String siteDescription,
            String siteType, String siteVisibility) throws Exception {
        if (alfrescoHttpHelper.checkIfSiteExists(siteName))
            alfrescoHttpHelper.deleteSite(siteName);
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Sites",
                "Create Site");
        alfrescoCreateSiteSteps.inputNameField(siteName);
        alfrescoCreateSiteSteps.inputDescriptionField(siteDescription);
        alfrescoCreateSiteSteps.selectTypeOption(siteType);
        alfrescoCreateSiteSteps.selectSiteVisibility(siteVisibility);
        alfrescoCreateSiteSteps.clickOnOkButton();
    }

    public void createACertainTypeOfSite(String siteName,
            String siteDescription, String siteType) throws Exception {
        if (alfrescoHttpHelper.checkIfSiteExists(siteName))
            alfrescoHttpHelper.deleteSite(siteName);
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Sites",
                "Create Site");
        alfrescoCreateSiteSteps.inputNameField(siteName);
        alfrescoCreateSiteSteps.inputDescriptionField(siteDescription);
        alfrescoCreateSiteSteps.selectTypeOption(siteType);
        alfrescoCreateSiteSteps.clickOnOkButton();
    }

    public void verifySiteName(String siteName) {
        alfrescoCreateSiteSteps.verifySiteName(siteName);
    }

    public void checkActivitiesNotification(String user, String fileName,
            String actionName) {
        alfrescoSiteSteps.checkActivitiesNotification(user, fileName,
                actionName);
    }

    public void checkThatDocumentIsPresentInSiteContentList(String docName) {
        alfrescoSiteSteps.checkThatDocumentIsPresentInSiteContentList(docName);
    }

    public void checkDocumentStatusInSiteContent(String docName,
            String actionName, String userName) {
        alfrescoSiteSteps.checkDocumentStatusInSiteContentList(docName,
                actionName, userName);
    }

    public void checkThatSiteNavigationItemIsPresent(String itemTitle) {
        alfrescoSiteSteps.checkThatSiteNavigationItemIsPresent(itemTitle);
    }

    public void checkThatSiteNavigationItemIsNotPresent(String itemTitle) {
        alfrescoSiteSteps.checkThatSiteNavigationItemIsNotPresent(itemTitle);
    }
}
