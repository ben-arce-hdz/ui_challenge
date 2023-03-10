package com.torc.ui.demo.hooks;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.torc.ui.demo.constants.Constants;
import com.torc.ui.demo.page.HomePage;
import com.torc.ui.demo.util.ScreenShotUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private @Lazy @Autowired HomePage homePage;
	private @Lazy @Autowired ScreenShotUtil screenShot;

	@Before()
	public void beforeEachScenario() {
		homePage.openLoginPage();
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) throws IOException {
		if(scenario.isFailed())
			scenario.embed(screenShot.takeScreenShot(), Constants.IMAGE_PNG, scenario.getName());
	}

	@After
	public void cleanUp() {
		homePage.close();
	}
}