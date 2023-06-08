package Project;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTaskActivity1 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void create_list_of_activities_in_Google_Task() throws InterruptedException{
        //Add first task
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Create new task")));
        driver.findElement(MobileBy.AccessibilityId("Create new task")).click();
        Thread.sleep(2000);
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
       //add second task
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Create new task")));
        driver.findElement(MobileBy.AccessibilityId("Create new task")).click();
        Thread.sleep(2000);
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        //add third task
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Create new task")));
        driver.findElement(MobileBy.AccessibilityId("Create new task")).click();
        Thread.sleep(2000);
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(MobileBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/task_name")));
        int numberoftasks = driver.findElements(MobileBy.id("com.google.android.apps.tasks:id/task_name")).size();
        Assert.assertEquals(numberoftasks,3,"Thre tasks are not added successfully");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
