package com.company.ITic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Cart extends BasePage{

    public Cart(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "country")
    WebElement country;
    @FindBy(id = "region_id")
    WebElement state;
    @FindBy(id = "postcode")
    WebElement zipCode;
    @FindBy(xpath = "//div[contains(@class,'cart-totals')]/ul/li/button[@title=\"Proceed to Checkout\"]")
    WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//input[@id=\"coupon_code\"]")
    WebElement dicountCode;
    @FindBy(xpath = "//button[@title=\"Apply\"]")
    WebElement applyButton;
    @FindBy(xpath = "//ul/li[@class=\"error-msg\"]/ul/li/span")
    WebElement errorMessage;
    @FindBy(xpath = "//button[@title=\"Continue Shopping\"]")
    WebElement continueShoppingButton;
    @FindBy(id = "empty_cart_button")
    WebElement emptyCartButton;
    @FindBy(xpath = "//div[@class=\"page-title\"]/h1")
    WebElement emptyCartMessage;

    public void selectCountry(String countryName){
        Select countrySelection = new Select(country);
        countrySelection.selectByVisibleText(countryName);
    }
    public void selectState(String stateName){
        Select stateSelection = new Select(state);
        stateSelection.selectByVisibleText(stateName);
    }
    public void enterZipCode(int zipCodeValue){
        zipCode.sendKeys(String.valueOf(zipCodeValue));
    }
    public Checkout clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
        return new Checkout (driver);
    }
    public void addCouponCode(String dicountCodeValue){
        dicountCode.sendKeys(dicountCodeValue);
    }
    public void clickApplyButton(){
        applyButton.click();
    }
    public Subcategory clickContinueShoppingBtn(){
        continueShoppingButton.click();
        return new Subcategory(driver);
    }
    public void clickEmptyCartBtn(){
        emptyCartButton.click();
    }
}
