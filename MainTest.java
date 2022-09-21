package com.company.ITic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest{

    @Test
    public void AddFrenchMenShirtToCart(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openSubcategoryMen("Shirts");
        Subcategory subcategory = new Subcategory(driver);
        subcategory.openSingleProduct("French Cuff Cotton Twill Oxford");
        ProductPage productPage = new ProductPage(driver);
        productPage.pickColor("White");
        productPage.pickSize("L");
        productPage.clickAtcButton();
        WebElement frenchShirtAssert = driver.findElement(By.xpath("//tr/td/a/img[@alt=\"French Cuff Cotton Twill Oxford\"]"));
        Assert.assertTrue(frenchShirtAssert.isDisplayed());
    }

    @Test
    public void ProceedToCheckout(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openSubcategoryMen("Shirts");
        Subcategory subcategory = new Subcategory(driver);
        subcategory.openSingleProduct("Plaid Cotton Shirt");
        ProductPage productPage = new ProductPage(driver);
        productPage.pickColor("Khaki");
        productPage.pickSize("M");
        productPage.clickAtcButton();
        Cart cart = new Cart(driver);
        cart.selectCountry("United States");
        cart.selectState("California");
        cart.enterZipCode(94203);
        cart.clickProceedToCheckoutButton();
        Checkout checkout = new Checkout(driver);
        String expectedCheckoutAssert = "CHECKOUT METHOD";
        Assert.assertEquals(checkout.chechoutAssert.getText(), expectedCheckoutAssert);
    }

    @Test
    public void ApplyWrongDicountCode(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openSubcategoryWomen("New Arrivals");
        Subcategory subcategory = new Subcategory(driver);
        subcategory.openSingleProduct("Tori Tank");
        ProductPage productPage = new ProductPage(driver);
        productPage.pickColor("Indigo");
        productPage.pickSize("M");
        productPage.clickAtcButton();
        Cart cart = new Cart(driver);
        cart.addCouponCode("wrongdicountcode");
        cart.clickApplyButton();
        String expectedMessageAssert = "Coupon code \"wrongdicountcode\" is not valid.";
        Assert.assertEquals(cart.errorMessage.getText(), expectedMessageAssert);
    }

    @Test
    public void AddAndRemoveProducts(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openSubcategoryHomeAndDecor("Bed & Bath");
        Subcategory subcategory = new Subcategory(driver);
        subcategory.atcClick(2);
        Cart cart = new Cart(driver);
        cart.clickContinueShoppingBtn();
        subcategory.atcClick(3);
        cart.clickContinueShoppingBtn();
        subcategory.atcClick(1);
        cart.clickEmptyCartBtn();
        String expectedEmptyCartMessage = "SHOPPING CART IS EMPTY";
        Assert.assertEquals(cart.emptyCartMessage.getText(), expectedEmptyCartMessage);
    }

    @Test
    public void FullOrderingProcess(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openSubcategoryHomeAndDecor("Bed & Bath");
        Subcategory subcategory = new Subcategory(driver);
        subcategory.atcClick(0);
        Cart cart = new Cart(driver);
        cart.selectCountry("United States");
        cart.selectState("California");
        cart.enterZipCode(94203);
        cart.clickProceedToCheckoutButton();
        Checkout checkout = new Checkout(driver);
        checkout.selectRegisterRadio("Checkout as Guest");
        checkout.clickContinueCheckoutRegisterBtn();
        checkout.enterFirstName("Stefan");
        checkout.enterLastName("Itic");
        checkout.enterEmail("stefanitic@fptc.com");
        checkout.enterAddress("633 West Fifth Street");
        checkout.enterCity("Sacramento");
        checkout.selectState("California");
        checkout.enterZipCode("94203");
        checkout.selectCountry("United States");
        checkout.enterPhoneNumber("+1 213-683-1000");
        checkout.selectShipRadio("Ship to this address");
        checkout.clickAddressContinueButton();
        checkout.clickShippingMethodContinueBtn();
        checkout.clickPaymentInfoContinueBtn();
        checkout.clickPlaceOrderBtn();
        OrderPage orderPage = new OrderPage(driver);
        String expectedThankYouMessage = "THANK YOU FOR YOUR PURCHASE!";
        WebElement menuMen = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("h2.sub-title")));
        Assert.assertEquals(orderPage.thankYouMessage.getText(), expectedThankYouMessage);
    }
}
