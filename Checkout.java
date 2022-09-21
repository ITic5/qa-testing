package com.company.ITic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout extends BasePage{

    public Checkout(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[contains(@class,'step-title')]/h2")
    WebElement chechoutAssert;
    @FindBy(xpath = "//div[@class=\"col-1\"]//li[@class=\"control\"]//label[@for=\"login:guest\"]")
    WebElement checkoutRegisterFirstRadio;
    @FindBy(xpath = "//div[@class=\"col-1\"]//li[@class=\"control\"]//label[@for=\"login:register\"]")
    WebElement checkoutRegisterSecondRadio;
    @FindBy(id = "onepage-guest-register-button")
    WebElement continueCheckoutRegisterButton;
    @FindBy(id = "billing:firstname")
    WebElement firstName;
    @FindBy(id = "billing:lastname")
    WebElement lastName;
    @FindBy(id = "billing:email")
    WebElement email;
    @FindBy(id = "billing:street1")
    WebElement address;
    @FindBy(id = "billing:city")
    WebElement city;
    @FindBy(id = "billing:postcode")
    WebElement zipCode;
    @FindBy(id = "billing:telephone")
    WebElement phoneNumber;
    @FindBy(id = "billing:region_id")
    WebElement state;
    @FindBy(id = "billing:country_id")
    WebElement country;
    @FindBy(xpath = "//li[@class=\"control\"]//label[@for=\"billing:use_for_shipping_yes\"]")
    WebElement shippingFirstRadio;
    @FindBy(xpath = "//li[@class=\"control\"]//label[@for=\"billing:use_for_shipping_no\"]")
    WebElement shippingSecondRadio;
    @FindBy(xpath = "//div[@id=\"billing-buttons-container\"]/button[@title=\"Continue\"]")
    WebElement addressContinueButton;
    @FindBy(xpath = "//div[@id=\"shipping-method-buttons-container\"]/button")
    WebElement shippingMethodContinueButton;
    @FindBy(xpath = "//div[@id=\"payment-buttons-container\"]/button")
    WebElement paymentInfoContinueButton;
    @FindBy(xpath = "//button[@title=\"Place Order\"]")
    WebElement placeOrderButton;

    public void selectRegisterRadio(String radio){
        switch (radio){
            case "Checkout as Guest":
                if (!checkoutRegisterFirstRadio.isSelected()){
                    checkoutRegisterFirstRadio.click();
                }
            break;
            case "Register and Checkout":
                if (!checkoutRegisterSecondRadio.isSelected()){
                    checkoutRegisterSecondRadio.click();
                }
            break;
        }
    }
    public void clickContinueCheckoutRegisterBtn(){
        continueCheckoutRegisterButton.click();
    }
    public void enterFirstName (String firstNameValue){
        firstName.sendKeys(firstNameValue);
    }
    public void enterLastName (String lastNameValue){
        lastName.sendKeys(lastNameValue);
    }
    public void enterEmail (String emailValue){
        email.sendKeys(emailValue);
    }
    public void enterAddress (String addressValue){
        address.sendKeys(addressValue);
    }
    public void enterCity (String cityValue){
        city.sendKeys(cityValue);
    }
    public void enterZipCode (String zipValue){
        zipCode.sendKeys(zipValue);
    }
    public void enterPhoneNumber (String phoneValue){
        phoneNumber.sendKeys(phoneValue);
    }
    public void selectState(String stateName){
        Select stateSelection = new Select(state);
        stateSelection.selectByVisibleText(stateName);
    }
    public void selectCountry(String countryName){
        Select countrySelection = new Select(country);
        countrySelection.selectByVisibleText(countryName);
    }
    public void selectShipRadio(String shipRadio){
        switch (shipRadio){
            case "Ship to this address":
                if (!shippingFirstRadio.isSelected()){
                    shippingFirstRadio.click();
                }
                break;
            case "Ship to different address":
                if (!shippingSecondRadio.isSelected()){
                    shippingSecondRadio.click();
                }
                break;
        }
    }
    public void clickAddressContinueButton(){
        addressContinueButton.click();
    }
    public void clickShippingMethodContinueBtn(){
        WebElement menuMen = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@id=\"shipping-method-buttons-container\"]/button")));
        shippingMethodContinueButton.click();
    }
    public void clickPaymentInfoContinueBtn(){
        WebElement menuMen = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@id=\"payment-buttons-container\"]/button")));
        paymentInfoContinueButton.click();
    }
    public OrderPage clickPlaceOrderBtn (){
        WebElement menuMen = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@title=\"Place Order\"]")));
        placeOrderButton.click();
        return new OrderPage (driver);
    }

}
