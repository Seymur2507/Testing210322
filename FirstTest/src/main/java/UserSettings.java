import Pojos.CreateUser;
import Pojos.CreateUserResponse;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UserSettings {

    public String baseUrl = "https://petstore.swagger.io/v2";
    public void createUser(CreateUser rq){
        given()
                .baseUri(baseUrl)
                .basePath("/user")
                .contentType(ContentType.JSON)
                .body(rq)
                .when().post()
                .then().statusCode(200);
    }
    public void createUser(CreateUser rq, Integer statusCode){
        given()
                .baseUri(baseUrl)
                .basePath("/user")
                .contentType(ContentType.JSON)
                .body(rq)
                .when().post()
                .then().statusCode(statusCode);
    }
    public CreateUserResponse getUser(String username){
        Response rs = given()
                .baseUri(baseUrl)
                .basePath("/user/" + username)
                .contentType(ContentType.JSON)
                .when().get();

        CreateUserResponse targetObject = new Gson().fromJson(rs.getBody().asString(), CreateUserResponse.class);
    return targetObject;
    }

    public CreateUserResponse getUser(String username, int statusCode){
        Response rs = given()
                .baseUri(baseUrl)
                .basePath("/user/" + username)
                .contentType(ContentType.JSON)
                .when().get();
        assertEquals(rs.getStatusCode(),statusCode);
        CreateUserResponse targetObject = new Gson().fromJson(rs.getBody().asString(), CreateUserResponse.class);
    return targetObject;
    }
}
