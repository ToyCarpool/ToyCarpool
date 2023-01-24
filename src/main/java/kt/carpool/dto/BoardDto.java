package kt.carpool.dto;

import kt.carpool.domain.Board;
import kt.carpool.domain.Gender;
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
    private Gender writer_gender;
    private String title;
    private Integer peopleNo;
    private String startTime;
    private String departure;
    private String destination;
    private Integer cost;
    private String description;
    private Boolean open;
    private Boolean negotiable;


    @Builder
    public BoardDto(Long id, Member member, Gender writer_gender, String title, Integer peopleNo, String startTime, String departure, Integer cost, String destination, String description, Boolean open) {
        this.id = id;
        this.member_id = member != null ? member.getId() : null;
        this.title = title;
        this.peopleNo = peopleNo;
        this.startTime = startTime;
        this.cost = cost;
        this.departure = departure;
        this.destination = destination;
        this.description = description;
        this.open = open;
        this.writer_gender = writer_gender;
    }


}
