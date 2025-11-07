package org.example.gradleandrew;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @BeforeAll
    static void SetUp() {
       // driver = WebDriverManager.chromedriver().getWebDriver();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless"); // для Jenkins
        options.addArguments("--no-sandbox");

    }

    @BeforeEach
    void setupTest() {
        driver = WebDriverManager.chromedriver().getWebDriver();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    // @AfterEach
    // void attachScreenshot() {
    // if (hasFailed()) {
    //    Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    //      }
    //  }

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        WebElement datetOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.className("react-datepicker__month-select")
                )
        );
        datetOption.click();
        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        Select select = new Select(month);
        select.selectByValue("2");
        driver.findElement(By.className("react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select")).click();
        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select yearselect = new Select(year);
        yearselect.selectByValue("1990");
        driver.findElement(By.cssSelector("div.react-datepicker__day react-datepicker__day--015")).click();
    }

    protected void selectGender() { driver.findElement(By.id("gender-radio-1")).click();
    }

    protected void fillSubject(String subject) {
        driver.findElement(By.id("subjectsInput")).sendKeys(subject);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        WebElement subjectOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class, 'subjects-auto-complete__option') and text()='Maths']")
                )
        );

        subjectOption.click();

    }

    protected void fillAddress(String address) {driver.findElement(By.id("currentAddress")).sendKeys(address);
    }

    protected void checkHobbies() {

        driver.findElement(By.id("hobbies-checkbox-1")).click();
    }



    protected void generateAndLoadFile() throws IOException {
        // Создаём временный файл
        //Path tempFile = Files.createTempFile("selenium-upload", ".txt");
        //Files.write(tempFile, "Hello from Selenium!".getBytes());
        // 1. Создаём временный файл с префиксом "upload" и расширением ".txt"
        Path tempFile = Files.createTempFile("upload", ".txt");

        // 2. Записываем в него текст
        String content = "Это тестовый файл для загрузки через Selenium.";
        Files.write(tempFile, content.getBytes(), StandardOpenOption.WRITE);

        // 3. Выводим путь (можно передать в Selenium)
        System.out.println("Временный файл создан: " + tempFile.toAbsolutePath());

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

    protected void openMainPage() {
        driver.get("https://demoqa.com/automation-practice-form");
    }
}
