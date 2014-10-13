package a.steps.alfresco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import a.pages.alfresco.AlfrescoRepositoryPage;
import a.tools.alfresco.WebDriverConfig;


public class AlfrescoRepositorySteps {

	WebDriver driver = WebDriverConfig.getCurrentDriver();
	AlfrescoRepositoryPage repositoryPage = PageFactory.initElements(driver, AlfrescoRepositoryPage.class);

	public void selectItem(String item) {
		repositoryPage.selectItem(item);
	}

	public void openRepository() {
		repositoryPage.openRepository();
	}

	public void verifyCustomIconInRepoMainView(String nodeName, String iconType) {
		repositoryPage.verifyCustomIconInRepoMainView(nodeName, iconType);
	}

}
