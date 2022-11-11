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
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public String SingUp(@RequestBody MemberDto memberdto){
        Member member = new Member().builder()
                .username(memberdto.getUsername())
                .password(memberdto.getPassword())
                .name(memberdto.getName())
                .department(memberdto.getDepartment())
                .build();
        if (memberService.signUp(member)==-1) {
            return "fail";
        };
        return "ok_success";
    }

    @PostMapping("/signin")
    public String SignIn(@RequestBody MemberDto memberdto){
        Member member = new Member().builder()
                .name(memberdto.getUsername())
                .password(memberdto.getPassword())
                .build();
        Integer status = memberService.signIn(member);
        if(status == 0) return "ok_success";
        else return "fail";
    }
}
