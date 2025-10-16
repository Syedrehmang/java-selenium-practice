@tag
Feature: Verify the error displayed for invalid credentails
  I want to use this template for my feature file
  
@ErrorValidation
  Scenario Outline: Error displayed for invalid credentails
    Given I landed on Ecommerce page
    Given Logged in with username "<email>" and password "<password>"
    Then "Incorrect email or password." message is displayed
    

    Examples: 
      | email                     | password     | 
      | syedrehman9617@gmail.com  | Syed@19961   |