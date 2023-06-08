package Activities;

import io.appium.java_client.MobileBy;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity5 {
    private AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("noReset",true);
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void sendSms(){
        driver.findElementByAccessibilityId("Start new conversation").click();
        String contactbox ="resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(contactbox)));
        driver.findElement(MobileBy.AndroidUIAutomator(contactbox)).sendKeys("9804547710");
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        String messageTextBox = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(messageTextBox)));
        driver.findElement(MobileBy.AndroidUIAutomator(messageTextBox)).sendKeys("Hello from Appium");
        driver.findElement(MobileBy.AndroidUIAutomator(messageTextBox)).click();
        String finalMessageText="resourceId(\"com.google.android.apps.messaging:id/message_text\")";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator(finalMessageText)));
        String textfrommessage = driver.findElement(MobileBy.AndroidUIAutomator(finalMessageText)).getText();
        System.out.println("The message from text is "+textfrommessage);
        Assert.assertEquals("Hello from appium",textfrommessage);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
