package core;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HttpClient {

    private static final String AUTH_HEADER = "Authorization";
    private static final String CONTENT_TYPE = "Content-Type";

    // ===========================
    // GET
    // ===========================
    public static Response get(String url) {
        return given()
                .filter(new AllureRestAssured())   // Allure automatic logging
                .header(AUTH_HEADER, "Bearer " + AuthHandler.getToken())
                .header(CONTENT_TYPE, "application/json")
                .when()
                .get(url);
    }

    // ===========================
    // POST
    // ===========================
    public static Response post(String url, Object body) {
        return given()
                .filter(new AllureRestAssured())
                .header(AUTH_HEADER, "Bearer " + AuthHandler.getToken())
                .header(CONTENT_TYPE, "application/json")
                .body(body)
                .when()
                .post(url);
    }

    // ===========================
    // PUT
    // ===========================
    public static Response put(String url, Object body) {
        return given()
                .filter(new AllureRestAssured())
                .header(AUTH_HEADER, "Bearer " + AuthHandler.getToken())
                .header(CONTENT_TYPE, "application/json")
                .body(body)
                .when()
                .put(url);
    }

    // ===========================
    // PATCH
    // ===========================
    public static Response patch(String url, Object body) {
        return given()
                .filter(new AllureRestAssured())
                .header(AUTH_HEADER, "Bearer " + AuthHandler.getToken())
                .header(CONTENT_TYPE, "application/json")
                .body(body)
                .when()
                .patch(url);
    }

    // ===========================
    // DELETE
    // ===========================
    public static Response delete(String url) {
        return given()
                .filter(new AllureRestAssured())
                .header(AUTH_HEADER, "Bearer " + AuthHandler.getToken())
                .when()
                .delete(url);
    }
}

