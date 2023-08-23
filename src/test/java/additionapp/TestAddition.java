package additionapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestAddition {
    private WebDriver driver;
    private WebElement inputFieldA;
    private WebElement inputFieldB;
    private WebElement submitButton;
    private WebElement resultField;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver");

        driver = new FirefoxDriver();
        driver.get("https://0eix.github.io/somme/");

        inputFieldA = driver.findElement(By.id("a"));
        inputFieldB = driver.findElement(By.id("b"));
        resultField = driver.findElement(By.id("resultat"));
        submitButton = driver.findElement(By.cssSelector("button.btn.btn-secondary"));
    }

    @Test
    public void testPositivePlusPositive() {
        inputFieldA.sendKeys("10");
        inputFieldB.sendKeys("24");
        submitButton.click();
        assertThat(resultField.getAttribute("value"), equalTo("34"));
    }

    @Test
    public void testNegativePlusNegative() {
        inputFieldA.sendKeys("-6");
        inputFieldB.sendKeys("-1");
        submitButton.click();
        assertThat(resultField.getAttribute("value"), equalTo("-7"));
    }

    @Test
    public void testPositivePlusNegative() {
        inputFieldA.sendKeys("-2");
        inputFieldB.sendKeys("15");
        submitButton.click();
        assertThat(resultField.getAttribute("value"), equalTo("13"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
