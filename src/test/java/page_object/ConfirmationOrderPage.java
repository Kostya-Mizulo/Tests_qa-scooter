package page_object;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ConfirmationOrderPage extends BasePage{
    @FindBy(xpath = "//div[contains(text(), 'Заказ оформлен')]")
    private WebElement successModalTitle;


    public ConfirmationOrderPage(){
        PageFactory.initElements(driver, this);
    }


    public boolean isOrderCreatedSuccessfully(){
        try {
            return successModalTitle.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }


}
