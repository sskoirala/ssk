import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginTest {
    public static void main(String[] args) {
        // set the path to your Chrome driver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // navigate to the Facebook login page
        driver.get("https://www.facebook.com/");

        // find the email and password input fields and login button
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));

        // enter your email and password into the input fields
        emailInput.sendKeys("your_email_address");
        passwordInput.sendKeys("your_password");

        // click the login button
        loginButton.click();

        // wait for the page to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // verify that the login was successful
        WebElement profileLink = driver.findElement(By.xpath("//a[@title='Profile']"));
        Assert.assertTrue(profileLink.isDisplayed());

        // close the browser
        driver.quit();
    }
}


