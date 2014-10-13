package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;
import a.tools.alfresco.Constants;

public class AlfrescoCustomizeDashboardSteps extends AbstractSteps{

	private static final long serialVersionUID = 5329796943701216412L;

	public AlfrescoCustomizeDashboardSteps(Pages pages) {
		super(pages);
	}
	
	@Step
	public void clickOnCustomizeDashboard(){
		customizeDashboardPage().clickOnCustomizeDashboard();
		waitABit(Constants.WAIT_TIME_SHORT);
	}

//	@Step
//	public void clickOnAddDashlet() {
//		customizeDashboardPage().clickOnAddDashlet();
//		
//	}

	@Step
	public void dragAndDropCollectionsDashlet() {
		customizeDashboardPage().dragAndDropCollectionsDashlet();
	}
	
	
	
}
