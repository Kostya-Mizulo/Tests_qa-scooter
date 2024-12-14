package tests;

import ext_file_readers.TestValuesProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import page_object.QAScooterMainPage;
import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class FAQTest extends BaseTest{
    private final String question;
    private final String answer;


    public FAQTest(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    @Parameterized.Parameters
    public static Object[][] getFAQValues(){
        return TestValuesProvider.FAQ_VALUES;
    }


    @Test
    public void clickQuestionInFAQCorrectAnswerOpensSuccessfully(){
        QAScooterMainPage mainPage = new QAScooterMainPage();
        mainPage.scrollToAccordion();

        String locatorToAccordionItemQuestion = ((new StringBuilder())
                .append("//div[@class='accordion__button' and contains(text(), '")
                .append(question)
                .append("')]"))
                .toString();

        driver.findElement(By.xpath(locatorToAccordionItemQuestion)).click();

        String locatorToAccordionItemAnswer = ((new StringBuilder())
                .append(locatorToAccordionItemQuestion)
                .append("/ancestor::div[@class='accordion__item']//div[@class='accordion__panel']"))
                .toString();

        String actualTextInAccordion = driver.findElement(By.xpath(locatorToAccordionItemAnswer)).getText();

        assertTrue("Текст ответа не совпадает с ожидаемым", actualTextInAccordion.contains(answer));
    }


}