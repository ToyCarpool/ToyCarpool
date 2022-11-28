package kt.carpool.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private String department;

    @OneToMany(mappedBy = "member")
    private final List<Board> boards = new ArrayList<Board>();;


    @Builder
    public Member(Long id, String username, String password, String name, String department) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
    }
}
