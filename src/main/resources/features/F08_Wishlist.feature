@smoke
Feature:Wishlist Feature
  Background: user click on wishlist icon
    When click on wishlist button

  Scenario: add product to your wishlist
  Then success message "The product has been added to your wishlist"

     Scenario: click on succes message and check number of wishlist
       When click on wishlist message
       Then check number of wishlist