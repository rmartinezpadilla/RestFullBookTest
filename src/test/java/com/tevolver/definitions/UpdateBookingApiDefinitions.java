package com.tevolver.definitions;

import com.tevolver.tasks.Generate;
import com.tevolver.tasks.UpdateBooking;
import com.tevolver.utils.Constans;
import com.tevolver.utils.Globals;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UpdateBookingApiDefinitions {
public static String text;

    @Before
    public void init() {

        OnStage.setTheStage(OnlineCast.whereEveryoneCan(CallAnApi.at(Constans.BASE_URL)));
        OnStage.theActorCalled("Test");
    }

    @When("is created token with user: (.*) and password: (.*)")
    public void is_created_token_with_user_and_password(String user, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Generate.newToken(user,password)
        );

    }

    @Then("should generate new token")
    public void should_generate_new_token() {
        OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse( "User details should be correct",
                response -> response.statusCode(200).body("token", Matchers.not(Matchers.empty()))));

    }

    @When("^is update booking firstname: (.*)$")
    public void is_update_booking(String firstname){
        text= firstname;
        OnStage.theActorInTheSpotlight().attemptsTo(
                UpdateBooking.Update(firstname)
        );

    }

    @Then("^should booking update$")
    public void should_booking_update(){
    OnStage.theActorInTheSpotlight().should(ResponseConsequence.seeThatResponse("Update Booking",
            response -> response.statusCode(200))
            );
    assertThat(text, is(equalTo(Globals.firstname)));
    }
}