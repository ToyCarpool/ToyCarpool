package kt.carpool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Long user_id;
    private String title;
    private Integer peopleNo;
    private String startTime;
    private Integer cost;
    private String description;
    private Boolean open;
}
