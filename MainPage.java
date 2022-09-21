package com.company.ITic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends BasePage{

    public MainPage (ChromeDriver driver){
        this.driver = driver;
    }

    public Subcategory openSubcategoryMen (String subcategoryName){

        WebElement menuMen = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(@class,'has-children') and text()='Men']")));
        new Actions(driver).moveToElement(menuMen).build().perform();
        List<WebElement> subcategories = driver.findElements
                (By.xpath("//a[contains(@class,'has-children') and text()='Men']//following::ul[1]//li/a"));
        for (WebElement element: subcategories) {
            if (element.getText().equals(subcategoryName)){
                element.click();
                break;
            }
        }
        return new Subcategory(driver);
    }
    public Subcategory openSubcategoryWomen (String subcategoryName){

        WebElement menuMen = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(@class,'has-children') and text()='Women']")));
        new Actions(driver).moveToElement(menuMen).build().perform();
        List<WebElement> subcategories = driver.findElements
                (By.xpath("//a[contains(@class,'has-children') and text()='Women']//following::ul[1]//li/a"));
        for (WebElement element: subcategories) {
            if (element.getText().equals(subcategoryName)){
                element.click();
                break;
            }
        }
        return new Subcategory(driver);
    }

    public Subcategory openSubcategoryHomeAndDecor (String subcategoryName){

        WebElement menuMen = new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(@class,'has-children') and text()='Home & Decor']")));
        new Actions(driver).moveToElement(menuMen).build().perform();
        List<WebElement> subcategories = driver.findElements
                (By.xpath("//a[contains(@class,'has-children') and text()='Home & Decor']//following::ul[1]//li/a"));
        for (WebElement element: subcategories) {
            if (element.getText().equals(subcategoryName)){
                element.click();
                break;
            }
        }
        return new Subcategory(driver);
    }

}
