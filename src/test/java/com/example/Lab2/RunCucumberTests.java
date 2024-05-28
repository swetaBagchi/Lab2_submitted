package com.example.Lab2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/example/Lab2/resources/features",
        plugin = {"pretty" ,"html:target/cucumber-report.html"},
        glue = {"helpers","src/test/java/com/example/Lab2/StepDefinition.java"} ,
        dryRun = true,
        monochrome = true)

public class RunCucumberTests {

}
