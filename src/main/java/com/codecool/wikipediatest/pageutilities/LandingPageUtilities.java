package com.codecool.wikipediatest.pageutilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPageUtilities extends Utility {

    //Login Credentials
    private static final String USERNAME = System.getenv("username");
    private static final String PASSWORD = System.getenv("password");

    //Path

    private final By SIGN_IN_POPUP = By.xpath("//*[@id=\"topbar\"]//a");
    private static final By LINK_LOGIN = By.xpath("//a[@aria-label=\"Sign in\"]");

    private static final By INPUT_USERNAME =  By.xpath("//input[@id=\"identifierId\"]");
    private static final By INPUT_PASSWORD = By.xpath("//*[@type=\"password\"]");

    private static final By BUTTON_REJECT_ALL = By.xpath("//body/ytd-app[1]/ytd-consent-bump-v2-lightbox[1]/tp-yt-paper-dialog[1]/div[4]/div[2]/div[6]/div[1]/ytd-button-renderer[1]/yt-button-shape[1]/button[1]/yt-touch-feedback-shape[1]/div[1]/div[2]");
    private static final By BUTTON_LOGIN = By.xpath("//*[@jsname=\"Njthtb\"]/div/button/span");

    private final By AVATAR = By.id("avatar-btn");
    private final By AVATAR_IMG = By.xpath("//button[@id=\"avatar-btn\"]//img");
   // private static final By TEXT_VERIFY_LOGIN = By.id("pt-userpage-2");
   private static final By INPUT_SEARCH = By.id("search");

    public LandingPageUtilities(WebDriver driver) {
        super(Pages.LANDING_PAGE.getUrl(), driver);

    }

    public void clickSignInButton() {
        try {
            WebElement signInPopupButton = driver.findElement(SIGN_IN_POPUP);
            signInPopupButton.click();
        } catch (Exception e) {
            WebElement signInButton = driver.findElement(LINK_LOGIN);
            signInButton.click();
            e.getMessage();
        }

    }

    public void performLogin() {
        clickSignInButton();
       // driver.findElement(LINK_LOGIN).click();
        driver.findElement(INPUT_USERNAME).sendKeys(USERNAME, Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(INPUT_PASSWORD)).click();
        driver.findElement(INPUT_PASSWORD).sendKeys(PASSWORD, Keys.ENTER);
        //driver.findElement(BUTTON_LOGIN).click();

    }

   /*
    public void clickRejectAllButton(){
        driver.findElement(BUTTON_REJECT_ALL).click();
    } */

        public boolean verifyLogin() {
        return driver.findElement(AVATAR_IMG).isDisplayed();

    }

    public void performSearch(String wordToSearch) {
        driver.findElement(INPUT_SEARCH).sendKeys(wordToSearch, Keys.ENTER);
    }

    public void goToLink(String linkText) {
        driver.findElement(By.xpath("//*[@title='" + linkText + "']")).click();
    }
}
