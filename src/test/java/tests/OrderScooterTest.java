package tests;


import org.junit.Test;
import page_object.ConfirmationOrderPage;
import page_object.QAScooterMainPage;
import static org.junit.Assert.assertTrue;

public class OrderScooterTest extends BaseTest{
    @Test
    public void orderScooterWithPickCalendarAndNoCommentSuccessfullOrdered(){

        ConfirmationOrderPage confirmationPage = new QAScooterMainPage()
                .clickTopOrderButton()
                .insertValuesIntoFieldsWithoutMetro("person1")
                .selectSecondFromTopMetroStation()
                .clickNextButtonSuccess()
                .insertRentInformationFirstOption()
                .clickAndConfirmOrder();

        assertTrue("Ошибка: не удалось оформить заказ самоката", confirmationPage.isOrderCreatedSuccessfully());
    }

    @Test
    public void orderScooterWithWritingDateAndCommentSuccessfullOrdered(){

        ConfirmationOrderPage confirmationPage = new QAScooterMainPage()
                .clickBottomOrderButton()
                .insertValuesIntoFieldsWithoutMetro("person2")
                .selectSecondFromTopMetroStation()
                .clickNextButtonSuccess()
                .insertRentInformationSecondOption()
                .clickAndConfirmOrder();

        assertTrue("Ошибка: не удалось оформить заказ самоката", confirmationPage.isOrderCreatedSuccessfully());
    }


}
