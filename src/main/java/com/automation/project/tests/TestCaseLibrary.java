package com.automation.project.tests;

import org.openqa.selenium.WebDriver;

public interface TestCaseLibrary {

	public void initializeTestEnviorement(WebDriver driver,String browserName);
	public void openBrowser(WebDriver driver) throws InterruptedException;
	public void destroyTests(WebDriver driver);
	
}
