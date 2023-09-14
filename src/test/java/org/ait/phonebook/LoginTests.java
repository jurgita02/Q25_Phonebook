package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: if user should be logged out
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        //click on login link- a:nth-child(4) -css\
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().fillRegistrationForm(new User().setEmail("jurgita@gmail.com").setPassword("Qwerty123456$"));
        //click on login button
        app.getUser().clickOnLoginButton();
        //assert Sign out button present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().fillRegistrationForm(new User().setPassword("Qwerty123456$"));
        //click on login button
        app.getUser().clickOnLoginButton();
        //assert Sign out button present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void loginPositiveTestWithScreencast() throws IOException, AWTException {
        app.getUser().deleteScreencast();
        app.getUser().startRecording();
        app.getUser().fillRegistrationForm(new User()
                .setEmail("jurgita@gmail.com")
                .setPassword("Qwerty123456$"));
        //click on login button
        app.getUser().clickOnRegistrationButtonForScreencast();
        app.getUser().pause(5000);
      app.getUser().startRecording();
    }
}