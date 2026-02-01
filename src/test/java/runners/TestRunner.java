package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",   // caminho dos arquivos .feature
        glue = {"steps", "support"},                           // pacote onde estão os Step e context
        plugin = {"pretty", "html:target/cucumber-report.html"}, // relatórios
        monochrome = true                           // saída mais legível no console
)
public class TestRunner {
}
