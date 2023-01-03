package kt.carpool.domain;

import lombok.*;
import org.apache.catalina.User;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "BOARD")
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;
    // 외래키 어노테이션 잘 모르겠음

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    private String title;
    private Integer peopleNo;
    private String startTime;
    private Integer cost;
    private String description;
    private Boolean open;
    @Builder
    public Board(Long id, Member member, String title, Integer peopleNo, String startTime, Integer cost, String description, Boolean open) {
        this.id = id;
        this.member = member;
        this.title = title;
        this.peopleNo = peopleNo;
        this.startTime = startTime;
        this.cost = cost;
        this.description = description;
        this.open = open;
        if (member!=null) {
            setMember(member);
        }
    }

    public void setMember(Member member) {
        this.member = member;
        member.getBoards().add(this);
    }


}
