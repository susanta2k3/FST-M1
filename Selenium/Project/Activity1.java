package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

    public WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Reporter.log("User is able to open the HCM application successfully");
    }

    @Test
    public void checkTitle(){
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM",title,"The title is not correct");
        Reporter.log("The title is displayed correctly as Orange HCM");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
