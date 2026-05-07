package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Ayush Indapure - 224880003
 * Selenium functional tests
 */
public class LoginSeleniumTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginSuccess() {

        System.setProperty("webdriver.chrome.driver",
                "/home/yourpath/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("file:///path-to-your/login.html");

        sleep(2);

        driver.findElement(By.id("username")).sendKeys("ayush");
        driver.findElement(By.id("passwd")).sendKeys("qwerty12");
        driver.findElement(By.id("dob")).sendKeys("2003-08-18");

        driver.findElement(By.id("loginBtn")).click();

        sleep(2);

        String title = driver.getTitle();

        System.out.println("TITLE: " + title);

        Assert.assertEquals("success", title);

        driver.quit();
    }

    @Test
    public void testLoginFailWrongPassword() {

        System.setProperty("webdriver.chrome.driver",
                "/home/yourpath/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("file:///path-to-your/login.html");

        sleep(2);

        driver.findElement(By.id("username")).sendKeys("ayush");
        driver.findElement(By.id("passwd")).sendKeys("wrong");
        driver.findElement(By.id("dob")).sendKeys("2003-08-18");

        driver.findElement(By.id("loginBtn")).click();

        sleep(2);

        String title = driver.getTitle();

        Assert.assertEquals("fail", title);

        driver.quit();
    }
}