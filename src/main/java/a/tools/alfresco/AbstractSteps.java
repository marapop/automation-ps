package a.tools.alfresco;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import a.pages.alfresco.AlfrescoActionsPage;
import a.pages.alfresco.AlfrescoAdvancedSearchPage;
import a.pages.alfresco.AlfrescoCreateContentPage;
import a.pages.alfresco.AlfrescoCreateSitePage;
import a.pages.alfresco.AlfrescoCreateUserPage;
import a.pages.alfresco.AlfrescoCustomizeDashboardPage;
import a.pages.alfresco.AlfrescoCustomizeSitePage;
import a.pages.alfresco.AlfrescoDashboardPage;
import a.pages.alfresco.AlfrescoDocumentPathPage;
import a.pages.alfresco.AlfrescoLinkToPage;
import a.pages.alfresco.AlfrescoListActionsPage;
import a.pages.alfresco.AlfrescoListViewsPage;
import a.pages.alfresco.AlfrescoLocalManagePermissionsPage;
import a.pages.alfresco.AlfrescoLoginPage;
import a.pages.alfresco.AlfrescoManagePermissionsPage;
import a.pages.alfresco.AlfrescoMembersPage;
import a.pages.alfresco.AlfrescoMoveToPage;
import a.pages.alfresco.AlfrescoNavigationPage;
import a.pages.alfresco.AlfrescoPathRibbonPage;
import a.pages.alfresco.AlfrescoReassignPage;
import a.pages.alfresco.AlfrescoSearchPage;
import a.pages.alfresco.AlfrescoSearchResultsPage;
import a.pages.alfresco.AlfrescoSearchSitePage;
import a.pages.alfresco.AlfrescoSelectedItemsPage;
import a.pages.alfresco.AlfrescoSiteHeaderPage;
import a.pages.alfresco.AlfrescoSitesDropdownPage;
import a.pages.alfresco.AlfrescoTaskFormPage;
import a.pages.alfresco.AlfrescoUploadDialogPage;
import a.pages.alfresco.AlfrescoWorkflowsStartedPage;
import a.steps.alfresco.AlfrescoRightsTemplatesPage;


public class AbstractSteps extends ScenarioSteps{
	private static final long serialVersionUID = -2917865444900602964L;

	public AbstractSteps(Pages pages) {
		super(pages);
	}

	public void navigateToURL(String URL){
		getDriver().get(URL);
		getDriver().manage().window().maximize();
	}

	protected void refreshPage() {
		getDriver().navigate().refresh();		
	}

	protected FormatDate formatDate(){
		return new FormatDate();
	}
	
	protected AlfrescoLoginPage loginPage() {
		return getPages().currentPageAt(AlfrescoLoginPage.class);
	}

	protected AlfrescoCreateSitePage createSitePage(){
		return getPages().currentPageAt(AlfrescoCreateSitePage.class);
	}

	protected AlfrescoSitesDropdownPage sitesDropdownPage(){
		return getPages().currentPageAt(AlfrescoSitesDropdownPage.class);
	}

	protected AlfrescoSiteHeaderPage siteHeaderPage(){
		return getPages().currentPageAt(AlfrescoSiteHeaderPage.class);
	}

	protected AlfrescoCustomizeSitePage customizeSitePage(){
		return getPages().currentPageAt(AlfrescoCustomizeSitePage.class);
	}

	protected AlfrescoCustomizeDashboardPage customizeDashboardPage(){
		return getPages().currentPageAt(AlfrescoCustomizeDashboardPage.class);
	}

	protected AlfrescoDocumentPathPage documentPathPage(){
		return getPages().currentPageAt(AlfrescoDocumentPathPage.class);
	}

	protected AlfrescoLocalManagePermissionsPage localManagePermissionsPage(){
		return getPages().currentPageAt(AlfrescoLocalManagePermissionsPage.class);
	}
	
	protected AlfrescoWorkflowsStartedPage workflowsStartedPage(){
		return getPages().currentPageAt(AlfrescoWorkflowsStartedPage.class);
	}

	protected AlfrescoReassignPage reassignPage(){
		return getPages().currentPageAt(AlfrescoReassignPage.class);
	}

	protected AlfrescoRightsTemplatesPage rightsTemplatesPage(){
		return getPages().currentPageAt(AlfrescoRightsTemplatesPage.class);
	}

	protected AlfrescoTaskFormPage taskFormPage(){
		return getPages().currentPageAt(AlfrescoTaskFormPage.class);
	}
	
	protected AlfrescoDashboardPage dashboardPage(){
		return getPages().currentPageAt(AlfrescoDashboardPage.class);
	}

	protected AlfrescoListViewsPage listViewsPage(){
		return getPages().currentPageAt(AlfrescoListViewsPage.class);
	}

	protected AlfrescoCreateContentPage createContentPage(){
		return getPages().currentPageAt(AlfrescoCreateContentPage.class);
	}

	protected AlfrescoPathRibbonPage pathRibbonPage(){
		return getPages().currentPageAt(AlfrescoPathRibbonPage.class);
	}

	protected AlfrescoSelectedItemsPage selectedItemsPage(){
		return getPages().currentPageAt(AlfrescoSelectedItemsPage.class);
	}

	protected AlfrescoListActionsPage listActionsPage(){
		return getPages().currentPageAt(AlfrescoListActionsPage.class);
	}

	protected AlfrescoMoveToPage moveToPage(){
		return getPages().currentPageAt(AlfrescoMoveToPage.class);
	}

	protected AlfrescoLinkToPage linkToPage(){
		return getPages().currentPageAt(AlfrescoLinkToPage.class);
	}

	protected AlfrescoActionsPage actionsPage(){
		return getPages().currentPageAt(AlfrescoActionsPage.class);
	}

	protected AlfrescoSearchSitePage searchSitePage(){
		return getPages().currentPageAt(AlfrescoSearchSitePage.class);
	}

	protected AlfrescoNavigationPage navigationPage(){
		return getPages().currentPageAt(AlfrescoNavigationPage.class);
	}

	protected AlfrescoCreateUserPage createUserPage(){
		return getPages().currentPageAt(AlfrescoCreateUserPage.class);
	}

	protected AlfrescoUploadDialogPage uploadDialogPage(){
		return getPages().currentPageAt(AlfrescoUploadDialogPage.class);
	}

	protected AbstractPage abstractPage(){
		return getPages().currentPageAt(AbstractPage.class);
	}

	protected AlfrescoMembersPage membersPage(){
		return getPages().currentPageAt(AlfrescoMembersPage.class);
	}

	protected AlfrescoManagePermissionsPage managePermissionsPage(){
		return getPages().currentPageAt(AlfrescoManagePermissionsPage.class);
	}

	protected AlfrescoSearchPage searchPage(){
		return getPages().currentPageAt(AlfrescoSearchPage.class);
	}

	protected AlfrescoSearchResultsPage searchResultsPage(){
		return getPages().currentPageAt(AlfrescoSearchResultsPage.class);
	}

	protected AlfrescoAdvancedSearchPage advancedSearchPage(){
		return getPages().currentPageAt(AlfrescoAdvancedSearchPage.class);
	}
}
