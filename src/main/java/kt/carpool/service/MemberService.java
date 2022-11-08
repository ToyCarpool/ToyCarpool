package kt.carpool.service;

import kt.carpool.domain.Member;
import kt.carpool.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Long join(Member member){
        if (validateDuplicateMember(member)) {
            return -1L;
        };
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    private boolean validateDuplicateMember(Member member) {
        return memberRepository.findByName(member.getName()).isPresent();

    }
}
