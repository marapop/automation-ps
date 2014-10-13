package a.tools.alfresco;

import static a.tools.alfresco.WebDriverFactory.REMOTE;
import static a.tools.alfresco.WebDriverFactory.REMOTE_URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverConfig {

	private static String desiredBrowser = System.getProperty("webdriver.browser", "chrome");
	private static boolean desiredRemote = Boolean.parseBoolean(System.getProperty("webdriver.remote", "false"));
	private static String desiredRemoteUrl = System.getProperty("webdriver.remote.url", "http://localhost:5555/wd/hub");
	private static DesiredCapabilities capabilities = new DesiredCapabilities();

	static {
		capabilities.setCapability(CapabilityType.BROWSER_NAME, desiredBrowser);
		capabilities.setCapability(REMOTE, desiredRemote);
		capabilities.setCapability(REMOTE_URL, desiredRemoteUrl);
		System.out.println("Desired capabilities are:");
		System.out.println(capabilities.toString());
	}

	private static WebDriver driver;

	public synchronized static WebDriver getCurrentDriver() {
		if (driver == null) {
			try {
				driver = WebDriverFactory.createWebDriver(capabilities);
				driver.manage().window().maximize();
			} finally {
				//Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}
		}
		return driver;
	}

	public static void close() {
		try {
			getCurrentDriver().quit();
		} catch (Exception e) {
			System.out.println("Cannot close browser: Exception");
			e.printStackTrace();
		}
		driver = null;
	}

	public WebDriverWait wait = new WebDriverWait(driver, 15);
}
