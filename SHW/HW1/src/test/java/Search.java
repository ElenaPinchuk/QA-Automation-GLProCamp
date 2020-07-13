import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Search {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    @Test
    void searchTest() {

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium\n");
        Assertions.assertEquals("Selenium",driver.findElement(new By.ByTagName("h3")).getText());

    }
}

