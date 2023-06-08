package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {

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
    public void validateDirectoryClickable() throws InterruptedException{
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.id("menu_directory_viewDirectory"));
        WebDriverWait wt = new WebDriverWait(driver,5);
        wt.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Thread.sleep(2000);
        WebElement directoryElement = driver.findElement(By.xpath("//a[@class='toggle tiptip']"));
        Assert.assertTrue(directoryElement.isDisplayed(),"User is not able to open Directory Page");
        Reporter.log("Directory link is clickable and user is able to navigate to Directory Page");

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
