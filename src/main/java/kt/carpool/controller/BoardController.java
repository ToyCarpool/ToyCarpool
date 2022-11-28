package kt.carpool.controller;


import kt.carpool.domain.Board;
import kt.carpool.domain.Member;
import kt.carpool.dto.BoardDto;
import kt.carpool.repository.BoardRepository;
import kt.carpool.repository.MemberRepository;
import kt.carpool.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public BoardController(BoardService boardService, MemberRepository memberRepository, BoardRepository boardRepository) {
        this.boardService = boardService;
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
    }

    @GetMapping("/list")
    public ResponseEntity getList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber()-1,
                pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "id"));
        Page<BoardDto> posts = boardService.getList(pageable);
        System.out.println("posts = " + posts);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/write")
    public void writeArticle(@RequestBody BoardDto boardDto) {
        Board board = Board.builder()
                .member(memberRepository.findById(boardDto.getMember_id()).get())
                .title(boardDto.getTitle())
                .peopleNo(boardDto.getPeopleNo())
                .startTime(boardDto.getStartTime())
                .cost(boardDto.getCost())
                .description(boardDto.getDescription())
                .open(boardDto.getOpen())
                .build();
        boardService.write(board);
    }

}
