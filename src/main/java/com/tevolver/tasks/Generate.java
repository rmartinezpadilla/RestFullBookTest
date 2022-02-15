package com.tevolver.tasks;

import com.tevolver.models.User;
import com.tevolver.utils.Globals;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class Generate implements Task {

    private final String user;
    private final String password;

    public Generate(String user, String password) {
        this.user = user;
        this.password = password;

    }

    public static Generate newToken(String user, String password) {

        return Tasks.instrumented(Generate.class, user, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        User user = new User(this.user,this.password);
        actor.attemptsTo(Post.to("/auth").with(request -> request.header("Content-Type", "application/json")
                .body(user))
        );

        //Constans.token = SerenityRest.lastResponse().prettyPrint();
        SerenityRest.lastResponse().prettyPrint();
        Globals.token =  SerenityRest.lastResponse().jsonPath().getString("token");


    }
}
