package tests;

import clients.UsersClient;
import models.UserPayloads;
import utils.DataGenerator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UsersDeleteTests {

    UsersClient users = new UsersClient();

    @Test
    public void testDeleteValidUser() {
        UserPayloads payload = new UserPayloads(
                DataGenerator.randomName(),
                "male",
                DataGenerator.randomEmail(),
                "active"
        );

        Response createResponse = users.createUser(payload);
        int id = createResponse.jsonPath().getInt("id");

        users.deleteUser(id)
                .then()
                .statusCode(204);
    }

    @Test
    public void testDeleteInvalidUser() {
        users.deleteUser(999999)
                .then()
                .statusCode(404);
    }
}

