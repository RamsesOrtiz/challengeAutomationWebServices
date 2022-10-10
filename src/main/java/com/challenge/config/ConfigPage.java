package com.challenge.config;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Logger;

import static com.challenge.config.LoggerPage.logger;

public class ConfigPage {

    private static final Logger logger = logger(ConfigPage.class);

    public static void setup(String step) {
        RestAssured.requestSpecification = defaultRequestSpecification();
        RestAssured.responseSpecification = defaultResponseSpecification();
        RestAssured.requestSpecification = new RequestSpecBuilder().build().filter(new AllureRestAssured());

        logger.info("-------------------");
        logger.info("Start " + step + " Configuration");
    }

    public static RequestSpecification defaultRequestSpecification() {
        return new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }

    public static ResponseSpecification defaultResponseSpecification() {
        return new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_OK).expectContentType(ContentType.JSON).build();
    }
}
