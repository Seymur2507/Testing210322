import Pojos.CreateUser;
import Pojos.CreateUserResponse;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

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
    public void getUser(String username){
        given()
                .baseUri(baseUrl)
                .basePath("/user/" + username)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200);
    }

    public void getUser(String username, Integer statusCode){
        given()
                .baseUri(baseUrl)
                .basePath("/user/" + username)
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(statusCode);
    }
}
