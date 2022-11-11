package kt.carpool.repository;

import kt.carpool.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>{

    Optional<Member> findByUsername(String username);
    Optional<Member> findById(Long id);
    List<Member> findAll();
    Member save(Member member);
}
