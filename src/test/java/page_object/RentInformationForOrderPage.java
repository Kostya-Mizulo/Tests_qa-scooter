package page_object;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class RentInformationForOrderPage extends BasePage{
    @FindBy(xpath = "//input[contains(@placeholder, 'Когда привезти самокат')]")
    private WebElement calendarInputField;

    @FindBy(xpath = "//button[text()='Next Month']")
    private WebElement nextMonthIconButtonInCalendar;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[text()='9']")
    private WebElement dayElementInCalendar;

    @FindBy(className = "Dropdown-control")
    private WebElement rentalPeriodField;

    @FindBy(xpath = "//div[@class='Dropdown-option' and contains(text(),'сутки')]")
    private WebElement oneDayRentSelect;

    @FindBy(xpath = "//input[@id='black']")
    private WebElement checkboxForBlackScooter;

    @FindBy(xpath = "//div[contains(@class, 'Order_Buttons')]//button[text()='Заказать']")
    private WebElement orderButton;

    @FindBy(xpath = "//input[contains(@placeholder, 'Комментарий')]")
    private WebElement commentInputField;

    @FindBy(xpath = "//div[contains(@class, 'Order_Modal')]//button[text()='Да']")
    private WebElement confirmOrderButton;


    public RentInformationForOrderPage(){
        PageFactory.initElements(driver, this);
    }


    public RentInformationForOrderPage insertRentInformationFirstOption(){
        calendarInputField.click();
        nextMonthIconButtonInCalendar.click();
        dayElementInCalendar.click();
        rentalPeriodField.click();
        oneDayRentSelect.click();
        checkboxForBlackScooter.click();

        return this;
    }


    public RentInformationForOrderPage insertRentInformationSecondOption(){
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String tomorrowForInsert = tomorrow.format(formatter);
        calendarInputField.sendKeys(tomorrowForInsert, Keys.ENTER);
        rentalPeriodField.click();
        oneDayRentSelect.click();
        checkboxForBlackScooter.click();
        commentInputField.sendKeys("Ты крутой!");

        return this;
    }


    public ConfirmationOrderPage clickAndConfirmOrder(){
        orderButton.click();
        confirmOrderButton.click();

        return new ConfirmationOrderPage();
    }


}