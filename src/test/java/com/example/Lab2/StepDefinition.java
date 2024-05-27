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

    @When("the user accepts the cookies")
    public void the_user_accepts_the_cookies() {
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Then("h1 header should be visible")
    public void h1_header_should_be_visible() {
       boolean visibilityOfH1 = driver.findElement(By.tagName("h1")).isDisplayed();
       assertTrue(visibilityOfH1);
    }

    @When("the window opens in fullscreen")
    public void the_window_opens_in_fullscreen() {
        driver .manage().window().fullscreen();

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Then("mobile toggle menu is not visible")
    public void mobile_toggle_menu_is_not_visible() {
        boolean visibilityOfMobileToggleMenu = driver.findElement(By.xpath("//*[@id=\"mobile-toggle\"]/i")).isDisplayed();
        assertFalse(visibilityOfMobileToggleMenu);
    }

    @When("removes the pop-up")
    public void removes_the_pop_up() {
        driver.findElement(By.xpath("//*[@id=\"popmake-5683\"]/button")).click();

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("visits all courses")
    public void visits_all_courses() {
        driver.findElement(By.xpath("//*[@id=\"mobile-toggle\"]/i")).click();
        driver.findElement(By.xpath("//*[@id=\"nav-utbildningar\"]/a")).click();
    }

    @Then("number of courses available are {int}")
    public void number_of_courses_available_are(Integer expectedNumberOfCourses) {
        List<WebElement> myCourses = driver.findElements(By.xpath("//*[@id='search-filter-results-4749']/div/div"));
        int size = myCourses.size();
        assertEquals(expectedNumberOfCourses,size);

    }

    @When("user maximizes the window")
    public void user_maximizes_the_window() {
        driver.manage().window().maximize();
    }

    @When("an option is clicked from home page")
    public void an_option_is_clicked_from_home_page() {
        driver.findElement(By.xpath("//*[@id=\"frontpage\"]/div/div[1]/div/div/div[2]/div/a[3]")).click();

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("returns back to home page")
    public void returns_back_to_home_page() {
        driver.navigate().back();
    }

    @When("the user logins with username and password")
    public void the_user_logins_with_username_and_password() {

        driver.findElement(By.xpath("//*[@id=\"mobile-toggle\"]/i")).click();
        driver.findElement(By.xpath("//*[@id=\"nav-studentportaliclassfarfasigninalti\"]/a")).click();
        WebElement usrname = driver.findElement(By.id("username"));
        WebElement pwd = driver.findElement(By.id("password"));

        //Credential Details
        usrname.sendKeys("sweta.bagchi@iths.se");
        pwd.sendKeys("Sweta@1988");
        driver.findElement(By.id("loginbtn")).click();
    }

    @Then("Mina Kurser option is visible")
    public void mina_kurser_option_is_visible() {
        boolean visibilityOfMinaKurser = driver.findElement(By.xpath("//*[@id=\"main-navigation0\"]")).isDisplayed();
        assertFalse(visibilityOfMinaKurser);
    }

    @Then("retrieves an element by classname only and the text equals to {string}")
    public void the_text_equals_to(String expectedString) {
        String elementByClassName = driver.findElement(By.className("hero__preheader")).getText();
        assertEquals(expectedString,elementByClassName);
    }

    @Then("retrieves an element using multiple locators and the text equals to {string}")
    public void retrieves_an_element_using_multiple_locators_and_the_text_equals_to(String expectedString) {
        String elementByMultipleLocators =driver.findElement(By.xpath("//*[contains(@class, 'post-slider__more btn') and contains(@href , 'https://www.iths.se/nyheter/')]")).getText();
        assertEquals(expectedString, elementByMultipleLocators);
    }

    @When("mouse hovers on an element and select an option from the drop down")
    public void mouse_hovers_on_an_element_and_select_an_option_from_the_drop_down() {
        //Hovering the mouse
        WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"nav-frstuderande\"]/a"));
        //Instantiating Actions class
        Actions actions = new Actions(driver);
        //Hovering on main menu
        actions.moveToElement(mainMenu);
        WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"nav-antagningsprovet\"]/a"));
        //To mouseover on sub menu
        actions.moveToElement(subMenu);
        actions.click().build().perform();
    }

    @Then("the h4 heading is {string}")
    public void the_h4_heading_is(String expectedHeading) {
        String elementOnTheFinalPage = driver.findElement(By.tagName("h4")).getText();
        assertEquals(expectedHeading,elementOnTheFinalPage);
    }

    @After
    public void closeDriver() {
        System.out.println("**END OF TEST**");
        if(driver != null) {
            driver.quit();
        }
    }
}
