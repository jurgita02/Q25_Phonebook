package org.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().login();
        //click on Add link [href='/add'] - css
        app.getContactHelper().addContact();
    }

    @Test
    public void removePositiveTest(){
        int sizeBefore = app.getContactHelper().sizeOfContacts();
        //click on Contact card - .contact-item_card__2SOIM -css
        app.getContactHelper().removeContact();
        app.getContactHelper().pause(1000);
        int sizeAfter = app.getContactHelper().sizeOfContacts();
        //assert contact is removed
        Assert.assertEquals(sizeAfter, sizeBefore-1);
    }

}
