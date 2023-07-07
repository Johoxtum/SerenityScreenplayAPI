package task;

import models.GetHeaderModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchBookingTask implements Task {

    public final String endpoint;

    public SearchBookingTask(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.rest();
        actor.attemptsTo(
                Get.resource(endpoint)
                        .with(requestSpecification -> requestSpecification
                                .headers(GetHeaderModel.basicHeaders())
                                .relaxedHTTPSValidation()
                                .log().all())
        );
    }
    public static SearchBookingTask search(String endpoint){
        return instrumented(SearchBookingTask.class,endpoint);
    }
}
