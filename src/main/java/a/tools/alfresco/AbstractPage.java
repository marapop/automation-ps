package a.tools.alfresco;

import java.awt.AWTException;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

@SuppressWarnings("deprecation")
public class AbstractPage extends PageObject {

    public AbstractPage(WebDriver driver) {
        super(driver);
    }
//	@FindBy(css = "div.document-metadata-header.document-details-panel h2")
	@FindBy(css="div[class*='document-actions'] h2[class*='alfresco-twister-closed']")
	private WebElement actionsDocumentArrow;
	
	@FindBy(css="div[class*='document-metadata-header'] h2[class*='alfresco-twister-closed']")
	private WebElement propertiesArrow;
	
	/**
	 * @FindBy(css = "div.folder-actions.folder-details-panel h2") 
	 * -in case that asset folder expand for properties wont work
	 */
	@FindBy(id = "template_x002e_folder-actions_x002e_folder-details_x0023_default-heading")
//	@FindBy(id = "template_x002e_document-metadata_x002e_document-details_x0023_default-heading")
	private WebElement actionsFolderArrow;
	
    public void verifyNotificationMessage(String... message) {
        // waitForAllStringsToAppear(By.cssSelector("div#message"),
        // Delay.MEDIUM,
        // message);
        // boolean success =
        // waitUntilElementAttributeContainsTextOrElementNotPresent(
        // By.cssSelector("div#message_c"), "class", "yui-overlay-hidden",
        // Delay.MEDIUM);
        // Assert.assertTrue("The notification message did not disappear!",
        // success);
        waitABit(5000);
    }


	public void verifyPopupMessage(String message) {
        WebElement popupMessageContainer = getDriver().findElement(
                By.cssSelector("div#prompt > div.bd"));
        String popupMessage = popupMessageContainer.getText();
        Assert.assertTrue(String.format(
                "The popup message should be '%s' and it is '%s'!", message,
                popupMessage), popupMessage.contains(message));
    }

    // global methods comes here to be accesible for all page classes the will
    // extend this class

    public void goBack() {
        getDriver().navigate().back();
    }

    public void scrollToPageTop() {
        evaluateJavascript("window.scrollTo(document.body.scrollHeight,0);");
    }

    public void scrollPageDown() {
        getDriver().switchTo().defaultContent();
        getDriver().findElement(By.cssSelector("body"))
                .sendKeys(Keys.PAGE_DOWN);
    }

    public void scrollPageDown(By by, int times) {
        WebElement element = getDriver().findElement(by);
        for (int i = 0; i < times; i++) {
            element.sendKeys(Keys.PAGE_DOWN);
        }
    }

    public static void scrollPageDown(WebElement element, int times) {
        for (int i = 0; i < times; i++) {
            element.sendKeys(Keys.PAGE_DOWN);
        }
    }

    public void scrollUntilVisible(WebElement elementToScroll,
            int maxScrollCount, WebElement... elementIframes) throws Error {
        try {
            getDriver().switchTo().defaultContent();
            // we need to switch to the frames in which the element is located
            for (WebElement iframe : elementIframes) {
                getDriver().switchTo().frame(iframe);
            }
            element(elementToScroll).waitUntilVisible();
        } catch (WebDriverException e) {
            if (maxScrollCount > 0) {
                getDriver().switchTo().defaultContent();
                evaluateJavascript("window.scrollBy(0,50);");
                scrollUntilVisible(elementToScroll, --maxScrollCount);
            } else {
                throw new Error("Couldn't scroll to the requested element");
            }
        }
    }

    public void jQueryNoConflict() {
        // evaluateJavascript("jQuery.noConflict();");
    }

    public void switchToDefaultContent(WebElement element) {
        getDriver().switchTo().defaultContent();
        element(element).waitUntilVisible();
    }

    public void mouseOver(WebElement element) {
        Actions mouseOver = new Actions(getDriver());
        mouseOver.moveToElement(element).build().perform();
    }

