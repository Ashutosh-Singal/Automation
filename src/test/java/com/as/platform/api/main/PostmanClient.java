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
        Response response = apiRequests.get(
                RestRequest.builder()
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.AUTH_ENDPOINT)
                        .build()
        );
        try {
            AuthResultModel authResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), AuthResultModel.class);
            authResultModel.setStatusCode(response.getStatusCode());
            return authResultModel;
        } catch (Exception e) {
            return AuthResultModel.builder().statusCode(response.getStatusCode()).build();
        }
    }

    public AccountResultModel createAccount(AccountInputModel accountInputModel, Header header) {
        Response response = apiRequests.post(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.ACCOUNT_ENDPOINT)
                        .body(accountInputModel)
                        .build()
        );
        try {
            AccountResultModel accountResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), AccountResultModel.class);
            accountResultModel.setStatusCode(response.getStatusCode());
            return accountResultModel;
        } catch (Exception e) {
            return AccountResultModel.builder().statusCode(response.getStatusCode()).build();
        }
    }

    public AccountDetailsResultModel getAllAccountDetails(Header header) {
        Response response = apiRequests.get(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.ACCOUNT_ENDPOINT)
                        .build()
        );
        try {
            AccountDetailsResultModel accountDetailsResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), AccountDetailsResultModel.class);
            accountDetailsResultModel.setStatusCode(response.getStatusCode());
            return accountDetailsResultModel;
        } catch (Exception e) {
            return AccountDetailsResultModel.builder().statusCode(response.getStatusCode()).build();
        }
    }

    public CreateTransactionResultModel createTransaction(CreateTransactionInputModel createTransactionInputModel, Header header) {
        Response response = apiRequests.post(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.TRANSACTIONS_ENDPOINT)
                        .body(createTransactionInputModel)
                        .build()
        );
        try {
            CreateTransactionResultModel createTransactionResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), CreateTransactionResultModel.class);
            createTransactionResultModel.setStatusCode(response.getStatusCode());
            return createTransactionResultModel;
        } catch (Exception e) {
            return CreateTransactionResultModel.builder().statusCode(response.getStatusCode()).build();
        }
    }

    public TransactionDetailsResultModel getTransactionDetailsByToAccountId(long toAccountId, Header header) {
        Response response = apiRequests.get(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.TRANSACTIONS_ENDPOINT)
                        .queryParams(Map.of(APIConstants.TO_ACCOUNT_ID, toAccountId))
                        .build()
        );
        try {
            TransactionDetailsResultModel transactionDetailsResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), TransactionDetailsResultModel.class);
            transactionDetailsResultModel.setStatusCode(response.getStatusCode());
            return transactionDetailsResultModel;
        } catch (Exception e) {
            return TransactionDetailsResultModel.builder().statusCode(response.getStatusCode()).build();
        }
    }

    public TransactionDetailResultModel getTransactionDetailsById(long transactionId, Header header) {
        Response response = apiRequests.get(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.TRANSACTIONS_ENDPOINT + "/" + transactionId)
                        .build()
        );
        try {
            TransactionDetailResultModel transactionDetailResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), TransactionDetailResultModel.class);
            transactionDetailResultModel.setStatusCode(response.getStatusCode());
            return transactionDetailResultModel;
        } catch (Exception e) {
            return TransactionDetailResultModel.builder().statusCode(response.getStatusCode()).build();
        }
    }

    public AccountDetailResultModel getAccountDetailsById(long accountId, Header header) {
        Response response = apiRequests.get(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.ACCOUNT_ENDPOINT + "/" + accountId)
                        .build()
        );
        try {
            AccountDetailResultModel accountDetailResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), AccountDetailResultModel.class);
            accountDetailResultModel.setStatusCode(response.getStatusCode());
            return accountDetailResultModel;
        } catch (Exception e) {
            return AccountDetailResultModel.builder().statusCode(response.getStatusCode()).build();
        }
    }

    public DeleteAccountResultModel deleteAccountById(long accountId, Header header) {
        Response response = apiRequests.delete(
                RestRequest.builder()
                        .headers(Map.of(APIConstants.API_KEY, header.getApiKey()))
                        .url(APIConstants.POSTMAN_BASE_URL + APIConstants.ACCOUNT_ENDPOINT + "/" + accountId)
                        .build()
        );
        try {
            DeleteAccountResultModel deleteAccountResultModel = CommonSerializationUtil.readObject(response.getBody().asString(), DeleteAccountResultModel.class);
            deleteAccountResultModel.setStatusCode(response.getStatusCode());
            return deleteAccountResultModel;
        } catch (Exception e) {
            return DeleteAccountResultModel.builder().statusCode(response.getStatusCode()).build();
        }
    }

}
