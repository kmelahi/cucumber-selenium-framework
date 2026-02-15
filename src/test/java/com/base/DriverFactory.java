package com.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver() {
		String browser = ConfigReader.get("browser").toLowerCase();
		boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
		long implicitWait = Long.parseLong(ConfigReader.get("implicitWaitSeconds"));

		WebDriver webDriver;

		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			webDriver = new EdgeDriver();
			break;

		case "chrome":
		default:
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if (headless) {
				options.addArguments("--headless=new");
			}
			options.addArguments("--window-size=1920,1080");
			webDriver = new ChromeDriver(options);
			break;
		}

		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		webDriver.manage().window().maximize();

		driver.set(webDriver);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove();
		}
	}
}
