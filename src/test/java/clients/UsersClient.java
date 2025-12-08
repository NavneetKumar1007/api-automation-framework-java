package clients;

import config.ConfigLoader;
import core.HttpClient;
import models.UserPayloads;
import io.restassured.response.Response;

public class UsersClient {

    private final String BASE = ConfigLoader.getInstance().getBaseUrl() + "/users";

    public Response getAllUsers() {
        return HttpClient.get(BASE);
    }

    public Response getUser(int id) {
        return HttpClient.get(BASE + "/" + id);
    }

    public Response createUser(UserPayloads payload) {
        return HttpClient.post(BASE, payload);
    }

    public Response updateUser(int id, UserPayloads payload) {
        return HttpClient.put(BASE + "/" + id, payload);
    }

    public Response patchUser(int id, UserPayloads payload) {
        return HttpClient.patch(BASE + "/" + id, payload);
    }

    public Response deleteUser(int id) {
        return HttpClient.delete(BASE + "/" + id);
    }
}

