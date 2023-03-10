package com.torc.ui.demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import com.torc.ui.demo.annotations.PageObject;
import com.torc.ui.demo.base.BasePage;

@PageObject
public class HomePage extends BasePage{

	@FindBy(css = "#search_form_input_homepage")
	@CacheLookup
	private WebElement searchInput;
	
	@FindBy(css = "#search_button_homepage")
	@CacheLookup
	private WebElement searchButton;
	
	public void search(String text) {
		sendKeys(searchInput, text);
		click(searchButton);
	}
}
