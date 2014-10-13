package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import a.pages.alfresco.AlfrescoCreateSitePage;

public class AlfrescoCreateSiteSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    public AlfrescoCreateSiteSteps(Pages pages) {
        super(pages);
    }

    private AlfrescoCreateSitePage alfrescoCreateSitePage;

    @Step
    public void inputNameField(String name) {
        alfrescoCreateSitePage.inputNameField(name);
    }

    @Step
    public void inputDescriptionField(String siteDescription) {
        alfrescoCreateSitePage.inputDescriptionField(siteDescription);
    }

    @Step
    public void selectTypeOption(String siteType) {
        alfrescoCreateSitePage.selectTypeOption(siteType);
    }

    @Step
    public void clickOnOkButton() {
        alfrescoCreateSitePage.clickOnOkButton();
    }
    @Step
    public void createSiteModal(String siteName,String siteDescription) {
		alfrescoCreateSitePage.evaluateJavascript("Alfresco.util.ComponentManager.get('global_x002e_header_x0023_default-app_sites').showCreateSite(); return false;");
		fillCreateSiteDialogBox(siteName, siteDescription);
		createSite();
	}
    @Step
	public void fillCreateSiteDialogBox(String siteName, String siteDescription){
		alfrescoCreateSitePage.fillCreateSiteDialogBox(siteName, siteDescription);
	}
    
    @Step
    public void verifySiteName(String siteName) {
        alfrescoCreateSitePage.verifySiteName(siteName);
    }

    @Step
    public void selectSiteVisibility(String siteVisibility) {
        alfrescoCreateSitePage.selectSiteVisibility(siteVisibility);
    }
    @Step
	public void createSite(){
		alfrescoCreateSitePage.createSite();
	}

}
