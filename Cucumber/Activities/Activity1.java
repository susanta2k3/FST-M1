package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("User is on the Google home page.")
    public void userIsOnTheGoogleHomePage(){
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com");
    }

    @When("User types in Cheese and hits Enter")
    public void userTypesInCheeseAndHitsEnter(){
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);
    }

    @Then("Show how many search results were shown")
    public void showHowManySearchResultsWereShown() throws InterruptedException{
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//div[@id='result-stats']"));
        wait.until((ExpectedConditions.visibilityOf(element)));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='result-stats']")));
        String resultText=element.getText();
        System.out.println("The total number of results is : "+resultText);
    }

    @And("Close the Browser.")
    public void closeTheBrowser(){
        driver.quit();
    }
}
