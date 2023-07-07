package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"summary"},
        features = {"src/test/resources/features/"},
        glue = {"stepdefinitions"},
        tags = "@Restful",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RestfulRunner {
}
