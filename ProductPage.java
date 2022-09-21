package com.company.ITic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'add-to-cart-buttons')]/button")
    WebElement atcButton;
    @FindBy(xpath = "//span/img")
    List<WebElement> colors;
    @FindBy(xpath = "//li/a/span")
    List<WebElement> sizes;

    public void pickColor(String colorName) {
        for (WebElement element : colors) {
            if (element.getAttribute("alt").equals(colorName)) {
                element.click();
                break;
            }
        }
    }

    public void pickSize(String size) {
        for (WebElement element : sizes) {
            if (element.getText().equals(size)) {
                element.click();
                break;
            }
        }
    }

    public Cart clickAtcButton() {
        atcButton.click();
        return new Cart(driver);
    }


}
