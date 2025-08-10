package com.as.common.assertions;


import lombok.AllArgsConstructor;
import org.testng.asserts.SoftAssert;

@AllArgsConstructor
public class CommonAssertions {

    private SoftAssert softAssert;

    public void assertHttpSuccess(int statusCode){
        softAssert.assertTrue(statusCode >= 200 && statusCode < 300, "HTTP status code is not 2xx");
    }
}
