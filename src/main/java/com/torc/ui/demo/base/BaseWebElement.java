package com.torc.ui.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseWebElement {

	private static final String ATTR_NAME="name";
	
	@Lazy
	@Autowired
	protected FluentWait<WebDriver> wait;
	
	public void click(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Clicking {}", element.getAttribute(ATTR_NAME));
		element.click();
	}

	public void sendKeys(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Entering {}", text);
		element.sendKeys(text);
	}
	
	public String getText(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Extracting text from {}", element.getText());
		return element.getText();
	}
}
