package org.example;
import org.example.gradleandrew.RegistrationData;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

public class RegisterNewUser extends TestBase{




    @Test
    public void registerUser() {
        RegistrationData user = new RegistrationData(
                "Anna",
                "Doe",
                "artr@mail.ru",
                RegistrationData.Gender.MALE,
                "1234567890",
                LocalDate.of(1995, 8, 20),
                "theme",
                RegistrationData.Hobbies.READING,
                "New city, orlando, 34-3434"
        );


        driver.get("https://demoqa.com/automation-practice-form");
        fillFistName(user.getFirstName());
        fillLastName(user.getLastName());
        fillEmail(user.getEmail());
        selectGender(user.getGender().toString());
        fillMobile(user.getMobile());
        selectDateOfBirth();
        fillSubject(user.getSubject());
        checkHobbies();
        fillAddress(user.getAddress());

        driver.findElement(By.id("submit")).click();
        Assertions.assertTrue(driver.getTitle().contains("DEMOQA"));
    }

}
