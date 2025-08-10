package com.as.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Objects;

@Slf4j
public class Common {

    static int childXmlCount = 0;
    private final Listeners listeners = new Listeners();

    public void executeShellCmd(String shellCmd) {
        try {
            Process process = Runtime.getRuntime().exec(shellCmd);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Error in Executing the command " + shellCmd);
        }
    }

    public void generateAllureReport(ITestContext iTestContext) {
        XmlSuite xmlSuite = iTestContext.getSuite().getXmlSuite();
        if (Objects.isNull(xmlSuite.getParentSuite())) {
            listeners.generateAllureReport();
        } else {
            List<XmlSuite> childXmlSuiteList = xmlSuite.getParentSuite().getChildSuites();
            if (++childXmlCount == childXmlSuiteList.size()) {
                listeners.generateAllureReport();
            }
        }
    }

}