    private void implicitlyWait(long time) {
        getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void implicitlyWaitDefault() {
        implicitlyWait(Delay.DEFAULT);
    }

    public void implicitlyWaitSmall() {
        implicitlyWait(Delay.SMALL);
    }

    public void implicitlyWaitReasonable() {
        implicitlyWait(Delay.REASONABLE);
    }

    public void implicitlyWaitExtraSmall() {
        implicitlyWait(Delay.EXTRA_SMALL);
    }

    public void implicitlyWaitMedium() {
        implicitlyWait(Delay.MEDIUM);
    }

    public void implicitlyWaitLarge() {
        implicitlyWait(Delay.LARGE);
    }

    public void implicitlyWaitExtraLarge() {
        implicitlyWait(Delay.EXTRA_LARGE);
    }

    /**
     * This method retrieves the text of a hidden element.
     * 
     * @param cssElementSelector
     * @param elementIframes
     * @return
     */
    public String getHiddenElementText(String cssElementSelector,
            String... elementIframes) {
        WebElement elem = makeHiddenElementVisible(cssElementSelector,
                elementIframes);
        String elementText = elem.getText();
        Assert.assertNotNull("Element text is null!", elementText);
        return elementText;
    }

    /**
     * This method sets the style of a hidden element to visible.
     * 
     * @param cssElementSelector
     * @param elementIframes
     * @return
     */
    public WebElement makeHiddenElementVisible(String cssElementSelector,
            String... elementIframes) {
        getDriver().switchTo().defaultContent();
        // we need to switch to the frames in which the element is located
        for (String iframe : elementIframes) {
            getDriver().switchTo().frame(iframe);
        }
        evaluateJavascript(("jQuery('" + cssElementSelector + "').css('display','inline');"));
        WebElement elem = getDriver().findElement(
                By.cssSelector(cssElementSelector));
        element(elem).waitUntilVisible();
        return elem;
    }

    /**
     * This method verifies that an alert message is present and if so, it accepts the alert condition
     */
    public void verifyThatAlertIsPresentAndAccept() {
        implicitlyWaitSmall();
        try {
            waitFor(ExpectedConditions.alertIsPresent());
            getDriver().switchTo().alert().accept();
        } catch (NoAlertPresentException Ex) {
            Assert.fail("Alert is not present!");
        }
        implicitlyWaitDefault();
    }

    public void verifyAlertText(String expectedText) {
        String alertMessage = null;
        try {
            waitFor(ExpectedConditions.alertIsPresent());
            alertMessage = getDriver().switchTo().alert().getText();
        } catch (NoAlertPresentException Ex) {
            Assert.fail("Alert is not present!");
        }
        Assert.assertTrue("Alert message is '" + alertMessage
                + "' and it should be '" + expectedText + "'!",
                alertMessage.equals(expectedText));
    }

    /**
     * This method tries to find the desired element for 'noOfRetries' times
     * 
     * @param by
     * @param waitSeconds
     */
    public WebElement waitUntilElementExists(By by, int waitSeconds) {
        getDriver().manage().timeouts()
                .implicitlyWait(Delay.EXTRA_SMALL_MS, TimeUnit.MILLISECONDS);
        WebElement element = null;
        for (int i = 0; i < waitSeconds * 2; i++) {
            try {
                element = getDriver().findElement(by);
                implicitlyWaitDefault();
                return element;
            } catch (Exception e) {
                // no need to do anything
            }
        }
        Assert.fail(String.format(
                "The searched element '%s' was not found after %d seconds!",
                by.toString(), waitSeconds));
        return element;
    }

    public void waitForAllStringsToAppear(By by, int waitingTime,
            String... terms) {
        boolean foundElement = false;
        boolean foundTerms = false;
        String notFoundString = "";
        int count = 0;
        while (!foundTerms && count < waitingTime * 10) {
            count++;
            WebElement container = getElementIfExists(by, 100,
                    TimeUnit.MILLISECONDS);
            if (container != null) {
                foundElement = true;
                String content = container.getText();
                foundTerms = true;
                for (String term : terms) {
                    if (!content.contains(term)) {
                        notFoundString = term;
                        foundTerms = false;
                        waitABit(100);
                        break;
                    }
                }
            } else {
                if (foundElement) {
                    Assert.fail(String.format(
                            "The '%s' element is not present anymore!",
                            by.toString()));
                }
            }
        }
        Assert.assertTrue(String.format(
                "The '%s' term was not found in the element after %d seconds!",
                notFoundString, waitingTime), foundTerms);
    }

    public boolean checkIfAllStringsAppear(By by, int waitingTime,
            String... terms) {
        boolean foundElement = false;
        boolean foundTerms = false;
        int count = 0;
        while (!foundTerms && count < waitingTime * 10) {
            count++;
            WebElement container = getElementIfExists(by, 100,
                    TimeUnit.MILLISECONDS);
            if (container != null) {
                foundElement = true;
                String content = container.getText();
                foundTerms = true;
                for (String term : terms) {
                    if (!content.contains(term)) {
                        foundTerms = false;
                        waitABit(100);
                        break;
                    }
                }
            } else {
                if (foundElement) {
                    Assert.fail(String.format(
                            "The '%s' element is not present anymore!",
                            by.toString()));
                }
            }
        }
        return foundTerms;
    }

    public boolean waitUntilElementTextStartsWithGivenTextOrElementInvisible(
            By by, String text, int waitSeconds) {
        for (int i = 0; i < waitSeconds * 10; i++) {
            WebElement element = getElementIfExists(by, 100,
                    TimeUnit.MILLISECONDS);
            getDriver().manage().timeouts()
                    .implicitlyWait(100, TimeUnit.MICROSECONDS);
            if (element != null) {
                if ($(element).isVisible()) {
                    String elementText = element.getText();
                    if (elementText.startsWith(text)) {
                        return true;
                    }
                    waitABit(100);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean waitUntilElementAttributeContainsTextOrElementNotPresent(
            By by, String attribute, String text, int waitSeconds) {
        for (int i = 0; i < waitSeconds * 10; i++) {
            WebElement element = getElementIfExists(by, 100,
                    TimeUnit.MILLISECONDS);
            if (element != null) {
                String attributeValue = element.getAttribute(attribute);
                boolean contains = attributeValue.contains(text);
                if (!contains)
                    waitABit(100);
                else
                    return true;
            } else {
                return true;
            }
        }
        return false;
    }

    public WebElement waitUntilElementAttributeContainsText(By by,
            String attribute, String text, int waitSeconds) {
        WebElement element = getDriver().findElement(by);
        String attributeValue = element.getAttribute(attribute);
        int i = 0;
        while (i < waitSeconds * 10 && !attributeValue.contains(text)) {
            i++;
            element = getDriver().findElement(by);
            attributeValue = element.getAttribute(attribute);
            waitABit(100);
        }
        Assert.assertTrue("The element's '" + attribute + "' attribute is '"
                + attributeValue + "' and after " + waitSeconds
                + " seconds it should contain '" + text + "'!", element != null);
        return element;
    }

    public WebElement waitUntilElementAttributeDoesntContainText(By by,
            String attribute, String text, int waitSeconds) {
        WebElement element = getDriver().findElement(by);
        String attributeValue = element.getAttribute(attribute);
        if (!attributeValue.contains(text))
            waitABit(1000);
        int i = 0;
        while (i < waitSeconds * 10 && attributeValue.contains(text)) {
            i++;
            element = getDriver().findElement(by);
            attributeValue = element.getAttribute(attribute);
            waitABit(100);
        }
        Assert.assertTrue("The element's '" + attribute + "' attribute is '"
                + attributeValue + "' and after " + waitSeconds
                + " seconds it should not contain '" + text + "'!",
                element != null);
        return element;
    }

    public WebElement waitUntilElementAttributeDoesntContainText(
            WebElement element, String attribute, String text, int waitSeconds) {
        String attributeValue = element.getAttribute(attribute);
        if (!attributeValue.contains(text))
            waitABit(1000);
        int i = 0;
        while (i < waitSeconds * 10 && attributeValue.contains(text)) {
            i++;
            attributeValue = element.getAttribute(attribute);
            waitABit(100);
        }
        Assert.assertTrue("The element's '" + attribute + "' attribute is '"
                + attributeValue + "' and after " + waitSeconds
                + " seconds it should not contain '" + text + "'!",
                element != null);
        return element;
    }

    public WebElement waitUntilLastElementAttributeContainsText(By by,
            String attribute, String text, int waitSeconds) {
        implicitlyWaitSmall();
        List<WebElement> elementsList = getDriver().findElements(by);
        Assert.assertTrue("No matching elements were found!",
                elementsList.size() > 0);
        WebElement element = elementsList.get(elementsList.size() - 1);
        String attributeValue = element.getAttribute(attribute);
        if (attributeValue.contains(text))
            waitABit(1000);
        int i = 0;
        while (i < waitSeconds * 10 && !attributeValue.contains(text)) {
            i++;
            elementsList = getDriver().findElements(by);
            element = elementsList.get(elementsList.size() - 1);
            attributeValue = element.getAttribute(attribute);
            waitABit(100);
        }
        Assert.assertTrue("The element's '" + attribute + "' attribute is '"
                + attributeValue + "' and after " + waitSeconds
                + " seconds it should contain '" + text + "'!", element != null);
        implicitlyWaitDefault();
        return element;
    }

    /**
     * This method tries to find the desired element for @noOfRetries times
     * 
     * @param by
     * @param waitTimeMS
     * @param noOfRetries
     */
    public void waitUntilElementDoesntExist(By by, int waitTimeMS,
            int noOfRetries) {
        getDriver().manage().timeouts()
                .implicitlyWait(waitTimeMS, TimeUnit.MICROSECONDS);
        boolean elementPresent = false;
        for (int i = 0; i < noOfRetries; i++) {
            try {
                waitABit(waitTimeMS);
                getDriver().findElement(by);
                elementPresent = true;
            } catch (Exception e) {
                implicitlyWaitDefault();
                elementPresent = false;
                break;
            }
        }
        Assert.assertFalse("The searched element did not disappear after "
                + waitTimeMS * noOfRetries + " seconds!", elementPresent);
        implicitlyWaitDefault();
    }

    public void checkThatElementDoesntExist(By by) {
        boolean elementPresent = false;
        try {
            getDriver().findElement(by);
            elementPresent = true;
        } catch (Exception e) {
            elementPresent = false;
        }
        Assert.assertFalse("The element should not be present!", elementPresent);
    }

    /**
     * This method tries to find the desired element for 'waitSeconds' times
     * 
     * @param by
     * @param waitSeconds
     */
    public void waitUntilElementDoesntExist(By by, int waitSeconds) {
        waitUntilElementDoesntExist(by, 100, waitSeconds * 10);
    }

    public WebElement findAndWaitForElementToBePresent(final By locator,
            int timeoutSeconds) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .pollingEvery(Delay.EXTRA_SMALL, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement searchedElement = wait
                .until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(locator);
                    }
                });
        return searchedElement;
    }

    public boolean waitUntilElementNotPresentOrInvisible(By locator,
            int timeoutSeconds) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .pollingEvery(Delay.EXTRA_SMALL, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        boolean elementNotPresent = wait.until(ExpectedConditions
                .invisibilityOfElementLocated(locator));
        return elementNotPresent;
    }

    // public WebElement getElementWhenVisible(By locator, int timeoutSeconds) {
    // Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
    // .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
    // .pollingEvery(Delay.EXTRA_SMALL_MS, TimeUnit.MILLISECONDS)
    // .ignoring(NoSuchElementException.class);
    //
    // WebElement element = wait.until(ExpectedConditions
    // .visibilityOfElementLocated(locator));
    // return element;
    // }

    public WebElement getElementWhenVisible(By by, int timeoutSeconds) {
        getDriver().manage().timeouts()
                .implicitlyWait(100, TimeUnit.MILLISECONDS);
        WebElement element = null;
        for (int i = 0; i < timeoutSeconds * 10; i++) {
            try {
                element = getDriver().findElement(by);
                implicitlyWaitDefault();
                if ($(element).isVisible()) {
                    return element;
                }
            } catch (Exception e) {
                // no need to do anything
            }
        }
        Assert.fail(String.format(
                "The searched element '%s' was not visible after %d seconds!",
                by.toString(), timeoutSeconds));
        return element;
    }

    public <T> WebElement getElementAndWaitFor(
            ExpectedCondition<WebElement> expectedCondition, int timeoutSeconds) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .pollingEvery(Delay.EXTRA_SMALL, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        @SuppressWarnings("unchecked")
        WebElement element = (WebElement)wait
                .until((Function<? super WebDriver, T>)expectedCondition);
        return element;
    }

    public WebElement getElementWhenClickable(By locator, int timeoutSeconds) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .pollingEvery(Delay.EXTRA_SMALL, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions
                .elementToBeClickable(locator));
        return element;
    }

    public WebElement waitForElementToBeClickable(By locator, int timeoutSeconds) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(timeoutSeconds, TimeUnit.SECONDS)
                .pollingEvery(Delay.EXTRA_SMALL, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions
                .elementToBeClickable(locator));
        return element;
    }

