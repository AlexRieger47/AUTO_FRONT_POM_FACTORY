package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.plugin", value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty")
@ConfigurationParameter(key = "cucumber.publish.quiet", value = "true")
@ConfigurationParameter(key = "cucumber.glue", value = "stepdefinitions")
public class CucumberTestSuite {
}
