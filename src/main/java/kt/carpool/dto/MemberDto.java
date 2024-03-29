package kt.carpool.dto;


import kt.carpool.domain.Board;
import kt.carpool.domain.Gender;
import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String password;

    private String name;
    private String email;
    private String role;
    private Gender gender;
    private String provider;
    private String providerId;
    @Builder
    public MemberDto(Long id, String username, String password, String name, String email, String role, String provider, String providerId, Timestamp createDate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }
}
