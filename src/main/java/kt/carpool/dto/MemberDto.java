package kt.carpool.dto;


import kt.carpool.domain.Board;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String department;
    private List<Board> boards = new ArrayList<Board>();
    @Builder
    public MemberDto(Long id, String username, String password, String name, String department) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.department = department;
    }
}
