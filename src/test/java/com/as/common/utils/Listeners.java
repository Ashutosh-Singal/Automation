package com.as.common.utils;

import io.qameta.allure.testng.AllureTestNg;
import lombok.extern.slf4j.Slf4j;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class Listeners extends AllureTestNg {

    private final Common common = new Common();

    @Override
    public void onStart(ITestContext context) {
        super.onStart(context);
        log.info("Allure Test onStart:context");
        log.info(context.getName());
    }

    @Override
    public void onStart(ISuite suite) {
        super.onStart(suite);
        log.info("Allure Test onStart:suite");
        log.info(suite.getName());
    }

    @Override
    public void onTestStart(ITestResult testResult) {
        super.onTestStart(testResult);
        log.info("---------------------------------------");
        log.info("Test " + testResult.getName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        super.onTestSuccess(testResult);
        log.info("Test Success");
        onTestEnd(testResult);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        log.info("Test Failed");
        onTestEnd(result);
    }

    private void onTestEnd(ITestResult testResult) {
        log.info(String.valueOf(testResult.getStatus()));
        log.info("Test " + testResult.getName() + " Ended");
        log.info("---------------------------------------");
    }


    @Override
    public void onFinish(ITestContext suite) {
        try {
            log.info("********** onFinish(ITestContext suite) : Started **********");
            super.onFinish(suite);
            log.info("Tests Finished");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void generateAllureReport() {
        String pattern = "dd-MM-yyyy_HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String reportFolder = "allure-report_" + simpleDateFormat.format(new Date());
        try {
            common.executeShellCmd("mkdir allure-history");
            common.executeShellCmd("mkdir allure-reports");
            common.executeShellCmd("cp -R allure-history/history target/allure-results");
            Thread.sleep(500);
            common.executeShellCmd("allure generate --clean target/allure-results -o allure-reports/" + reportFolder);
            common.executeShellCmd("cp -R allure-reports/" + reportFolder + "/history allure-history");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
