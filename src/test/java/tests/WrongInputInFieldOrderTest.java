package tests;

import org.junit.Test;
import page_object.PersonalInformationForOrderPage;
import page_object.QAScooterMainPage;
import static org.junit.Assert.assertTrue;

public class WrongInputInFieldOrderTest extends BaseTest{

    @Test
    public void wrongInputInFieldNameCauseValidationErrorTest(){
        PersonalInformationForOrderPage personalInformationForOrderPage = (new QAScooterMainPage())
                .clickTopOrderButton().clickNextButtonError();

        assertTrue("Текст ошибки не отображается",
                personalInformationForOrderPage.isNameInputValidationErrorTextDisplayed());
    }

    @Test
    public void wrongInputInFieldSurnameCauseValidationErrorTest(){
        PersonalInformationForOrderPage personalInformationForOrderPage = (new QAScooterMainPage())
                .clickTopOrderButton().clickNextButtonError();

        assertTrue("Текст ошибки не отображается",
                personalInformationForOrderPage.isSurnameInputValidationErrorTextDisplayed());
    }

    @Test
    public void wrongInputInFieldAddressCauseValidationErrorTest(){
        PersonalInformationForOrderPage personalInformationForOrderPage = (new QAScooterMainPage())
                .clickTopOrderButton().clickNextButtonError();

        assertTrue("Текст ошибки не отображается",
                personalInformationForOrderPage.isAddressInputValidationErrorTextDisplayed());
    }

    @Test
    public void wrongInputInFieldMetroCauseValidationErrorTest(){
        PersonalInformationForOrderPage personalInformationForOrderPage = (new QAScooterMainPage())
                .clickTopOrderButton().clickNextButtonError();

        assertTrue("Текст ошибки не отображается",
                personalInformationForOrderPage.isMetroInputValidationErrorTextDisplayed());
    }

    @Test
    public void wrongInputInFieldPhoneCauseValidationErrorTest(){
        PersonalInformationForOrderPage personalInformationForOrderPage = (new QAScooterMainPage())
                .clickTopOrderButton().clickNextButtonError();

        assertTrue("Текст ошибки не отображается",
                personalInformationForOrderPage.isPhoneInputValidationErrorTextDisplayed());
    }
}
