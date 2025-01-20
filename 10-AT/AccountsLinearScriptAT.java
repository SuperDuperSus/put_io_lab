package put.selenium.linear;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import put.selenium.utils.ScreenshotAndQuitOnFailureRule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class AccountsLinearScriptAT {

    private WebDriver driver;

    @Rule
    public ScreenshotAndQuitOnFailureRule screenshotOnFailureAndWebDriverQuitRule =
            new ScreenshotAndQuitOnFailureRule();


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        this.driver = new ChromeDriver();
        screenshotOnFailureAndWebDriverQuitRule.setWebDriver(driver);
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
    }

    @Test
    public void successfulUserRegistration() throws Exception {
        driver.get("http://localhost:8080/accounts/controller?action=db_reset");
        driver.manage().window().setSize(new Dimension(600, 890));
        driver.findElement(By.cssSelector("html")).click();
        driver.findElement(By.cssSelector("html")).click();

        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).click();

        driver.findElement(By.cssSelector("tr:nth-child(1)")).click();
        driver.findElement(By.name("username")).sendKeys("test");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("test123");

        driver.findElement(By.name("repeat_password")).click();
        driver.findElement(By.name("repeat_password")).sendKeys("test123");

        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys("Test Test");

        driver.findElement(By.name("addressData")).click();
        driver.findElement(By.name("addressData")).sendKeys("Nowa 13");
        driver.findElement(By.name("submit")).click();

        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).sendKeys("test");

        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.name("submit")).click();

        driver.findElement(By.linkText("Logout")).click();
    }
}
