package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoUploadSteps extends AbstractSteps{

	private static final long serialVersionUID = 492917638896299474L;

	public AlfrescoUploadSteps(Pages pages) {
		super(pages);
	}

	
	@Step
	public String uploadMinorVersion(String uploadFilePath, String uploadComment) {
		return uploadDialogPage().uploadMinorVersion(uploadFilePath,
				uploadComment);
	}
}
