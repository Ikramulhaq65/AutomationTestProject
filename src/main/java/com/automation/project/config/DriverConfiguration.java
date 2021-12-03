package com.automation.project.config;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DriverConfiguration implements Runnable {

    public String isBrowser;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    public DriverConfiguration(String name) {
        this.isBrowser = name;
    }

    public void run() {
        
        // Chrome driver configuration
        TestConfiguration testConfiguration = new TestConfiguration();
        if (isBrowser == "chrome") {
            System.setProperty("webdriver.chrome.driver", "/home/shkahmed/Documents/eclipse-workspace/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            Map<String, Integer> timeouts = new HashMap<String, Integer>();
            timeouts.put("implicit", 3000);
            options.setCapability("timeouts", timeouts);

            ChromeDriver driver = new ChromeDriver(options);
            testConfiguration.excuteTests(driver, isBrowser);
        }
        // FireFox driver configuration
        else if (isBrowser == "FireFox") {
            System.setProperty("webdriver.gecko.driver", "/home/shkahmed/Documents/eclipse-workspace/geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-notifications");

            Map<String, Integer> timeouts = new HashMap<String, Integer>();
            timeouts.put("implicit", 3000);
            options.setCapability("timeouts", timeouts);

            WebDriver driverF = new FirefoxDriver(options);
            testConfiguration.excuteTests(driverF, isBrowser);
        }
    }
}
