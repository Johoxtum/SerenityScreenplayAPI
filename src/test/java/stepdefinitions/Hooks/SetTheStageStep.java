package stepdefinitions.Hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class SetTheStageStep {

    public static EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage(){

        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Usuario");
        String theRestApiBaseUrl = environmentVariables.optionalProperty("environments.stg.baseurl")
                .orElse("environments.dev.baseurl");
        theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

}


