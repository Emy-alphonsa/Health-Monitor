package bdd_test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class FeatureStepDefinition {

    private static Response response;
    private static final String BASE_URI="http://localhost:8080";

    @Given("^I set start GET request api endpoint$")
    public void setStartGetEndPoint(){
        RestAssured.baseURI=BASE_URI;
        RestAssured.basePath="/start";
    }

    @Given("^I set stop GET request api endpoint$")
    public void setStopGetEndPoint(){
        RestAssured.baseURI=BASE_URI;
        RestAssured.basePath="/stop";
    }

    @When("^I submit the start GET request$")
    public void sendStartGetRequest(){
        RequestSpecification startRequest = RestAssured.given();
        response=startRequest.get();
    }

    @When("^I submit the stop GET request$")
    public void sendStopGetRequest(){
        RequestSpecification stopRequest = RestAssured.given();
        response=stopRequest.get();
    }

    @Then("^I should get 200 Success Status code for start GET request$")
    public void startCheckStatus(){
        int statusCode=response.getStatusCode();
        Assert.assertEquals(200,statusCode);
    }

    @Then("^I should get 200 Success Status code for stop GET request$")
    public void stopCheckStatus(){
        int statusCode=response.getStatusCode();
        Assert.assertEquals(200,statusCode);
    }
}

