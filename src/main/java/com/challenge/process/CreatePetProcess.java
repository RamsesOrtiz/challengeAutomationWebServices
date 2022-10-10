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

public class CreatePetProcess extends ConfigPage {

    private static final Logger logger = logger(CreatePetProcess.class);

    public static String bodyPet() {
        return bodyPet;
    }

    public static void sendPost() {

        setup("Post");
        logger.info("Body to send: " + bodyPet());

        try {
            ValidatableResponse post = RestAssured
                    .given()
                    .body(bodyPet())
                    .post(URI)
                    .then()
                    .statusCode(HttpStatus.SC_OK)
                    .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(new File("src/main/resources/schema.json")));

            logger.info("Response Post: " + post.extract().body().asString());
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
