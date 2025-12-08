package core;

import io.github.cdimascio.dotenv.Dotenv;

public class AuthHandler {

    private static final Dotenv dotenv = Dotenv.load();

    public static String getToken() {
        return dotenv.get("API_TOKEN");
    }
}

