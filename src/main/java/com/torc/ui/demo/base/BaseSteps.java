package com.torc.ui.demo.base;

import org.springframework.beans.factory.annotation.Autowired;
import com.torc.ui.demo.page.HomePage;
import com.torc.ui.demo.page.ResultsPage;

public abstract class BaseSteps{

	@Autowired
	protected HomePage homePage;

	@Autowired
	protected ResultsPage resultsPage;

}
