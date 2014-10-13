package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoSearchSiteSteps extends AbstractSteps{

	private static final long serialVersionUID = -3856843383254889499L;

	public AlfrescoSearchSiteSteps(Pages pages) {
		super(pages);
	}


	
	@Step
	public void deleteSiteModal(String siteName) {
		dashboardPage().searchSiteModal();
		searchTheSiteCreatedByOther(siteName);
		deleteSearchedSite(siteName);
	}
	
	@Step
	public void searchSiteModal(String siteName) {
		dashboardPage().searchSiteModal();
		searchTheSiteCreatedByOther(siteName);
	}
	
	@Step
	public void openTheSiteFound(String siteName){
		searchSitePage().openTheSiteFound(siteName);
	}
	
	@Step
	 public void searchTheSiteCreatedByOther(String siteName){
		searchSitePage().searchTheSiteCreatedByOther(siteName);
	}
	
	@Step
	public void deleteSearchedSite(String siteName){
		searchSitePage().deleteSite(siteName);
	}

	
	@Step
	public void searchTheSiteToDelete(String siteName){
		searchSitePage().searchTheSiteToDelete(siteName);
	}
	
	@Step
	public void deleteTheSiteFound(){
		searchSitePage().deleteTheSiteFound();
	}
	
	

}