    /**
     * Returns the list of visible text of the elements from the provided list
     * 
     * @param listOfWebElements
     * @return
     */
    public static List<String> getVisibleTextOfWebElements(
            List<WebElement> listOfWebElements) {
        List<String> listOfElementsText = new ArrayList<String>();
        for (WebElement element : listOfWebElements) {
            String elementText = element.getText().trim();
            listOfElementsText.add(elementText);
        }
        return listOfElementsText;
    }

    public List<WebElement> removeTheElementsHavingTheSpecifiedTextInAtributeFromList(
            List<WebElement> elementsList, String attribute, String text) {
        for (int i = 0; i < elementsList.size(); i++) {
            WebElement element = elementsList.get(i);
            try {
                String attributeValue = element.getAttribute(attribute);
                if (attributeValue.contains(text)) {
                    elementsList.remove(i);
                    i--;
                }
            } catch (Exception e) {
            }
        }
        return elementsList;
    }

    public void verifyTextContainsTerms(String text, boolean ignoreCase,
            String... strTerms) {
        text = StringUtils.removeNewLinesMultipleSpacesAndTabs(text);
        if (ignoreCase)
            text = text.toLowerCase();
        for (String term : strTerms) {
            if (ignoreCase)
                term = term.toLowerCase();
            Assert.assertTrue("The following term couldn't be found: " + term,
                    text.contains(term));
        }
    }

