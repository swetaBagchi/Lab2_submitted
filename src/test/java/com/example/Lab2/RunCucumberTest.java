package com.example.Lab2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/example/Lab2/resources",
                  plugin = {"pretty" ,"html:*/Cucumber-Reports.html"},
                  publish = true
                )

public class RunCucumberTest {

}
