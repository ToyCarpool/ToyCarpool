package kt.carpool.service;

import kt.carpool.domain.Board;
import kt.carpool.domain.Member;
import kt.carpool.repository.BoardRepository;
import kt.carpool.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    MemberRepository memberRepository;


    @Test
    @Rollback(value = false)
    void write() {
        Member member = new Member().builder()
                .password("123")
                .username("cho")
                .department("AICC구독솔루션팀")
                .name("조영래")
                .build();
        memberRepository.save(member);

        Board board = new Board().builder()
                .member(member)
                .title("제목")
                .peopleNo(3)
                .startTime("3시 10분")
                .cost(3000)
                .description("나랑 같이 갈 사람")
                .open(Boolean.TRUE)
                .build();
        boardRepository.save(board);
        Assertions.assertEquals("제목",boardRepository.findByMember(board.getMember()).get(0).getTitle());
    }

    @Test
    @Rollback(value = false)
    void edit() {
        Member member = new Member().builder()
                .password("123")
                .username("cho")
                .department("AICC구독솔루션팀")
                .name("조영래")
                .build();
        memberRepository.save(member);


        Board board1 = new Board().builder()
                .member(member)
                .title("제목")
                .peopleNo(3)
                .startTime("3시 10분")
                .cost(3000)
                .description("나랑 같이 갈 사람")
                .open(Boolean.TRUE)
                .build();
        boardRepository.save(board1);



        Board board2 = new Board().builder()
                .member(member)
                .title("제목r333333")
                .peopleNo(3)
                .startTime("3시 10분")
                .cost(3000)
                .description("나랑 같이 갈 사람")
                .open(Boolean.TRUE)
                .build();
        boardRepository.save(board2);

        // 이 게시물의 주인이 쓴 모든 글 조회
        System.out.println("이 게시물의 주인이 쓴 모든 글 조회");
        for (Board board :board2.getMember().getBoards()) {
            System.out.println("board = " + board.getTitle());
        }
    }

    @Test
    @Rollback(value = false)
    void 게시글가져오기(){
        Member member = new Member().builder()
                .password("123")
                .username("cho")
                .department("AICC구독솔루션팀")
                .name("조영래")
                .build();
        memberRepository.save(member);


        Board board1 = new Board().builder()
                .member(member)
                .title("제목")
                .peopleNo(3)
                .startTime("3시 10분")
                .cost(3000)
                .description("나랑 같이 갈 사람")
                .open(Boolean.TRUE)
                .build();


        Board board2 = new Board().builder()
                .member(member)
                .title("제목2")
                .peopleNo(3)
                .startTime("34시 110분")
                .cost(3000)
                .description("나요나")
                .open(Boolean.TRUE)
                .build();
        boardRepository.save(board1);
        boardRepository.save(board2);
//        Assertions.assertEquals(4,boardRepository.findAll().size());
    }
}