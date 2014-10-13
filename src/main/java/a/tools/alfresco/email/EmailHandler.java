package a.tools.alfresco.email;

import java.util.Properties;

import javax.mail.*;

import a.tools.alfresco.MailUtils;

public class EmailHandler {

    private EmailProviderModel emailProviderModel;

    //private Session session;

    public EmailHandler(EmailProviderModel emailProviderModel) {
        this.emailProviderModel = emailProviderModel;
        init();
    }

    public EmailHandler(String emailAccount, String password) {
        this.emailProviderModel = new EmailProviderModel(emailAccount, password);
        init();
    }

    private void init() {
        Properties props = new Properties();
        //session = Session.getDefaultInstance(props, null);
        Session.getDefaultInstance(props, null);
    }

    public String getEmailAddress(String username) {
        return (username + emailProviderModel.getEmailAccount().substring(
                emailProviderModel.getEmailAccount().indexOf("@"),
                emailProviderModel.getEmailAccount().length()));
    }

    public String getMail(String key, boolean deleteAfter) {
        return MailUtils.getMail(key, emailProviderModel, deleteAfter);
    }

    public String getEmailSingleRetryWithoutDelete(String key) {
        return MailUtils.getMailSingleRetry(key, emailProviderModel, false);
    }

    // public String getMail(String key) {
    // return MailUtils.getMail(session, key,
    // emailProviderModel, false);
    // }
    //
    // public String getEmailSingleRetryWithoutDelete(
    // String key) {
    // return MailUtils.getMailSingleRetry(session, key,
    // emailProviderModel, false);
    // }
}
