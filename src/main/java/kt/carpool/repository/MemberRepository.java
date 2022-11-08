package kt.carpool.repository;

import kt.carpool.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long>{

    Optional<Member> findByName(String name);
    Optional<Member> findById(Long id);
    List<Member> findAll();
    Member save(Member member);
}
