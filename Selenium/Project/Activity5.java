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

public class Activity5 {

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
    public void editInfoTest() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Edit']")).click();
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Susanta");
        driver.findElement(By.id("personal_txtEmpLastName")).clear();
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Kumar");
        driver.findElement(By.id("personal_optGender_2")).click();
        driver.findElement(By.id("personal_cmbNation")).click();
        driver.findElement(By.xpath("//option[text()='Indian']")).click();
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        Thread.sleep(2000);
        Reporter.log("User is able to update the information successfully");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
