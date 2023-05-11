package ru.check_website.api_user;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class User {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";
    private static final String PATH = "api/auth/register";
    private static final String LOGIN_PATH = "api/auth/login";
    public static final String DELETE_USER_API = "api/auth/user";

    public User() {
        RestAssured.baseURI = BASE_URI;
    }

    @Step("Создание пользователя")
    public void requestCreateUser(CreateUser user) {
        given()
                .contentType(ContentType.JSON)
                .and()
                .body(user)
                .when()
                .post(PATH)
                .then();
    }

    @Step("Удаление пользователя")
    public void userDelete(String bearerToken) {
        given()
                .headers("Authorization", bearerToken)
                .contentType(ContentType.JSON)
                .delete(DELETE_USER_API + bearerToken)
                .then();
    }

    @Step("Создание логин пользователя")
    public static ValidatableResponse requestCreateLogin(CreateUser user) {
        return given()
                .contentType(ContentType.JSON)
                .and()
                .body(user)
                .when()
                .post(LOGIN_PATH)
                .then();
    }

}


