package kt.carpool.service;

import kt.carpool.domain.Board;
import kt.carpool.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

//    public Board delete(){
//
//    }
}
