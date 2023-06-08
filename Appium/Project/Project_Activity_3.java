
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Project_Activity_3 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void add_reminder_in_Google_Keep() throws InterruptedException{
        //wait for add note button
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("New text note")));
        driver.findElement(MobileBy.AccessibilityId("New text note")).click();
        Thread.sleep(2000);
        String titlelocator ="resourceId(\"com.google.android.keep:id/browse_note_interior_content\")";
        //add note and description
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/editable_title")));
        driver.findElement(MobileBy.id("com.google.android.keep:id/editable_title")).sendKeys("Test Bonus");
        String notedesclocator = "resourceId(\"com.google.android.keep:id/edit_note_text\")";
        driver.findElement(MobileBy.AndroidUIAutomator(notedesclocator)).sendKeys("This task is to test the bonus module.");
        driver.findElement(MobileBy.id("com.google.android.keep:id/menu_reminder")).click();
        Thread.sleep(1000);
        //driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.view.ViewGroup[1]").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Later today']").click();
        driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]").click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//androidx.cardview.widget.CardView[contains(@content-desc,\"Test Bonus\")]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]")));
        String noteTitle = driver.findElement(MobileBy.xpath("//androidx.cardview.widget.CardView[contains(@content-desc,\"Test Bonus\")]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]")).getText();
        Assert.assertEquals(noteTitle,"Test Bonus");
        Assert.assertTrue(driver.findElementById("com.google.android.keep:id/reminder_chip_text").isDisplayed());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
