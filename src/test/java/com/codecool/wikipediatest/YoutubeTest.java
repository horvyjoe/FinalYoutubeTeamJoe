package com.codecool.wikipediatest;

import com.codecool.wikipediatest.pageutilities.LandingPageUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class YoutubeTest {

    private static WebDriver driver;
    private static LandingPageUtilities landingPageUtilities;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*", "--start-maximized", "--incognito");  //"--headless=new"

        driver = new ChromeDriver(options);
        landingPageUtilities = new LandingPageUtilities(driver);

        landingPageUtilities.navigateToUrl();
    }

    @Disabled
    @Test
    @DisplayName("Login to YouTube")
    void login() {
        landingPageUtilities.performLogin();

       //Assertions.assertEquals(2, 2);

    }

    //@Disabled
    @Test
    @DisplayName("Search YouTube")
    void searchForFunny() {
        landingPageUtilities.performLogin();
       // landingPageUtilities.performSearch("funny");

     //   String expectedUrl = "https://www.youtube.com/results?search_query=funny+dog";

     //   landingPageUtilities.goToLink(" ");

     //   Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Disabled
    @Test
    @DisplayName("Search for Framework")
    void searchForFramework() {
        String searchWord = "Framework";
        landingPageUtilities.performSearch(searchWord);
        String expectedUrl = "https://en.wikipedia.org/wiki/" + searchWord;
        landingPageUtilities.goToLink(searchWord);
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    /*
    @AfterEach
    void tearDown() {
        driver.quit();
    }

     */

}