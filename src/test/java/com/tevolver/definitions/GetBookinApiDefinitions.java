package com.tevolver.definitions;

import com.tevolver.tasks.GetBooking;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class GetBookinApiDefinitions {

    @When("^is get bookin with id$")
    public void is_get_bookin_with_id() {
        OnStage.theActorCalled("Test").attemptsTo(
                GetBooking.get()
        );

    }

    @Then("^should get bookin$")
    public void should_get_bookin() {
        // Write code here that turns the phrase above into concrete actions
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse( "Get Booking Details",
                response -> response.statusCode(200)));
    }

}
