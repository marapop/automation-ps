package a.tools.alfresco;

import net.thucydides.core.annotations.Steps;
import a.steps.alfresco.AlfrescoActivitiExplorerSteps;
import a.steps.alfresco.AlfrescoCreateSiteSteps;
import a.steps.alfresco.AlfrescoDashboardSteps;
import a.steps.alfresco.AlfrescoDocumentLibrarySteps;
import a.steps.alfresco.AlfrescoFilePreviewSteps;
import a.steps.alfresco.AlfrescoGroupsSteps;
import a.steps.alfresco.AlfrescoLoginSteps;
import a.steps.alfresco.AlfrescoOldAlfrescoSteps;
import a.steps.alfresco.AlfrescoSearchSteps;
import a.steps.alfresco.AlfrescoSiteSteps;
import a.steps.alfresco.AlfrescoTasksSteps;
import a.steps.alfresco.AlfrescoUploadAssetsSteps;
import a.steps.alfresco.AlfrescoUsersSteps;

public class AbstractJBSteps {

    @Steps
    public AlfrescoLoginSteps alfrescoLoginSteps;
    @Steps
    public AlfrescoDashboardSteps alfrescoDashboardSteps;
    @Steps
    public AlfrescoCreateSiteSteps alfrescoCreateSiteSteps;
    @Steps
    public AlfrescoHttpHelper alfrescoHttpHelper;
    @Steps
    public AlfrescoDocumentLibrarySteps alfrescoDocumentLibrarySteps;
    @Steps
    public AlfrescoSiteSteps alfrescoSiteSteps;
    @Steps
    public AlfrescoUploadAssetsSteps alfrescoUploadAssetsSteps;
    @Steps
    public AlfrescoFilePreviewSteps alfrescoFilePreviewSteps;
    @Steps
    public AlfrescoUsersSteps alfrescoUsersSteps;
    @Steps
    public AlfrescoTasksSteps alfrescoTasksSteps;
    @Steps
    public AlfrescoGroupsSteps alfrescoGroupsSteps;
    @Steps
    public AlfrescoSearchSteps alfrescoSearchSteps;
    @Steps
    public AlfrescoOldAlfrescoSteps oldAlfrescoSteps;
    @Steps
    public AlfrescoActivitiExplorerSteps activitiExplorerSteps;

    public static String[] getVarargs(String parameter) {
        return StringUtils.getSubstringsSplitByKey(parameter, "/");
    }

    public static String[] getVarargs(String parameter, String delimiter) {
        return StringUtils.getSubstringsSplitByKey(parameter, delimiter);
    }
}
