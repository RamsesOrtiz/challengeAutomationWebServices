package com.challenge.process;

import com.challenge.config.ConfigPage;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.Logger;

import java.io.File;

import static com.challenge.config.LoggerPage.logger;
import static com.challenge.config.PropertiesPage.*;

public class GetPetProcess extends ConfigPage {

    private static final Logger logger = logger(GetPetProcess.class);

    public static int getPetId() {
        return id;
    }

    public static void getPet() {

        setup("Get");
        logger.info("Get Pet ID: " + getPetId());

        try {
            ValidatableResponse get = RestAssured
                    .given()
                    .when()
                    .get(getURI + getPetId())
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/schema.json")));

            logger.info("Response Get: " + get.extract().body().asString());
            logger.info("Status Code and Schema Response OK");
            SERVER_RESPONSE = "Status Code and Schema Response OK";

        } catch (AssertionError e) {
            logger.error("Status Code and Schema Response Error: " + e);
            SERVER_RESPONSE = "Status Code and Schema Response Error";
        }
    }

    public static String validateResponse() {
        return SERVER_RESPONSE;
    }
}
