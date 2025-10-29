package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

public class RegisterNewUser extends TestBase{




    @Test
    public void registerUser() {
        driver.get("https://demoqa.com/automation-practice-form");
        Assertions.assertTrue(driver.getTitle().contains("DEMOQA"));
    }
}
