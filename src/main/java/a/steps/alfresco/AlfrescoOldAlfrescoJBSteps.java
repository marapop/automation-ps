package a.steps.alfresco;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import a.tools.alfresco.AbstractJBSteps;
import a.tools.alfresco.Constants;
import a.tools.alfresco.DateUtils;
import a.tools.alfresco.FileUtils;

public class AlfrescoOldAlfrescoJBSteps extends AbstractJBSteps {

    public void loginWithUsernameAndPassword(String username, String password) {
        alfrescoLoginSteps.openLoginPage(Constants.OLD_ALFRESCO_INTERFACE_URL);
        int i = 0;
        while (oldAlfrescoSteps.checkIfLoginButtonIsPresent() && i < 2) {
            oldAlfrescoSteps.insertUserName(username);
            oldAlfrescoSteps.insertPassword(password);
            oldAlfrescoSteps.clickOnLoginButton();
            i++;
        }
    }

    public void loginOnceWithUsernameAndPassword(String username,
            String password) {
        alfrescoLoginSteps.openLoginPage(Constants.OLD_ALFRESCO_INTERFACE_URL);
        oldAlfrescoSteps.insertUserName(username);
        oldAlfrescoSteps.insertPassword(password);
        oldAlfrescoSteps.clickOnLoginButton();

    }

    public void generateSnapshotReportForSite(String site, String script) {
        generateSnapshotReportForSite(site, script, null);
    }

    public void generateSnapshotReportForSite(String site, String script,
            String statusReportLabel) {
        oldAlfrescoSteps.navigateInLeftMenu("Company Home", "Sites", site);
        oldAlfrescoSteps.clickOnSiteMenuAction("More Actions", "View Details");
        oldAlfrescoSteps.clickOnViewDetailsAction("Run Action");
        oldAlfrescoSteps.selectActionForRunActionWizard("Execute script");
        oldAlfrescoSteps.clickOnSetValuesAndAddButton();
        oldAlfrescoSteps.selectActionValues(script);
        oldAlfrescoSteps.clickOnRunActionWizardOkButton();
        oldAlfrescoSteps.clickOnRunActionWizardFinishButton();
        TimeZone timeZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        Date systemDate = new Date();
        alfrescoLoginSteps.openLoginPage(Constants.SHARE_URL);
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Home");
        alfrescoDashboardSteps.selectSiteFromDashboard(site);
        alfrescoSiteSteps.clickOnSiteActionButton("Customize Site");
        alfrescoSiteSteps.dragAvailableSitePageToCurrentSitePages("Data List");
        alfrescoSiteSteps.clickOnCustomizeSiteOkButton();
        if (statusReportLabel == null || statusReportLabel.isEmpty()) {
            statusReportLabel = "Data Lists";
        }
        alfrescoSiteSteps.selectSiteNavigationItem(statusReportLabel);
        alfrescoSiteSteps.clickOnTaskInfoLink();
        alfrescoTasksSteps
                .checkIfDateCorespondsWithSystemTimeInDataList(systemDate);
        FileUtils.deleteFilesContainingStringsInNameFromDirectory(
                FileUtils.getCurrentUserPath() + "\\Downloads",
                getVarargs("DataListExport"));
        alfrescoSiteSteps.clickOnExportAsXlsButton();
        if (System.getProperty("webdriver.driver").contains("firefox")) {
            alfrescoDocumentLibrarySteps.chooseToSaveFileInBrowserPopup();
        }
        File f = FileUtils.getMostRecentFile(FileUtils.searchFileRecursively(
                FileUtils.getCurrentUserPath() + "\\Downloads", new String[] {
                        "zip", "xml", "doc", "xlsx", "xls" }, false,
                "DataListExport.xlsx"));
        System.out.println("!!!!!!!!!!!!!!!!!!!" + f.getAbsolutePath());
        //not implemented
        List<List<String>> myCellRowsLists = FileUtils.getXLSXTypeExcelContent(
                f.getAbsolutePath(), 0);

        String cellContent = myCellRowsLists.get(0).get(1);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~ " + cellContent);
        Date excelDate = DateUtils.fromStringTime(cellContent,
                "EEE MMM dd yyyy HH:mm:ss zzz");
        DateUtils.checkDatesWithErrorMargin(systemDate, excelDate,
                "EEE MMM dd yyyy HH:mm:ss", 1, Calendar.MINUTE);
        TimeZone.setDefault(timeZone);
    }

    public void generateLifecycleStatusReportForSite(String site, String script) {
        generateLifecycleStatusReportForSite(site, script, null);
    }

    public void generateLifecycleStatusReportForSite(String site,
            String script, String statusReportLabel) {
        oldAlfrescoSteps.navigateInLeftMenu("Company Home", "Sites", site);
        oldAlfrescoSteps.clickOnSiteMenuAction("More Actions", "View Details");
        oldAlfrescoSteps.clickOnViewDetailsAction("Run Action");
        oldAlfrescoSteps.selectActionForRunActionWizard("Execute script");
        oldAlfrescoSteps.clickOnSetValuesAndAddButton();
        oldAlfrescoSteps.selectActionValues(script);
        oldAlfrescoSteps.clickOnRunActionWizardOkButton();
        oldAlfrescoSteps.clickOnRunActionWizardFinishButton();
        TimeZone timeZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        Date systemDate = new Date();
        alfrescoLoginSteps.openLoginPage(Constants.SHARE_URL);
        alfrescoDashboardSteps.clickOnDashboardHeaderButton("Home");
        alfrescoDashboardSteps.selectSiteFromDashboard("Top Notch 3E");
        if (statusReportLabel == null || statusReportLabel.isEmpty()) {
            statusReportLabel = "Data Lists";
        }
        alfrescoSiteSteps.selectSiteNavigationItem(statusReportLabel);
        alfrescoSiteSteps.clickOnLifeCycleStatusReportLink();
        alfrescoTasksSteps
                .checkIfDateCorespondsWithSystemTimeInDataList(systemDate);
        FileUtils.deleteFilesContainingStringsInNameFromDirectory(
                FileUtils.getCurrentUserPath() + "\\Downloads",
                getVarargs("DataListExport"));
        alfrescoSiteSteps.clickOnExportAsXlsButton();
        if (System.getProperty("webdriver.driver").contains("firefox")) {
            alfrescoDocumentLibrarySteps.chooseToSaveFileInBrowserPopup();
        }
        File f = FileUtils.getMostRecentFile(FileUtils.searchFileRecursively(
                FileUtils.getCurrentUserPath() + "\\Downloads", new String[] {
                        "zip", "xml", "doc", "xlsx", "xls" }, false,
                "DataListExport.xlsx"));
        System.out.println("!!!!!!!!!!!!!!!!!!!" + f.getAbsolutePath());
        List<List<String>> myCellRowsLists = FileUtils.getXLSXTypeExcelContent(
                f.getAbsolutePath(), 0);

        String cellContent = myCellRowsLists.get(0).get(1);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~" + cellContent);
        Date excelDate = DateUtils.fromStringTime(cellContent,
                "EEE MMM dd yyyy HH:mm:ss zzz");
        System.out.println("**************************************** "
                + excelDate.toString());
        DateUtils.checkDatesWithErrorMargin(systemDate, excelDate,
                "EEE MMM dd yyyy HH:mm:ss", 1, Calendar.MINUTE);
        TimeZone.setDefault(timeZone);
        FileUtils.deleteFilesContainingStringsInNameFromDirectory(
                FileUtils.getCurrentUserPath() + "\\Downloads",
                getVarargs("DataListExport"));
    }
}