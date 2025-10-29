// src/test/java/module-info.java

open module org.example.gradleandrew.test {
    // JUnit 5
    requires org.junit.jupiter.api;
   // requires org.junit.jupiter.engine;

    // RestAssured
 //   requires io.restassured;

    // Jackson (для сериализации Map → JSON)
    requires com.fasterxml.jackson.databind;

    // Allure
    requires io.qameta.allure.junit5;
    requires io.qameta.allure.restassured;
    requires io.qameta.allure.commons;
    requires rest.assured;
    requires org.hamcrest;
    requires org.seleniumhq.selenium.api;
    requires org.seleniumhq.selenium.chrome_driver;
    requires io.github.bonigarcia.webdrivermanager;
    requires org.seleniumhq.selenium.firefox_driver;
    requires org.example.gradleandrew;

    // Экспортируем пакет с тестами, чтобы JUnit мог его обнаружить
    exports org.example;
}