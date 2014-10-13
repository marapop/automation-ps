package a.steps.alfresco;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import a.tools.alfresco.AbstractSteps;
import a.tools.alfresco.Constants;

public class AlfrescoAdvancedSearchSteps extends AbstractSteps {

	public AlfrescoAdvancedSearchSteps(Pages pages) {
		super(pages);
	}

	private static final long serialVersionUID = -6869876987811239526L;

	@Step
	public void inputSearchName(String contentName) {
		advancedSearchPage().inputName(contentName);
	}

	@Step
	public void clickSearchButton() {
		advancedSearchPage().clickSearchButton();
	}

	@Step
	public void inputSearchKeyword(String keyword) {
		advancedSearchPage().inputKeyword(keyword);
	}

	@Step
	public void inputSearchTitle(String contentTitle) {
		advancedSearchPage().inputTitle(contentTitle);

	}

	@Step
	public void selectMimeType(String mimeType) {
		advancedSearchPage().selectMimeType(mimeType);
	}

	@Step
	public void inputSearchDescription(String searchDescription) {
		advancedSearchPage().inputDescription(searchDescription);
	}

	@Step
	public void inputSearchModifier(String searchModifier) {

	}

	@StepGroup
	public void searchForContentName(String contentName) {
		inputSearchName(contentName);
		clickSearchButton();

	}

	@StepGroup
	public void searchForTitleName(String contentTitle) {
		inputSearchTitle(contentTitle);
		clickSearchButton();
	}

	@StepGroup
	public void searchByKeyword(String keyword) {
		inputSearchKeyword(keyword);
		clickSearchButton();
	}

	public void fillAdvancedSearchFields(String keyword, String name,
			String title, String description) {

		if (keyword.length() > 0) {
			inputSearchKeyword(keyword);
		}
		if (name.length() > 0) {
			inputSearchName(name);
		}

		if (title.length() > 0) {
			inputSearchTitle(title);
		}

		if (description.length() > 0) {
			inputSearchDescription(description);
		}

		waitABit(Constants.WAIT_TIME_SHORT);
		clickSearchButton();
		waitABit(Constants.WAIT_TIME_SHORT);

	}

	@StepGroup
	public void chooseTypeOfAdvancedSearch(String assetType) {
		clickOnLookForDropdown();
		selectTypeOfSearch(assetType);
	}

	@Step
	public void clickOnLookForDropdown() {
		advancedSearchPage().clickOnLookForDropdown();
	}

	@Step
	public void selectTypeOfSearch(String assetType) {
		advancedSearchPage().selectTypeOfSearch(assetType);
	}

	@Step
	public void clickOnAssetExapnd() {
		advancedSearchPage().clickOnAssetExapnd();
	}
}
