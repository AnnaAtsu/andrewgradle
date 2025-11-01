package org.example;

import org.example.gradleandrew.RegistrationData;
import org.junit.jupiter.api.*;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterNewUser extends TestBase{




    @Test
    public void registerUser() throws IOException {
        RegistrationData user = new RegistrationData(
                "Anna",
                "Doe",
                "artr@mail.ru",
                "1234567890",
                "Ma",
               "New city, orlando, 34-3434"
        );
        openMainPage();
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
        assertTrue(driver.getTitle().contains("DEMOQA"));
        //первая проверка
        PracticeFormResultModal modal = new PracticeFormResultModal(driver);
        modal.waitForVisible();
        //проверка за заполнение поля имени и email в модальном окне
        PracticeFormResultModal.shouldDisplayCorrectNameInResultModal();
        PracticeFormResultModal.shouldDisplayCorrectEmailInResultModal();
    }

}
