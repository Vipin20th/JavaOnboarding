package runner;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/FeatureFiles"},
        tags = {"@Demo"},
        glue = {"src/test/java/stepDef"},
        plugin = {"pretty","json:path/to/json_repot.json"}
)


public class RunCucumberTest extends AbstractTestNGCucumberTests{

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
