package a.tools.alfresco;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class WebDriverFactory {
	
	public static final String REMOTE = "remote";
	public static final String REMOTE_URL = "remoteUrl";
	
	public static WebDriver createWebDriver(DesiredCapabilities capabilities) {
		if(capabilities.getCapability(REMOTE) != null && 
				(Boolean) capabilities.getCapability(REMOTE) == true) {
			return createRemoteWebDriver(capabilities);
		} else {
			return createLocalWebDriver(capabilities);
		}
		
	}

	private static WebDriver createRemoteWebDriver(DesiredCapabilities capabilities) {
		String rawUrl = (String) capabilities.getCapability(REMOTE_URL);
		URL remoteUrl = null;
		try {
			remoteUrl = new URL(rawUrl);
			return new RemoteWebDriver(remoteUrl, capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (UnreachableBrowserException ube) {
			System.out.println("Trying to connect to remote WebDriver at: " + remoteUrl);
			ube.printStackTrace();
			throw ube;
		}
		
	}

	private static WebDriver createLocalWebDriver(DesiredCapabilities capabilities) {
		String desiredBrowser = (String) capabilities.getBrowserName();

		if("chrome".equals(desiredBrowser)) {
			System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver29.exe");
			System.out.println("---    NOTE     ---");
			System.out.println("Property webdriver.chrome.driver was set in 'createLocalWebDriver(DesiredCapabilities capabilities)'");
			System.out.println("--- END OF NOTE ---");
			return new ChromeDriver();
		} else if("firefox".equals(desiredBrowser)) {
			return new FirefoxDriver();
		} else if("ie".equals(desiredBrowser)) {
			return new InternetExplorerDriver();
		} else if("htmlunit".equals(desiredBrowser)) {
			return new HtmlUnitDriver();
		} else if("phantomjs".equals(desiredBrowser)) {
			return new PhantomJSDriver();
		} else {
			throw new RuntimeException("Unsupported browser requested: " + desiredBrowser);
		}
	}

}
