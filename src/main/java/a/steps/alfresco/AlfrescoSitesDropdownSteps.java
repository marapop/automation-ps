package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoSitesDropdownSteps extends AbstractSteps{

	private static final long serialVersionUID = -5807138509652940447L;

	public AlfrescoSitesDropdownSteps(Pages pages) {
		super(pages);

	}
	
	@StepGroup
	@Deprecated
	public void openSiteDashboard(String siteName) {
//    	clickOnSitesButton();
    //	searchCreatedSite(siteName);
	}
	

	
	
	// Dashboard Header actions - used in stepgroups
	@Step
	public void clickOnCreateSitesButton(){
		sitesDropdownPage().clickOnCreateSitesButton();
	}
	
	@Step
	public void searchForSites(){
		sitesDropdownPage().searchForSites();
	}

}
