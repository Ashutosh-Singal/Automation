package com.as.common.utils;

import io.qameta.allure.Flaky;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.lang.reflect.Method;

public class RetryAnalyzer implements IRetryAnalyzer {

    int retryCount = 0;
    int maxRetryCount = 1;


    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (retryCount < maxRetryCount) {
                result.setStatus(ITestResult.SKIP);
                retryCount++;
                return true;
            } else {
                Method testMethod = result.getMethod().getConstructorOrMethod().getMethod();
                if(testMethod.getAnnotation(Flaky.class) !=null) {
                    result.setStatus(ITestResult.SKIP);
                    return false;
                }
                result.setStatus(ITestResult.FAILURE);
            }
        } else {
            result.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

}