package kt.carpool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VocBoardDto {
    private Long user_id;

    private String title;
    private String description;
    private Boolean open;
}
