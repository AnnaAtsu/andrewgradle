package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

public class RegisterNewUser {

    private WebDriver driver;

    @BeforeAll
    static void SetUp() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void registerUser() {
        driver.get("https://demoqa.com/automation-practice-form");
        Assertions.assertTrue(driver.getTitle().contains("DEMOQA"));
    }
}
