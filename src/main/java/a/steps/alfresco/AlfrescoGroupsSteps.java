package a.steps.alfresco;

import a.pages.alfresco.AlfrescoGroupsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class AlfrescoGroupsSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    public AlfrescoGroupsSteps(Pages pages) {
        super(pages);
    }

    private AlfrescoGroupsPage alfrescoGroupsPage;

    @Step
    public void clickOnBrowseButton() {
        alfrescoGroupsPage.clickOnBrowseButton();
    }

    @Step
    public void clickOnNewGroupButton() {
        alfrescoGroupsPage.clickOnNewGroupButton();
    }

    @Step
    public void clickOnCreateGroupButton() {
        alfrescoGroupsPage.clickOnCreateGroupButton();
    }

    @Step
    public void insertGroupIdentifier(String groupIdentifier) {
        alfrescoGroupsPage.insertGroupIdentifier(groupIdentifier);
    }

    @Step
    public void insertGroupName(String groupName) {
        alfrescoGroupsPage.insertGroupName(groupName);
    }
}
