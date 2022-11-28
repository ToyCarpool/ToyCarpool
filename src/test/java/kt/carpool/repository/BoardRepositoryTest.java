package kt.carpool.repository;

import kt.carpool.domain.Board;
import kt.carpool.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    public void save() {
        Member member = new Member().builder()
                .name("cho")
                .department("AICC구독솔루션팀")
                .username("cho")
                .password("1234")
                .build();
        memberRepository.save(member);

        Board board = new Board().builder()
                .member(member)
                .cost(1000)
                .open(true)
                .peopleNo(2)
                .description("오세요")
                .startTime("123")
                .build();


        boardRepository.save(board);
    }

}