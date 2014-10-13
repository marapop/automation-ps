package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import a.pages.alfresco.AlfrescoInvitePeoplePage;


public class AlfrescoInvitePeopleSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;
    private AlfrescoInvitePeoplePage alfrescoInvitePeoplePage;

    public AlfrescoInvitePeopleSteps(Pages pages) {
        super(pages);
    }
    
	@Step
	public void checkIfAddExternalUsersScetionExsits() {
		alfrescoInvitePeoplePage.checkIfAddExternalUsersScetionExsits();
	}


}
