import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String args[]){
        //declare and initialize the webdriver
        WebDriver driver = new FirefoxDriver();
        //open the url
        driver.get("https://www.training-support.net/");
        //get the title
        String title = driver.getTitle();
        System.out.println("Page title is : "+title);
        WebElement idlocator=driver.findElement(By.id("about-link"));
        System.out.println("The text from element is: "+idlocator.getText());
        WebElement classlocator=driver.findElement(By.className("green"));
        System.out.println("The text from element is: "+classlocator.getText());
        WebElement linklocator=driver.findElement(By.linkText("About Us"));
        System.out.println("The text from element is: "+linklocator.getText());
        WebElement csslocator=driver.findElement(By.cssSelector(".green"));
        System.out.println("The text from element is: "+csslocator.getText());
        //close the driver
        driver.quit();

    }
}
