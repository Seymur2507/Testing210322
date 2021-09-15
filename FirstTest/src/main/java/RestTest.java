import Pojos.CreateUser;
import Pojos.CreateUserResponse;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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
        CreateUserResponse createUserResponse = st.getUser(rq.getUsername(), 200);
        assertEquals(createUserResponse.hashCode(), rq.hashCode());
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
