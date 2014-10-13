package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoCustomizeSiteSteps extends AbstractSteps{

	private static final long serialVersionUID = 2369109696608252967L;

	public AlfrescoCustomizeSiteSteps(Pages pages) {
		super(pages);

	}

	@StepGroup
	public void customizeSiteToWiki() {
		dragAndDropWikiPage();
		clickOnOkOrSaveButton();
	}

	
	@Step
	public void dragAndDropWikiPage() {
		customizeSitePage().dragAndDropWikiPage();
	}



	@Step
	public void clickOnOkOrSaveButton() {
		customizeSitePage().clickOnOkOrSaveButton();
	}
}
