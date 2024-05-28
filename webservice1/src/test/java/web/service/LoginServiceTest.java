package web.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testValidLogin() {
        assertTrue(LoginService.login("admin", "password", "1997-10-24"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("", "password", "1997-10-24"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(LoginService.login("admin", "", "1997-10-24"));
    }

    @Test
    public void testInvalidDOB() {
        assertFalse(LoginService.login("admin", "password", ""));
    }

    @Test
    public void testIncorrectCredentials() {
        assertFalse(LoginService.login("admin", "wrong_password", "1997-10-24"));
    }

    @Test
    public void testLoginSuccess() {
        System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\ASUS\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe\"");
        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);
        

        driver.navigate().to("\\\"C:\\\\Master Degree\\\\SIT707 - Software Quality And Testing\\\\Projet Task\\\\8.1P-resources (2)\\\\pages\\\\login.html\\\"");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("ahsan");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("ahsan_pass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("24-10-1997");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        assertTrue(title.equalsIgnoreCase("success"));

        driver.close();
    }
    @Test
    public void testEmptyFields() {
        System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\ASUS\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe\"");
        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        driver.navigate().to("\"C:\\Master Degree\\SIT707 - Software Quality And Testing\\Projet Task\\8.1P-resources (2)\\pages\\login.html\"");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        assertFalse(title.equalsIgnoreCase("success"));

        driver.close();
    }

    @Test
    public void testInvalidCredentials() {
        System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\ASUS\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe\"");
        WebDriver driver = new ChromeDriver();
        System.out.println("Driver info: " + driver);

        driver.navigate().to("\"C:\\Master Degree\\SIT707 - Software Quality And Testing\\Projet Task\\8.1P-resources (2)\\pages\\login.html\"");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("random_user");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("random_pass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("1997-10-24");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        assertFalse(title.equalsIgnoreCase("success"));

        driver.close();
    }
}