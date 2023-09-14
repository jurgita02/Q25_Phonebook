package org.ait.phonebook.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager  {
    String browser;
    public WebDriver driver;

UserHelper user;
ContactHelper contactHelper;
HomePageHelper homePageHelper;

    public ApplicationManager(String browser) {
        this.browser=browser;
    }

    public void init() {
System.err.close();
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")) {
            driver =new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("microsoftedge")) {
            driver = new EdgeDriver();

        }


                    driver.get("https://telranedu.web.app");
            //maximize browser window
            driver.manage().window().maximize();
            //set implicit timeout
            driver.manage().timeouts().implicitlyWait(23, TimeUnit.SECONDS);
            user = new UserHelper(driver);
            contactHelper = new ContactHelper(driver);
            homePageHelper = new HomePageHelper(driver);
        }
    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public HomePageHelper getHomePageHelper() {
        return homePageHelper;
    }

    public void stop() {
        driver.quit();
    }

}
