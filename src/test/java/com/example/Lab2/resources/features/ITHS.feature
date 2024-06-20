Feature: Test ITHS.se for LAB2

  Background:
    Given iths.se is available
    When the user visits iths.se

  Scenario: ITHS should show correct title
    Then the title should be "IT-Högskolan – Här startar din IT-karriär!"

  Scenario: Open the window in fullsceen
    When the user accepts the cookies
    And the window opens in fullscreen
    And removes the pop-up
    Then mobile toggle menu is not visible

  Scenario: Count the number of all courses
    When the user accepts the cookies
    And removes the pop-up
    And visits all courses
    Then number of courses available are 30

  Scenario: Maximize window size and check menu button visibility
    When user maximizes the window
    And the user accepts the cookies
    And removes the pop-up
    Then mobile toggle menu is not visible

  Scenario: Click on a button and comes back to home-page
    When the user accepts the cookies
    And removes the pop-up
    And an option is clicked from home page
    And returns back to home page
    Then h1 header should be visible

  Scenario: Go to student portal and login
    When the user accepts the cookies
    And removes the pop-up
    And the user logins with username and password
    Then Mina Kurser option is visible

  Scenario: Retrieve an element by classname
    When the user accepts the cookies
    And removes the pop-up
    Then retrieves an element by classname only and the text equals to "VÄLKOMMEN TILL IT-HÖGSKOLAN"

  Scenario: Retrieve a data using multiple locators
    When the user accepts the cookies
    And removes the pop-up
    Then retrieves an element using multiple locators and the text equals to "ALLA NYHETER"

  Scenario: Hover the mouse on a title and select an option from the drop-down
    When user maximizes the window
    And the user accepts the cookies
    And removes the pop-up
    And mouse hovers on an element and select an option from the drop down
    Then the h4 heading is "Frågor & svar Antagningsprovet"





