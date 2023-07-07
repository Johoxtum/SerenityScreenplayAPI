package environments;


import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import stepdefinitions.Hooks.SetTheStageStep;


public class Endpoint {

    public Endpoint() {}
    public static String setEndpoint(String path) {
        return EnvironmentSpecificConfiguration.from(SetTheStageStep.environmentVariables).getProperty(path);
    }


    public static final String TOKEN = setEndpoint("auth");
    public static final String BOOKING = setEndpoint("book");

}