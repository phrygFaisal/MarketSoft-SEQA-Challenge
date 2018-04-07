package com.marketsoft.tests;

import com.marketsoft.utilities.PageCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;

public class BaseTest {

    public WebDriver testDriver;
    public WebDriverWait wait;
    public PageCreator testPage;

    final int timeout = 10;

    @BeforeClass
    @Parameters("browser")
    public void setUpBeforeClass(String browser) {

        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "chromedriver");
                testDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver");
                testDriver = new FirefoxDriver();
                break;
            case "opera":
                OperaOptions options = new OperaOptions();

                options.setBinary(new File("operadriver"));


//                System.setProperty("webdriver.chrome.driver","operadriver");
                testDriver = new OperaDriver(options);

                break;
            default:
                System.setProperty("webdriver.chrome.driver","chromedriver");
                testDriver = new ChromeDriver();
                break;
        }

//        System.setProperty("webdriver.chrome.driver", "chromedriver");
//
//        testDriver = new ChromeDriver();

        wait = new WebDriverWait(testDriver,timeout);

        testDriver.manage().window().maximize();

    }

    @BeforeMethod
    public void setUpBeforeMethod(){

        testPage = new PageCreator(testDriver);
    }

    @AfterClass
    public void tearDown(){

        testDriver.close();

        testDriver.quit();
    }

}
