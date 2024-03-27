package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;
import praktikum.pages.text.TextsOrderScooter;

import java.time.Duration;

public class RentPage {
    private final WebDriver driver;

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }
    //поле даты доставки
      final By deliveryDate = By.xpath("//input[@placeholder= '* Когда привезти самокат']");
    // подтвердить увыбранную дату
      final By confirmDate = By.xpath("//div[@class= 'react-datepicker-popper']");
    //   поле срок аренды
      final By rentTermDropDown = By.className("Dropdown-placeholder");
    // выбрать срок аренды 2 суток
    public static final By chooseRentTermTwoDays = By.xpath("//div[contains(text(),'двое суток')]");
    //выбрать срок аренды сутки
    public static final  By chooseRentTermOneDay = By.xpath("//div[contains(text(),'сутки')]");
    //выбрать цвет черный
    public static final By scooterColourBlack = By.xpath("//input[@id= 'black']");
    //выбрать цвет серый
    public static final By scooterColourGrey = By.xpath("//input[@id= 'grey']");
    //поле коменметарий для курьера
      final By commentField = By.xpath("//input[@class= 'Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //кнопка заказать
      final By orderButton = By.xpath("//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка подтвердить заказ
      final By orderButtonConfirm = By.xpath("//button[contains(text(), 'Да')]");
    //окно Заказ оформлен
      final By orderIsProcessedModal = By.xpath("//div[contains(text(), 'Заказ оформлен')]");

    public RentPage sendDeliveryDate(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDate));
        driver.findElement(deliveryDate).sendKeys(TextsOrderScooter.DATA);
        driver.findElement(confirmDate).click();
        return this;
    }
    public RentPage rentTerm(By rentTern){
        driver.findElement(rentTermDropDown).click();
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(rentTern));
        driver.findElement(rentTern).click();
        return  this;
    }
    public RentPage chooseScooterColour(By scooterColour){
        driver.findElement(scooterColour).click();
        return this;
    }
    public RentPage sendCommentToCourier(){
        driver.findElement(commentField).sendKeys(TextsOrderScooter.COMMENT_TO_COURIER);
        return this;
    }
    public RentPage clickOrderButton(){
        driver.findElement(orderButton).click();
        return this;
    }
    public RentPage clickOrderButtonConfirm(){
        driver.findElement(orderButtonConfirm).click();
        return this;
    }
    public RentPage modalOrderIsProcessedIsVisible(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT)).
                until(ExpectedConditions.visibilityOfElementLocated(orderIsProcessedModal));
        return this;
    }
}
