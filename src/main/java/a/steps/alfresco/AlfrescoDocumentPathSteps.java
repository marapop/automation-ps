package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoDocumentPathSteps extends AbstractSteps{

	private static final long serialVersionUID = -8973438508645200212L;

	public AlfrescoDocumentPathSteps(Pages pages) {
		super(pages);
	}

	@Step
	public void backToCreateNewDoc(String folderName){
		documentPathPage().backToCreateNewDoc(folderName);
	}
	
}
