@smoke
  Feature: Change Currency Feature
    Scenario: user could change currency feature
      Given user go to home page
      When Select Euro currency from the dropdown list
      Then Euro Symbol (€) is shown on the four products

