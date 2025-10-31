package org.example;
import org.example.gradleandrew.RegistrationData;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.time.LocalDate;

public class RegisterNewUser extends TestBase{




    @Test
    public void registerUser() throws IOException {
        RegistrationData user = new RegistrationData(
                "Anna",
                "Doe",
                "artr@mail.ru",

                "1234567890",
               "Ma",
                RegistrationData.Hobbies.READING,
                "New city, orlando, 34-3434"
        );


        driver.get("https://demoqa.com/automation-practice-form");
        fillFistName(user.getFirstName());
        fillLastName(user.getLastName());
        fillEmail(user.getEmail());
        selectGender();
        fillMobile(user.getMobile());
        selectDateOfBirth();
        fillSubject(user.getSubject());
        checkHobbies();
        fillAddress(user.getAddress());
        generateAndLoadFile();
        getSubmit();
        Assertions.assertTrue(driver.getTitle().contains("DEMOQA"));
    }

}
