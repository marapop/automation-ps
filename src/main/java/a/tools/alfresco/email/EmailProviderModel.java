package a.tools.alfresco.email;

public class EmailProviderModel {

    private String protocolType = "imaps";
    //	private String protocolType = "pop3";
    //	private String serverAddress = "smtp.gmail.com";
    private String serverAddress = "imap.gmail.com";
    //	private String serverAddress = "pop.gmail.com";
    //	private String serverAddress = "imap.mail.yahoo.com";
    //	private String serverAddress = "pop.mail.yahoo.com";
    //	private String serverPort = "465";
    private String serverPort = "993";
    //	private String serverPort = "587";
    //	private String serverPort = "993";
    //	private String serverPort = "995";
    //	private String serverPort = "110";
    private String emailAccount;
    private String password;

    public EmailProviderModel(String emailAccount, String password) {
        this.emailAccount = emailAccount;
        this.password = password;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public String getEmailAccount() {
        return emailAccount;
    }

    public void setEmailAccount(String emailAccount) {
        this.emailAccount = emailAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
