package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    protected void selectDateOfBirth() {

        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.cssSelector("div.react-datepicker__day react-datepicker__day--015")).click();
    }

    protected void selectGender(String string) { driver.findElement(By.id("gender-radio-1")).click();
    }

    protected void fillSubject(String subject) {driver.findElement(By.id("subjectsInput")).sendKeys(subject);
    }

    protected void fillAddress(String address) {driver.findElement(By.id("currentAddress")).sendKeys(address);
    }

    protected void checkHobbies() {
        driver.findElement(By.id("hobbies-checkbox-1")).click();
    }




    public void generateFile() {
        // 1. Создаём временный файл с префиксом "upload" и расширением ".txt"
        Path tempFile = Files.createTempFile("upload", ".txt");

        // 2. Записываем в него текст
        String content = "Это тестовый файл для загрузки через Selenium.";
        Files.write(tempFile, content.getBytes(), StandardOpenOption.WRITE);

        // 3. Выводим путь (можно передать в Selenium)
        System.out.println("Временный файл создан: " + tempFile.toAbsolutePath());

        // ⚠️ Файл будет автоматически удалён при завершении JVM, если не вызвать delete
        // Но лучше удалять явно после использования в тесте:
        // Files.deleteIfExists(tempFile);
    }


    protected void loadFile() throws IOException {
        // Создаём временный файл
        Path tempFile = Files.createTempFile("selenium-upload", ".txt");
        Files.write(tempFile, "Hello from Selenium!".getBytes());

        try {
            // Передаём путь в input type="file"
            WebElement fileInput = driver.findElement(By.id("uploadPicture"));
            fileInput.sendKeys(tempFile.toAbsolutePath().toString());


        } finally {
            // Удаляем файл после теста
            Files.deleteIfExists(tempFile);
        }
    }

    protected void getSubmit() {
        driver.findElement(By.id("submit")).click();
    }
}
