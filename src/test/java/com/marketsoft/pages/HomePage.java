package com.marketsoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.marketsoft.utilities.PropertiesManager;

import java.io.IOException;


public class HomePage {

    private WebDriver driver;

    static PropertiesManager testProperties = new PropertiesManager();

    //Page URL
    private static String PAGE_URL;

    static {
        try {
            PAGE_URL = testProperties.getTestProperties("homepage_url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Locators

    //Apply as Developer Button
    @FindBy(how = How.ID, using = "APPLY AS A DEVELOPER")
    private WebElement developerApplyButton;

    //Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnDeveloperApplyButton(){

        developerApplyButton.click();

    }

}
