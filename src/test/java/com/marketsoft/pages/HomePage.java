package com.marketsoft.pages;

import com.marketsoft.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.marketsoft.utilities.PropertiesManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HomePage extends BasePage{

    PropertiesManager propertiesManager;

    //constructor
    public HomePage (WebDriver driver) throws IOException {
        super(driver);

        propertiesManager = new PropertiesManager();


    }


    //use common property here LATER
    String baseUrl = "https://www.google.de";/*propertiesManager.getHomepageProperties("homepage_url");*/
    //String logoId = propertiesManager.getHomepageProperties("google_logo_id");

//    String searchBoxId = propertiesManager.getHomepageProperties("google_searchbox_id");




    //WebElements read from property LATER
    @FindBy(how=How.ID,using = "hplogo")
    public WebElement logoGoogle;

    @FindBy(how=How.ID, using = "lst-ib")
    public WebElement searchBox;

    @FindBy(how=How.NAME, using = "btnK")
    public WebElement btnGoogleSearch;

    @FindBy(how=How.NAME, using = "btnI")
    public WebElement btnFeelingLucky;

    //WebElements end here


    //page methods

    /*
    METHOD navigates to the specified URL via the browser under test
    RETURNs void
     */
    public void goToHomepage(){

            pageDriver.get(baseUrl/*propertiesManager.getHomepageProperties(baseUrl)*/);

    }

    /*
    METHOD to write user defined text on the search box
    RETURNs void
     */
    public void writeOnSearchBox(String textToWrite){

        this.writeText(searchBox,textToWrite);

    }

    /*
   METHOD to read text from the search box
   RETURNs String text
    */
    public String readSearchBox(String textToWrite){

        return this.readText(searchBox);
    }

      /*
   METHOD to click on the search button
   RETURNs void
    */
    public void clickOnSearchBtn(){

        this.click(btnGoogleSearch);
    }

    /*
    METHOD to click on the feeling lucky button
    RETURNs void
    */
    public void clickOnLuckyBtn(){

        this.click(btnFeelingLucky);
    }

    /*
    METHOD to flag the availability/visibility of the Google Logo in page.
    RETURNs Boolean value based on the result
    */
    public Boolean isGoogleLogoVisible(){

        return this.isAvailable(logoGoogle);

    }


//    //Go to LoginPage
//    public LoginPage goToLoginPage (){
//        click(signInButton);
//        //I want to chain LoginPage's methods so I return LoginPage by initializing its elements
//        return new PageFactory().initElements(driver,LoginPage.class);
//    }


}
