package com.automation.project;

import com.automation.project.config.DriverConfiguration;

public class TestRunner {

    public static void main(String[] args) throws InterruptedException {

        DriverConfiguration testClass = new DriverConfiguration("chrome");
        DriverConfiguration testClass2 = new DriverConfiguration("FireFox");
        Thread t1 = new Thread(testClass2);
        Thread t2 = new Thread(testClass);
        t1.start();
        t2.start();
    }

}
