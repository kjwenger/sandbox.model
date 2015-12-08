package com.u14n.sandbox.model

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
    monochrome = true,
    dryRun = false,
    strict = true,
    format = Array[String]("pretty"),
    glue = Array[String]("com.u14n.sandbox.model.geography"),
    features = Array[String](
        "classpath:com/u14n/sandbox/model/geography/location.feature",
        "classpath:com/u14n/sandbox/model/geography/location_dao.feature"
    ),
    tags = Array[String]("~@ignore")
)
class ScalaFeatures {
  
}