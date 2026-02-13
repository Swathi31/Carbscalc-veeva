package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CarbCalculatorPage {

    WebDriver driver;
    WebDriverWait wait;

    public CarbCalculatorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    @FindBy(id="cage")
    WebElement ageInput;

    @FindBy(xpath="//label[@for='csex1' and contains(text(),'male')]")
    WebElement genderMaleRadio;

    @FindBy(xpath="//label[@for='csex2' and contains(text(),'female')]")
    WebElement genderFemaleRadio;

    @FindBy(id="cheightmeter")
    WebElement heightInput;

    @FindBy(id="ckg")
    WebElement weightInput;

    @FindBy(id="cactivity")
    WebElement activityDropdown;

    @FindBy(xpath="//input[@value='Calculate']")
    WebElement calculateBtn;

    @FindBy(xpath="//table[@class='cinfoT']")
    WebElement resultSection;
    
    @FindBy(id = "cage")
    private WebElement ageField;

    @FindBy(css = ".bigtext")
    private WebElement resultSection1;
    
    //@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/font")
    @FindBy(xpath="//div[contains(@style,'/error.svg')]")
    private WebElement ageErrorMessage;
   
    

    // Methods
    public void enterAge(String age){
        wait.until(ExpectedConditions.visibilityOf(ageInput));
        ageInput.clear();
        ageInput.sendKeys(age);
    }

    public void selectGender(String gender){
        wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadio));
        if(gender.equalsIgnoreCase("Male")){
            genderMaleRadio.click();
        } else if(gender.equalsIgnoreCase("Female")){
            genderFemaleRadio.click();
        }
    }

    public void enterHeight(String height){
        wait.until(ExpectedConditions.visibilityOf(heightInput));
        heightInput.clear();
        heightInput.sendKeys(height);
    }

    public void enterWeight(String weight){
        wait.until(ExpectedConditions.visibilityOf(weightInput));
        weightInput.clear();
        weightInput.sendKeys(weight);
    }

    public void selectActivity(String activityLevel){
        wait.until(ExpectedConditions.visibilityOf(activityDropdown));
        Select select = new Select(activityDropdown);
        select.selectByVisibleText(activityLevel);
    }

    public void clickCalculate(){
        wait.until(ExpectedConditions.elementToBeClickable(calculateBtn));
        calculateBtn.click();
    }

    public boolean isResultDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOf(resultSection));
            return resultSection.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getResultText(){
        return resultSection.getText().trim();
    }
    
    public void clearAgeField() {
        ageField.clear();
    }


    public boolean isResultsDisplayed() {
        try {
            return resultSection1.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAgeValidationErrorDisplayed() {
        try {
            return ageErrorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
}
