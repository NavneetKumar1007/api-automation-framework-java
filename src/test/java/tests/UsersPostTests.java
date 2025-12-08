package tests;

import clients.UsersClient;
import models.UserPayloads;
import utils.DataGenerator;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class UsersPostTests {

    UsersClient users = new UsersClient();

    @Test
    public void testCreateUserValid() {
        UserPayloads payload = new UserPayloads(
                DataGenerator.randomName(),
                "male",
                DataGenerator.randomEmail(),
                "active"
        );

        users.createUser(payload)
                .then()
                .statusCode(201)
                .body("email", equalTo(payload.email));
    }

    @Test
    public void testCreateUserMissingEmail() {
        UserPayloads payload = new UserPayloads(
                DataGenerator.randomName(),
                "male",
                "",
                "active"
        );

        users.createUser(payload)
                .then()
                .statusCode(422);
    }

    @Test
    public void testCreateUserInvalidEmail() {
        UserPayloads payload = new UserPayloads(
                DataGenerator.randomName(),
                "male",
                "invalid",
                "active"
        );

        users.createUser(payload)
                .then()
                .statusCode(422);
    }
}

