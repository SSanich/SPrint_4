package praktikum;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import praktikum.pages.MainPage;
import praktikum.pages.text.TextsOfFaqTest;

@RunWith(Parameterized.class)
public class FaqTest {
    @ClassRule
    public static DriverRule driverRule = new DriverRule();
    private final String id;
    private final String textAnswerToCheck;
    private final String textQuestionToCheck;

    public FaqTest(String  id, String textAnswerToCheck, String textQuestionToCheck) {
        this.id = id;
        this.textAnswerToCheck = textAnswerToCheck;
        this.textQuestionToCheck = textQuestionToCheck;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"0", TextsOfFaqTest.FAQ_ANSWER_ID_0, TextsOfFaqTest.FAQ_QUESTION_ID_0},
                {"1", TextsOfFaqTest.FAQ_ANSWER_ID_1, TextsOfFaqTest.FAQ_QUESTION_ID_1},
                {"2", TextsOfFaqTest.FAQ_ANSWER_ID_2, TextsOfFaqTest.FAQ_QUESTION_ID_2},
                {"3", TextsOfFaqTest.FAQ_ANSWER_ID_3, TextsOfFaqTest.FAQ_QUESTION_ID_3},
                {"4", TextsOfFaqTest.FAQ_ANSWER_ID_4, TextsOfFaqTest.FAQ_QUESTION_ID_4},
                {"5", TextsOfFaqTest.FAQ_ANSWER_ID_5, TextsOfFaqTest.FAQ_QUESTION_ID_5},
                {"6", TextsOfFaqTest.FAQ_ANSWER_ID_6, TextsOfFaqTest.FAQ_QUESTION_ID_6},
                {"7", TextsOfFaqTest.FAQ_ANSWER_ID_7, TextsOfFaqTest.FAQ_QUESTION_ID_7},
        };
    }


    @Test
    public void checkTextsOfFaq() throws InterruptedException {
        WebDriver driver= driverRule.getDriver();
        MainPage main = new MainPage(driver);
        main.open();
        main.scrollToFaqElement(id);
        main.checkFaqText(id, textAnswerToCheck, textQuestionToCheck);
    }

}