package com.as.common.assertions;

import com.as.common.models.result.AccountResultModel;
import com.as.common.models.result.AuthResultModel;
import com.as.common.models.result.CreateTransactionResultModel;
import com.as.common.models.result.DeleteAccountResultModel;
import org.testng.asserts.SoftAssert;

public class PostmanAssertions {

    private final SoftAssert softAssert;

    public PostmanAssertions(SoftAssert softAssert) {
        this.softAssert = softAssert;
    }

    public void assertHttpSuccess(int statusCode, String message) {
        softAssert.assertTrue(statusCode >= 200 && statusCode < 300, "HTTP status code is not 2xx in " + message);
    }

    public void assertAuthToken(AuthResultModel authResultModel) {
        softAssert.assertNotNull(authResultModel.getApiKey(), "Auth token is null");
        assertHttpSuccess(authResultModel.getStatusCode(), "Auth token creation");
    }

    public void assertAccountCreation(AccountResultModel accountResultModel) {
        assertHttpSuccess(accountResultModel.getStatusCode(), "Account creation");
        softAssert.assertNotNull(accountResultModel.getAccount(), "Account is null");
        softAssert.assertTrue(accountResultModel.getAccount().getId() > 0, "Invalid account id");

    }

    public void assertCreateTransaction(CreateTransactionResultModel createTransactionResultModel) {
        assertHttpSuccess(createTransactionResultModel.getStatusCode(), "Transaction creation");
        softAssert.assertTrue(createTransactionResultModel.isSuccess(), "Transaction creation failed");
        softAssert.assertNotNull(createTransactionResultModel.getTransaction(), "Transaction is null");
        softAssert.assertTrue(createTransactionResultModel.getTransaction().getId() > 0, "Invalid transaction id");
    }

    public void assertCleanup(DeleteAccountResultModel deleteAccountResultModel) {
        assertHttpSuccess(deleteAccountResultModel.getStatusCode(), "Account deletion");
        softAssert.assertTrue(deleteAccountResultModel.isSuccess(), "Account deletion failed");
    }
}
