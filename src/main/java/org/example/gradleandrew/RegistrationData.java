package org.example.gradleandrew;

import java.time.LocalDate;

public class RegistrationData {
    private final String firstName;
    private final String lastName;
    private final String email;

    private final String mobile; // 10 цифр как строка

    private final String subject;


    private final String address;
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getSubject() {
        return subject;
    }

    public String getAddress() {
        return address;
    }





    public enum Hobbies {
        SPORTS("Sports"),
        READING("Reading"),
        MUSIC("Music");

        private final String displayHobby;
        Hobbies(String displayHobby){
            this.displayHobby = displayHobby;
        }
        @Override
        public String toString() {
            return displayHobby;
        }
            }
    public RegistrationData(String firstName, String lastName, String email,  String mobile, String subject, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        this.mobile = mobile;

        this.subject = subject;

        this.address = address;
    }

}
