package dev.selenium.tests;

import dev.selenium.bases.BaseTest;
import dev.selenium.pageObjects.CarModelPage;
import dev.selenium.pageObjects.HomePage;
import dev.selenium.pageObjects.RegisterPage;
import dev.selenium.pageObjects.componentObjects.NavigationBarComponent;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SanityTests extends BaseTest {

    @Test
    public void UserCanSeeHomePage() {
        HomePage homePage = new HomePage(this.driver).get();

        // Assertion
        assertAll("homepage",
                () -> assertTrue(homePage.navigationBar.isStandardNavigationBarDisplay()),
                () -> assertTrue(homePage.banner.isBannerComponentDisplayed()),
                () -> assertTrue(homePage.getPopularMakeHeader().isDisplayed()),
                () -> assertTrue(homePage.getPopularMakeLink().isDisplayed()),
                () -> assertTrue(homePage.getPopularModelHeader().isDisplayed()),
                () -> assertTrue(homePage.getPopularModelLink().isDisplayed()),
                () -> assertTrue(homePage.getOverallRatingHeader().isDisplayed()),
                () -> assertTrue(homePage.getOverallRatingLink().isDisplayed())
        );
    }

    @Test
    public void UserCanloginSuccessfully() throws InterruptedException {
        HomePage homePage = new HomePage(this.driver).get();

        // Action: Login on Navigation bar of Home page
        NavigationBarComponent navBar = homePage.navigationBar;
        navBar.successfullyLoginWithUsername();

        // Assertion
        assertTrue(navBar.isLoggedInNavigationBarDisplay());
    }

    @Test
    public void newUserCanRegisterAndLogInSuccessfully() {
        HomePage homePage = new HomePage(this.driver).get();

        // Action: Register new user
        RegisterPage registerPage = homePage.navigationBar.clickRegister();
        String registeredUsername = registerPage.successfullyRegisterNewUser();
        assertEquals(registerPage.getSuccessMsg().getText(), "Registration is successful");

        // Assertion: Log in with registered user
        registerPage.navigationBar.successfullyLoginWithUsername(registeredUsername);
        assertTrue(registerPage.navigationBar.isLoggedInNavigationBarDisplay());
    }

    @Test
    public void UserCanLoginAndVoteOnCarModelPage() throws InterruptedException {
        CarModelPage carModelPage = new CarModelPage(this.driver).get();

        // Action
        carModelPage.navigationBar.successfullyLoginWithUsername();

        // Assertion
        assertAll("vote section",
                () -> assertTrue(carModelPage.getVoteLabel().isDisplayed()),
                () -> assertTrue(carModelPage.getCommentTextBox().isDisplayed()),
                () -> assertTrue(carModelPage.getCommentTextBox().isEnabled()),
                () -> assertTrue(carModelPage.getVoteButton().isDisplayed()),
                () -> assertTrue(carModelPage.getVoteButton().isEnabled())
        );
    }

    @Test
    public void UserCanLogout() throws InterruptedException {
        HomePage homePage = new HomePage(this.driver).get();

        // Navigation bar on Home page
        NavigationBarComponent navBar = homePage.navigationBar;
        navBar.successfullyLoginWithUsername();

        // Action
        navBar.logoutSuccessfully();

        // Assertion
        assertTrue(navBar.isStandardNavigationBarDisplay());
    }
}

