package org.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{


    @BeforeMethod
    public void ensurePrecondition(){
        //precondition: if user should be logged out
        if (!isElementPresent(By.cssSelector("a:nth-child(4)"))){
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        }
        //click on login link- a:nth-child(4) -css\
        driver.findElement(By.cssSelector("a:nth-child(4)")).click();
    }
    @Test
    public void newUserRegistrationPositiveTest(){
        //enter email - [placeholder='Email']- css
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("jurgita@gmail.com");
        //enter password - [placeholder='Password'] css
        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Qwerty123456$");
        //click on Registration button - //button[text()='Registration'] xpath
        driver.findElement(By.xpath("//button[text()='Registration']")).click();
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
        //assert Sign out button displayed - //button[contains(.,'Sign Out')] xpath

    }

}
