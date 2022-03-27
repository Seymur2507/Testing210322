import Pojos.CreateUser;
import Pojos.CreateUserResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestTest {
    @Test
    public void createUser(){
        CreateUser rq =
                CreateUser.builder()
        .id(0)
        .username("SEM1")
        .firstName("SEm")
        .lastName("Akc")
        .email("tester@mail.ru")
        .password("123")
        .phone("83915555555")
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
                        .username("SEM1")
                        .firstName("SEM")
                        .lastName("Akc")
                        .email("tester@mail.ru")
                        .password("123")
                        .phone("89315555555")
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
