package com.as.platform.api;

import com.as.common.models.commons.RestRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIRequests {
    private RequestSpecification buildRequest(RestRequest req) {

        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();

        if (req.getHeaders() != null) {
            request.headers(req.getHeaders());
        }

        if (req.getQueryParams() != null) {
            request.queryParams(req.getQueryParams());
        }

        if (req.getPathParams() != null) {
            request.pathParams(req.getPathParams());
        }

        if (req.getBody() != null) {
            request.contentType(ContentType.JSON);
            request.body(req.getBody());
        }

        return request;
    }

    public Response get(RestRequest req) {
        return buildRequest(req)
                .when()
                .get(req.getUrl())
                .then()
                .extract()
                .response();
    }

    public Response post(RestRequest req) {
        return buildRequest(req)
                .when()
                .post(req.getUrl())
                .then()
                .extract()
                .response();
    }

    public Response put(RestRequest req) {
        return buildRequest(req)
                .when()
                .put(req.getUrl())
                .then()
                .extract()
                .response();
    }

    public Response delete(RestRequest req) {
        return buildRequest(req)
                .when()
                .delete(req.getUrl())
                .then()
                .extract()
                .response();
    }

    public Response patch(RestRequest req) {
        return buildRequest(req)
                .when()
                .patch(req.getUrl())
                .then()
                .extract()
                .response();
    }

}
