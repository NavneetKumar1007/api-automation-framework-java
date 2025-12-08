package tests;

import clients.UsersClient;
import io.restassured.response.Response;
import models.UserPayloads;
import org.testng.annotations.Test;
import utils.DataGenerator;

import static org.hamcrest.Matchers.equalTo;

public class UsersPatchTests {

    UsersClient users = new UsersClient();

    @Test
    public void testUpdateStatusOnly() {

        // Step 1: Create a user
        UserPayloads createPayload = new UserPayloads(
                DataGenerator.randomName(),
                "male",
                DataGenerator.randomEmail(),
                "active"
        );

        Response createRes = users.createUser(createPayload);
        int id = createRes.jsonPath().getInt("id");

        // Step 2: Reuse the existing user's name, gender, email
        String existingName = createRes.jsonPath().getString("name");
        String existingGender = createRes.jsonPath().getString("gender");
        String existingEmail = createRes.jsonPath().getString("email");

        // Step 3: PATCH with full object but changed status
        UserPayloads patchPayload = new UserPayloads(
                existingName,
                existingGender,
                existingEmail,
                "inactive"
        );

        users.patchUser(id, patchPayload)
                .then()
                .statusCode(200)
                .body("status", equalTo("inactive"));
    }
}

