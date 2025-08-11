package com.as.platform.api.main;

import com.as.common.APIConstants;
import com.as.common.models.commons.Header;
import com.as.common.models.commons.RestRequest;
import com.as.common.models.input.AccountInputModel;
import com.as.common.models.input.CreateTransactionInputModel;
import com.as.common.models.result.*;
import com.as.common.utils.CommonSerializationUtil;
import com.as.platform.api.APIRequests;
import io.restassured.response.Response;

import java.util.Map;

public class PostmanClient {

    private final APIRequests apiRequests = new APIRequests();

    public AuthResultModel getAuthToken() {
        Response response = apiRequests.post(
                RestRequest.builder()
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.AUTH_ENDPOINT)
                        .build()
        );
        AuthResultModel authResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), AuthResultModel.class);
        authResultModel.setStatusCode(authResultModel.getStatusCode());
        return authResultModel;
    }

    public AccountResultModel postAccountDetails(AccountInputModel accountInputModel, Header header) {
        Response response = apiRequests.post(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.ACCOUNT_ENDPOINT)
                        .body(accountInputModel)
                        .build()
        );
        AccountResultModel accountResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), AccountResultModel.class);
        accountResultModel.setStatusCode(accountResultModel.getStatusCode());
        return accountResultModel;
    }

    public AccountDetailsResultModel getAllAccountDetails(Header header) {
        Response response = apiRequests.get(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.ACCOUNT_ENDPOINT)
                        .build()
        );
        AccountDetailsResultModel accountDetailsResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), AccountDetailsResultModel.class);
        accountDetailsResultModel.setStatusCode(accountDetailsResultModel.getStatusCode());
        return accountDetailsResultModel;
    }

    public CreateTransactionResultModel createTransaction(CreateTransactionInputModel createTransactionInputModel,Header header) {
        Response response = apiRequests.post(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.TRANSACTIONS_ENDPOINT)
                        .body(createTransactionInputModel)
                        .build()
        );
        CreateTransactionResultModel createTransactionResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), CreateTransactionResultModel.class);
        createTransactionResultModel.setStatusCode(createTransactionResultModel.getStatusCode());
        return createTransactionResultModel;
    }

    public TransactionDetailsResultModel getTransactionDetailsByToAccountId(int toAccountId, Header header) {
        Response response = apiRequests.get(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.TRANSACTIONS_ENDPOINT)
                        .queryParams(Map.of(APIConstants.TO_ACCOUNT_ID, toAccountId))
                        .build()
        );
        TransactionDetailsResultModel transactionDetailsResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), TransactionDetailsResultModel.class);
        transactionDetailsResultModel.setStatusCode(transactionDetailsResultModel.getStatusCode());
        return transactionDetailsResultModel;
    }

    public TransactionDetailResultModel getTransactionDetailsById(int transactionId, Header header) {
        Response response = apiRequests.get(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.TRANSACTIONS_ENDPOINT + "/" + transactionId)
                        .build()
        );
        TransactionDetailResultModel transactionDetailResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), TransactionDetailResultModel.class);
        transactionDetailResultModel.setStatusCode(transactionDetailResultModel.getStatusCode());
        return transactionDetailResultModel;
    }

    public AccountDetailResultModel getAccountDetailsById(int accountId, Header header) {
        Response response = apiRequests.get(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.ACCOUNT_ENDPOINT + "/" + accountId)
                        .build()
        );
        AccountDetailResultModel accountDetailResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), AccountDetailResultModel.class);
        accountDetailResultModel.setStatusCode(accountDetailResultModel.getStatusCode());
        return accountDetailResultModel;
    }

    public DeleteAccountResultModel deleteAccountById(int accountId, Header header) {
        Response response = apiRequests.delete(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.ACCOUNT_ENDPOINT + "/" + accountId)
                        .build()
        );
        DeleteAccountResultModel deleteAccountResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), DeleteAccountResultModel.class);
        deleteAccountResultModel.setStatusCode(deleteAccountResultModel.getStatusCode());
        return deleteAccountResultModel;
    }

}