    /**
     * Selects the desired option from the provided drop-down that contains the searched terms with the possibility of choosing whether or not to ignore the
     * case.
     * 
     * @param dropdownCSSSelector
     * @param ignoreCase
     * @param searchedTerms
     */
    public void selectDesiredDropdownOption(WebElement dropdownElement,
            boolean ignoreCase, String... searchedTerms) {
        element(dropdownElement).waitUntilVisible();
        // dropdownElement.click();
        Select dropdownSelect = new Select(dropdownElement);
        boolean foundOption = false;
        for (WebElement option : dropdownSelect.getOptions()) {
            boolean matched = true;
            if (ignoreCase) {
                for (String term : searchedTerms) {
                    if (!option.getText().toLowerCase()
                            .contains(term.toLowerCase())) {
                        matched = false;
                        break;
                    }
                }
            } else {
                for (String term : searchedTerms) {
                    if (!option.getText().contains(term)) {
                        matched = false;
                        break;
                    }
                }
            }
            if (matched) {
                foundOption = true;
                option.click();
                // dropdownElement.click();
                break;
            }
        }
        Assert.assertTrue("Searched option couldn't be found!", foundOption);
    }

    /**
     * Selects the desired option from the provided drop-down that contains the searched terms with the possibility of choosing whether or not to ignore the
     * case.
     * 
     * @param by
     * @param ignoreCase
     * @param searchedTerms
     */
    public WebElement selectDesiredDropdownOption(By by, boolean ignoreCase,
            String... searchedTerms) {
        WebElement dropdownElement = getElementWhenClickable(by, Delay.LARGE);
        Select dropdownSelect = new Select(dropdownElement);
        boolean foundOption = false;
        for (WebElement option : dropdownSelect.getOptions()) {
            boolean matched = true;
            if (ignoreCase) {
                for (String term : searchedTerms) {
                    if (!option.getText().toLowerCase()
                            .contains(term.toLowerCase())) {
                        matched = false;
                        break;
                    }
                }
            } else {
                for (String term : searchedTerms) {
                    if (!option.getText().contains(term)) {
                        matched = false;
                        break;
                    }
                }
            }
            if (matched) {
                foundOption = true;
                option.click();
                break;
            }
        }
        Assert.assertTrue("Searched option couldn't be found!", foundOption);
        return dropdownElement;
    }

