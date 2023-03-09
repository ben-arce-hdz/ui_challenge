package com.torc.ui.demo.stepdefinitions;

import org.springframework.boot.test.context.SpringBootTest;

import com.torc.ui.demo.base.BaseSteps;
import io.cucumber.java.en.When;

@SpringBootTest
public class HomeSteps extends BaseSteps {

	@When("I search {string}")
	public void sarching(String text) {
		homePage.search(text);
	}
}
