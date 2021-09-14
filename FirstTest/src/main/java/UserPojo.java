import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor

public class UserPojo {
    private int id;
    private String avatar;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("Last_name")
    private String lastName;
    private String email;
}
