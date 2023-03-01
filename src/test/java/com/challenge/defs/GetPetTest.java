package com.challenge.defs;

import com.challenge.config.ConfigPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.challenge.process.GetPetProcess.*;
import static com.challenge.config.PropertiesPage.id;

public class GetPetTest {

    @Given("a user with a pet id")
    public void a_user_with_a_pet_id() {
        Assert.assertEquals(getPetId(), id);
    }

    @When("send a get to service path")
    public void send_a_get_to_service_path() {
        getPet();
    }

    @Then("server response is ok and with a get valid schema")
    public void server_response_is_ok_and_with_a_get_valid_schema() {
        Assert.assertEquals(validateResponse(), "Status Code and Schema Response OK");
    }
}
