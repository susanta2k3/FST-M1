package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    public WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Reporter.log("User is able to open the HCM application successfully");
    }

    @Test
    public void printHeaderImageURL(){
        WebElement element = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
        String url = element.getAttribute("src");
        System.out.println("The url of header image is: "+url);
        Reporter.log("User is able to get and print the url from header image");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
