package Activities;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity1 {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("noReset",true);
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity",".Calculator");
        URL appServer= new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer,caps);
    }

    @Test
    public void activity(){
        driver.findElementById("digit_5").click();
        driver.findElementByAccessibilityId("multiply").click();
        // Using XPath
        driver.findElementByXPath("//android.widget.Button[@text='9']").click();

        // Perform Calculation
        driver.findElementById("eq").click();
        String resultTest = driver.findElement(MobileBy.id("result")).getText();
        System.out.println("Result is : "+resultTest);
        Assert.assertEquals("45",resultTest);

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
