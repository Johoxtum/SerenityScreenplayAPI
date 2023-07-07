package task;

import models.AuthDTO;
import models.GetHeaderModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AuthTask implements Task {

    private final String endpoint;
    private final AuthDTO authDTO;

    public AuthTask(String endpoint, AuthDTO authDTO) {
        this.endpoint = endpoint;
        this.authDTO = authDTO;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SerenityRest.rest();
        actor.attemptsTo(
                Post.to(endpoint)
                        .with(request -> request
                                .headers(GetHeaderModel.basicHeaders())
                                .body(authDTO)
                                .relaxedHTTPSValidation()
                                .log().all())
        );
    }
    public static AuthTask token(String endpoint,AuthDTO authDTO){
        return instrumented(AuthTask.class,endpoint,authDTO);
    }
}
