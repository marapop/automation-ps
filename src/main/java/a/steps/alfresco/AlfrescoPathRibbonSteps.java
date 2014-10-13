package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;
import a.tools.alfresco.Constants;

public class AlfrescoPathRibbonSteps extends AbstractSteps{

	private static final long serialVersionUID = 2653252447767562786L;


	public AlfrescoPathRibbonSteps(Pages pages) {
		super(pages);
	}


//	@Step
//	public void navigateToPreviousFolder(String folder){
//		pathRibbonPage().navigateToPreviousFolder(folder);
//	}
	
	@Step
	public void openFolderForEditPropertiesView() {
		pathRibbonPage().openFolderForEditPropertiesView();
	}

	@Step
	public void navigateToFolderProperties(String title) {
		waitABit(Constants.WAIT_TIME);
		pathRibbonPage().navigateToFolderProperties(title);
		waitABit(Constants.WAIT_TIME);
		
	}


//	@Step
//	public void backFromPropertiesToCreateNewDoc(String folderName) {
//		pathRibbonPage().backFromPropertiesToCreateNewDoc(folderName);
//	}
}
