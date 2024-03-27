package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;
import praktikum.pages.text.TextsOrderScooter;

import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;
    //поле для ввода имени
    final By nameField = By.xpath("//input[@placeholder= '* Имя']");
    //поле для ввода фамилии
    final By lastNameField = By.xpath("//input[@placeholder= '* Фамилия']");
    //поле для ввода адреса
    final By adresField = By.xpath("//input[@placeholder= '* Адрес: куда привезти заказ']");
    //поле для выпадающего списка станций метро
    final By metroStationList = By.className("select-search__input");
    // выбор нужной станции
    final By metroStation = By.xpath("//button[@value='99']");
    //Поле номера телефона
    final By phoneNumberField = By.xpath("//input[@placeholder= '* Телефон: на него позвонит курьер']");
    // кнопка далее
    final By buttonNext = By.xpath("//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public OrderPage sendNameAndLastname(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT)).until(ExpectedConditions.
                visibilityOfElementLocated(nameField));
    driver.findElement(nameField).sendKeys(TextsOrderScooter.NAME);
    driver.findElement(lastNameField).sendKeys(TextsOrderScooter.LAST_NAME);
    return this;
    }
    public OrderPage sendAdresToDelivery(){
        driver.findElement(adresField).sendKeys(TextsOrderScooter.ADRES);
        return this;
    }
    public OrderPage selectMetroStation(){
        driver.findElement(metroStationList).click();
        driver.findElement(metroStation).click();
        return this;
    }
    public OrderPage sendPhoneNumber(){
        driver.findElement(phoneNumberField).sendKeys(TextsOrderScooter.PHONE);
        return this;
    }
    public OrderPage clickButtonNext(){
        driver.findElement(buttonNext).click();
        return this;
    }

}
