package com.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.DriverFactory;

public class ScreenshotUtils {

	public static byte[] takeScreenshotBytes() {
		return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
	}
}
