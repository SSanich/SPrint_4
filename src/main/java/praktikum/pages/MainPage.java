package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;


public class MainPage {
    private final WebDriver driver;
//локатор кнопки куки
    final By cookieAcceptButton = cssSelector("[class *=App_CookieButton]");
    // локатор кнопки  выдапающего списка «Вопросы о важном»
    final String faqListButton ="accordion__heading-";
    //локатор  текста с ответом на вопрос из раздела «Вопросы о важном»
    final String textAnswerOfFaqList ="//div[@aria-labelledby= 'accordion__heading-";
    //локатор  кнопки входа из header
    public static final By orderButtonHeader =xpath("//button[@class='Button_Button__ra12g']");
    //локатор  кнопки входа из body
    public static final By orderButtonBody =xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //открыть основную страницу
    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);
        return this;
    }
    // отправить куки, плашка не будет мешать
    public MainPage acceptCookie() {
        driver.findElement(cookieAcceptButton).click();
        return this;
    }

    // проверка текстов вопросов/ответов  выпадающего списка
    public MainPage checkFaqText(String id, String textAnswerToCheck, String textQuestionToCheck) {
        // ожидание  кнопки выпадающего списка
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated
                (By.id(faqListButton + id)));
        //клик по кнопке
        driver.findElement(By.id(faqListButton + id)).click();
        //проверка текста вопроса
        assertEquals(EnvConfig.INVALID_TEXT, textQuestionToCheck, driver.findElement(By.id(faqListButton +id)).getText());
        // ожидание  текста выпадающего списка
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated
                (xpath(textAnswerOfFaqList + id+"']//p")));
        //проверка текста ответа
        assertEquals(EnvConfig.INVALID_TEXT, textAnswerToCheck, driver.findElement(xpath((textAnswerOfFaqList + id+"']//p"))).
                getText());
        return this;
    }

    //перейти на странице к элементу
    public MainPage scrollToFaqElement(String id){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.
                findElement(By.id("accordion__heading-"+id)));
        return this;
    }
    // клик по кнопке заказать
    public MainPage clickOrderButton(By enterPoint){
        driver.findElement(enterPoint).click();
        return this;
    }
}
