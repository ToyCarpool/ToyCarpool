package kt.carpool.controller;


import kt.carpool.domain.Member;
import kt.carpool.dto.MemberDto;
import kt.carpool.repository.MemberRepository;
import kt.carpool.service.MemberService;
import kt.carpool.utils.MemberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberUtils memberUtils;

    @Autowired
    public MemberController(MemberService memberService, MemberUtils memberUtils) {
        this.memberService = memberService;
        this.memberUtils = memberUtils;
    }


    @PostMapping("/signup")
    public String SingUp(@RequestBody MemberDto memberdto){
        Member member = memberUtils.toEntity(memberdto);
        if (memberService.signUp(member)==-1) {
            return "fail";
        };
        return "ok_success";
    }

    @PostMapping("/signin")
    public String SignIn(@RequestBody MemberDto memberdto){
        Member member = memberUtils.toEntity(memberdto);
        Integer status = memberService.signIn(member);
        if(status == 0) return "ok_success";
        else return "fail";
    }
}
