package com.tevolver.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/get_booking.feature",
        glue = "com.tevolver.definitions"
)
public class GetBookingApiRun {
}
