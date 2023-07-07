package questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static utils.constants.Constant.VALIDATION_STATUS_CODE;

public class StatusCodeUpdate implements Question<Boolean> {

    private final int code;

    public StatusCodeUpdate(int code) {
        this.code =  code;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.should(
                seeThatResponse(VALIDATION_STATUS_CODE,
                        response -> response
                                .statusCode(code)
                )
        );

        return true;
    }

    public static StatusCodeUpdate is(int statusCode) {
        return new StatusCodeUpdate(statusCode);
    }
}

