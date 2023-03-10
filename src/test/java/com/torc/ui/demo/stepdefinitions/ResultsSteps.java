package com.torc.ui.demo.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import com.torc.ui.demo.base.BaseSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResultsSteps extends BaseSteps{
		
	@When("Open the first result")
	public void openFirstResult() {
	    resultsPage.openFirtResult();
	}
	
	@Then("Check if the URL is {string}")
	public void checkIfUrlContains(String URL) {
		assertThat(resultsPage.getURL()).withFailMessage("The URL is different.").contains(URL);
	}
}
