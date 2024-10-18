package page_object;


import ext_file_readers.TestValuesProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAScooterMainPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class, 'Header_Header')]//button[text()='Заказать']")
    private WebElement topOrderButton;

    @FindBy(xpath = "//div[contains(@class, 'Home_FinishButton')]//button[text()='Заказать']")
    private WebElement bottomOrderButton;


    public QAScooterMainPage(){
        driver.get(TestValuesProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public PersonalInformationForOrderPage clickTopOrderButton(){
        topOrderButton.click();
        return new PersonalInformationForOrderPage();
    }
}
