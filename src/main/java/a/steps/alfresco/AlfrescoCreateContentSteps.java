package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;

public class AlfrescoCreateContentSteps extends AbstractSteps{

	private static final long serialVersionUID = 708608780910099155L;

	public AlfrescoCreateContentSteps(Pages pages) {
		super(pages);
	}

	/**
	 * will click on create content and create project
	 */
	@StepGroup
	public void clickOnCreateProject() {
		clickOnCreateContent();
		clickOnCreateOupProject();
	}
	
	@StepGroup
	public void createNewCollection() {
		clickOnCreateContent();
		clickOnCreateCollection();
	}
	
	@StepGroup
	public void createPlainTextContent(){
		clickOnCreateContent();
		clickOnPlainText();
	}
	
	@StepGroup
	public void createNewProject(){
		clickOnCreateContent();
		clickOnCreateOupProject();
	}

	@Step
	public void createNewFolder(){
		createContentPage().createNewFolder();
	}
	
	@Step
	public void clickOnPlainText(){
		createContentPage().clickOnCreateContentPlainText();
	}
	
	@Step
	public void clickOnPlaceholderAsset() {
		createContentPage().clickOnPlaceholderAsset();
	}
		
	//---------------------------------------------------
	
	@Step
	public void clickOnCreateCollection() {
		createContentPage().clickOnCreateCollection();
	}
		
	@Step
	public void uploadDocument(String fileName){
		createContentPage().uploadDocument(fileName);
	}
	
	@Step
	public void clickOnCreateContent(){
		createContentPage().clickOnCreateContent();
	}
	
	
	@Step
	public void clickOnCreateOupProject(){
		createContentPage().clickOnCreateOupProject();
	}
	
	@Step
	public void clickOnCreateAssetSpec() {
		createContentPage().clickOnCreateAssetSpec();
	}
	
	@Step
	public void clickOnCreateFolder() {
		createContentPage().clickOnCreateFolder();
	}

	@Step
	public void verifyCreateNewFolderButtonIsDisabled() {
		createContentPage().verifyCreateFolderIsDisabled();
	}

	@Step
	public void verifyIfCreateContentIsDisabled() {
		createContentPage().verifyIfCreateContentIsDisabled();
	}
	
	@Step
	public void verifyIfCreateContentIsEnabled() {
		createContentPage().verifyIfCreateContentIsEnabled();
	}

	@Step
	public void verifyIfCreateCollectionIsDisabled() {
		createContentPage().verifyIfCreateCollectionIsDisabled();
	}

	@Step
	public void clickOnCreateSeries() {
		createContentPage().clickOnCreateSeries();		
	}

	
}
