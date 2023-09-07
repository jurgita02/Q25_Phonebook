package org.ait.phonebook;

import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition(){
        //precondition: if user should be logged out
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        //click on login link- a:nth-child(4) -css\
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //leidzia naudoti ta pati meila n kartu.
        int i = (int)System.currentTimeMillis()/1000%3000;
        //enter email - [placeholder='Email']- css
        app.getUser().fillRegistrationForm(new User().setEmail("jurgita@gmail.com").setPassword("Qwerty123456$"));
        //click on Registration button - //button[text()='Registration'] xpath
        app.getUser().clickOnRegistrationButton();
        //assert is appeared, ta lentele virsuje, ispejimas, ten turi buti kazkas parasyta.T.y. Alert
Assert.assertTrue(app.getUser().isAlertPresent());

    }

}
