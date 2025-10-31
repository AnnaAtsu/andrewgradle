package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormResultModal {

     WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "modal-dialog modal-lg")
    private WebElement modalTitle;


    public PracticeFormResultModal(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    //  с ожиданием
    public void waitForVisible() {
        wait.until(webDriver -> modalTitle.isDisplayed());
    }
}
