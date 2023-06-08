package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity2 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("User is on the Login Page.")
    public void user_is_on_the_login_page(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @When("User enters {string} and {string} to login to the application")
    public void user_enters_admin_and_to_login_to_the_application(String username, String password) throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }
    @Then("User validates the welcome message.")
    public void user_validates_the_welcome_message() {
        String title = driver.getTitle();
        System.out.println("The  page title is "+title);
    String welcomeText = driver.findElement(By.id("action-confirmation")).getText();
    System.out.println("The welcome message displayed is: "+welcomeText);
    Assert.assertEquals(welcomeText,"Welcome Back, admin");
    }

    @And("Close the Browser after execution.")
    public void close_TheBrowser_after_Execution(){
        driver.quit();
    }
}
