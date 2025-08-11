package com.as.platform.api.test;

import com.as.common.utils.CommonUtils;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected ITestContext testContext;
    private final CommonUtils commonUtils = new CommonUtils();

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext context) {
        testContext = context;
    }

//    @AfterSuite
//    public void tearDown() {
//        commonUtils.generateAllureReport(testContext);
//    }
}
