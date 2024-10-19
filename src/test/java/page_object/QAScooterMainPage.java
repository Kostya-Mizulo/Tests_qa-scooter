package page_object;


import ext_file_readers.TestValuesProvider;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAScooterMainPage extends BasePage{

    @FindBy(xpath = "//div[contains(@class, 'Header_Header')]//button[text()='Заказать']")
    private WebElement topOrderButton;

    @FindBy(xpath = "//div[contains(@class, 'Home_FinishButton')]//button[text()='Заказать']")
    private WebElement bottomOrderButton;

    @FindBy(id = "rcc-confirm-button")
    private WebElement confirmCookieButton;

    @FindBy(className = "accordion")
    private WebElement accordion;


    public QAScooterMainPage(){
        driver.get(TestValuesProvider.URL);
        PageFactory.initElements(driver, this);
        confirmCookieButton.click();
    }

    public PersonalInformationForOrderPage clickTopOrderButton(){
        topOrderButton.click();
        return new PersonalInformationForOrderPage();
    }

    public PersonalInformationForOrderPage clickBottomOrderButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bottomOrderButton);
        bottomOrderButton.click();
        return new PersonalInformationForOrderPage();
    }

    public QAScooterMainPage scrollToAccordion(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", accordion);
        return this;
    }
}
