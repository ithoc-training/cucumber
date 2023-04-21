package de.ithoc.training;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("linkz")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class LinkzSuite {
}
