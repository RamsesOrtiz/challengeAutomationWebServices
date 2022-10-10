package com.challenge.defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.challenge.config.PropertiesPage.bodyPet;
import static com.challenge.process.CreatePetProcess.*;

public class CreatePetTest {

    @Given("a user with a pet info in json format")
    public void a_user_with_a_pet_info_in_json_format() {
        Assert.assertEquals(bodyPet(), bodyPet);
    }

    @When("send a post to service path")
    public void send_a_post_to_service_path() {
        sendPost();
    }

    @Then("server response is ok and with a post valid schema")
    public void server_response_is_ok_and_with_a_post_valid_schema() {
        Assert.assertEquals(validateResponse(), "Status Code and Schema Response OK");
    }
}
