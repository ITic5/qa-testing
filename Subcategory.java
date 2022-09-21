package com.company.ITic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Subcategory extends BasePage{

    public Subcategory(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "img")
    List<WebElement> product;
    @FindBy(xpath = "//div[@class=\"actions\"]/button[@title=\"Add to Cart\"]")
    List<WebElement> atcButtons;

    public Subcategory openSingleProduct(String productName){
        for (WebElement element: product) {
            if (element.getAttribute("alt").equals(productName)){
                element.click();
                break;
            }
        }
        return new Subcategory(driver);
    }
    public Cart atcClick(int i){
        atcButtons.get(i).click();
        return new Cart(driver);
    }
}
