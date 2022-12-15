package kt.carpool.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private String username;
    private String password;

    private String name;
    private String email;
    //    private String department;
    private String role;

    private String provider;
    private String providerId;
    @CreationTimestamp
    private Timestamp createDate;
}
