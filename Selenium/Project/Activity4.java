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

public class Activity4 {

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

    @Test(dependsOnMethods={"loginValidateTest"})
    public void addEmployeeTest() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("btnAdd")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).sendKeys("Susanta");
        driver.findElement(By.id("lastName")).sendKeys("Kumar");
        driver.findElement(By.id("btnSave")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("Susanta");
        driver.findElement(By.id("searchBtn")).click();
        WebElement element = driver.findElement(By.xpath("//a[text()='Susanta']"));
        Assert.assertTrue(element.isDisplayed(),"The new employee is not added successfully");
        Reporter.log("User is able to add a new Employee successfully");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
