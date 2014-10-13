package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;
import a.tools.alfresco.Constants;

public class AlfrescoNavigationSteps extends AbstractSteps{

	private static final long serialVersionUID = 2988675586799266652L;

	public AlfrescoNavigationSteps(Pages pages) {
		super(pages);
	}
	
	@StepGroup
	public void navigateToFolder(String filePath){
		String[] pathList = filePath.split(Constants.PATH_SEPARATOR);
		String lastChild = pathList[pathList.length - 1 ];
		
		for(String fileName:pathList){
			if(!fileName.isEmpty()){
				expandFolderView(fileName);
				lastChild = fileName;
			}
		}
		openFolderView(lastChild);
		
	}
	
	@Step
	public void expandFolderView(String folderName){
		navigationPage().navigateToFolder(folderName);
	}

	@Step
	public void navigateToSingleFolder(String folderName) {
		navigationPage().navigateToSingleFolder(folderName);
	}

	@Step
	public void navigationToDocumentsProperties() {
		navigationPage().navigationToDocumentsProperties();
	}
	
	@Step
	public void openFolderView(String folderName){
		navigationPage().openFolderView(folderName);
	}
	
	@StepGroup
	public void verifyTreeViewStructure(String treeView) {
		waitABit(Constants.WAIT_TIME_LONG);
		String[] treeElements = treeView.split(Constants.PATH_SEPARATOR);
		for(String elementNow:treeElements){
			verifyTreeViewItem(elementNow);
			waitABit(Constants.WAIT_TIME_SHORT);
		}
		
	}
	
	@Step
	public void verifyTreeViewItem(String itemName){
		navigationPage().verifyTreeViewItem(itemName);
	}
	

}
