package kt.carpool.utils;

import kt.carpool.domain.Board;
import kt.carpool.domain.Member;
import kt.carpool.dto.MemberDto;
import kt.carpool.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberUtilsTest {

    @Autowired
    MemberUtils memberUtils;

    @Test
    void dto변환() {
        Member entity = new Member().builder()
                .id(1L)
                .password("123")
                .username("cho")
                .department("AICC구독솔루션팀")
                .name("조영래")
                .build();

        Board board = new Board().builder()
                .member(entity)
                .title("제목")
                .peopleNo(3)
                .startTime("3시 10분")
                .cost(3000)
                .description("나랑 같이 갈 사람")
                .open(Boolean.TRUE)
                .build();

        MemberDto dto = memberUtils.toDto(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getBoards(), entity.getBoards());
    }

    @Test
    void entity변환() {
        MemberDto dto = new MemberDto().builder()
                .id(1L)
                .password("123")
                .username("cho")
                .department("AICC구독솔루션팀")
                .name("조영래")
                .build();


        Member entity = memberUtils.toEntity(dto);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getBoards(), entity.getBoards());
    }
}