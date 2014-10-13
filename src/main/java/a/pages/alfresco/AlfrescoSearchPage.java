package a.pages.alfresco;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.Delay;

public class AlfrescoSearchPage extends AbstractPage {

    public AlfrescoSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[id*='search-button-button']")
    private WebElement searchButtonFromResultsList;

    @FindBy(css = "input[id$='prop_cm_modifier']")
    private WebElement modifierField;

    @FindBy(css = "div[class*='set']> div:nth-child(1) input")
    private WebElement nameField;

    @FindBy(css = "div[class*='set']> div:nth-child(4) select")
    private WebElement mimeTypeDropdown;

    @FindBy(css = "input.terms")
    private WebElement keywordInput;

    @FindBy(css = "div.set > input.terms")
    private WebElement advancedKeywordInput;

    @FindBy(css = "input[id*='date-from']")
    private WebElement dateSearchFromInput;

    @FindBy(css = "input[id*='date-to']")
    private WebElement dateSearchToInput;

    public void clickOnSearchButtonFromResultsList() {
        element(searchButtonFromResultsList).waitUntilVisible();
        element(searchButtonFromResultsList).click();
    }

    public void inputModifierField(String userName) {
        element(modifierField).waitUntilVisible();
        element(modifierField).type(userName);
    }

    public void inputNameField(String fileName) {
        element(nameField).waitUntilVisible();
        element(nameField).type(fileName);
    }

    public boolean checkIfDocumentIsPresentInResultsList(String docName) {
        boolean hasMorePages = true;
        boolean foundDocument = false;
        while (hasMorePages && !foundDocument) {
            foundDocument = checkIfElementWithSpecifiedTextExistsInList(
                    By.cssSelector("div[id*='default-results'] > table tbody.yui-dt-data tr > td:nth-child(2) > div.yui-dt-liner > h3 > a"),
                    true, false, docName);
            WebElement nextPageButton = getElementIfExists(
                    By.cssSelector("a.yui-pg-next"), Delay.SMALL,
                    TimeUnit.SECONDS);
            if (nextPageButton == null) {
                hasMorePages = false;
            } else if (!foundDocument) {
                nextPageButton.click();
            }
        }
        return foundDocument;
    }

    public void checkThatDocumentIsPresentInResultsList(String docName) {
        Assert.assertTrue(String.format(
                "The '%s' document was not found in the search results!",
                docName), checkIfDocumentIsPresentInResultsList(docName));
    }

    public void checkThatDocumentIsNotPresentInResultsList(String docName) {
        Assert.assertFalse(
                String.format(
                        "The '%s' document should not have been found in the search results!",
                        docName),
                checkIfDocumentIsPresentInResultsList(docName));
    }

    public void checkTheNumberOfSearchResults(String number) {
        WebElement resultsNumber = getDriver().findElement(
                By.cssSelector("div.search-info"));
        Assert.assertTrue("The number is not correcr", resultsNumber.getText()
                .contains(number));
    }

    public void clickOnMimetype() {
        element(mimeTypeDropdown).waitUntilVisible();
        element(mimeTypeDropdown).sendKeys("");
        element(mimeTypeDropdown).click();
        waitABit(3000);
    }

    public void selectMimeType(String fileType) {
        WebElement mimeTypeDropdown = getDriver().findElement(
                By.cssSelector("div[class*='set']> div:nth-child(4) > select"));
        mimeTypeDropdown.click();
        $(mimeTypeDropdown).selectByVisibleText(fileType);
        // selectDesiredDropdownOption(
        // By.cssSelector("div[class*='set']> div:nth-child(4) > select"),
        // true, fileType);
    }

    public void insertSearchKeyword(String keyword) {
        keywordInput.clear();
        keywordInput.sendKeys(keyword);
    }

    public void insertAdvancedKeyword(String keyword) {
        advancedKeywordInput.clear();
        advancedKeywordInput.sendKeys(keyword);
    }

    public void insertDateSearchFrom(String dateFrom) {
        dateSearchFromInput.clear();
        dateSearchFromInput.sendKeys(dateFrom);
    }

    public void insertDateSearchTo(String dateTo) {
        dateSearchToInput.clear();
        dateSearchToInput.sendKeys(dateTo);
    }
}
