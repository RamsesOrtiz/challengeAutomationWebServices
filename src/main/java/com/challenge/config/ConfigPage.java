package com.challenge.config;

import io.cucumber.java.BeforeAll;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import static com.challenge.config.LoggerPage.logger;

public class ConfigPage {

    private static final Logger logger = logger(ConfigPage.class);

    public static void setup() {
        RestAssured.requestSpecification = defaultRequestSpecification();
        RestAssured.responseSpecification = defaultResponseSpecification();
        RestAssured.filters(new AllureRestAssured());

        logger.info("-------------------");
        logger.info("Start Configuration");
    }

    public static RequestSpecification defaultRequestSpecification() {
        return new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }

    public static ResponseSpecification defaultResponseSpecification() {
        return new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_OK).expectContentType(ContentType.JSON).build();
    }
}
