package com.tevolver.tasks;

import com.tevolver.utils.Globals;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class UpdateBooking implements Task {

    private final String name;

    public UpdateBooking(String name) {
        this.name = name;
    }

    public static UpdateBooking Update(String name) {

        return Tasks.instrumented(UpdateBooking.class, name);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to("/booking/1").with(
                request ->  request.header("Cookie","token="+ Globals.token)
                        .header("Content-Type", "application/json")
                        .header("Accept","application/json")
                        .body("{\n" +
                                "    \"firstname\" : \"" + name + "\",\n" +
                                "    \"lastname\" : \"Brown\",\n" +
                                "    \"totalprice\" : 111,\n" +
                                "    \"depositpaid\" : true,\n" +
                                "    \"bookingdates\" : {\n" +
                                "        \"checkin\" : \"2018-01-01\",\n" +
                                "        \"checkout\" : \"2019-01-01\"\n" +
                                "    },\n" +
                                "    \"additionalneeds\" : \"Breakfast\"\n" +
                                "}"))
        );


        SerenityRest.lastResponse().prettyPrint();
        Globals.firstname = SerenityRest.lastResponse().jsonPath().getString("firstname");

    }


}
