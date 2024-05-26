package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features="src/test/resources/features",
        plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue={"com.StepDefinitions","com.hook"},
        tags = "@fake-search",
        monochrome=true
)
public class Runner extends AbstractTestNGCucumberTests {
}