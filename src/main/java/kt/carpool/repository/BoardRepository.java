package kt.carpool.repository;

import kt.carpool.domain.Board;
import kt.carpool.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
        Board save(Board board);

//        @Query("select b from Board b WHERE b.user_id = :user_id")
//        List<Board> findAllByUserId(@Param("user_id") Long user_id);

        List<Board> findByMember(Member member);

        List<Board> findAll();

        Page<Board> findAll(Pageable pageable);

}
