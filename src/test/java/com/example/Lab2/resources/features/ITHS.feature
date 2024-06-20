Feature: Test ITHS.se for LAB2

  Background:
    Given iths.se is available
    When the user visits iths.se

  Scenario: ITHS should show correct title
    Then the title should be "IT-Högskolan – Här startar din IT-karriär!"

