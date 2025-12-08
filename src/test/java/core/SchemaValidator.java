package core;

import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;

public class SchemaValidator {

    public static JsonSchemaValidator userSchema() {
        return JsonSchemaValidator.matchesJsonSchema(
                new File("src/test/resources/schemas/user_schema.json")
        );
    }
}

