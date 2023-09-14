package org.ait.phonebook;

import org.ait.phonebook.models.Contact;
import org.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviders;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().login();
        //click on Add link [href='/add'] - css
        app.getContactHelper().clickOnAddLink();
    }

    @Test
    public void addContactPositiveTest(){
        //enter all input fields in contact form -input:nth-child(1) - css
        app.getContactHelper().fillContactForm(new Contact()
                .setName("Karl")
                .setSurname( "Adam")
                .setPhoneNumber("1234567890")
                .setEmail("adam@gmail.com")
                .setAddress( "Koblenz")
                .setDesc("goalkeeper"));
        //click on Save button -.add_form__2rsm2 button - css
        app.getContactHelper().clickOnSaveButton();
        //assert by text contact is added
    Assert.assertTrue(app.getContactHelper().isContactAdded("Karl"));

}

    @AfterMethod
public void postCondition(){
        app.getContactHelper().removeContact();
    }



    @Test(dataProvider = "newContact",dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String name, String surname, String phone, String email, String address, String description){

        app.getContactHelper().fillContactForm(new Contact()
                .setName(name)
                .setSurname( surname)
                .setPhoneNumber(phone)
                .setEmail(email)
                .setAddress( address)
                .setDesc(description));

        app.getContactHelper().clickOnSaveButton();

        Assert.assertTrue(app.getContactHelper().isContactAdded(name));

    } @Test(dataProvider = "newContactWithCSVFile", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProviderWithCSV(Contact contact){

        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().pause(1000);
        app.getContactHelper().clickOnSaveButton();

Assert.assertEquals(Integer.toString(app.getContactHelper().sizeOfContacts()),"1");

    }
}
