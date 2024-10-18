package page_object;

import ext_file_readers.TestValuesProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

import static java.lang.String.format;

public class PersonalInformationForOrderPage extends BasePage{

    @FindBy(xpath = "//input[contains(@placeholder, 'Имя')]")
    private WebElement nameInputField;

    @FindBy(xpath = "//input[contains(@placeholder, 'Фамилия')]")
    private WebElement surnameInputField;

    @FindBy(xpath = "//input[contains(@placeholder, 'Адрес')]")
    private WebElement addressInputField;

    @FindBy(xpath = "//input[contains(@placeholder, 'метро')]")
    private WebElement metroSearchInputField;

//    @FindBy(xpath = "")
//    private WebElement metroSecondValueFromList;

    @FindBy(xpath = "//input[contains(@placeholder, 'Телефон')]")
    private WebElement phoneInputField;

    @FindBy(xpath = "//button[text()='Далее']")
    private WebElement nextButton;

    public PersonalInformationForOrderPage(){
        PageFactory.initElements(driver, this);
    }

    public PersonalInformationForOrderPage insertValuesIntoFieldsWithoutMetro(String person){
            nameInputField.sendKeys(TestValuesProvider.readConfig()
                    .getString(format("PersonalInformation.%s.name", person)));
            surnameInputField.sendKeys(TestValuesProvider.readConfig()
                    .getString(format("PersonalInformation.%s.surname", person)));
            addressInputField.sendKeys(TestValuesProvider.readConfig()
                    .getString(format("PersonalInformation.%s.address", person)));
            phoneInputField.sendKeys(TestValuesProvider.readConfig()
                    .getString(format("PersonalInformation.%s.phone", person)));

        return this;
    }

    public PersonalInformationForOrderPage selectSecondFromTopMetroStation(){
        metroSearchInputField.click();
        metroSearchInputField.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

        return this;
    }

    public RentInformationForOrderPage clickNextButton(){
        nextButton.click();
        return new RentInformationForOrderPage();
    }

}
