import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class Search {
    WebDriver driver;
    WebDriver driver1;

    @BeforeEach
    void setUp() throws MalformedURLException {
       // WebDriverManager.chromedriver().setup();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());
        driver1 = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.firefox());
    }

    @AfterEach
    void tearDown() {
        driver.quit(); driver1.quit();
    }

    @Test
    void searchTest() {

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium\n");
        Assertions.assertTrue(driver.getTitle().contains("Selenium"));
    }

    @Test
    void searchTest1() {

        driver1.get("http://google.com");
        driver1.findElement(By.name("q")).sendKeys("Webdriver\n");
        Assertions.assertTrue(driver1.getTitle().contains("Creatio"));

    }
}

