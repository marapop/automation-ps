package a.pages.alfresco;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;

import a.tools.alfresco.AbstractPage;
import a.tools.alfresco.StringUtils;

public class AlfrescoSitePage extends AbstractPage {
    public AlfrescoSitePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.navigation-menu.horizontal-widget > div.alf-menu-bar > div.dijitMenuPassive.dijitMenuBar > div > span.alf-menu-bar-label-node > a")
    private List<WebElement> navigationItemsList;

    @FindBy(css = "div[id*='activityList']")
    private WebElement siteActivitiesSection;

    @FindBy(css = "span[id*='customise-site'] > span > button[id*='save-button-button']")
    private WebElement customizeSiteOkButton;

    public void selectSiteNavigationItem(String itemTitle) {
        boolean foundItem = false;
        for (WebElement navigationItem : navigationItemsList) {
            if (navigationItem.getText().contains(itemTitle)) {
                foundItem = true;
                navigationItem.click();
                break;
            }
        }
        Assert.assertTrue("The '" + itemTitle
                + "' site navigation item was not found!", foundItem);
    }

    public boolean checkIfTheDocumentActionIsPresent(String itemTitle) {
        for (WebElement navigationItem : navigationItemsList) {
            if (navigationItem.getText().contains(itemTitle)) {
                return true;
            }
        }
        return false;
    }

    public void checkThatSiteNavigationItemIsPresent(String itemTitle) {
        Assert.assertTrue("The '" + itemTitle
                + "' site navigation item was not found!",
                checkIfTheDocumentActionIsPresent(itemTitle));
    }

    public void checkThatSiteNavigationItemIsNotPresent(String itemTitle) {
        Assert.assertFalse("The '" + itemTitle
                + "' site navigation item was not found!",
                checkIfTheDocumentActionIsPresent(itemTitle));
    }

    public void checkActivitiesNotification(String... terms) {
        element(siteActivitiesSection).waitUntilVisible();

        List<WebElement> activitiesList = siteActivitiesSection.findElements(By
                .cssSelector("div[class*='activity']"));
        boolean foundTerms = false;
        for (WebElement activity : activitiesList) {
            if (StringUtils.checkIfTextContainsTerms(activity.getText(), true,
                    terms)) {
                foundTerms = true;
                break;
            }
        }
        Assert.assertTrue(
                String.format(
                        "No activity containing the following terms was found: %s",
                        StringUtils
                                .getConcatenatedStringRepresentationOfTheElementsOfAnArray(
                                        "", terms)), foundTerms);
    }

    public void clickOnSiteActionButton(String... labels) {
        getDriver()
                .findElement(
                        By.cssSelector("div.title-menu.horizontal-widget span.alf-menu-arrow"))
                .click();
        // if (labels.length > 0)
        List<WebElement> optionsTables = getDriver().findElements(
                By.cssSelector("div.alf-menu-groups"));
        WebElement optionsTable = optionsTables.get(optionsTables.size() - 1);
        getElementWithSpecifiedTextFromListInsideParentElement(
                optionsTable,
                By.cssSelector("table.dijit.dijitMenu.dijitMenuPassive.dijitReset.dijitMenuTable.alf-dropdown-menu td.dijitReset.dijitMenuItemLabel"),
                false, true, labels[0]).click();
    }

    public void dragAvailableSitePageToCurrentSitePages(String pageTitle) {
        WebElement availableSitePage = getElementWithSpecifiedTextFromList(
                By.cssSelector("div.available-pages > ul.page-list > li"),
                false, false, pageTitle).findElement(By.tagName("img"));
        WebElement currentSitePages = getDriver().findElement(
                By.cssSelector("div.current-pages > ul.page-list"));
        Actions action = new Actions(getDriver());
        action.dragAndDrop(availableSitePage, currentSitePages).build()
                .perform();
    }

    public void clickOnCustomizeSiteOkButton() {
        customizeSiteOkButton.click();
    }

    public void clickOnTaskInfoLink() {
        WebElement taskInfoLink = getDriver().findElement(
                By.linkText("Task Info"));
        taskInfoLink.click();
    }

    public void clickOnLifeCycleStatusReportLink() {
        WebElement statusReportLink = getDriver().findElement(
                By.linkText("Lifecycle Status Report"));
        statusReportLink.click();
        waitABit(3000);
    }

    public WebElement getTaskInfoRow(String... taskSubject) {
        return getElementWithSpecifiedTextInsideElementFromList(
                By.cssSelector("div.grid.yui-dt > table > tbody.yui-dt-data > tr"),
                By.cssSelector("td[class*='yui-dt-col-assoc_wcc_workflowSubject'] div"),
                false, true, taskSubject);
    }

    public void checkThatDocumentIsPresentInSiteContentList(String docName) {
        waitABit(5000);
        WebElement document = getElementWithSpecifiedTextFromList(
                By.cssSelector(".dashlet.docsummary div[class*='body scrollableList'] tbody[class*='data'] h3 > a"),
                true, false, docName);
        Assert.assertTrue("The document was not found!", document.getText()
                .contains(docName));
    }

    public void checkDocumentStatusInSiteContentList(String docName,
            String actionName, String userName) {
        waitABit(5000);
        WebElement document = getElementWithSpecifiedTextFromList(
                By.cssSelector(".dashlet.docsummary div[class*='body scrollableList'] tbody[class*='data'] h3 > a"),
                true, false, docName);
        if (document.getText().contains(docName)) {
            WebElement action = getElementWithSpecifiedTextFromList(
                    By.cssSelector(".dashlet.docsummary div[class*='body scrollableList'] tbody[class*='data'] span[class*='item']"),
                    true, false, actionName);
            if (action.getText().contains(actionName)) {
                WebElement username = getElementWithSpecifiedTextFromList(
                        By.cssSelector(".dashlet.docsummary div[class*='body scrollableList'] tbody[class*='data'] span[class*='item'] a"),
                        true, false, userName);
                Assert.assertTrue("The action was not found!", username
                        .getText().contains(userName));
            }
        }
        Assert.assertTrue("The document was not found!", document.getText()
                .contains(docName));
    }

    public void clickOnExportAsXlsButton() {
        WebElement exportAsXlsButton = getDriver().findElement(
                By.cssSelector("span[id*='exportCsvButton'] button"));
        element(exportAsXlsButton).waitUntilVisible();
        element(exportAsXlsButton).click();
    }

    public WebElement getFileInfoRow(String... fileName) {
        return getElementWithSpecifiedTextInsideElementFromList(
                By.cssSelector("div.grid.yui-dt > table > tbody.yui-dt-data > tr"),
                By.cssSelector("td[class*='statusDocumentName'] div"), false,
                true, fileName);
    }
}
