package com.company.ITic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    ChromeDriver driver;

    @BeforeMethod
    public void openChromeDriver(){
        System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo-store.seleniumacademy.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeChromeDriver(){
        driver.close();
    }

}
