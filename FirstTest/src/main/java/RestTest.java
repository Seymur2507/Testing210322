import Pojos.CreateUser;
import Pojos.CreateUserResponse;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class RestTest {
    @Test
    public void createUser(){
        CreateUser rq =
                CreateUser.builder()
        .id(0)
        .username("AhalaiMahalai")
        .firstName("Daniil")
        .lastName("Malkov")
        .email("tester123@mail.ru")
        .password("123")
        .phone("88005553535")
        .userStatus(0)
        .build();

        UserSettings st = new UserSettings();
        st.createUser(rq);
        CreateUserResponse rs = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/user/AhalaiMahalai")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().as(CreateUserResponse.class);

        //st.getUser(rq.getUsername(), 200);
        //CreateUser targetObject = new Gson().fromJson(rq.toString(), CreateUser.class);
        //assertEquals(targetObject.getUsername(), "AhalaiMahalai");
    }
    @Test
    public void createUserNegative(){
        CreateUser rq =
                CreateUser.builder()
                        .username("AhalaiMahalai")
                        .firstName("Daniil")
                        .lastName("Malkov")
                        .email("tester123@mail.ru")
                        .password("123")
                        .phone("88005553535")
                        .build();

        UserSettings st = new UserSettings();
        st.createUser(rq, 400);
    }
    @Test
    public void getUserNegative(){
        UserSettings st = new UserSettings();
        st.getUser("qwerty", 404);
    }
}
