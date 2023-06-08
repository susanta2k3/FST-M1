import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String args[]){
        //declare and initialize the webdriver
        WebDriver driver = new FirefoxDriver();
        //open the url
        driver.get("https://www.training-support.net/");
        //close the driver
        driver.quit();

    }
}

