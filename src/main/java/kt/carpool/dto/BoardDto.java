package kt.carpool.dto;

import kt.carpool.domain.Board;
import kt.carpool.domain.Member;
import kt.carpool.repository.MemberRepository;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardDto {
    private Long id;
    private Long member_id;
    private String title;
    private Integer peopleNo;
    private String startTime;
    private Integer cost;
    private String description;
    private Boolean open;

    @Builder
    public BoardDto(Long id, Member member, String title, Integer peopleNo, String startTime, Integer cost, String description, Boolean open) {
        this.id = id;
        this.member_id = member != null ? member.getId() : -1;
        this.title = title;
        this.peopleNo = peopleNo;
        this.startTime = startTime;
        this.cost = cost;
        this.description = description;
        this.open = open;
    }
}
