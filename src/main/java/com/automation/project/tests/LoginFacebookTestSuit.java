package com.automation.project.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LoginFacebookTestSuit implements TestCaseLibrary {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    public void initializeTestEnviorement(WebDriver driver, String browserName) {
        // TODO Auto-generated method stub
        htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("Open Browsers :" + browserName);
        test.log(Status.PASS, "Sucessfully Login :" + browserName);
    }

    public void openBrowser(WebDriver driver) throws InterruptedException {
        // TODO Auto-generated method stub
        ExtentTest test1 = extent.createTest("Facebook Page Reload");
        driver.get("https://www.facebook.com/");
        if (driver.getCurrentUrl().equals("https://www.facebook.com/")) {
            test1.log(Status.PASS, "Navigated to the specified URL");
        } else {
            test1.log(Status.FAIL, "Test Failed");
        }
        driver.manage().window().maximize();

    }

    public void test2(WebDriver driver) {
        ExtentTest test = extent.createTest("Facebook Sign In");
        driver.findElement(By.id("email")).sendKeys("mtom86041@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("k9FeZTjSBXif5hK");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button"))
                .click();

        if (driver.findElement(By.id("email")) != null) {
            test.log(Status.PASS, "login sucessfully");
        } else {
            test.log(Status.FAIL, "fail");
        }
    }

    public void test3(WebDriver driver) throws InterruptedException {
        // TODO Auto-generated method stub
        int numberOfPost = 1;
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[1]")).click();
        ExtentTest test3 = extent.createTest("Creat Post");
        int i = 0;
        Thread.sleep(5000);
        for (i = 0; i < 1; i++) {
            driver.findElement(By.xpath(
                    "/html/body/div[1]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[3]/div/div[2]/div/div/div/div[1]/div/div[1]/span"))
                    .click();
            Thread.sleep(5000);
            driver.findElement(By.xpath(
                    "/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div"))
                    .sendKeys(1 + ":hello just check = " + i + " for assignment");
            Thread.sleep(5000);
            driver.findElement(By.xpath(
                    "/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[3]/div[2]/div/div"))
                    .click();
            Thread.sleep(5000);
            test3.log(Status.PASS, "Post " + i + " sucessful");
        }

        if (i < numberOfPost) {
            test3.log(Status.FAIL, "fail");
        } else {
            test3.log(Status.PASS, "Post completed");
        }

    }

    public void destroyTests(WebDriver driver) {
        ExtentTest test3 = extent.createTest("Close Driver");
        test3.log(Status.PASS,"Driver is closed.");
        driver.close();
        extent.flush();
    }

}
