package base;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CarbCalculatorPage;
import utils.DriverFactory;

public class CarbCalculatorSteps {

    CarbCalculatorPage calc = new CarbCalculatorPage(DriverFactory.getDriver());

    @Given("User is on the carbohydrate calculator page")
    public void userOnCalculatorPage(){
        DriverFactory.getDriver().get("https://www.calculator.net/carbohydrate-calculator.html");
    }

    @When("User enters age as {string}")
    public void userEntersAge(String age){
        calc.enterAge(age);
    }

    @When("User selects gender as {string}")
    public void userSelectsGender(String gender){
        calc.selectGender(gender);
    }

    @When("User enters height as {string}")
    public void userEntersHeight(String height){
        calc.enterHeight(height);
    }

    @When("User enters weight as {string}")
    public void userEntersWeight(String weight){
        calc.enterWeight(weight);
    }

    @When("User selects activity level as {string}")
    public void userSelectsActivity(String activityLevel){
        calc.selectActivity(activityLevel);
    }

    @When("User clicks on Calculate button")
    public void userClicksCalculate(){
        calc.clickCalculate();
    }

    @Then("User should see daily calorie requirement displayed")
    public void dailyCalorieRequirementDisplayed(){
        Assert.assertTrue(calc.getResultText().contains("Calories"), "Calorie requirement not displayed");
    }

    @Then("User should see reduced calorie recommendation")
    public void reducedCalorieDisplayed(){
        Assert.assertTrue(calc.getResultText().contains("Calories"), "Reduced calorie recommendation not displayed");
    }

    @Then("User should see adjusted carbohydrate intake for weight loss")
    public void adjustedCarbsDisplayed(){
        Assert.assertTrue(calc.getResultText().contains("Weight Maintenance"), "Adjusted carbs not displayed");
    }

    @Then("User verifies the results section is displayed correctly")
    public void verifyResultsSection(){
        Assert.assertTrue(calc.isResultDisplayed(), "Results section not displayed correctly");
    }
    
    @When("User leaves age field empty")
    public void user_leaves_age_field_empty() {
        calc.clearAgeField();
    }


    @Then("User should see validation error message for age")
    public void user_should_see_validation_error_message_for_age() {
        Assert.assertTrue(calc.isAgeValidationErrorDisplayed(),
                "Age validation error message is not displayed!");
    }

    @Then("Calculation results should not be displayed")
    public void calculation_results_should_not_be_displayed() {
        Assert.assertFalse(calc.isResultsDisplayed(),
                "Calculation results should not be displayed when input is invalid!");
    }
}
