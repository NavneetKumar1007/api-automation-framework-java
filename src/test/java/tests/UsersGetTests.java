package tests;

import clients.UsersClient;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class UsersGetTests {

    UsersClient users = new UsersClient();

    @Test
    public void testGetAllUsers() {
        users.getAllUsers()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    public void testGetUserByValidId() {
        Response allUsers = users.getAllUsers();
        int id = allUsers.jsonPath().getInt("[0].id");

        users.getUser(id)
                .then()
                .statusCode(200)
                .body("id", equalTo(id));
    }

    @Test
    public void testGetUserByInvalidId() {
        users.getUser(999999)
                .then()
                .statusCode(404);
    }
}

