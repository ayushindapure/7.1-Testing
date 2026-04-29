package web.functional;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class StemAppFunctionalTest {

    private static WebDriver driver;
    private static final String BASE_URL = "http://127.0.0.1:8080";

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    // Helper: perform login
    private void doLogin(String user, String pass) {
        driver.get(BASE_URL + "/login");
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("passwd")).sendKeys(pass);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    // ── Login Tests ──────────────────────────────────────────

    @Test
    public void testLoginPageLoads() {
        driver.get(BASE_URL + "/login");
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("login"));
    }

    @Test
    public void testValidLogin() {
        doLogin("ahsan", "ahsan_pass");
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void testInvalidLoginShowsError() {
        doLogin("wrong", "wrong");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        Assert.assertTrue(driver.getPageSource().contains("Incorrect credentials"));
    }

    @Test
    public void testEmptyLoginFields() {
        doLogin("", "");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    // ── Q1 Addition Tests ────────────────────────────────────

    @Test
    public void testQ1CorrectAnswer() {
        doLogin("ahsan", "ahsan_pass");
        driver.findElement(By.name("result")).sendKeys("3"); // 1+2=3
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
    }

    @Test
    public void testQ1WrongAnswerShowsError() {
        doLogin("ahsan", "ahsan_pass");
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
        Assert.assertTrue(driver.getPageSource().contains("Wrong answer"));
    }

    @Test
    public void testQ1EmptyAnswerHandledGracefully() {
        doLogin("ahsan", "ahsan_pass");
        driver.findElement(By.name("result")).sendKeys("");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        // Should NOT show error/crash page
        Assert.assertFalse(driver.getPageSource().contains("Whitelabel Error Page"));
    }

    // ── Q2 Subtraction Tests ─────────────────────────────────

    @Test
    public void testQ2CorrectAnswer() {
        doLogin("ahsan", "ahsan_pass");
        // Answer Q1 first
        driver.findElement(By.name("result")).sendKeys("3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        // Now Q2
        driver.findElement(By.name("result")).sendKeys("3"); // e.g. 5-2=3
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
    }

    @Test
    public void testQ2WrongAnswerShowsError() {
        doLogin("ahsan", "ahsan_pass");
        driver.findElement(By.name("result")).sendKeys("3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));
        Assert.assertTrue(driver.getPageSource().contains("Wrong answer"));
    }

    // ── Q3 Multiplication Tests ──────────────────────────────

    @Test
    public void testQ3CorrectAnswerCompletesGame() {
        doLogin("ahsan", "ahsan_pass");
        driver.findElement(By.name("result")).sendKeys("3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.findElement(By.name("result")).sendKeys("3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.findElement(By.name("result")).sendKeys("42"); // 6×7=42
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/complete"));
    }

    @Test
    public void testQ3WrongAnswerShowsError() {
        doLogin("ahsan", "ahsan_pass");
        driver.findElement(By.name("result")).sendKeys("3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.findElement(By.name("result")).sendKeys("3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        driver.findElement(By.name("result")).sendKeys("99");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));
        Assert.assertTrue(driver.getPageSource().contains("Wrong answer"));
    }
}