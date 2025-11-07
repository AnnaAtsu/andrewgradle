package org.example.gradleandrew;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CreateUser {

Map<String, String> requestBody = Map.of(
        "name", "morpheus",
        "job", "leader"
);
    @Test
    @Epic("API Tests")
    @Feature("User Management")
    @Story("Create users")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка создания пользователя через POST /api/users")
    @Step("Создать нового пользователя")
    public void createUsertest() {
        ValidatableResponse response = step("Создать пользователя и получить ответ", () -> {
     return given()
             .filter(new AllureRestAssured()) //  логирует запрос/ответ в Allure
             .baseUri("https://reqres.in")
             //.body("{ \"name\": \"morpheus\", \"job\": \"leader\" }")
             .header("Content-Type", "application/json; charset=utf-8")
             .body(requestBody)
             .log().all()
             .when()
             .post("/api/users")
                     .then()
             .log().all()
                     .statusCode(201);
        });
        step("Убедиться, что в ответе есть поле 'id'", () -> {
            response.body("name", notNullValue());
            response.body("job", notNullValue());
            response.body("id", notNullValue());
            response.body("createdAt", notNullValue());
            response.body("name", equalTo("morpheus"));
            response.body("job", equalTo("leader"));
        });




}


}
