package kt.carpool.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Time;
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
    private int id;
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


//    @OneToMany(mappedBy = "member")
//    private final List<Board> boards = new ArrayList<Board>();
//
//    @OneToMany(mappedBy = "member")
//    private final List<VocBoard> vocBoards = new ArrayList<VocBoard>();

    @Builder
    public Member(int id, String username, String password, String name, String email, String role, String provider, String providerId, Timestamp createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.createDate = createDate;
    }

}