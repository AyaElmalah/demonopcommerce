@smoke
  Feature: Search Feature
    Background: user open home page
      Given user navigates to home page

    Scenario Outline: user could search using product name

When I enter product name as "<product>"
And  user clicks on search button
  Examples:
  | product |
    | book |
    | laptop |
    | nike |
    Scenario Outline: user could search for product using sku
      When I enter product name using sku as "<product>"
      And user clicks on search button
      Examples:
        | product |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |

