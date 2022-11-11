package kt.carpool.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
}
