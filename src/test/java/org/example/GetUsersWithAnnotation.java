package org.example;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

public class GetUsersWithAnnotation {

    @Test
    @Epic("API Tests")
    @Feature("User Management")
    @Story("SHOW users")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка получения списка пользователей через GET /api/users?page=2 с аннотацией Step")
    @Step("Получить список пользователей на второй странице")
    public void testGetUserwithAnnotations() {
        baseURI = "https://reqres.in/";
        given()
                .filter(new AllureRestAssured())
                .log().all()
                .when()
                .get("api/users?page=2")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", notNullValue())
                .body("data", hasSize(6))
                .body("data.id", everyItem(notNullValue()))
                .body("data.email", everyItem(containsString("@")))
                .body("data.first_name", everyItem(notNullValue()))
                .body("data.last_name", everyItem(notNullValue()))
                .body("data.avatar", everyItem(notNullValue()));

    }
}
