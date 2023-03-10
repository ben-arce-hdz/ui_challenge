package com.torc.ui.demo.config;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import com.torc.ui.demo.annotations.LazyConfiguration;
import com.torc.ui.demo.annotations.ParallelScope;
import static com.torc.ui.demo.constants.Constants.*;

@LazyConfiguration
public class WebDriverConfig {
		
	@Value("${browser.isheadless:false}")
	private boolean isHeadless;

	@ParallelScope
	@ConditionalOnProperty(name = "browser", havingValue = "firefox")
	public WebDriver firefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		var firefoxOptions = new FirefoxOptions();
		if (isHeadless)
			firefoxOptions.addArguments(DISABLE_GPU, HEADLESS);
		return new FirefoxDriver(firefoxOptions);
	}
	
	@ParallelScope
	@ConditionalOnMissingBean
	public WebDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		var chromeOptions = new ChromeOptions();
		if (isHeadless)
			chromeOptions.addArguments(DISABLE_GPU, HEADLESS);
		chromeOptions.addArguments(START_MAXIMIZED);
		return new ChromeDriver(chromeOptions);
	}
}