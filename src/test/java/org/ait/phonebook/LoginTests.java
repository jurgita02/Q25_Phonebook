package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

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
    public void loginPositiveTest(){
        fillRegistrationForm("jurgita@gmail.com", "Qwerty123456$");
        //click on login button
        click(By.xpath("//button[.='Login']"));
        //assert Sign out button present
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
    }
}
