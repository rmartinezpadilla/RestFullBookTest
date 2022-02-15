package com.tevolver.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetBooking implements Task {

    public static GetBooking get() {
        return Tasks.instrumented(GetBooking.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Get.resource("/booking/{id}").with(
                request -> request.pathParam("id", 1)));

        SerenityRest.lastResponse().prettyPrint();

    }

}
