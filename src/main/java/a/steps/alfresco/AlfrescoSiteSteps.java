package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import a.pages.alfresco.AlfrescoSitePage;

public class AlfrescoSiteSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    public AlfrescoSiteSteps(Pages pages) {
        super(pages);
    }

    private AlfrescoSitePage alfrescoSitePage;

    @Step
    public void selectSiteNavigationItem(String itemTitle) {
        alfrescoSitePage.selectSiteNavigationItem(itemTitle);
    }

    @Step
    public void checkThatSiteNavigationItemIsPresent(String itemTitle) {
        alfrescoSitePage.checkThatSiteNavigationItemIsPresent(itemTitle);
    }

    @Step
    public void checkThatSiteNavigationItemIsNotPresent(String itemTitle) {
        alfrescoSitePage.checkThatSiteNavigationItemIsNotPresent(itemTitle);
    }

    @Step
    public void checkActivitiesNotification(String... strTerms) {
        alfrescoSitePage.checkActivitiesNotification(strTerms);
    }

    @Step
    public void clickOnSiteActionButton(String... labels) {
        alfrescoSitePage.clickOnSiteActionButton(labels);
    }

    @Step
    public void dragAvailableSitePageToCurrentSitePages(String pageTitle) {
        alfrescoSitePage.dragAvailableSitePageToCurrentSitePages(pageTitle);
    }

    @Step
    public void clickOnCustomizeSiteOkButton() {
        alfrescoSitePage.clickOnCustomizeSiteOkButton();
    }

    @Step
    public void clickOnTaskInfoLink() {
        alfrescoSitePage.clickOnTaskInfoLink();
    }

    @Step
    public void clickOnLifeCycleStatusReportLink() {
        alfrescoSitePage.clickOnLifeCycleStatusReportLink();
    }

    @Step
    public void checkIfTaskExistsInSnapshotReport(String taskDescription) {
        alfrescoSitePage.getTaskInfoRow(taskDescription);
    }

    @Step
    public void checkThatDocumentIsPresentInSiteContentList(String docName) {
        alfrescoSitePage.checkThatDocumentIsPresentInSiteContentList(docName);
    }

    @Step
    public void checkDocumentStatusInSiteContentList(String docName,
            String actionName, String userName) {
        alfrescoSitePage.checkDocumentStatusInSiteContentList(docName,
                actionName, userName);
    }

    @Step
    public void clickOnExportAsXlsButton() {
        alfrescoSitePage.clickOnExportAsXlsButton();
    }
}
