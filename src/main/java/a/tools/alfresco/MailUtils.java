package a.tools.alfresco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import junit.framework.Assert;
import a.tools.alfresco.email.EmailProviderModel;

import com.sun.mail.imap.protocol.FLAGS;

@SuppressWarnings("deprecation")
public class MailUtils {

    public static String getMail(Session session, String searchKey,
            EmailProviderModel emailProviderModel, boolean deleteAfter,
            int waitCycle) {
        String returnMessage = null;
        try {
            System.out.println(" Connect to server: "
                    + emailProviderModel.getServerAddress());
            System.out.println("Looking for email for: "
                    + emailProviderModel.getEmailAccount() + " with key: "
                    + searchKey);

            Store store = session
                    .getStore(emailProviderModel.getProtocolType());
            store.connect(emailProviderModel.getServerAddress(),
                    Integer.parseInt(emailProviderModel.getServerPort()),
                    emailProviderModel.getEmailAccount(),
                    emailProviderModel.getPassword());
            System.out.println(" Connected to server: "
                    + emailProviderModel.getServerAddress()
                    + ". Getting inbox...");
            Folder inbox = store.getFolder("Inbox");

            if (deleteAfter) {
                inbox.open(Folder.READ_WRITE);
            } else {
                inbox.open(Folder.READ_ONLY);
            }
            System.out.println("Inbox opened...");
            int retry = 0;
            do {
                System.out.println("number: " + inbox.getMessageCount());
                returnMessage = searchForMail(inbox.getMessages(),
                        emailProviderModel.getEmailAccount(), searchKey,
                        deleteAfter);
                if (returnMessage == null) {
                    try {
                        Thread.sleep(Constants.EMAIL_WAIT_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("retries for checking mail : " + (++retry)
                        + " server/address: "
                        + emailProviderModel.getServerAddress() + "/"
                        + emailProviderModel.getEmailAccount());
            } while ((returnMessage == null) && (retry < waitCycle));
            inbox.close(deleteAfter);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        org.junit.Assert
                .assertTrue(
                        String.format(
                                "No email containing '%s' was found in the inbox folder for the '%s' email address!",
                                searchKey, emailProviderModel.getEmailAccount()),
                        returnMessage != null);
        return returnMessage;
    }

    public static String getMail(String searchKey,
            EmailProviderModel emailProviderModel, boolean deleteAfter,
            int waitCycle) {
        String returnMessage = null;
        try {
            System.out.println(" Connect to server: "
                    + emailProviderModel.getServerAddress());
            System.out.println("Looking for email for: "
                    + emailProviderModel.getEmailAccount() + " with key: "
                    + searchKey);

            Properties props = new Properties();

            props.put("mail.smtp.host", emailProviderModel.getServerAddress());
            props.put("mail.smtp.port", emailProviderModel.getServerPort());
            props.put("mail.smtp.user", emailProviderModel.getEmailAccount());

            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.debug", "true");

            props.put("mail.smtp.socketFactory.port",
                    emailProviderModel.getServerPort());
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session session = Session.getInstance(props, null);
            session.setDebug(true);

            Store store = session
                    .getStore(emailProviderModel.getProtocolType());
            store.connect(emailProviderModel.getServerAddress(),
                    // Integer.parseInt(emailProviderModel.getServerPort()),
                    emailProviderModel.getEmailAccount(),
                    emailProviderModel.getPassword());
            System.out.println(" Connected to server: "
                    + emailProviderModel.getServerAddress()
                    + ". Getting inbox...");
            Folder inbox = store.getFolder("Inbox");

            if (deleteAfter) {
                inbox.open(Folder.READ_WRITE);
            } else {
                inbox.open(Folder.READ_ONLY);
            }
            System.out.println("Inbox opened...");
            System.out.println("No of emails in inbox: "
                    + inbox.getMessages().length);
            int retry = 0;
            do {
                System.out.println("retry " + retry);
                System.out.println("number: " + inbox.getMessageCount());
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ "
                        + new Date().getTime());
                returnMessage = searchForMail(inbox.getMessages(),
                        emailProviderModel.getEmailAccount(), searchKey,
                        deleteAfter);
                System.out
                        .println("returnMessage ```````````````````````````````````````"
                                + returnMessage);
                if (returnMessage == null) {
                    try {
                        Thread.sleep(Constants.EMAIL_WAIT_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ++retry;
                System.out.println("retries for checking mail : " + retry
                        + " server/address: "
                        + emailProviderModel.getServerAddress() + "/"
                        + emailProviderModel.getEmailAccount());
            } while ((returnMessage == null) && (retry < waitCycle));
            inbox.close(deleteAfter);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
            org.junit.Assert.fail("Couldn't connect to the email server!");
        }
        System.out.println("!!!!!!!!!!!!!!!"
                + emailProviderModel.getEmailAccount());
        org.junit.Assert
                .assertTrue(
                        String.format(
                                "No email containing '%s' was found in the inbox folder for the '%s' email address!",
                                searchKey, emailProviderModel.getEmailAccount()),
                        returnMessage != null);
        return returnMessage;
    }

    public static String getMail(Session session, String searchKey,
            EmailProviderModel emailProviderModel, boolean deleteAfter) {
        return getMail(session, searchKey, emailProviderModel, deleteAfter,
                Constants.EMAIL_RETRY_CYCLEs);
    }

    public static String getMailSingleRetry(Session session, String searchKey,
            EmailProviderModel emailProviderModel, boolean deleteAfter) {
        return getMail(session, searchKey, emailProviderModel, deleteAfter, 1);
    }

    public static String getMail(String searchKey,
            EmailProviderModel emailProviderModel, boolean deleteAfter) {
        return getMail(searchKey, emailProviderModel, deleteAfter,
                Constants.EMAIL_RETRY_CYCLEs);
    }

    public static String getMailSingleRetry(String searchKey,
            EmailProviderModel emailProviderModel, boolean deleteAfter) {
        return getMail(searchKey, emailProviderModel, deleteAfter, 1);
    }

    private static String searchForMail(Message[] messages,
            String emailAddress, String searchKey, boolean deleteAfter) {

        //		Date yesterday = DateUtils.getYesterday();

        boolean found = false;
        String returnMessage = null;
        System.out.println("ooooooooooooooooooooooooooooooooooooo "
                + messages.length);
        for (int i = messages.length - 1; i >= 0; i--) {
            try {
                //				if (deleteAfter
                //						&& (yesterday.compareTo(messages[i].getReceivedDate()) == 1)) {
                //					messages[i].setFlag(FLAGS.Flag.DELETED, true);
                //					continue;
                //				}
                // try {
                // Address[] addresses = messages[i].getAllRecipients();
                // System.out.println("******************************************");
                // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx " +
                // addresses.length);
                // for (Address address : addresses) {
                // if (address.toString().contains(emailAddress)) {
                String allText = getStringFromMessage(messages[i]);
                if (allText.contains(searchKey)) {
                    returnMessage = allText;
                    if (deleteAfter) {
                        messages[i].setFlag(FLAGS.Flag.DELETED, true);
                    }
                    found = true;
                    break;
                }
                // }
                // }
                // } catch (Exception e) {
                // try {
                // String text = messages[i].getContent().toString();
                // System.out.println("############################### " +
                // text);
                // } catch (IOException e1) {
                // }
                // }
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            if (found) {
                break;
            }
        }
        return returnMessage;
    }

    private static String getStringFromMessage(Message message) {
        StringBuilder textContent = new StringBuilder("");
        try {
            textContent = new StringBuilder((message.getSubject() + " "));
            if (message.getContentType().startsWith("multipart")) {
                MimeMultipart content = (MimeMultipart)message.getContent();
                for (int i = 0; i < content.getCount(); i++) {
                    BodyPart part = content.getBodyPart(i);
                    textContent.append(part.getContent());
                }
            } else {
                textContent.append(message.getContent().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textContent.toString();
    }

    /**
     * extracts first occurrence url from multiline string
     * 
     * @param email
     * @return
     */
    public static String extractUrlFromEmailMessage(String email) {
        int matchStart = 0;
        int matchEnd = 0;
        int occ = 0;
        Pattern urlPattern = Pattern
                .compile(
                        "(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?",
                        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                                | Pattern.DOTALL);
        Matcher matcher = urlPattern.matcher(email);
        while (matcher.find() & occ < 1) {
            occ++;
            matchStart = matcher.start(1);
            matchEnd = matcher.end();
            // now you have the offsets of a URL match
        }
        String link = email.substring(matchStart, matchEnd);
        return link;
    }

    /**
     * returns list of url's fount in a string
     * 
     * @param str
     * @return
     */
    public static List<String> extractUrlsFromString(String str) {
        int matchStart = 0;
        int matchEnd = 0;
        List<String> urlList = new ArrayList<String>();
        Pattern urlPattern = Pattern
                .compile(
                        "(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?",
                        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
                                | Pattern.DOTALL);
        Matcher matcher = urlPattern.matcher(str);
        while (matcher.find()) {
            matchStart = matcher.start(1);
            matchEnd = matcher.end();
            // now you have the offsets of a URL match
            String link = str.substring(matchStart, matchEnd);
            urlList.add(link);
        }

        return urlList;
    }

    /**
     * Extracts first occurrence url containing a desired key from multiline string
     * 
     * @param email
     * @param key
     * @return
     */
    public static String extractURLContainingKeysFromString(String email, String... keys) {
        email = StringUtils.removeNewLinesMultipleSpacesAndTabs(email)
                .replaceAll("  ", " ");
        String[] lines = email.split("href=\"");
        for (String s : lines) {
            int index = s.indexOf('\"');
            //			int index = s.indexOf('\"') < s.indexOf(' ') ? s.indexOf('\"') : s
            //					.indexOf(' ');
            s = s.substring(0, (index > -1 ? index : s.length()));
            if (StringUtils.checkIfTextContainsTerms(s, true, keys)) {
                return s.trim();
            }
        }
        Assert.fail(
                "No matching URL was found in the provided email message!");
        return null;
    }

    public static void checkMail(String user) {
        Properties props = new Properties();
        Session session = Session.getInstance(props, null);
        try {
            Store store = session.getStore("pop3");
            store.connect("pop.mailinator.com", 110, user, "12345678");
            Folder inbox = store.getFolder("inbox");
            if (inbox == null) {
                System.out.println("no inbox");
            } else {
                inbox.open(Folder.READ_ONLY);
                for (Message message : inbox.getMessages()) {

                    byte[] buffer = new byte[10000];

                    try {

                        while ((message.getInputStream().read(buffer, 0,
                                1024)) > 0) {
                            for (int i = 0; i < buffer.length; i++) {
                                System.out.print((char)buffer[i]);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        System.out.println(message.getContent().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            inbox.close(false);
            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}