package kt.carpool.controller;


import kt.carpool.domain.Member;
import kt.carpool.dto.MemberDto;
import kt.carpool.repository.MemberRepository;
import kt.carpool.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @PostMapping("/login")
    public String memberLogin(@RequestBody MemberDto memberdto){
        Member member = new Member();
        member.setName(memberdto.getName());
        member.setPassword(memberdto.getPassword());
        memberService.join(member);
        return "ok_success";
    }
}
