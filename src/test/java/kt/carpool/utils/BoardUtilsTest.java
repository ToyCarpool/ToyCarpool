package kt.carpool.utils;

import kt.carpool.domain.Board;
import kt.carpool.domain.Member;
import kt.carpool.dto.BoardDto;
import kt.carpool.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardUtilsTest {

    @Autowired
    BoardUtils boardUtils;

    @Autowired
    MemberRepository memberRepository;
    @Test
    void dto변환() {
        Member member = new Member().builder()
                .password("123")
                .username("cho")
                .department("AICC구독솔루션팀")
                .name("조영래")
                .build();

        Board entity = new Board().builder()
                .member(member)
                .title("제목")
                .peopleNo(3)
                .startTime("3시 10분")
                .cost(3000)
                .description("나랑 같이 갈 사람")
                .open(Boolean.TRUE)
                .build();
        BoardDto dto = boardUtils.toDto(entity);
        System.out.println("dto.getCost() = " + dto.getCost());
        System.out.println("entity.getCost() = " + entity.getCost());

        assertEquals(dto.getCost(), entity.getCost());
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getMember_id(), entity.getMember().getId());

    }

    @Test
    void 엔터티변환() {
        Member member = new Member().builder()
                .id(1L)
                .password("123")
                .username("cho")
                .department("AICC구독솔루션팀")
                .name("조영래")
                .build();

        BoardDto dto = new BoardDto().builder()
                .member(member)
                .title("제목")
                .peopleNo(3)
                .startTime("3시 10분")
                .cost(3000)
                .description("나랑 같이 갈 사람")
                .open(Boolean.TRUE)
                .build();

        Board entity = boardUtils.toEntity(dto);
        assertEquals(dto.getCost(), entity.getCost());
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getMember_id(), entity.getMember().getId());

    }
}