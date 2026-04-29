package sit707_week4;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSeleniumTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void openLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    // =========================
    // CASE 1: VALID LOGIN
    // =========================
    @Test
    public void testValidLogin() {
        openLoginPage();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")))
                .sendKeys("tomsmith");

        driver.findElement(By.id("password"))
                .sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("secure"));

        Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
    }

    // =========================
    // CASE 2: INVALID LOGIN
    // =========================
    @Test
    public void testInvalidLogin() {
        openLoginPage();

        driver.findElement(By.id("username")).sendKeys("wrong");
        driver.findElement(By.id("password")).sendKeys("wrong");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );

        Assert.assertTrue(error.getText().contains("Your username is invalid"));
    }

    // =========================
    // CASE 3: EMPTY LOGIN
    // =========================
    @Test
    public void testEmptyLogin() {
        openLoginPage();

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );

        Assert.assertTrue(error.getText().contains("Your username is invalid"));
    }
}