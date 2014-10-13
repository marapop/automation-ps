package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoLinkToSteps extends AbstractSteps{

	private static final long serialVersionUID = 5990642649350294101L;

	public AlfrescoLinkToSteps(Pages pages) {
		super(pages);
	}

	
	@Step
	public void selectTheSiteToLink(String siteName) {
		linkToPage().selectTheSiteToLink(siteName);
	}
    
	@Step
	public void selectTheFolderToLink(String projectName) {
		linkToPage().selectTheFolderToLink(projectName);
	}
	
	@Step
	public void clickOnLinkButton() {
		linkToPage().clickOnLinkButton();
	}
	
	@Step
	public void clickOnCreateButton() {
		linkToPage().clickOnCreateButton();
	}
}
