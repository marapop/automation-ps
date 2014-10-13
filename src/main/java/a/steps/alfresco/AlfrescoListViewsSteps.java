package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;
import a.tools.alfresco.Constants;

public class AlfrescoListViewsSteps extends AbstractSteps{

	private static final long serialVersionUID = 462302259587209572L;

	public AlfrescoListViewsSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void clickOnSimpleView() {
		listViewsPage().clickOnSimpleView();
	}


	@Step
	public void verifyCurrentView(Constants.ENUM_VIEWS cView) {
		listViewsPage().verifyCurrentView(cView);
	}

	@Step
	public void clickOnDetailedView() {
		listViewsPage().clickOnDetailedView();
		
	}
	

}
