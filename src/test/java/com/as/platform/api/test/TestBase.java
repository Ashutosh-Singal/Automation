package com.as.platform.api.test;

import com.as.common.utils.Common;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    private static ITestContext testContext;
    private final Common common = new Common();

    @BeforeSuite
    public void setUp(ITestContext context) {
        testContext = context;
    }

    @AfterSuite
    public void tearDown() {
        common.generateAllureReport(testContext);
    }
}
