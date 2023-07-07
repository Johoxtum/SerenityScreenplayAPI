package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class SchemaResponseUpdate implements Question<Boolean> {

    private final String structure;

    public SchemaResponseUpdate(String structure) {
        this.structure = structure;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Validation schema service response",
                        response -> response
                                .assertThat()
                                .body(matchesJsonSchemaInClasspath("templates/"+ structure + ".json"))
                )
        );
        return true;
    }
    public static SchemaResponseUpdate response (String schemaResponse){
        return new SchemaResponseUpdate(schemaResponse);
    }
}