package testsomme;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSomme {
    private WebDriver driver;
    private WebElement a;
    private WebElement b;
    private WebElement btn_submit;
    private WebElement resultat;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver");

        driver = new FirefoxDriver();

        driver.get("http://localhost:3000/");

        a = driver.findElement(By.id("a"));
        b = driver.findElement(By.id("b"));
        resultat = driver.findElement(By.id("resultat"));
        btn_submit = driver.findElement(By.cssSelector("button.btn.btn-secondary"));
    }

    @Test
    public void testPositifPositif() {
        a.sendKeys("10");
        b.sendKeys("24");
        btn_submit.click();
        assertThat(resultat.getAttribute("value"), equalTo("34"));
    }

    @Test
    public void testNegatifNegatif() {
        a.sendKeys("-6");
        b.sendKeys("-1");
        btn_submit.click();
        assertThat(resultat.getAttribute("value"), equalTo("-7"));
    }

    @Test
    public void testPositifNegatif() {
        a.sendKeys("-2");
        b.sendKeys("15");
        btn_submit.click();
        assertThat(resultat.getAttribute("value"), equalTo("13"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
