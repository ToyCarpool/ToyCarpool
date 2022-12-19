package kt.carpool.service;

import kt.carpool.domain.Board;
import kt.carpool.dto.BoardDto;
import kt.carpool.repository.BoardRepository;
import kt.carpool.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void edit(Board board){
        boardRepository.save(board);
    }

    public void write(Board board){
        boardRepository.save(board);
    }

    public Page<BoardDto> getList(Pageable pageable){
        Page<Board> boards = boardRepository.findAll(pageable);
        Page<BoardDto> boardDtos = boards.map(m -> BoardDto.builder()
                .id(m.getId())
                .member(m.getMember())
                .title(m.getTitle())
                .cost(m.getCost())
                .peopleNo(m.getPeopleNo())
                .startTime(m.getStartTime())
                .description(m.getDescription())
                .open(m.getOpen())
                .build());
        System.out.println("boardDtos.getContent().toString() = " + boardDtos.getContent().toString());
        return boardDtos;

    }

}
