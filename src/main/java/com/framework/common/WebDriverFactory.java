package com.framework.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

	public WebDriver driver = null;
	private int pageTimeOut = 10;

	@SuppressWarnings("deprecation")
	public WebDriver getDriver() {

		if (driver == null) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			ConfigurationProperties configProp = new ConfigurationProperties();
			String browserName = configProp
					.getProperty(ConfigurationProperties.BROWSER_NAME);

			if (("chrome").equalsIgnoreCase(browserName)) {
				capabilities = DesiredCapabilities.chrome();
				capabilities
						.setCapability(
								CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
								true);
				capabilities.setJavascriptEnabled(true);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,
						true);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				options.addArguments("disable-infobars");
				options.addArguments("--disable-notifications");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")
								+ "/Drivers/chromedriver.exe");
				driver = new ChromeDriver(options);
			}

			else if (("ie").equalsIgnoreCase(browserName)) {
				capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(
						InternetExplorerDriver.NATIVE_EVENTS, false);
				capabilities
						.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
				capabilities.setCapability(
						InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				capabilities.setCapability("allow-blocked-content", true);
				capabilities.setCapability("allowBlockedContent", true);
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir")
								+ "/Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver(capabilities);
			}

			else if (("firefox").equalsIgnoreCase(browserName)) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir")
								+ "/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println("Firefox Browser launched");
			} else {
				System.out.println(browserName + " is Invalid");
			}
			driver.manage().timeouts()
					.implicitlyWait(pageTimeOut, TimeUnit.SECONDS);
			return driver;

		}

		return driver;
	}

}
