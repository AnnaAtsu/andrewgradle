package org.example.gradleandrew;

import java.time.LocalDate;

public class RegistrationData {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Gender gender;
    private final String mobile; // 10 цифр как строка
    private final LocalDate dateOfBirth;
    private final String subject;
    private final Hobbies hobbies;

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
    public Gender getGender() { return gender; }
    public String getAddress() {
        return address;
    }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public enum Gender  {
        MALE("Male"),
        FEMALE("Female"),
        OTHER("Other");
        private final String displayName;

        Gender(String displayName) {
            this.displayName = displayName;
        }
        @Override
        public String toString() {
            return displayName;
        }
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
    public RegistrationData(String firstName, String lastName, String email, Gender gender, String mobile, LocalDate dateOfBirth, String subject, Hobbies hobbies, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
        this.subject = subject;
        this.hobbies = hobbies;
        this.address = address;
    }

}
