package com.example.Lab2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/example/Lab2/resources/features",
                  plugin = {"pretty" ,"html:target/Cucumber-Reports.html"}
                )

public class RunCucumberTest {

}
