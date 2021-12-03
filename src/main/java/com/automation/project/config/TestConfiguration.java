package com.automation.project.config;

import org.openqa.selenium.WebDriver;

import com.automation.project.tests.LoginFacebookTestSuit;

public class TestConfiguration {

    public void excuteTests(WebDriver driver, String isBrowser) {
        LoginFacebookTestSuit tests = new LoginFacebookTestSuit();
        try {
            tests.initializeTestEnviorement(driver, isBrowser);
            tests.openBrowser(driver);
            tests.test2(driver);
            tests.test3(driver);
            tests.destroyTests(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
