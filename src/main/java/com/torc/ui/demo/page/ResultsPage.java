package com.torc.ui.demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.torc.ui.demo.annotations.PageObject;
import com.torc.ui.demo.base.BasePage;

@PageObject
public class ResultsPage extends BasePage{
	
	@FindBy(css = "#links #r1-0")
	private WebElement firstResultLink;

	public void openFirtResult() {
		click(firstResultLink);
	}
}
