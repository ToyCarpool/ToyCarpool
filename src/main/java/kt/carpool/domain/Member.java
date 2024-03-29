package kt.carpool.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name="USERS")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;
    private String username;
    private String password;
    private String name;

    private String email;
    private String role;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String provider;
    private String providerId;

    @OneToMany(mappedBy = "member")
    private final List<Board> boards = new ArrayList<Board>();

    @CreationTimestamp
    private Timestamp createDate;


    @Builder
    public Member(String username, String password, String name, String email, String role, String provider, String providerId,Timestamp createDate, Gender gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.createDate = createDate;
        this.gender = gender;
    }

}
