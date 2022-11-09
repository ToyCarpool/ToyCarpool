package kt.carpool.service;

import kt.carpool.domain.Member;
import kt.carpool.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
//    @Rollback(value = false)
    void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("hello33");
        //when
        Long saveId = memberService.signUp(member);
        //then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    @Rollback(value = false)
    void 로그인() throws Exception{
        Member member = new Member();
        member.setName("hello3");
        member.setPassword("333");
        memberRepository.save(member);
    }
    @Test
    void 멤버불러오기() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        Member member2 = new Member();
        member2.setName("spring2");
        Member member3 = new Member();
        member3.setName("spring3");
        memberService.signUp(member1);
        memberService.signUp(member2);
        memberService.signUp(member3);

        //when
        List<Member> memberList = memberService.findMembers();
        //then
        assertEquals(memberList.get(0).getName(), member1.getName());
    }
}