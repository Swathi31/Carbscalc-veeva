Feature: Carbohydrate Calculator
  # Scenario 1: Calculate carbs for moderate activity

  Scenario: Calculate daily carbohydrates for a moderately active male
    Given User is on the carbohydrate calculator page
    When User enters age as "30"
    And User selects gender as "Male"
    And User enters height as "175"
    And User enters weight as "70"
    And User selects activity level as "Moderate: exercise 4-5 times/week"
    And User clicks on Calculate button
    Then User should see daily calorie requirement displayed
    
    
  # Scenario 2: Calculate carbs for weight loss goal
 
  Scenario: Calculate carbohydrate intake for weight loss
    When User enters age as "28"
    And User selects gender as "Female"
    And User enters height as "165"
    And User enters weight as "65"
    And User selects activity level as "Light: exercise 1-3 times/week"
    And User clicks on Calculate button
    Then User should see reduced calorie recommendation
    And User should see adjusted carbohydrate intake for weight loss
    And User verifies the results section is displayed correctly


  # Scenario 3: Validate error message for invalid input

  Scenario: Verify validation message when mandatory fields are empty
    When User leaves age field empty
    And User clicks on Calculate button
    Then User should see validation error message for age
    And Calculation results should not be displayed


    
    