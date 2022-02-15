package com.tevolver.definitions;

import com.tevolver.tasks.CreateBooking;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class CreateBookingApiDefinitions {

    @When("^is create booking$")
    public void is_create_booking() {
        OnStage.theActorCalled("Test").attemptsTo(
                CreateBooking.Create()

        );

    }

    @Then("^should generate new booking$")
    public void should_generate_new_booking() {
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse("Create Booking",
                response -> response.statusCode(200)));

    }
}