    public String closeNewestOpenedTab() {
        Set<String> winSet = getDriver().getWindowHandles();
        List<String> winList = new ArrayList<String>(winSet);
        String previousTab = winList.get(winList.size() - 2);
        String newTab = winList.get(winList.size() - 1);
        getDriver().switchTo().window(newTab).close();
        getDriver().switchTo().window(previousTab);
        return previousTab;
    }

    public String switchToNewestOpenedTab() {
        Set<String> winSet = getDriver().getWindowHandles();
        List<String> winList = new ArrayList<String>(winSet);
        Assert.assertTrue("There is only one tab!", winList.size() > 1);
        String previousTab = winList.get(winList.size() - 2);
        String newTab = winList.get(winList.size() - 1);
        getDriver().switchTo().window(newTab);
        getDriver().manage().window().maximize();
        return previousTab;
    }

    public String switchToNewestOpenedTabIfExists() {
        Set<String> winSet = getDriver().getWindowHandles();
        List<String> winList = new ArrayList<String>(winSet);
        String previousTab = winList
                .get(winList.size() > 2 ? winList.size() - 2 : 0);
        String newTab = winList.get(winList.size() - 1);
        getDriver().switchTo().window(newTab);
        getDriver().manage().window().maximize();
        return previousTab;
    }

    public String closeNewestOpenedTabIfExists() {
        Set<String> winSet = getDriver().getWindowHandles();
        List<String> winList = new ArrayList<String>(winSet);
        String previousTab = null;
        if (winList.size() > 1) {
            previousTab = winList.get(winList.size() - 2);
            String newTab = winList.get(winList.size() - 1);
            getDriver().switchTo().window(newTab).close();
            getDriver().switchTo().window(previousTab);
        }
        return previousTab;
    }

    // public void uploadFileUsingSikuli(String fileName) {
    // ScreenRegion desktopScreen = new DesktopScreenRegion();
    // Mouse mouse = new DesktopMouse();
    // Keyboard keyboard = new DesktopKeyboard();
    //
    // ScreenRegion uploadInput = desktopScreen.wait(new ImageTarget(
    // Images.FILE_UPLOAD_INPUT), 1000);
    //
    // mouse.click(uploadInput.getCenter());
    // keyboard.type(fileName);
    // keyboard.keyDown(KeyEvent.VK_ENTER);
    // keyboard.keyUp(KeyEvent.VK_ENTER);
    // }

    
    /**
     * Waits until the active element is visible
     */
    public void waitForActiveElementToBeVisible() {
        WebElement activeElement = getDriver().switchTo().activeElement();
        $(activeElement).waitUntilVisible();
    }

