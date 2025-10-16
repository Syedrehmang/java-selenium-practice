@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background: 
    Given I landed on Ecommerce page

 @SubmittingOrder
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username "<email>" and password "<password>"
    When I add product "<productName>" to the cart
    And Checkout "<productName>" and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | email                     | password     | productName  |
      | syedrehman9617@gmail.com  | Syed@199617  | ZARA COAT 3  |