package a.steps.alfresco;

import a.tools.alfresco.AbstractJBSteps;
import a.tools.alfresco.FileUtils;
import a.tools.alfresco.MailUtils;
import a.tools.alfresco.StringUtils;
import a.tools.alfresco.email.EmailHandler;

public class AlfrescoMiscJBSteps extends AbstractJBSteps {

    public void checkEmailContainsTerms(String emailAddress, String password,
            String key, String terms) {
        EmailHandler emailHandler = new EmailHandler(emailAddress, password);
        String emailMessage = emailHandler.getMail(key, true);
        //		FileUtils.writeToFile("emailMessage", emailMessage);
        StringUtils.verifyTextContainsTerms(emailMessage, true,
                getVarargs(terms));
    }

    public void openLinkFromEmailContainingTerms(String linkIdentifiers, String emailAddress, String password,
            String key, String terms) {
        EmailHandler emailHandler = new EmailHandler(emailAddress, password);
        String emailMessage = emailHandler.getMail(key, false);
        //		FileUtils.writeToFile("emailMessage.txt", emailMessage);
        StringUtils.verifyTextContainsTerms(emailMessage, false,
                getVarargs(terms, ", "));
        String link = MailUtils.extractURLContainingKeysFromString(emailMessage, getVarargs(linkIdentifiers, ", "));
        alfrescoLoginSteps.navigateToUrl(link);
    }

    public void navigateToUrl(String url) {
        alfrescoLoginSteps.getDriver().get(url);
    }

    public void deleteFilesFromDownloadsFolder() {
        FileUtils
                .cleanDirectory(FileUtils.getCurrentUserPath() + "\\Downloads");
    }

    public void deleteFilesFromDownloadsFolder(String searchedTerms) {
        FileUtils.deleteFilesContainingStringsInNameFromDirectory(
                FileUtils.getCurrentUserPath() + "\\Downloads",
                getVarargs(searchedTerms));
    }

    public void checkIfTheFileHasBeenSuccessfullyDownloaded(
            String fileIdentifiers) {
        alfrescoCreateSiteSteps.waitABit(10000);
        FileUtils.searchFileRecursively(
                FileUtils.getCurrentUserPath() + "\\Downloads",
                new String[] { "zip", "xml", "doc", "xlsx" }, false,
                getVarargs(fileIdentifiers)).get(0);
    }

    public void downloadFileInFirefox() {
        if (System.getProperty("webdriver.driver").contains("firefox")) {
        	//not implemented
            alfrescoDocumentLibrarySteps.chooseToSaveFileInBrowserPopup();
        }
    }

    public void downloadFileInFirefox(String name) {
        if (System.getProperty("webdriver.driver").contains("firefox")) {
        	//not implemented
            alfrescoDocumentLibrarySteps.chooseToSaveFileInBrowserPopup();
        }
    }
}
