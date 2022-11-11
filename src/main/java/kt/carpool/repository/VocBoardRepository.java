package kt.carpool.repository;

import kt.carpool.domain.VocBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocBoardRepository extends JpaRepository<VocBoard, Long> {
    VocBoard save(VocBoard vocboard);
}
