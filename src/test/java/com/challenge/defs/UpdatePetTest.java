package com.challenge.defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.challenge.config.PropertiesPage.*;
import static com.challenge.process.UpdatePetProcess.*;

public class UpdatePetTest {

    @Given("a user with a previous pet created")
    public void a_user_with_a_previous_pet_created() {
        Assert.assertEquals(bodyUpdatePet(), bodyUpdate);
    }

    @When("send a put to update service path")
    public void send_a_put_to_update_service_path() {
        sendPut();
    }

    @Then("server response is ok and with put valid schema")
    public void server_response_is_ok_and_with_put_valid_schema() {
        Assert.assertEquals(validateResponse(), "Status Code and Schema Response OK");
    }
}
