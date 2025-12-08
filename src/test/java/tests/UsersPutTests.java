package tests;

import clients.UsersClient;
import io.restassured.response.Response;
import models.UserPayloads;
import utils.DataGenerator;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class UsersPutTests {

    UsersClient users = new UsersClient();

    @Test
    public void testFullUpdateUser() {
        // Step 1 → create user
        UserPayloads createPayload = new UserPayloads(
                DataGenerator.randomName(),
                "male",
                DataGenerator.randomEmail(),
                "active"
        );

        Response createResponse = users.createUser(createPayload);
        int id = createResponse.jsonPath().getInt("id");

        // Step 2 → prepare update payload
        UserPayloads updatePayload = new UserPayloads(
                "Updated Name",
                "male",
                DataGenerator.randomEmail(),
                "inactive"
        );

        // Step 3 → put update
        users.updateUser(id, updatePayload)
                .then()
                .statusCode(200)
                .body("name", equalTo("Updated Name"))
                .body("status", equalTo("inactive"));
    }
}

