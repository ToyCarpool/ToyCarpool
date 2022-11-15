package kt.carpool.controller;


import kt.carpool.domain.Board;
import kt.carpool.domain.Member;
import kt.carpool.dto.BoardDto;
import kt.carpool.repository.MemberRepository;
import kt.carpool.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final MemberRepository memberRepository;

    @Autowired
    public BoardController(BoardService boardService, MemberRepository memberRepository) {
        this.boardService = boardService;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/list")
    public List<Board> getList(){
        return boardService.getList();
    }

    @PostMapping("/write")
    public void writeArticle(@RequestBody BoardDto boardDto) {
        Board board = null;
        if (memberRepository.findById(boardDto.getUser_id()).isPresent()) {
            board = Board.builder()
                    .member(memberRepository.findById(boardDto.getUser_id()).get())
                    .title(boardDto.getTitle())
                    .peopleNo(boardDto.getPeopleNo())
                    .startTime(boardDto.getStartTime())
                    .cost(boardDto.getCost())
                    .description(boardDto.getDescription())
                    .open(boardDto.getOpen())
                    .build();
        }

        boardService.write(board);
    }

}
