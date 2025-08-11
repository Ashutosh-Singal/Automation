package com.as.platform.api.test;

import com.as.common.APIConstants;
import com.as.common.assertions.PostmanAssertions;
import com.as.common.models.commons.Header;
import com.as.common.models.enums.Currency;
import com.as.common.models.input.AccountInputModel;
import com.as.common.models.input.CreateTransactionInputModel;
import com.as.common.models.result.AccountResultModel;
import com.as.common.models.result.AuthResultModel;
import com.as.common.models.result.CreateTransactionResultModel;
import com.as.common.models.result.DeleteAccountResultModel;
import com.as.common.utils.TestDataGenerator;
import com.as.platform.api.main.PostmanClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;

public class ValidTransactionTest extends TestBase {

    private final PostmanClient postmanClient = new PostmanClient();
    private final SoftAssert softAssert = new SoftAssert();
    private final PostmanAssertions postmanAssertions = new PostmanAssertions(softAssert);

    @Test(priority = 1)
    public void generateApiKey() {
        AuthResultModel authResultModel = postmanClient.getAuthToken();
        postmanAssertions.assertAuthToken(authResultModel);
        testContext.setAttribute(APIConstants.API_KEY, authResultModel.getApiKey());
    }

    @Test(priority = 2)
    public void createFromAccount() {
        String owner = TestDataGenerator.randomFullName("FromAccount");
        BigDecimal balance = TestDataGenerator.randomBigDecimal(0, 100000, 0);
        AccountResultModel accountResultModel = postmanClient.createAccount(
                AccountInputModel.builder()
                        .owner(owner)
                        .balance(balance)
                        .currency(Currency.RUPEE).build(),
                Header.builder().apiKey(testContext.getAttribute(APIConstants.API_KEY).toString()).build()
        );

        postmanAssertions.assertAccountCreation(accountResultModel);
        testContext.setAttribute("from_id", accountResultModel.getAccount().getId());
        testContext.setAttribute("from_balance", balance.toString());
        testContext.setAttribute("from_owner", owner);
    }

    @Test(priority = 3)
    public void createToAccount() {
        String owner = TestDataGenerator.randomFullName("ToAccount");
        BigDecimal balance = TestDataGenerator.randomBigDecimal(0, 100000, 0);

        AccountResultModel accountResultModel = postmanClient.createAccount(
                AccountInputModel.builder()
                        .owner(owner)
                        .balance(balance)
                        .currency(Currency.RUPEE).build(),
                Header.builder().apiKey(testContext.getAttribute(APIConstants.API_KEY).toString()).build()
        );

        postmanAssertions.assertAccountCreation(accountResultModel);
        testContext.setAttribute("to_id", accountResultModel.getAccount().getId());
        testContext.setAttribute("to_balance", balance.toString());
        testContext.setAttribute("to_owner", owner);
    }

    @Test(priority = 4)
    public void createTransaction() {
        BigDecimal amount = TestDataGenerator.randomBigDecimal(0, Double.parseDouble(testContext.getAttribute("from_balance").toString()), 0);
        CreateTransactionResultModel createTransactionResultModel = postmanClient.createTransaction(
                CreateTransactionInputModel.builder()
                        .fromAccountId(Long.parseLong(testContext.getAttribute("from_id").toString()))
                        .toAccountId(Long.parseLong(testContext.getAttribute("to_id").toString()))
                        .amount(amount)
                        .currency(Currency.RUPEE)
                        .build(),
                Header.builder().apiKey(testContext.getAttribute(APIConstants.API_KEY).toString()).build()

        );
        postmanAssertions.assertCreateTransaction(createTransactionResultModel);
        testContext.setAttribute("amount", amount.toString());
    }


    @Test(priority = 5)
    public void cleanup() {
        DeleteAccountResultModel deleteFromAccountResultModel = postmanClient.deleteAccountById(
                Long.parseLong(testContext.getAttribute("from_id").toString()),
                Header.builder().apiKey(testContext.getAttribute(APIConstants.API_KEY).toString()).build()
        );
        postmanAssertions.assertCleanup(deleteFromAccountResultModel);
        DeleteAccountResultModel deleteToAccountResultModel = postmanClient.deleteAccountById(
                Long.parseLong(testContext.getAttribute("to_id").toString()),
                Header.builder().apiKey(testContext.getAttribute(APIConstants.API_KEY).toString()).build()
        );
        postmanAssertions.assertCleanup(deleteToAccountResultModel);
        softAssert.assertAll();

    }

}
