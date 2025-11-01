package org.example;

import org.example.gradleandrew.RegistrationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracticeFormResultModal extends TestBase{

     static WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "modal-dialog modal-lg")
    private WebElement modalTitle;
    private static RegistrationData user;


    public PracticeFormResultModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    //  с ожиданием
    public void waitForVisible() {
        wait.until(webDriver -> modalTitle.isDisplayed());
    }


    //для проверки заполнения данных
    public String getFieldValueFromResultTable(String label) {
        // Локатор: найти <tr>, где первая <td> содержит label, и взять вторую <td>
        String xpath = String.format(
                "//table[contains(@class, 'table')]//tr[td[1] = '%s']/td[2]",
                label
        );
        WebElement valueCell = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return valueCell.getText().trim();
    }
    
    
    public static void shouldDisplayCorrectNameInResultModal() {

        PracticeFormResultModal modal = new PracticeFormResultModal(driver);
        // Ожидаемое полное имя
        String expectedFullName = user.getFirstName() + " " + user.getLastName();
        // Получаем фактические значения из таблицы
        String actualName = modal.getFieldValueFromResultTable("Student Name");
       // Проверки
        assertEquals(expectedFullName, actualName, "Имя не совпадает");

    }
    public static void shouldDisplayCorrectEmailInResultModal() {

        PracticeFormResultModal modal = new PracticeFormResultModal(driver);
        // Получаем фактические значения из таблицы
             String actualEmail = modal.getFieldValueFromResultTable("Student Email");
        // Проверки

        assertEquals(user.getEmail(), actualEmail, "Email не совпадает");
    }
}
