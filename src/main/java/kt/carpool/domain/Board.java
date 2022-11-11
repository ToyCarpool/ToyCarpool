package kt.carpool.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "BOARD")
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 외래키 어노테이션 잘 모르겠음
    private Long user_id;

    private String title;
    private Integer peopleNo;
    private String startTime;
    private Integer cost;
    private String description;
    private Boolean open;
    @Builder
    public Board(Long id, Long user_id, String title, Integer peopleNo, String startTime, Integer cost, String description, Boolean open) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.peopleNo = peopleNo;
        this.startTime = startTime;
        this.cost = cost;
        this.description = description;
        this.open = open;
    }



}
