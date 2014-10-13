package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoSiteHeaderSteps extends AbstractSteps{

	private static final long serialVersionUID = 3362799490897685427L;

	public AlfrescoSiteHeaderSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void openDocumentLibrary() {
		siteHeaderPage().clickOnDocumentLibraryButton();
	}
	
	@Step
	public void openSiteMembers() {
		siteHeaderPage().clickOnMembersButton();
	}
	
	@Step
	public void clickOnMoreButton() {
		siteHeaderPage().clickOnMoreButton();
	}

	@Step
	public void clickOnSiteDashboardButton() {
		siteHeaderPage().clickOnSiteDashboardButton();
		
	}
}
