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
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
    }

    @PostMapping("/join")
    public String memberLogin(@RequestBody MemberDto memberdto){
        Member member = new Member();
        member.setName(memberdto.getName());
        member.setPassword(memberdto.getPassword());
        if (memberService.join(member)==-1) {
            return "fail";
        };
        return "ok_success";
    }
}