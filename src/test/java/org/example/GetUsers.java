package org.example;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;




public class GetUsers {


    @Test
    @Epic("API Tests")
    @Feature("User Management")
    @Story("SHOW users")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка получения списка пользователей через GET /api/users?page=2")
    public void testGetUser() {
        step("Отправить GET-запрос на список пользователей на 2 странице", () -> {
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

        });
        step("Проверить, что есть список из 6 пользователей с ненулевыми значениями");
    }

}
