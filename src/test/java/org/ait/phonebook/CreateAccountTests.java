package org.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition(){
        //precondition: if user should be logged out
        if (!isLoginLinkPresent()){
            clickOnSignOutButton();
        }
        //click on login link- a:nth-child(4) -css\
        clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //leidzia naudoti ta pati meila n kartu.
        int i = (int)System.currentTimeMillis()/1000%3000;
        //enter email - [placeholder='Email']- css
        fillRegistrationForm("jurgita"+i+"@gmail.com", "Qwerty123456$");
        //click on Registration button - //button[text()='Registration'] xpath
        clickOnRegistrationButton();
        //assert is appeared, ta lentele virsuje, ispejimas, ten turi buti kazkas parasyta.T.y. Alert
Assert.assertTrue(isAlertPresent());

    }

}
