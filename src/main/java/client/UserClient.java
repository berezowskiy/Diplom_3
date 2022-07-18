package client;
import io.qameta.allure.Step;
import model.User;
import io.restassured.response.Response;


public class UserClient extends BaseHttpClient {

    @Step("Send POST request to api/auth/register")
    public Response createUser(User user) {
        return doPostRequest(super.baseUrl + "/api/auth/register", user);
    }

    @Step("Send POST request to api/auth/login")
    public Response loginUser(User user) {
        return doPostRequest(super.baseUrl + "/api/auth/login", user);
    }

    @Step("Send DELETE request to api/auth/user with access token")
    public Response deleteUser(String accessToken) {
        return doDeleteRequestWithAccessToken(super.baseUrl + "/api/auth/user",accessToken);
    }
}
