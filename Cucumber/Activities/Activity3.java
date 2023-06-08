package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity3 {
    private WebDriver driver;
    private WebDriverWait wait;

    Alert alert;

    @Given("User is on the page")
    public void user_is_on_page(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("User clicks the Simple Alert button")
    public void user_clicks_on_Simple_Alert(){
    driver.findElement(By.id("simple")).click();
    }

    @When("User clicks the Confirm Alert button")
    public void user_clicks_Confirm_Alert(){
        driver.findElement(By.id("confirm")).click();
    }

    @When("User clicks the Prompt Alert button")
    public void user_clicks_Prompt_Alert(){
        driver.findElement(By.id("prompt")).click();
    }

    @Then("Alert opens")
    public void alert_open(){
         alert = driver.switchTo().alert();
    }

    @Then("Read the text from it and print it")
    public void read_from_alert_and_print(){
        String alertText = alert.getText();
        System.out.println("The alert text displayed is: "+alertText);
    }

    @Then("Close the alert")
    public void close_alert(){
        alert.accept();
    }

    @Then("Close the alert with Cancel")
    public void close_alert_cancel(){
        alert.dismiss();
    }

    @Then("Write a custom message {string} in it")
    public void write_custom_message_in_alert(String message){
        alert.sendKeys(message);
    }

    @Then("Read the result text")
    public void read_the_result_text(){
        driver.switchTo().defaultContent();
        String title = driver.getTitle();
        System.out.println("The title text is : "+title);
    }


    @And("Close Browser")
    public void closeTheBrowser(){
        driver.quit();
    }
}
