package com.stepdefinitions;

import static org.junit.Assert.assertTrue;

import com.base.DriverFactory;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginPage;
	private HomePage homePage;

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
		loginPage = new LoginPage(DriverFactory.getDriver());
		homePage = new HomePage(DriverFactory.getDriver());
	}

	@When("I login with username {string} and password {string}")
	public void i_login_with_username_and_password(String user, String pass) {
		loginPage.login(user, pass);
	}

	@Then("I should see the home page")
	public void i_should_see_the_home_page() {
		assertTrue("Home page not visible", homePage.isHomePageVisible());
	}
}
