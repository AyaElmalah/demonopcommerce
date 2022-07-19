@smoke
Feature: homeSliders Feature

  Scenario: first slider is clickable on home page
    When click on first slider
    Then  direct user to expected url

  Scenario: second slider is clickable on home page
    When click on second slide
    Then direct user to expected second slide url