package com.u14n.sandbox.model;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    monochrome = true,
    dryRun = false,
    strict = true,
    format = { "pretty" },
    glue = "com.u14n.sandbox.model",
    features = {
            "classpath:com/u14n/sandbox/model/address.feature"
    },
    tags = {"~@ignore"}
)
/**
 * @author Klaus Wenger
 *
 */
public class JavaFeatures {
    // Empty
}
