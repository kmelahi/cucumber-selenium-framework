package com.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.utils.WaitUtils;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	protected void type(By locator, String text) {
		WaitUtils.waitForVisible(driver, locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	protected void click(By locator) {
		WaitUtils.waitForClickable(driver, locator).click();
	}

	protected String getText(By locator) {
		return WaitUtils.waitForVisible(driver, locator).getText();
	}

	protected boolean isDisplayed(By locator) {
		return WaitUtils.waitForVisible(driver, locator).isDisplayed();
	}
}