    public static void moveMouseCursorUsingRobot(int xCoord, int yCoord) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.mouseMove(xCoord, yCoord);
    }

    public static Rectangle getScreenSize() {
        Rectangle rectangle = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getMaximumWindowBounds();
        return rectangle;
    }

    public static void scrollPageUsingRobot(int direction) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.mouseWheel(direction);
    }

    public void openNewTab() {
        WebElement bodyElement = getDriver().findElement(By.tagName("body"));
        bodyElement.sendKeys(Keys.CONTROL + "t");
    }

    public void openNewTabUsingRobot() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            waitABit(3000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public String getNewHandle(Set<String> oldHandles) {
        Set<String> newHandles = getDriver().getWindowHandles();
        for (String newHandle : newHandles) {
            boolean foundHandle = false;
            for (String oldHandle : oldHandles) {
                if (newHandle.equals(oldHandle)) {
                    foundHandle = true;
                    break;
                }
            }
            if (!foundHandle)
                return newHandle;
        }
        Assert.fail("No new window handle was found!");
        return null;
    }

    public String injectAnchorTag(String id, String url) {
        return String
                .format("var anchorTag = document.createElement('a'); "
                        + "anchorTag.appendChild(document.createTextNode('nwh'));"
                        + "anchorTag.setAttribute('id', '%s');"
                        + "anchorTag.setAttribute('href', '%s');"
                        + "anchorTag.setAttribute('target', '_blank');"
                        + "anchorTag.setAttribute('style', 'display:block;');"
                        + "document.getElementsByTagName('body')[0].appendChild(anchorTag);",
                        id, url);
    }

    public String openNewWindow(String name, String url) {

        // Record old handles
        Set<String> oldHandles = getDriver().getWindowHandles();

        // Inject an anchor element
        evaluateJavascript(injectAnchorTag(name, url));

        // Click on the anchor element
        getDriver().findElement(By.id(name)).click();

        String handle = getNewHandle(oldHandles);

        return handle;
    }

    public WebElement getFirstVisibleElementFromList(By by) {
        List<WebElement> elementsList = getDriver().findElements(by);
        for (WebElement element : elementsList) {
            if ($(element).isCurrentlyVisible()) {
                return element;
            }
        }
        Assert.fail("No visible elements matching the provided selector were found!");
        return null;
    }

    public WebElement getLastVisibleElementFromList(By by) {
        List<WebElement> elementsList = getDriver().findElements(by);
        for (int i = elementsList.size() - 1; i >= 0; i--) {
            WebElement element = elementsList.get(i);
            if ($(element).isCurrentlyVisible()) {
                return element;
            }
        }
        Assert.fail("No visible elements matching the provided selector were found!");
        return null;
    }

    public List<WebElement> getVisibleElementsFromList(
            List<WebElement> elementsList) {
        implicitlyWaitSmall();
        for (int i = 0; i < elementsList.size(); i++) {
            WebElement element = elementsList.get(i);
            if (!$(element).isCurrentlyVisible()) {
                elementsList.remove(i);
                i--;
            }
        }
        implicitlyWaitDefault();
        return elementsList;
    }

    public boolean checkIfElementWithSpecifiedTextExistsInList(By by,
            boolean ignoreCase, boolean equals, String... terms) {
        implicitlyWaitReasonable();
        List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
                .findElements(by));
        for (WebElement element : elementsList) {
            String currentElementName = element.getText().trim();
            if (ignoreCase)
                currentElementName = currentElementName.toLowerCase();
            boolean matched = false;
            if (terms.length == 1) {
                if (ignoreCase)
                    matched = equals ? currentElementName.equals(terms[0]
                            .toLowerCase()) : currentElementName
                            .contains(terms[0].toLowerCase());
                else
                    matched = equals ? currentElementName.equals(terms[0])
                            : currentElementName.contains(terms[0]);
            } else
                matched = StringUtils.checkIfTextContainsTerms(
                        currentElementName, ignoreCase, terms);
            if (matched)
                return true;
        }
        return false;
    }

    public boolean checkIfElementWithSpecifiedTextInsideElementExistsInList(
            By elementsSelector, By textContainerSelector, boolean ignoreCase,
            boolean equals, String... terms) {
        implicitlyWaitSmall();
        List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
                .findElements(elementsSelector));
        for (WebElement element : elementsList) {
            String currentElementName = element
                    .findElement(textContainerSelector).getText().trim();
            if (ignoreCase)
                currentElementName = currentElementName.toLowerCase();
            boolean matched = false;
            if (terms.length == 1) {
                if (ignoreCase)
                    matched = equals ? currentElementName.equals(terms[0]
                            .toLowerCase()) : currentElementName
                            .contains(terms[0].toLowerCase());
                else
                    matched = equals ? currentElementName.equals(terms[0])
                            : currentElementName.contains(terms[0]);
            } else
                matched = StringUtils.checkIfTextContainsTerms(
                        currentElementName, ignoreCase, terms);
            if (matched)
                return true;
        }
        return false;
    }

    public WebElement getElementWithSpecifiedTextFromList(By by,
            boolean ignoreCase, boolean equals, String... terms) {
        waitUntilElementExists(by, Delay.MEDIUM);
        waitForRenderedElements(by);
        List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
                .findElements(by));
        for (WebElement element : elementsList) {
            String currentElementName = element.getText().trim();
            if (ignoreCase)
                currentElementName = currentElementName.toLowerCase();
            boolean matched = false;
            if (terms.length == 1) {
                if (ignoreCase)
                    matched = equals ? currentElementName.equals(terms[0]
                            .toLowerCase()) : currentElementName
                            .contains(terms[0].toLowerCase());
                else
                    matched = equals ? currentElementName.equals(terms[0])
                            : currentElementName.contains(terms[0]);
            } else
                matched = StringUtils.checkIfTextContainsTerms(
                        currentElementName, ignoreCase, terms);
            if (matched)
                return element;
        }
        Assert.fail("No element matching these terms: '"
                + StringUtils
                        .getConcatenatedStringRepresentationOfTheElementsOfAnArray(
                                ", ", terms) + "' was found in the list!");
        return null;
    }

    public WebElement getElementWithSpecifiedTextFromListIfExists(By by,
            boolean ignoreCase, boolean equals, String... terms) {
        waitUntilElementExists(by, Delay.MEDIUM);
        waitForRenderedElements(by);
        List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
                .findElements(by));
        for (WebElement element : elementsList) {
            String currentElementName = element.getText().trim();
            if (ignoreCase)
                currentElementName = currentElementName.toLowerCase();
            boolean matched = false;
            if (terms.length == 1) {
                if (ignoreCase)
                    matched = equals ? currentElementName.equals(terms[0]
                            .toLowerCase()) : currentElementName
                            .contains(terms[0].toLowerCase());
                else
                    matched = equals ? currentElementName.equals(terms[0])
                            : currentElementName.contains(terms[0]);
            } else
                matched = StringUtils.checkIfTextContainsTerms(
                        currentElementName, ignoreCase, terms);
            if (matched)
                return element;
        }
        return null;
    }

    public WebElement getElementWithSpecifiedTextInsideElementFromList(
            By elementsSelector, By textContainerSelector, boolean ignoreCase,
            boolean equals, String... terms) {
        waitUntilElementExists(elementsSelector, Delay.MEDIUM);
        waitForRenderedElements(elementsSelector);
        List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
                .findElements(elementsSelector));
        for (WebElement element : elementsList) {
            String currentElementName = element
                    .findElement(textContainerSelector).getText().trim();
            if (ignoreCase)
                currentElementName = currentElementName.toLowerCase();
            boolean matched = false;
            if (terms.length == 1) {
                if (ignoreCase)
                    matched = equals ? currentElementName.equals(terms[0]
                            .toLowerCase()) : currentElementName
                            .contains(terms[0].toLowerCase());
                else
                    matched = equals ? currentElementName.equals(terms[0])
                            : currentElementName.contains(terms[0]);
            } else
                matched = StringUtils.checkIfTextContainsTerms(
                        currentElementName, ignoreCase, terms);
            if (matched)
                return element;
        }
        Assert.fail("No element matching these terms: '"
                + StringUtils
                        .getConcatenatedStringRepresentationOfTheElementsOfAnArray(
                                ", ", terms) + "' was found in the list!");
        return null;
    }

    public WebElement getElementWithSpecifiedTextInsideElementFromListIfExists(
            By elementsSelector, By textContainerSelector, boolean ignoreCase,
            boolean equals, String... terms) {
        // waitABit(5000);
        // waitUntilElementExists(elementsSelector, Delay.REASONABLE);
        // waitForRenderedElements(elementsSelector);
        implicitlyWaitReasonable();
        List<WebElement> elementsList = getVisibleElementsFromList(getDriver()
                .findElements(elementsSelector));
        for (WebElement element : elementsList) {
            implicitlyWaitSmall();
            try {
                String currentElementName = element
                        .findElement(textContainerSelector).getText().trim();
                if (ignoreCase)
                    currentElementName = currentElementName.toLowerCase();
                boolean matched = false;
                if (terms.length == 1) {
                    if (ignoreCase)
                        matched = equals ? currentElementName.equals(terms[0]
                                .toLowerCase()) : currentElementName
                                .contains(terms[0].toLowerCase());
                    else
                        matched = equals ? currentElementName.equals(terms[0])
                                : currentElementName.contains(terms[0]);
                } else
                    matched = StringUtils.checkIfTextContainsTerms(
                            currentElementName, ignoreCase, terms);
                if (matched) {
                    implicitlyWaitDefault();
                    return element;
                }
            } catch (Exception e) {
                // no need to do anything if element is not found
            }
        }
        return null;
    }

    public WebElement getElementWithSpecifiedTextFromListInsideParentElement(
            WebElement parent, By by, boolean ignoreCase, boolean equals,
            String... terms) {
        waitUntilElementExists(by, Delay.MEDIUM);
        waitForRenderedElements(by);
        List<WebElement> elementsList = parent.findElements(by);
        elementsList = getVisibleElementsFromList(elementsList);
        for (WebElement element : elementsList) {
            String currentElementName = element.getText().trim();
            if (ignoreCase)
                currentElementName = currentElementName.toLowerCase();
            boolean matched = false;
            if (terms.length == 1) {
                if (ignoreCase)
                    matched = equals ? currentElementName.equals(terms[0]
                            .toLowerCase()) : currentElementName
                            .contains(terms[0].toLowerCase());
                else
                    matched = equals ? currentElementName.equals(terms[0])
                            : currentElementName.contains(terms[0]);
            } else
                matched = StringUtils.checkIfTextContainsTerms(
                        currentElementName, ignoreCase, terms);
            if (matched)
                return element;
        }
        Assert.fail("No element matching these terms: '"
                + StringUtils
                        .getConcatenatedStringRepresentationOfTheElementsOfAnArray(
                                ", ", terms) + "' was found in the list!");
        return null;
    }

    /**
     * Retrieves the text from the page
     * 
     * @return
     */
    public String getPageContent() {
        WebElement pageBody = getDriver().findElement(By.tagName("body"));
        element(pageBody).waitUntilVisible();
        return pageBody.getText();
    }

    public WebElement getElementIfExists(By by, int waitingTime,
            TimeUnit timeUnit) {
        getDriver().manage().timeouts().implicitlyWait(waitingTime, timeUnit);
        // List<WebElement> elements = getDriver().findElements(by);
        // if (elements.size() > 0) {
        // WebElement element = elements.get(0);
        // implicitlyWaitDefault();
        // return element;
        // } else {
        // implicitlyWaitDefault();
        // return null;
        // }
        try {
            WebElement element = getDriver().findElement(by);
            implicitlyWaitDefault();
            return element;
        } catch (Exception e) {
            implicitlyWaitDefault();
            return null;
        }
    }

    public boolean checkIfElementExists(By by) {
        implicitlyWaitSmall();
        try {
            getDriver().findElement(by);
            implicitlyWaitDefault();
            return true;
        } catch (Exception e) {
            implicitlyWaitDefault();
            return false;
        }
    }

    public boolean clickOnButtonIfExists(By by) {
        implicitlyWaitSmall();
        try {
            getDriver().findElement(by).click();
            implicitlyWaitDefault();
            return true;
        } catch (Exception e) {
            implicitlyWaitDefault();
            return false;
        }
    }

	public void expandActionsFields() {
		waitABit(Constants.WAIT_TIME);
		refreshPage();
		waitABit(Constants.WAIT_TIME);
	
		if (element(actionsDocumentArrow).isVisible()&& actionsDocumentArrow.getText().contains(Constants.DOCUMENT_ACTIONS))
		 {
			System.out.println("!! Expanding the " + actionsDocumentArrow.getText());
			actionsDocumentArrow.click();
		}
	}
	
	public void expandFolderActionsFields() {
		waitABit(Constants.WAIT_TIME);
		refreshPage();
		waitABit(Constants.WAIT_TIME);
		element(actionsFolderArrow).waitUntilVisible();
		if (actionsFolderArrow.getAttribute("class").contains("closed")) {
			actionsFolderArrow.click();
		}
	}
	
	public void expandPropertiesFields() {
		waitABit(Constants.WAIT_TIME);
		refreshPage();
		waitABit(Constants.WAIT_TIME);
		if (element(propertiesArrow).isVisible()&& propertiesArrow.getText().contains(Constants.PROPERTIES))
			 {
				System.out.println("!! Expanding the " + propertiesArrow.getText());
				propertiesArrow.click();
			}
	}

	public void refreshPage() {
		getDriver().navigate().refresh();
	}
	
	public void disableFlash() {
		String script = "Alfresco.util.setVar(\"noflash\", true)";
		evaluateJavascript(script);
	}

	public void scrollToPageBottom() {
		evaluateJavascript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public void createSiteModal() {
		evaluateJavascript("Alfresco.util.ComponentManager.get('global_x002e_header_x0023_default-app_sites').showCreateSite(); return false;");
	}

	public void searchSiteModal() {
		final String baseURL = System.getProperty(Constants.URL_PROPERTY);
		getDriver().get(baseURL + Constants.SEARCH_SITE_URL_PREFIX);
	}

	public void modifyElementProperty(String locator, String atributeName,
			String atributeValue) {
		evaluateJavascript(("jQuery('" + locator + "').css('" + atributeName
				+ "','" + atributeValue + "');"));
	}

	public void elementFocus(String element) {
		evaluateJavascript("var element =jQuery(' " + element
				+ " ');element.focus();");
	}

	public void elementjQueryClick(String element) {
		evaluateJavascript("var dd =jQuery(' " + element
				+ " ').eq(0);dd.click(); ");
	}

	public void elementjQueryMouseOver(String element) {
		evaluateJavascript("var dd =jQuery(' " + element
				+ " ').eq(0);dd.mouseover(); ");
		waitABit(Constants.WAIT_TIME_SHORT);
	}

	public boolean compareDatesInDifferentFormat(String date1AsString,
			String pattern1, String date2AsString, String pattern2) {

		Date date1 = null;
		Date date2 = null;
		try {
			date1 = new SimpleDateFormat(pattern1).parse(date1AsString);
			date2 = new SimpleDateFormat(pattern2).parse(date2AsString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (date1 == null || date2 == null) {
			return false;
		}
		return date1.equals(date2);
	}
}
