package com.hooks;


import com.base.DriverFactory;
import com.utils.ScreenshotUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void beforeScenario() {
        DriverFactory.initDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtils.takeScreenshotBytes();
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
        DriverFactory.quitDriver();
    }
}
