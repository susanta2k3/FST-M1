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

public class Activity7 {

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
    public void addWorkExperienceTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@id='sidenav']//a[text()='Qualifications']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Tester");
        driver.findElement(By.id("experience_from_date")).click();
        driver.findElement(By.id("experience_from_date")).sendKeys("2022-01-01");
        driver.findElement(By.id("experience_employer")).click();
        driver.findElement(By.id("experience_to_date")).click();
        driver.findElement(By.id("experience_to_date")).sendKeys("2022-05-06");
        driver.findElement(By.id("experience_employer")).click();
        driver.findElement(By.id("btnWorkExpSave")).click();
        Thread.sleep(2000);
        Reporter.log("User is able to add Work experience under Qualifications");


    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
