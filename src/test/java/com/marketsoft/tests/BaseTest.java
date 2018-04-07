package com.marketsoft.tests;

import com.marketsoft.utilities.PageCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public WebDriver testDriver;
    public WebDriverWait wait;
    public PageCreator testPage;

    final int timeout = 10;

    @BeforeClass
    public void setUpBeforeClass() {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        testDriver = new ChromeDriver();

        wait = new WebDriverWait(testDriver,timeout);

        testDriver.manage().window().maximize();

    }

    @BeforeMethod
    public void setUpBeforeMethod(){
        testPage = new PageCreator(testDriver);
    }

    @AfterClass
    public void tearDown(){
        testDriver.quit();
    }

}
