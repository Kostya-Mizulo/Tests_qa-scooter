package page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationOrderPage extends BasePage{
    @FindBy(xpath = "//div[contains(text(), 'Заказ оформлен')]")
    private WebElement successModalTitle;

    public boolean isOrderCreatedSuccessfully(){
        return successModalTitle.isDisplayed();
    }
}
