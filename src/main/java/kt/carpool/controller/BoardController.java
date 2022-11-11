package kt.carpool.controller;


import kt.carpool.domain.Board;
import kt.carpool.dto.BoardDto;
import kt.carpool.service.BoardService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public List<Board> getList(){
        return boardService.getList();
    }

    @PostMapping("/write")
    public void writeArticle(@RequestBody BoardDto boardDto){
        Board board = new Board().builder()
                .user_id(boardDto.getUser_id())
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
