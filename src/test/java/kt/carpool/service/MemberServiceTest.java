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
        Member member = new Member().builder()
                .username("hello")
                .password("3333")
                .name("gyeonghak")
                .department("solutionDevelop")
                .build();
        //when
        Long saveId = memberService.signUp(member);
        //then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getUsername(), findMember.getUsername());
    }

    @Test
    void 로그인() throws Exception{
        //given
        Member member = new Member().builder()
                .username("hello2")
                .password("123")
                .build();
        memberRepository.save(member);
        assertEquals(0,memberService.signIn(member));
    }
    @Test
    void 멤버불러오기() {
        //given
        Member member1 = new Member().builder()
                .username("hello3")
                .password("123")
                .name("hani")
                .department("gogo")
                .build();
        Member member2 = new Member().builder()
                .username("hello4")
                .password("123")
                .name("seulgi")
                .department("red")
                .build();
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> memberList = memberService.findMembers();
        //then
        assertEquals(memberList.get(0).getUsername(), member1.getUsername());
    }
}