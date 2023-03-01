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

public class UpdatePetProcess extends ConfigPage {

    private static final Logger logger = logger(UpdatePetProcess.class);

    public static String bodyUpdatePet() {
        return bodyUpdate;
    }

    public static void sendPut() {

        setup();

        try {
            ValidatableResponse put = RestAssured
                    .given()
                    .body(bodyUpdatePet())
                    .put(URI)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/schema.json")));

            logger.info("Response Update: " + put.extract().body().asString());
            logger.info("Status Code and Schema Response OK");
            SERVER_RESPONSE = "Status Code and Schema Response OK";

        } catch (AssertionError e) {
            logger.error("Status Code and Schema Response Error: " + e);
            SERVER_RESPONSE = "Status Code and Schema Response Error";
        }

        RestAssured.reset();
    }

    public static String validateResponse() {
        return SERVER_RESPONSE;
    }


}
