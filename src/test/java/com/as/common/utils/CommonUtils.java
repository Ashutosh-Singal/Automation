package com.as.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Objects;

@Slf4j
public class CommonUtils {

    static int childXmlCount = 0;
    private final Listeners listeners;


    public CommonUtils(Listeners listeners) {
        this.listeners = listeners;
    }

    public CommonUtils() {
        this.listeners = new Listeners(this);
    }

    public void executeShellCmd(String shellCmd) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String[] cmd;

            if (os.contains("win")) {
                cmd = new String[]{"cmd", "/c", shellCmd};
            } else {
                cmd = new String[]{"/bin/sh", "-c", shellCmd};
            }

            Process process = Runtime.getRuntime().exec(cmd);
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
