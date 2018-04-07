package com.marketsoft.tests;

import com.marketsoft.pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test (priority = 0)
    public void navigateToGoogleDEPage(){

        testPage.GetInstance(HomePage.class).goToHomepage();

        Assert.assertTrue((testPage.GetInstance(HomePage.class)).isGoogleLogoVisible());

    }

}

