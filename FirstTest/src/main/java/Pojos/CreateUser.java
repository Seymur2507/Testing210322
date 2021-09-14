package Pojos;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateUser {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;
}
