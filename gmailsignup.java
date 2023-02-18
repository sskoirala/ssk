import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailSignUpTest {

    public static void main(String[] args) {
        // Set system property for Chrome driver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to the Gmail sign up page
        driver.get("https://accounts.google.com/signup");

        // Fill in the sign up form
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys("John");

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Doe");

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("johndoe123");

        WebElement passwordField = driver.findElement(By.name("Passwd"));
        passwordField.sendKeys("MyPass123");

        WebElement confirmPasswordField = driver.findElement(By.name("ConfirmPasswd"));
        confirmPasswordField.sendKeys("MyPass123");

        WebElement submitButton = driver.findElement(By.xpath("//span[text()='Next']"));
        submitButton.click();

        // Wait for the verification code form to appear
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("code")));

        // Fill in the verification code form
        WebElement verificationCodeField = driver.findElement(By.id("code"));
        verificationCodeField.sendKeys("123456");

        WebElement verifyButton = driver.findElement(By.xpath("//span[text()='Verify']"));
        verifyButton.click();

        // Wait for the confirmation message to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Your account is created')]")));

        // Close the browser
        driver.quit();
    }
}
