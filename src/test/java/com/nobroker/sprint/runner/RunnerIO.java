package com.nobroker.sprint.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/com/nobroker/sprint/features/Scenario1.feature"}, dryRun = false, glue = "com.nobroker.sprint.stepdefinition")
public class RunnerIO extends AbstractTestNGCucumberTests{

}
