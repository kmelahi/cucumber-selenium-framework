package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BasePage;

public class HomePage extends BasePage {

	private final By productsTitle = By.className("title");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isHomePageVisible() {
		return isDisplayed(productsTitle);
	}
}
