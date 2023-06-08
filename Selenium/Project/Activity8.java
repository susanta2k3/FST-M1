package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity8 {

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
    public void applyLeave() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Apply Leave']/..")).click();
        Select leaveType = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leaveType.selectByVisibleText("DayOff");
        driver.findElement(By.id("applyleave_txtFromDate")).click();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2022-06-01");
        driver.findElement(By.id("applyleave_txtLeaveType")).click();
        driver.findElement(By.id("applyleave_txtToDate")).click();
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2022-06-01");
        driver.findElement(By.id("applyleave_txtLeaveType")).click();
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("calFromDate")).click();
        driver.findElement(By.id("calFromDate")).clear();
        driver.findElement(By.id("calFromDate")).sendKeys("2022-06-01");
        driver.findElement(By.id("btnSearch")).click();
        driver.findElement(By.id("calToDate")).click();
        driver.findElement(By.id("calToDate")).clear();
        driver.findElement(By.id("calToDate")).sendKeys("2022-06-01");
        driver.findElement(By.id("btnSearch")).click();
        Thread.sleep(2000);
        WebElement leaveapplied=driver.findElement(By.xpath("//a[contains(text(),'2022-06-01')]/../following-sibling::td/a[contains(text(),'Pending Approval')]"));
        Assert.assertTrue(leaveapplied.isDisplayed());
        Reporter.log("User is able to apply leave successfully");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
