package stepdefinitions;

import environments.Endpoint;
import exceptions.AssertionsServices;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.AuthDTO;
import net.serenitybdd.rest.SerenityRest;
import questions.SchemaResponseUpdate;
import questions.StatusCodeUpdate;
import task.AuthTask;
import task.SearchBookingTask;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.Assertions.assertThat;

public class RestfulStep {

    AuthDTO authDTO = new AuthDTO();
    @Given("el usuario se quiere autenticar")
    public void elUsuarioSeQuiereAutenticar() {
        theActorInTheSpotlight().describedAs("Ingresa a la app");
    }
    @When("se envía una solicitud POST con los siguientes datos:")
    public void seEnvíaUnaSolicitudPOSTConLosSiguientesDatos(List<Map<String, String>> data) {

        Map<String, String> parameters = data.get(0);

        authDTO.setUsername(parameters.get("username"));
        authDTO.setPassword(parameters.get("password"));
        theActorInTheSpotlight().attemptsTo(
                AuthTask.token(Endpoint.TOKEN,authDTO)
        );
    }
    @Then("la respuesta debe tener un código de estado {int}")
    public void laRespuestaDebeTenerUnCódigoDeEstado(int responseCode) {
        theActorInTheSpotlight()
                .should(seeThat(StatusCodeUpdate.is(responseCode))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED)
                );

    }
    @Then("la respuesta debe contener el {string} con un {int}")
    public void laRespuestaDebeContenerElTokenAcceso(String SchemaResponse, int responseCode ) {
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(responseCode);
        theActorInTheSpotlight()
                .should(seeThat(SchemaResponseUpdate.response(SchemaResponse)));
    }

    @Given("que el usuario desea conocer los libros disponibles")
    public void queElUsuarioDeseaConocerLosLibrosDisponibles() {

        theActorInTheSpotlight().describedAs("Buscar libros disponibles");

    }

    @When("envía una solicitud a la base de datos")
    public void envíaUnaSolicitudALaBaseDeDatos() {
        theActorInTheSpotlight().attemptsTo(
                SearchBookingTask.search(Endpoint.BOOKING)
        );
    }
}
