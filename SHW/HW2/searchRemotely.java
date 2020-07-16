import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class searchRemotely {
    WebDriver driver;

    @BeforeEach
    void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);

        driver = new RemoteWebDriver(new URL("http://18.156.73.241:4444/wd/hub"),
                capabilities);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    @Test
    void searchTest() {

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium\n");
        Assertions.assertTrue(driver.getTitle().contains("Selenium"));

    }
}