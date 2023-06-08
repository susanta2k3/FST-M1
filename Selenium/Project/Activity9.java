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

import java.util.List;

public class Activity9 {

    public WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        Reporter.log("User is able to open the HCM application successfully");
    }

    @Test
    public void loginValidateTest(){
        WebElement username=driver.findElement(By.id("txtUsername"));
        WebElement password=driver.findElement(By.id("txtPassword"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement dashboard=driver.findElement(By.xpath("//h1[text()='Dashboard']"));
        Assert.assertTrue(dashboard.isDisplayed());
        Reporter.log("User is able to successfully login to application and validate the Home Page");
    }

    @Test(dependsOnMethods = {"loginValidateTest"})
    public void editInfoTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Emergency Contacts']")).click();
        Thread.sleep(2000);
        List<WebElement> contactrows=driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));
        for(int r=1;r<=contactrows.size();r++){
            String contactname = driver.findElement(By.xpath("//table[@id='emgcontact_list']/tbody/tr["+r+"]//td/a")).getText();
            String RelationShip = driver.findElement(By.xpath("//table[@id='emgcontact_list']/tbody/tr["+r+"]//td[3]")).getText();
            String ContactNo = driver.findElement(By.xpath("//table[@id='emgcontact_list']/tbody/tr["+r+"]//td[5]")).getText();
            System.out.println("The emergency Contact details are: Name: "+contactname+" , Relationship: "+RelationShip+" ,Contact No: "+ContactNo);
        }
        Reporter.log("User is able to retrive and print emergency contact details");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
