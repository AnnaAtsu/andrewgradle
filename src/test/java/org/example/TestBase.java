package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.LocalDate;

public class TestBase {
    public WebDriver driver;

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

    protected void fillEmail(String email) { driver.findElement(By.id("userEmail")).sendKeys(email);
    }

    protected void fillLastName(String lastName) {
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    protected void fillFistName(String firstName) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    protected void fillMobile(String mobile) { driver.findElement(By.id("userNumber")).sendKeys(mobile);
    }

    protected void selectDateOfBirth(LocalDate dateOfBirth) {driver.findElement(By.id("dateOfBirthInput")).sendKeys(dateOfBirth);
    }

    protected void selectGender(String string) { driver.findElement(By.id("gender-radio-1")).click();
    }

    protected void fillSubject(String subject) {driver.findElement(By.id("subjectsInput")).sendKeys(subject);
    }

    protected void fillAddress(String address) {driver.findElement(By.id("currentAddress")).sendKeys(address);
    }
}
