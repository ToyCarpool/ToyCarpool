package kt.carpool.service;

import kt.carpool.domain.Member;
import kt.carpool.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Long signUp(Member member){
        if (validateDuplicateMember(member)) {
            return -1L;
        };
        memberRepository.save(member);
        return member.getId();
    }

    public Integer signIn(Member member){
        // 로그인 오류별로 리턴을 다르게 해야함
        // [비밀번호 오류, 아이디 오류, ....]
        // [로그인 성공 : 0, 비밀번호 오류 : 1, 없는 아이디 : 2]
        Optional<Member> compareMember = memberRepository.findByName(member.getName());
        if(compareMember.isPresent()){
            if(compareMember.get().getPassword() == member.getPassword()) return 0;
            else return 1;
        }
        else return 2;
    }
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    private boolean validateDuplicateMember(Member member) {
        return memberRepository.findByName(member.getName()).isPresent();

    }
}
