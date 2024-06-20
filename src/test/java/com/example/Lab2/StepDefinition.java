package com.example.Lab2;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinition {

    WebDriver driver;
    ChromeOptions options;


    //Background
    @Given("iths.se is available")
    public void iths_se_is_available() {
        options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("headless=new");
        driver = new ChromeDriver(options);
    }
    @When("the user visits iths.se")
    public void the_user_visits_iths_se() {
        driver.get("https://www.iths.se");
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedString) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedString,actualTitle);
    }


    @After
    public void closeDriver() {
        System.out.println("**END OF TEST**");
        if(driver != null) {
            driver.quit();
        }
    }
}
