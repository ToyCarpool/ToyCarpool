package kt.carpool.service;

import kt.carpool.domain.Board;
import kt.carpool.repository.BoardRepository;
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


    @Test
    @Rollback(value = false)
    void write() {
        Board board = new Board().builder()
                .user_id(2L)
                .title("제목")
                .peopleNo(3)
                .startTime("3시 10분")
                .cost(3000)
                .description("나랑 같이 갈 사람")
                .open(Boolean.TRUE)
                .build();
        boardRepository.save(board);
        Assertions.assertEquals("제목",boardRepository.findAllByUserId(board.getUser_id()).get(0).getTitle());
    }

    @Test
    @Rollback(value = false)
    void edit() {
        Board board1 = new Board().builder()
                .user_id(2L)
                .title("제목")
                .peopleNo(3)
                .startTime("3시 10분")
                .cost(3000)
                .description("나랑 같이 갈 사람")
                .open(Boolean.TRUE)
                .build();
        boardRepository.save(board1);
        Board board2 = new Board().builder()
                .id(board1.getId())
                .user_id(2L)
                .title("제목r333333")
                .peopleNo(3)
                .startTime("3시 10분")
                .cost(3000)
                .description("나랑 같이 갈 사람")
                .open(Boolean.TRUE)
                .build();
        boardRepository.save(board2);
    }
}