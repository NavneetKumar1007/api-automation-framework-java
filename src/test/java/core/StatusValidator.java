package core;

public class StatusValidator {

    public static void assertStatus(int actual, int expected) {
        if (actual != expected) {
            throw new AssertionError(
                "Expected status: " + expected + ", but got: " + actual
            );
        }
    }
}

